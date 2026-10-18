package com.student.model;

public class Student {

    private int id;
    private String name;
    private String course;
    private String email;
    private String address;
    private String phone;
    private int age;
    private String gender;

    public Student() {
    }

    public Student(String name, String course, String email,
                   String address, String phone, int age,
                   String gender) {

        this.name = name;
        this.course = course;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.age = age;
        this.gender = gender;
    }

    public Student(int id, String name, String course,
                   String email, String address,
                   String phone, int age, String gender) {

        this.id = id;
        this.name = name;
        this.course = course;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.age = age;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}