package com.example.springboot3demo.dao;
import com.example.springboot3demo.entity.Student;
import java.util.List;

public interface StudentDAO {
     void save(Student student);
     Student findById(int id);
     List<Student> findByLastName(String lName);
     void updateStudent(Student student);
     void deleteStudent(Integer id);
}
