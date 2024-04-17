package com.example.appplantorabackend.config;

import com.example.appplantorabackend.entity.User;
import com.example.appplantorabackend.enums.Language;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "default")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class UserConfig {
    Language language;
    User user;
}
