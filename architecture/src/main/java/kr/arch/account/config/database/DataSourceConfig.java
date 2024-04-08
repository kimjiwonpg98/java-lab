package kr.arch.account.config.database;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataSourceConfig {
    public static final String ARCH_WRITE_PROPERTIES = "spring.datasource.write";
    public static final String ARCH_READ_PROPERTIES = "spring.datasource.read";
    public static final String ARCH_WRITE_DATASOURCE = "archWriteDataSource";
    public static final String ARCH_READ_DATASOURCE = "archReadDataSource";
    public static final String DYNAMIC_ROUTING_DATA_SOURCE = "dynamicRoutingDataSource";
    public static final String LAZY_CONNECTION_DATA_SOURCE_PROXY = "lazyConnectionDataSourceProxy";


    @Bean(name = ARCH_WRITE_DATASOURCE)
    @ConfigurationProperties(prefix = ARCH_WRITE_PROPERTIES)
    DataSource archDataSourceWriteDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean(name = ARCH_READ_DATASOURCE)
    @ConfigurationProperties(prefix = ARCH_READ_PROPERTIES)
    DataSource archDataSourceReadDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean(name = DYNAMIC_ROUTING_DATA_SOURCE)
    @ConditionalOnBean(name = {ARCH_WRITE_DATASOURCE, ARCH_READ_DATASOURCE})
    public DataSource routingDataSource(
        @Qualifier(ARCH_WRITE_DATASOURCE) DataSource titleAcademyWriteDataSource,
        @Qualifier(ARCH_READ_DATASOURCE) DataSource titleAcademyReadDataSource
    ) {
        DynamicRoutingDataSource dynamicRoutingDataSource = new DynamicRoutingDataSource();
        Map<Object, Object> dataSources = new HashMap<>();

        dataSources.put(DynamicRoutingDataSource.WRITE, titleAcademyWriteDataSource);
        dataSources.put(DynamicRoutingDataSource.READ, titleAcademyReadDataSource);

        dynamicRoutingDataSource.setTargetDataSources(dataSources);
        dynamicRoutingDataSource.setDefaultTargetDataSource(titleAcademyWriteDataSource);

        return dynamicRoutingDataSource;
    }

    @Primary
    @Bean(name = LAZY_CONNECTION_DATA_SOURCE_PROXY)
    @ConditionalOnBean(name = DYNAMIC_ROUTING_DATA_SOURCE)
    public LazyConnectionDataSourceProxy lazyConnectionDataSourceProxy(
            @Qualifier(DYNAMIC_ROUTING_DATA_SOURCE) DataSource dynamicRoutingDataSource) {
        return new LazyConnectionDataSourceProxy(dynamicRoutingDataSource);
    }
}
