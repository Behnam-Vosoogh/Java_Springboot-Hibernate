package com.java_hibernate.cruddemo.dao;

import com.java_hibernate.cruddemo.entity.Student;

import java.util.List;

public interface StudentDao {

    void save(Student theStudent);
    Student findById(Integer id);
    List<Student> findall();
    List<Student> findByLastName(String theLastName);
    void Update(Student theStudent);
    void delete(Integer id);
    int deleteAll();

}
