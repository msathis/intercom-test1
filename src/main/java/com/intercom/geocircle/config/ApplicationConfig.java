package com.intercom.geocircle.config;

import com.intercom.geocircle.model.Location;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
@ConfigurationProperties(prefix = "intercom")
@ToString
@Getter
@Setter
public class ApplicationConfig {

    //Intercom Dublin office location
    @NonNull
    private Location location;

    //Maximum Distance Range. Default value is 100km
    @NonNull
    private Double maxDistance;

    //Customers file path. Must be a http url
    @NonNull
    private String filePath;

}
