package com.springpractice.sbpetclinic.configuration;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:dataconfig.properties")
@Configuration
public class DataConfig {

    @Bean
    @ConfigurationProperties(prefix = "datasource.h2")
    public DataSourceConfig getH2DataSourceConfig () {
        return new DataSourceConfig();
    }

}
