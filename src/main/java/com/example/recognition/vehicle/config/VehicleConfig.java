package com.example.recognition.vehicle.config;


import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "vehicleEntityManagerFactory", transactionManagerRef = "vehicleTransactionManager", basePackages = {"com.example.recognition.vehicle.repository"}
)
public class VehicleConfig {

    @Bean(name = "vehicleDataSourceProperties")
    @ConfigurationProperties("spring.datasource.vehicle")
    public DataSourceProperties vehicleDataSourceProperties() {
        return new DataSourceProperties();
    }

    //配置数据源
    @Bean(name = "vehicleDataSource")
    @ConfigurationProperties("spring.datasource.vehicle.configuration")
    public DataSource vehicledataSource(@Qualifier("vehicleDataSourceProperties") DataSourceProperties vehicleDataSourceProperties) {
        return vehicleDataSourceProperties.initializeDataSourceBuilder()
                .type(HikariDataSource.class)
                .build();
    }


    @Bean(name = "vehicleEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean barEntityManagerFactory(EntityManagerFactoryBuilder builder, @Qualifier("vehicleDataSource") DataSource vehicledataSource) {
        return builder.dataSource(vehicledataSource).packages("com.example.recognition.vehicle.entity").persistenceUnit("vehicle").build();
    }
//配置事务管理
    @Bean(name = "vehicleTransactionManager")
    public PlatformTransactionManager productTransactionManager(@Qualifier("vehicleEntityManagerFactory") LocalContainerEntityManagerFactoryBean vehicleEntityManagerFactory) {
        return new JpaTransactionManager(vehicleEntityManagerFactory.getObject());
    }

}

