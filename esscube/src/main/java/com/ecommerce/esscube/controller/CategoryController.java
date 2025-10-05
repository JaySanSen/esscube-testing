package com.ecommerce.esscube.controller;

import java.util.List;
import com.ecommerce.esscube.model.Category;
import com.ecommerce.esscube.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class CategoryController {
  private CategoryService categoryService;

  @Autowired
  public CategoryController(CategoryService categoryService) {
    this.categoryService = categoryService;
  }

  @GetMapping("api/public/categories")
  public ResponseEntity<List<Category>> getAllCategories() {
    return ResponseEntity.status(HttpStatus.OK).body(categoryService.getAllCategories());
  }

  @PostMapping("api/public/categories")
  public ResponseEntity<String> createCategory(@RequestBody Category category) {
    categoryService.createCategory(category);
    return ResponseEntity.ok("Category created");
  }

  @DeleteMapping("api/admin/categories/{categoryId}")
  public ResponseEntity<String> deleteCategory(@PathVariable Long categoryId) {
    try {
      String status = categoryService.deleteCategory(categoryId);
      return new ResponseEntity<>(status, HttpStatus.OK);
    } catch (ResponseStatusException e) {
      return new ResponseEntity<>(e.getReason(), e.getStatusCode());
    }
  }

  @PutMapping("api/admin/categories/{categoryId}")
  public ResponseEntity<String> updateCategory(@RequestBody Category category, @PathVariable Long categoryId) {
    try {
      Category savedCategory = categoryService.updateCategory(category, categoryId);
      return ResponseEntity.status(HttpStatus.OK).body("Category: " + categoryId + " updated successfully");
    } catch (ResponseStatusException e) {
      return ResponseEntity.status(e.getStatusCode()).body(e.getReason());
    }
  }
}