package com.intercom.geocircle.service;

import com.intercom.geocircle.TestConstants;
import com.intercom.geocircle.config.ApplicationConfig;
import com.intercom.geocircle.exception.InvalidFileException;
import com.intercom.geocircle.model.Customer;
import com.intercom.geocircle.model.Location;
import com.intercom.geocircle.service.impl.CustomerServiceImpl;
import com.intercom.geocircle.utils.CommonUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {

    private static final String FILE_PATH_MALFORMED = "";

    @Mock
    private ApplicationConfig applicationConfig = new ApplicationConfig();

    @InjectMocks
    private CustomerService customerService = new CustomerServiceImpl();

    private Customer customer1;

    private Customer customer2;

    private Location officeLocation;

    @Before
    public void setUp() {
        customer1 = new Customer(4, 53.2451022d, -6.238335d, "Ian Kehoe");
        customer2 = new Customer(1, 51.92893d, -10.27699d, "Alice Cahill");
        officeLocation = new Location(53.339428d, -6.257664d);
    }

    @Test(expected = InvalidFileException.class)
    public void testMalformedUrl() throws IOException {
        when(applicationConfig.getFilePath()).thenReturn(FILE_PATH_MALFORMED);
        customerService.getCustomers(applicationConfig.getFilePath());
    }

    @Test
    public void testCustomersCount() throws IOException {
        when(applicationConfig.getFilePath()).thenReturn(TestConstants.FILE_PATH);
        assertEquals(customerService.getCustomers(applicationConfig.getFilePath()).size(), 32);
    }

    @Test
    public void testCustomersWithInDistance() throws IOException {
        List<Customer> customerList = new ArrayList<>();
        customerList.add(customer1);
        customerList.add(customer2);

        when(applicationConfig.getMaxDistance()).thenReturn(100.0d);
        when(applicationConfig.getLocation()).thenReturn(officeLocation);

        List<Customer> filteredList = customerService.searchCustomersWithinDistance(customerList, applicationConfig.getLocation(), applicationConfig.getMaxDistance());
        assertEquals(filteredList.size(), 1);
        assertEquals(customer1, filteredList.get(0));
    }

    @Test
    public void testCustomerDistance() throws IOException {
        when(applicationConfig.getLocation()).thenReturn(officeLocation);

        double distance = CommonUtils.calculateDistance(applicationConfig.getLocation(), customer1.getLocation());
        assertTrue(distance == 10.578773712307225d);
    }

}
