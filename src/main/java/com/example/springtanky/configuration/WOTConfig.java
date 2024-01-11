package com.example.springtanky.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WOTConfig {

    @Value("${wot.api.base-url}")
    private String wotApiBaseUrl;

    public String getWotApiUrl(String playerName) {
        return wotApiBaseUrl + "&search=" + playerName;
    }
}