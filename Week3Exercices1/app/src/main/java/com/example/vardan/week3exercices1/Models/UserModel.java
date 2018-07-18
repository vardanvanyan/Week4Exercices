package com.example.vardan.week3exercices1.Models;


import java.util.List;

public class UserModel {
    private String name;
    private String age;
    private String trophy;
    private String image;
    private String phone;
    private String description;
    private String email;
    private List<MessageModel> message;

    public UserModel(String name, String age, String trophy, String image, String phone, String description, String email, List<MessageModel> message) {
        this.name = name;
        this.age = age;
        this.trophy = trophy;
        this.image = image;
        this.phone = phone;
        this.description = description;
        this.email = email;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getTrophy() {
        return trophy;
    }

    public void setTrophy(String trophy) {
        this.trophy = trophy;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<MessageModel> getMessage() {
        return message;
    }

    public void setMessage(List<MessageModel> message) {
        this.message = message;
    }
}




