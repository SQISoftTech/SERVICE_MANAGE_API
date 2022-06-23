package com.sqisoft.mgapi.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    entityManagerFactoryRef = "mgServiceEntityManagerFactory",
    transactionManagerRef = "mgServiceTransactionManager",
    basePackages = "com.sqisoft.mgapi.datasource.mg_service"
)
public class MgServiceDataSourceConfig {

  @Primary
  @ConfigurationProperties(prefix= "mg-service.datasource")
  @Bean(name ="mgServiceDataSource")
  public DataSource dataSource(){
     return DataSourceBuilder.create().type(HikariDataSource.class).build();
  }

  @Primary
  @Bean(name = "mgServiceEntityManagerFactory")
  public LocalContainerEntityManagerFactoryBean mysql(
      EntityManagerFactoryBuilder builder, @Qualifier("mgServiceDataSource") DataSource dataSource) {
    return builder
        .dataSource(dataSource)
        .packages("com.sqisoft.mgapi.datasource.mg_service.*.vo")
        .persistenceUnit("mgService")
        .build();
  }

  @Primary
  @Bean(name = "mgServiceTransactionManager")
  public PlatformTransactionManager transactionManager(
      @Qualifier("mgServiceEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
    return new JpaTransactionManager(entityManagerFactory);
  }
}
