package com.sda.spring.demo.service;


import com.sda.spring.demo.model.Category;
import com.sda.spring.demo.repository.CategoryRepository;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class CategoryServiceTest {



    @TestConfiguration
    public static class CategoryServiceTestConfig {
        @Bean
        public CategoryService categoryService() {
            return new CategoryService();
        }
    }


    @Autowired
    private CategoryService categoryService;

    @MockBean
    private CategoryRepository categoryRepository;


    @Before
    public void setUp() {
        Category category = new Category("Automobile");
        Mockito.when(categoryRepository.findByName(category.getName())).thenReturn(category);
    }


    @Test
    public void whenValidNameThenCategoryShouldBeFound() {
        String name = "Automobile";
        Category found = categoryService.getCategoryByName(name);
        Assertions.assertThat(found.getName()).isEqualTo(name);
    }

}