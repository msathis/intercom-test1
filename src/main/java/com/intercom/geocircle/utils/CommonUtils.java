package com.intercom.geocircle.utils;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.intercom.geocircle.common.Constants;
import com.intercom.geocircle.model.Customer;
import com.intercom.geocircle.model.Location;

public class CommonUtils {

    private static final Gson GSON = new Gson();

    /**
     * @param line Json {@link String} representation of the Customer object.
     * @return {@link Customer} object after deserializing the Json String
     * @throws JsonSyntaxException Throws if the json string is invalid
     */
    public static Customer getCustomer(String line) throws JsonSyntaxException {
        return GSON.fromJson(line, Customer.class);
    }

    /**
     * Calculates the distance between two locations: source and destination.
     * Latitude and longitude values of both the passed location are in degrees.
     * For distance calculation following formula is being used:
     * <p>
     * distance = earthRadius * deltaAngle; where
     * deltaAngle = arccos(sin(lat1) * sin(lat2) + cos(lat1) * cos(lat2) * cos(lon2 - lon1))
     * Refer {@literal https://en.wikipedia.org/wiki/Great-circle_distance}
     *
     * @param source      an object of {@link Location}
     * @param destination an object of {@link Location}
     * @return distance geo distance between given locations in kilometers
     */
    public static double calculateDistance(Location source, Location destination) {

        //Convert degrees to Radians
        source = Location.toRadian(source);
        destination = Location.toRadian(destination);

        double deltaAngle = Math.acos(Math.sin(source.getLatitude()) * Math.sin(destination.getLatitude()) +
                Math.cos(source.getLatitude()) * Math.cos(destination.getLatitude())
                        * Math.cos(destination.getLongitude() - source.getLongitude()));
        return Constants.EARTH_RADIUS * deltaAngle;
    }

    /**
     * Returns serialized json string version of a {@link Customer} object.
     *
     * @param customer an object of {@link Customer}
     * @return serialized json string
     */
    public static String toJson(Customer customer) {
        return GSON.toJson(customer);
    }
}
