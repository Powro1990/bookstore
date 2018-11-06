package com.sda.spring.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min=2, max = 20, message = "od 2 do 20 znaków")
    private String name;
    @NotNull
    @Size(min=2, max = 20, message = "od 2 do 20 znaków")
    private String lastName;

    @ManyToMany(mappedBy = "authorSet")
    private Set<Book> bookSet;

    public Author() {
    }

    public Author(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }
}
