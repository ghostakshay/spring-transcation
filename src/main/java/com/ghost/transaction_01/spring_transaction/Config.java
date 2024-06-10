package com.ghost.transaction_01.spring_transaction;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com")
@EnableTransactionManagement
public class Config {

	@Bean
	public DataSource datasource() {

		return new DriverManagerDataSource("jdbc:mysql://localhost:3306/test", "root", "root");
	}

	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(datasource());
	}

	@Bean
	public TransactionManager transactionManager() {

		return new DataSourceTransactionManager(datasource());
	}

}
