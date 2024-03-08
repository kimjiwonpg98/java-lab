package jpabook.jpashop.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


@Configuration
public class DataSourceConfig {
    private static final String JPASHOP_PROPERTIES = "spring.datasource.jpashop.write";

    @Bean
    @ConfigurationProperties(prefix = JPASHOP_PROPERTIES)
    DataSource dataSource() {
        return DataSourceBuilder.create()
            .type(HikariDataSource.class)
            .build();
    }

}


