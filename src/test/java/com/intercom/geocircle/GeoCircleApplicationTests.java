package com.intercom.geocircle;

import com.google.gson.JsonSyntaxException;
import com.intercom.geocircle.common.Constants;
import com.intercom.geocircle.config.ApplicationConfig;
import com.intercom.geocircle.service.CustomerService;
import com.intercom.geocircle.service.impl.CustomerServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.io.IOException;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {CustomerServiceImpl.class})
public class GeoCircleApplicationTests {

    private static final String NON_EXISTING_URL = "http://test.xyzzz/hhghhgh.txt";

    private static final String INVALID_JSON_URL = "http://google.com";

    private static final String MISSING_FIELD_JSON_URL = "https://gist.githubusercontent.com/msathis/4940476b45e5ed52eeea407752ede4fc/raw/53af834ceb2aba689dcfe20cd60cdfad177ccd07/customers_missing";


    @Mock
    private ApplicationConfig applicationConfig;

    @InjectMocks
    private GeoCircleApplicationRunner applicationRunner;

    @Spy
    private CustomerService customerService = new CustomerServiceImpl();

    @Test
    public void contextLoads() {
    }

    @Test(expected = NullPointerException.class)
    public void testEmptyJsonFieldsUrl() throws Exception {
        ApplicationArguments args = new DefaultApplicationArguments(new String[]{"--" + Constants.FILEPATH_OPTION_NAME + "=" + MISSING_FIELD_JSON_URL});
        applicationRunner.run(args);
    }

    @Test(expected = JsonSyntaxException.class)
    public void testNotJsonUrl() throws Exception {
        ApplicationArguments args = new DefaultApplicationArguments(new String[]{"--" + Constants.FILEPATH_OPTION_NAME + "=" + INVALID_JSON_URL});
        applicationRunner.run(args);
    }

    @Test(expected = IOException.class)
    public void testNotExistsFileUrl() throws Exception {
        ApplicationArguments args = new DefaultApplicationArguments(new String[]{"--" + Constants.FILEPATH_OPTION_NAME + "=" + NON_EXISTING_URL});
        applicationRunner.run(args);
    }
}
