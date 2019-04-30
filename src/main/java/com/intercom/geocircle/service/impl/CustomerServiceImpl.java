package com.intercom.geocircle.service.impl;

import com.intercom.geocircle.common.Constants;
import com.intercom.geocircle.model.Customer;
import com.intercom.geocircle.model.Location;
import com.intercom.geocircle.service.CustomerService;
import com.intercom.geocircle.utils.CommonUtils;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service("CustomerServiceImpl")
@NoArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private static final String GET = "GET";

    /**
     * Returns master data of customers. This list is sorted and cached for future requests.
     *
     * @param path path to file containing customer details
     * @return an object of {@link List<Customer> }
     * @throws IOException Throws IOException if the url is invalid or data is corrupted.
     */
    @Override
    @Cacheable("customers")
    public List<Customer> getCustomers(String path) throws IOException {

        Assert.notNull(path, Constants.INVALID_FILE_PATH);

        List<Customer> customers = new ArrayList<>();
        URL url = new URL(path);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(GET);
        connection.connect();

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;

            //Read customers line by line and deserialize them
            while ((line = bufferedReader.readLine()) != null) {
                Customer customer = CommonUtils.getCustomer(line);
                customers.add(customer);
            }
        }
        connection.disconnect();

        //Sort the list by userId. We are sorting here to avoid soring every time during API call.
        customers.sort(Comparator.comparing(Customer::getId));
        LOGGER.info("Total fetched customers: {}", customers.size());
        return customers;
    }


    /**
     * Returns list of customers within defined range. Default value of range is 100km
     *
     * @param allCustomers   {@link List<Customer> }
     * @param officeLocation {@link Location}
     * @param distance       Maximum distance range
     * @return an object of {@link List<Customer> }
     * @throws IOException If the master data is not fetchable IOException is thrown
     */
    public List<Customer> searchCustomersWithinDistance(List<Customer> allCustomers, Location officeLocation, Double distance)
            throws IOException {

        //Filter only customers within distance of given range. Default range value is 100km
        return allCustomers.stream()
                .filter(customer -> CommonUtils.calculateDistance(customer.getLocation(),
                        officeLocation) <= distance)
                .collect(Collectors.toList());
    }
}
