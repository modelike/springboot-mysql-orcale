package com.example.recognition.face.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "faceEntityManagerFactory", transactionManagerRef = "faceTransactionManager", basePackages = {"com.example.recognition.face.repository"})
public class FaceConfig {


    @Primary
    @Bean(name = "faceDataSourceProperties")
    @ConfigurationProperties("spring.datasource.face")
    public DataSourceProperties faceDataSourceProperties() {
        return new DataSourceProperties();
    }
    @Primary
    @Bean(name = "faceDataSource")
    @ConfigurationProperties("spring.datasource.face.configuration")
    public DataSource faceDataSource(@Qualifier("faceDataSourceProperties") DataSourceProperties faceDataSourceProperties) {
        return faceDataSourceProperties.initializeDataSourceBuilder()
                .type(HikariDataSource.class)
                .build();
    }

    @Primary
    @Bean(name = "faceEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder, @Qualifier("faceDataSource") DataSource facedataSource) {
        return builder.dataSource(facedataSource).packages("com.example.recognition.face.entity").persistenceUnit("face").build();
    }

    @Primary
    @Bean(name = "faceTransactionManager")
    public PlatformTransactionManager faceTransactionManager(@Qualifier("faceEntityManagerFactory") LocalContainerEntityManagerFactoryBean faceEntityManagerFactory) {
        return new JpaTransactionManager(faceEntityManagerFactory.getObject());
    }
}
