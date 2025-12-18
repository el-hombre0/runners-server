package ru.evendot.runners.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import tools.jackson.databind.ObjectMapper;
//import tools.jackson.databind.json.JsonMapper;
//import tools.jackson.datatype.jsr310.JavaTimeModule;

@Configuration
public class AppConfiguration {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

//    @Bean
//    public ObjectMapper jsonObjectMapper() {
//        return JsonMapper.builder().addModules(new JavaTimeModule()).build();
//    }
}
