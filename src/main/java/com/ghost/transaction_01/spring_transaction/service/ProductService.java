package com.ghost.transaction_01.spring_transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ghost.transaction_01.spring_transaction.model.Product;
import com.ghost.transaction_01.spring_transaction.repo.ProductRepo;

@Service
public class ProductService {

	@Autowired
	private ProductRepo productRepo;

	@Transactional(propagation = Propagation.REQUIRED,noRollbackFor = Throwable.class)
	public void saveProduct() throws Exception {

		for (int i = 0; i < 10; i++) {
			Product p = new Product(i, "Ghost" + i);
			productRepo.saveProduct(p);
			System.out.println("Save Product " + i);

			// Transcation is by default rollback for uncheked exception.
			// For Checked exception transcation is not roll back.
		}
		test();
	}

	//@Transactional(propagation = Propagation.REQUIRED)
	public void test() throws Exception {

		for (int i = 25; i < 30; i++) {
			System.out.println("I " + i);
			Product p = new Product(i, "Ghost" + i);
			productRepo.saveProduct(p);
			if (i == 26) {
				throw new RuntimeException("Exception Occured");
			}
		}
	}

}
