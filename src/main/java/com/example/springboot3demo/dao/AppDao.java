package com.example.springboot3demo.dao;

import com.example.springboot3demo.entity.Instructor;
import com.example.springboot3demo.entity.InstructorDetail;

public interface AppDao {

    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    InstructorDetail findInstructorDetailById(int id);
}
