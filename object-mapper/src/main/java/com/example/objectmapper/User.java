package com.example.objectmapper;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    private String name;
    private int age;

    @JsonProperty("phone_number")
    private String phoneNumber;

    public User() {
        this.name = null;
        this.age = 0;
        this.phoneNumber = null;
    }

    public User(String name, int age, String phoneNumber) { //Constructor overloading
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    //object mapper는 get method()만 참조
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public User defaultUser() { //내가 작성한 클래스가 object mapper에서 활용이 된다면 method 이름에 get이라고 붙이면 안됨(error)
        return new User("default" , 0, "010-1111-2222");
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
