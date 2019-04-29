package com.intercom.geocircle.model;

import com.intercom.geocircle.exception.InvalidLocationException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {

    private double latitude;

    private double longitude;

    public static Location toRadian(Location location) {
        if (location == null) {
            throw new InvalidLocationException("Location is null. Unable to convert its latitude and longitude values to radian");
        }
        return new Location(Math.toRadians(location.getLatitude()), Math.toRadians(location.getLongitude()));
    }
}
