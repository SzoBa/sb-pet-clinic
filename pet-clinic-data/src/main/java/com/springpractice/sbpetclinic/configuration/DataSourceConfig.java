package com.springpractice.sbpetclinic.configuration;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DataSourceConfig {
    private String username;
    private String password;
    private String jdbcurl;

}
