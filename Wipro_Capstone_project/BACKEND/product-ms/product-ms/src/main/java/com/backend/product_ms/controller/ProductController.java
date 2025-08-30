package com.backend.product_ms.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backend.product_ms.entity.Product;
import com.backend.product_ms.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    // ------------------ READ operations ------------------
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> list = productService.findAll();
        // Always return 200 OK, even if list is empty
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        Product product = productService.findById(id);
        if (product == null) {
            // Return 200 OK with null for consistency, or optional: throw custom message
            return ResponseEntity.ok(null);
        }
        return ResponseEntity.ok(product);
    }

    @GetMapping("/searchByName")
    public ResponseEntity<List<Product>> getProductsByName(@RequestParam String name) {
        List<Product> products = productService.findByProductName(name);
        // Always return 200 OK, even if empty
        return ResponseEntity.ok(products);
    }

    // ------------------ WRITE operations ------------------
    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody Product product) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("created-at", LocalDate.now().toString());
        productService.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body("Product created successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(id, product);
        if (updatedProduct == null) return ResponseEntity.ok(null); // or custom message
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        productService.deleteById(id);
        return ResponseEntity.ok("Product deleted successfully");
    }
    
    @PutMapping("/{productId}/reduce")
    public ResponseEntity<String> reduceQuantity(
            @PathVariable int productId,
            @RequestParam int quantity) {

        try {
            productService.reduceQuantity(productId, quantity);
            return ResponseEntity.ok("Quantity reduced successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
