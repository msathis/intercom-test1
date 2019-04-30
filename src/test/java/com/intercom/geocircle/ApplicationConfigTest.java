package com.intercom.geocircle;

import com.intercom.geocircle.config.ApplicationConfig;
import com.intercom.geocircle.model.Location;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationConfigTest {

    @Autowired
    private ApplicationConfig applicationConfig;

    @Test
    public void testConfigFilePath() {
        assertEquals(TestConstants.FILE_PATH, applicationConfig.getFilePath());
    }

    @Test
    public void testConfigOfficeLocation() {
        Location officeLocation = applicationConfig.getLocation();

        assertNotNull(officeLocation);
        assertTrue(officeLocation.getLatitude() == 53.339428d);
        assertTrue(officeLocation.getLongitude() == -6.257664d);
    }
}
