package com.ecommerce.esscube.controller;

import java.util.ArrayList;
import java.util.List;
import com.ecommerce.esscube.model.Category;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {
  private List<Category> categories = new ArrayList<>();

  @GetMapping("api/public/categories")
  public List<Category> getAllCategories() {
    return categories;
  }
}
