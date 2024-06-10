package com.ghost.transaction_01.spring_transaction.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ghost.transaction_01.spring_transaction.model.Product;

@Repository
public class ProductRepo {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	@Transactional
	public void saveProduct(Product product) {

		String sql = " INSERT INTO PRODUCT VALUES(?,?)";
		Object[] values = { product.getId(), product.getName() };
		jdbcTemplate.update(sql, values);

	}
}
