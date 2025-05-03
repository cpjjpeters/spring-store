package com.codewithmosh.store.controllers;

import com.codewithmosh.store.dtos.ProductDTO;
import com.codewithmosh.store.entities.ProductRepository;
import com.codewithmosh.store.mappers.ProductMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/* carlpeters created on 03/05/2025 inside the package - com.codewithmosh.store.controllers */
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @GetMapping("")
    public List<ProductDTO> getAllProducts(@RequestParam(name = "categoryId", required = false) Byte categoryId) {
        log.debug("Getting all products");


        if (categoryId != null) {
            return productRepository.findBycategoryId(categoryId)
                    .stream()
                    .map(productMapper::productToProductDTO)
                    .toList();
        } else {
            return productRepository.findAllWithCategory()
                    .stream()
                    .map(productMapper::productToProductDTO)
                    .toList();
        }
    }
            @GetMapping("/{id}")
            public ResponseEntity<ProductDTO> getUserById (@PathVariable Long id){
            var product = productRepository.findById(id).orElse(null);
            log.debug("Product: {}", product);
            if (product == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(productMapper.productToProductDTO(product));
        }

}