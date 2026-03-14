package com.example.multidb;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;

@Configuration
public class MultipleDataSourceConfig {

    @Bean(name = "primaryDataSource")
    public DataSource primaryDataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setUrl("jdbc:h2:mem:primarydb");
        ds.setDriverClassName("org.h2.Driver");
        return ds;
    }

    @Bean(name = "analyticsDataSource")
    public DataSource analyticsDataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setUrl("jdbc:h2:mem:analyticsdb");
        ds.setDriverClassName("org.h2.Driver");
        return ds;
    }
}
