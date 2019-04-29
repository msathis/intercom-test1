package com.intercom.geocircle;

import com.intercom.geocircle.exception.InvalidLocationException;
import com.intercom.geocircle.model.Location;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class LocationTest {

    private Location officeLocation;

    @Before
    public void setUp() {
        officeLocation = new Location(53.339428d, -6.257664d);
    }

    @Test(expected = InvalidLocationException.class)
    public void testWrongLocation() {
        Location.toRadian(null);
    }

    @Test
    public void testLocationRadians() {
        Location radianLocation = Location.toRadian(officeLocation);
        assertTrue(radianLocation.getLatitude() == 0.9309486397304538d);
        assertTrue(radianLocation.getLongitude() == -0.10921684028351844d);
    }

}
