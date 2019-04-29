package com.intercom.geocircle;

import com.intercom.geocircle.common.Constants;
import com.intercom.geocircle.config.ApplicationConfig;
import com.intercom.geocircle.model.Customer;
import com.intercom.geocircle.service.CustomerService;
import com.intercom.geocircle.utils.CommonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class GeoCircleApplicationRunner implements ApplicationRunner {

    private final CustomerService customerService;

    private final ApplicationConfig applicationConfig;

    public GeoCircleApplicationRunner(CustomerService customerService, ApplicationConfig applicationConfig) {
        this.customerService = customerService;
        this.applicationConfig = applicationConfig;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String fileUrl = applicationConfig.getFilePath();

        if (args.containsOption(Constants.FILEPATH_OPTION_NAME)) {
            fileUrl = args.getOptionValues(Constants.FILEPATH_OPTION_NAME).get(0);
        }

        List<Customer> allCustomers = customerService.getCustomers(fileUrl);
        List<Customer> customerList = customerService.searchCustomersWithinDistance(allCustomers,
                applicationConfig.getLocation(), applicationConfig.getMaxDistance());

        LOGGER.info("Total customers matched in range of {} km : {}", applicationConfig.getMaxDistance(), customerList.size());
        for (Customer customer : customerList) {
            LOGGER.info("{}\t{}\t{}", customer.getId(), customer.getName(), CommonUtils.toJson(customer));
        }
    }
}
