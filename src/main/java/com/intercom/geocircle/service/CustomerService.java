package com.intercom.geocircle.service;

import com.intercom.geocircle.model.Customer;
import com.intercom.geocircle.model.Location;

import java.io.IOException;
import java.util.List;

public interface CustomerService {

    /**
     * Returns master data of customers. This list is sorted and cached for future requests.
     *
     * @param path path to file containing customer details
     * @return an object of {@link List<Customer> }
     * @throws IOException Throws IOException if the url is invalid or data is corrupted.
     */
    List<Customer> getCustomers(String path) throws IOException;

    /**
     * Returns list of customers within defined range. Default value of range is 100km
     *
     * @param customers      {@link List<Customer> }
     * @param officeLocation {@link Location}
     * @param maxDistance    Maximum distance range
     * @return an object of {@link List<Customer> }
     * @throws IOException If the master data is not fetchable IOException is thrown.
     */
    List<Customer> searchCustomersWithinDistance(List<Customer> customers, Location officeLocation, Double maxDistance) throws IOException;
}
