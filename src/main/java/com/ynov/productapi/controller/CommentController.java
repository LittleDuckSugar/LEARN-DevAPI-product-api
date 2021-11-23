package com.ynov.productapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ynov.productapi.model.Comment;
import com.ynov.productapi.model.Product;
import com.ynov.productapi.service.CommentService;
import com.ynov.productapi.service.ProductService;

@RestController
public class CommentController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private CommentService commentService;

	@PostMapping("/comment/{id}")
	public Product addComment(@PathVariable("id") Integer id, @RequestBody Comment comment) {

		//Product existingProduct = productService.getProduct(id).get();
		//existingProduct.getComments().add(comment);
		//return productService.upsert(existingProduct);
		return commentService.addComment(id, comment);
	}
	
	@DeleteMapping("/comment/{id}")
	public void deleteComment(@PathVariable("id") Integer id) {
		commentService.deleteComment(id);
	}

}
