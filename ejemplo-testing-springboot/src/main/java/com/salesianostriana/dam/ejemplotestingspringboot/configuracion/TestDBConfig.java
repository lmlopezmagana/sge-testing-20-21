package com.salesianostriana.dam.ejemplotestingspringboot.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

import org.springframework.context.annotation.Profile;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;


@Configuration
public class TestDBConfig {


    @Bean
    @Profile("test")
    public DataSource testDataSource() {
        return new EmbeddedDatabaseBuilder().setName("test-db").build();
    }

    @Bean
    @Profile("test")
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(testDataSource());
    }

    @Bean
    @Profile("test")
    public PlatformTransactionManager testTransactionManager(){
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(testDataSource());
        return transactionManager;
    }

}
