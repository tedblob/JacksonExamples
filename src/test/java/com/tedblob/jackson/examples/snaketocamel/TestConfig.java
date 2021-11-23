package com.tedblob.jackson.examples.snaketocamel;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.ObjectMapper;

@TestConfiguration
public class TestConfig {

    @Bean
    public ObjectMapper objectMapper() {

        return new ObjectMapper();
    }
}