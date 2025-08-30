package com.backend.product_ms.service.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.product_ms.entity.Product;
import com.backend.product_ms.repository.ProductRepository;
import com.backend.product_ms.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(int productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        return optionalProduct.orElse(null);
    }

    @Override
    public List<Product> findByProductName(String productName) {
        return productRepository.findByProductName(productName);
    }

    @Override
    public void deleteById(int productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public Product updateProduct(int productId, Product updatedProduct) {
        Optional<Product> optionalProduct = productRepository.findById(productId);

        if (optionalProduct.isPresent()) {
            Product existingProduct = optionalProduct.get();
            
            // Update only the fields you want to allow
            existingProduct.setProductName(updatedProduct.getProductName());
            existingProduct.setProductDesc(updatedProduct.getProductDesc());
            existingProduct.setProductCat(updatedProduct.getProductCat());
            existingProduct.setMake(updatedProduct.getMake());
            existingProduct.setProductAvailableQty(updatedProduct.getProductAvailableQty());
            existingProduct.setProductPrice(updatedProduct.getProductPrice());
            existingProduct.setProductImgUrl(updatedProduct.getProductImgUrl());
            existingProduct.setDateOfManufacture(updatedProduct.getDateOfManufacture());
            
            return productRepository.save(existingProduct);
        } else {
            return null; 
        }
    }
    
    public void reduceQuantity(int productId, int quantity) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + productId));

        if (product.getProductAvailableQty() < quantity) {
            throw new RuntimeException("Insufficient stock for product id: " + productId);
        }

        product.setProductAvailableQty(product.getProductAvailableQty() - quantity);
        productRepository.save(product);
    }
    
}