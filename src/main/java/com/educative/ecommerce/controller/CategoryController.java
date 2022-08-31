package com.educative.ecommerce.controller;

import com.educative.ecommerce.Common.ApiResponce;
import com.educative.ecommerce.model.Category;
import com.educative.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponce> createCategory(@RequestBody Category category) {
        categoryService.createCategory(category);
        return new ResponseEntity<>(new ApiResponce(true,"create a new category"), HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public List<Category> listCategory() {
        return categoryService.listCategory();
    }

    @PostMapping("/update/{categoryId}")
    public ResponseEntity<ApiResponce> updateCategory(@PathVariable("categoryId") int categoryId,@RequestBody Category category ){
        System.out.println("categoryId = " + categoryId);
      if(!(categoryService.findByid(categoryId))){
          return new ResponseEntity<>(new ApiResponce(true,"Category not found"),HttpStatus.NOT_FOUND);
      }
        categoryService.editCategory(categoryId, category);
        return new ResponseEntity<>(new ApiResponce(true,"Category updated"),HttpStatus.OK);
    }
}
