package com.ecommerce.esscube.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ecommerce.esscube.model.Category;

@Service
public class CategoryServiceImpl implements CategoryService {

  private List<Category> categories = new ArrayList<>();
  private Long nextId = 1L;

  @Override
  public List<Category> getAllCategories() {
    return categories;
  }

  @Override
  public void createCategory(Category category) {
    category.setCategoryId(nextId++);
    categories.add(category);
  }

  @Override
  public String deleteCategory(Long categoryId) {
    Category categoryToRemove = categories.stream().filter(x -> x.getCategoryId().equals(categoryId)).findFirst()
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found in list"));
    // if (categoryToRemove == null) {
    // return "Category not found";
    // }
    categories.remove(categoryToRemove);
    return "Category: " + categoryId + " deleted";
  }

}
