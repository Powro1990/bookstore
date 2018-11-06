package com.sda.spring.demo.interfaces;

import com.sda.spring.demo.model.Category;

import java.util.List;

public interface CategoryInterface {

    List<Category> getCategories();
    Category addCategory(Category category);
    Category findById(Long id);
    void delete(Category category);
    void delete(Long id);
}
