package com.educative.ecommerce.controller;


import com.educative.ecommerce.Common.ApiResponce;
import com.educative.ecommerce.Dto.ProductDto;
import com.educative.ecommerce.model.Category;
import com.educative.ecommerce.model.Product;
import com.educative.ecommerce.repository.CategoryRepo;
import com.educative.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    CategoryRepo categoryRepo;


    @PostMapping("/add")
    public ResponseEntity<ApiResponce> createProduct(@RequestBody ProductDto productDto) {
        final Optional<Category> optional = categoryRepo.findById(productDto.getCategoryid());
        if (!(optional.isPresent())) {
            return new ResponseEntity<>(new ApiResponce(false, "category does not exists"), HttpStatus.BAD_REQUEST);
        }
        productService.createProduct(productDto, optional.get());
        return new ResponseEntity<>(new ApiResponce(true, "product has been saved"), HttpStatus.CREATED);

    }

    @GetMapping("/list")
    public ResponseEntity<List<ProductDto>> getProducts(){

        List<ProductDto> productDtos=productService.getAllProducts();
        return new ResponseEntity<>(productDtos,HttpStatus.OK);

    }

    @PostMapping("/update/{productId")
    public ResponseEntity<ApiResponce> updateProduct(@PathVariable("productId") Integer productId, @RequestBody ProductDto productDto) {
        Optional<Category> optional = categoryRepo.findById(productDto.getCategoryid());
        if (!(optional.isPresent())) {
            return new ResponseEntity<>(new ApiResponce(false, "category does not exists"), HttpStatus.BAD_REQUEST);
        }
        productService.updateProduct(productDto, optional.get());
        return new ResponseEntity<>(new ApiResponce(true, "product has been saved"), HttpStatus.CREATED);

    }
}
