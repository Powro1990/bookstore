package com.sda.spring.demo.service;


import com.sda.spring.demo.model.Author;
import com.sda.spring.demo.repository.AuthorRepository;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class AuthorServiceTest {

    @TestConfiguration
    public static class AuthorServiceTestConfig{
        @Bean
        public AuthorService authorService() {
            return new AuthorService();
        }
    }

    @Autowired
    private AuthorService authorService;
    @MockBean
    private AuthorRepository authorRepository;

    @Before
    public void setUp() {
        Author author = new Author("Zenek", "Nowak");
        Mockito.when(authorRepository.findByName(author.getName())).thenReturn(author);
    }

    @Test
    public void whenValidNameThenAuthorShouldBeFound(){
        String name = "Zenek";
        Author found = authorService.getAuthorByName(name);
        Assertions.assertThat(found.getName()).isEqualTo(name);
    }
}