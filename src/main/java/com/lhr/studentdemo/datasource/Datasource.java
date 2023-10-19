package com.lhr.studentdemo.datasource;

import com.zaxxer.hikari.HikariDataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.jdbc.metadata.HikariDataSourcePoolMetadata;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/10/10/00:56
 * @Description:
 */
@Configuration
public class Datasource {
  @Bean
  @ConfigurationProperties("app.datasource")
  public HikariDataSource hikariDataSource(){
    return DataSourceBuilder.create().type(HikariDataSource.class).build();
  }

}
