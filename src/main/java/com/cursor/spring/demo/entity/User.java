package com.cursor.spring.demo.entity;

import lombok.Data;

@Data
public class User {

    private String id;

    private String dataAccessId;

    private String name;

    private String email;

    private int age;
}
