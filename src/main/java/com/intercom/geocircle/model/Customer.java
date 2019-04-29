package com.intercom.geocircle.model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
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
