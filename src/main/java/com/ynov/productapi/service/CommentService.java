package com.ynov.productapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ynov.productapi.model.Comment;
import com.ynov.productapi.model.Product;

@Service
public class CommentService {

	@Autowired
	private ProductService productService;
	
	public Product addComment(Integer id, Comment comment) {
		Product existingProduct = productService.getProduct(id).get();

		existingProduct.getComments().add(comment);

		return productService.upsert(existingProduct);
	}
	
	public void deleteComment(Integer id) {
		
	}
	
	
	
}
