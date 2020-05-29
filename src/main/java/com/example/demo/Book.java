package com.example.demo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Book implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String content;
    private String auth;
    private Integer number;

    public Book(){
        super();
    }

    public Book(String name, String content, String auth, Integer number){
        this.auth = auth;
        this.name = name;
        this.content = content;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public Integer getNumber() {
        return number;
    }

    public Long getId() {
        return id;
    }

    public String getAuth() {
        return auth;
    }

    public String getContent() {
        return content;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }
}
