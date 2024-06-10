package com.ghost.transaction_01.spring_transaction;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ghost.transaction_01.spring_transaction.service.ProductService;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) throws Exception {

		AnnotationConfigApplicationContext contex = new AnnotationConfigApplicationContext(Config.class);
		contex.registerShutdownHook();

		ProductService productService = contex.getBean(ProductService.class);
		productService.saveProduct();
		//productService.test();

		contex.close();
	}
}
