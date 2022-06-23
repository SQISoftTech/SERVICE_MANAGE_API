package com.sqisoft.mgapi.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
    entityManagerFactoryRef = "iqsbz3EntityManagerFactory",
    transactionManagerRef = "iqsbz3TransactionManager",
    basePackages = "com.sqisoft.mgapi.datasource.iqsbz3"
)
public class Iqsbz3DataSourceConfig {

  @Bean(name ="iqsbz3DataSource")
  @ConfigurationProperties(prefix= "iqsbz3.datasource")
  public DataSource dataSource(){
    // return DataSourceBuilder.create().build();
       return DataSourceBuilder.create().type(HikariDataSource.class).build();
  }

  @Bean(name = "iqsbz3EntityManagerFactory")
  public LocalContainerEntityManagerFactoryBean mysql(
      EntityManagerFactoryBuilder builder, @Qualifier("iqsbz3DataSource") DataSource dataSource) {
    return builder
        .dataSource(dataSource)
        .packages("com.sqisoft.mgapi.datasource.iqsbz3.vo")
        .persistenceUnit("iqsbz3")
        .build();
  }

  @Bean(name = "iqsbz3TransactionManager")
  public PlatformTransactionManager transactionManager(
      @Qualifier("iqsbz3EntityManagerFactory") EntityManagerFactory entityManagerFactory) {
    return new JpaTransactionManager(entityManagerFactory);
  }

}
