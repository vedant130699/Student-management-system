package com.vedant.cruddemo.dao;

import com.vedant.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    public void save(Student theStudent);

    public Student findById(Integer id);
//    public void update(Student theStudent);

    public List<Student> findall();

    public List<Student> findByLastName(String lastName);

    public void update(Student theStudent);

    public void delete(Integer id);

    int deleteAll();
}
