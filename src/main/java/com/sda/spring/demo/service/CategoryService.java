package com.sda.spring.demo.service;

import com.sda.spring.demo.exceptions.BookNotFoundException;
import com.sda.spring.demo.exceptions.CategoryNotFoundException;
import com.sda.spring.demo.interfaces.CategoryInterface;
import com.sda.spring.demo.model.Category;
import com.sda.spring.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class CategoryService implements CategoryInterface {

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id).orElseThrow(
                () -> new BookNotFoundException(id)
        );
    }

    @Override
    public void delete(Category category) {

    }

    @Override
    public void delete(Long id) {

    }

    public Category getCategoryByName(String name){
        return categoryRepository.findByName(name);
    }

    public Category update(Long id, Category category) {
        Category updatedCategory = categoryRepository.findById(id).orElseThrow(
                () -> new CategoryNotFoundException(id)
        );
        updatedCategory.setName(category.getName());
        return  categoryRepository.save(updatedCategory);
    }

}
