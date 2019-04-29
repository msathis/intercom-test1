package com.intercom.geocircle.model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @SerializedName("user_id")
    @NonNull
    private Integer id;

    @NonNull
    private Double latitude;

    @NonNull
    private Double longitude;

    @NonNull
    private String name;

    public Location getLocation() {
        return new Location(latitude, longitude);
    }
}
