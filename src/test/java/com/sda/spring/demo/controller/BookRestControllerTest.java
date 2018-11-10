package com.sda.spring.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sda.spring.demo.model.Category;
import com.sda.spring.demo.service.CategoryService;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.mockito.verification.VerificationMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BookRestController.class)
public class BookRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CategoryService categoryService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void should_update_category() throws Exception {
        Category category = new Category("History");
        category.setId(1000L);

        given(categoryService.findById(1000L)).willReturn(category);
        ResultActions resultActions = mockMvc.perform(put("/api/category/1000").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(category)));

        resultActions.andExpect(status().isNoContent());
    }


    @Test
    public void givenCategoriesWhenGetCategoriesThenReturnJsonArray() throws Exception{
        Category category = new Category("Fantasy");
        Category category1 = new Category("Automobile");
        Category category2 = new Category("Games");

        List<Category> categories = Arrays.asList(category, category1, category2);

        BDDMockito.given(categoryService.getCategories()).willReturn(categories);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/category").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(jsonPath("$", Matchers.hasSize(3)));

        Mockito.verify(categoryService, VerificationModeFactory.times(2)).getCategories();
    }
}