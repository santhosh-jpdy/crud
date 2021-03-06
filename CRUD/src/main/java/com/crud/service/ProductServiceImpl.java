package com.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crud.exceptions.ResourceNotFoundExceptions;
import com.crud.model.Product;
import com.crud.repository.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProuductService{
	
	@Autowired
	private ProductRepository productRepository;
	
	
	@Override
	public Product createProduct(Product product) {
		
		return productRepository.save(product);
	}

	@Override
	public Product updateProduct(Product product) {
		Optional<Product> productdb =this.productRepository.findById(product.getId());
		
		if(productdb.isPresent()) {
			Product productupdate=productdb.get();
			productupdate.setId(product.getId());
			productupdate.setName(product.getName());
			productupdate.setDescription(product.getDescription());
			productRepository.save(productupdate);
			return productupdate;
		}else {
			throw new ResourceNotFoundExceptions("Record not found"+ product.getId());
		}
	}

	@Override
	public List<Product> getAllProduct() {
		
		return this.productRepository.findAll();
	}

	@Override
	public Product getProductById(long productId) {
		
		Optional<Product> productdb =this.productRepository.findById(productId);
		
		if(productdb.isPresent()) {
			return productdb.get();
		}else {
			throw new ResourceNotFoundExceptions("Record not found"+ productId);
		}
	}

	@Override
	public void deleteProduct(long productId) {
		Optional<Product> productdb =this.productRepository.findById(productId);
		
		if(productdb.isPresent()) {
			this.productRepository.delete(productdb.get());
		}else {
			throw new ResourceNotFoundExceptions("Record not found"+ productId);
		}
		
	}

	
}
