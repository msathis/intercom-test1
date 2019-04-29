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

    @NonNull
    private Location location;

    @NonNull
    private Double maxDistance;

    @NonNull
    private String filePath;

}
