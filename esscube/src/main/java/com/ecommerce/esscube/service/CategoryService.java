package com.ecommerce.esscube.service;

import java.util.List;

import com.ecommerce.esscube.model.Category;

public interface CategoryService {
  List<Category> getAllCategories();
  void createCategory(Category category);
  String deleteCategory(Long categoryId);
  Category updateCategory(Category category, Long categoryId);
}
