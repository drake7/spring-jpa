package com.example.springboot3demo.dao.impl;

import com.example.springboot3demo.dao.StudentDAO;
import com.example.springboot3demo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    //define fields for entity manager
    private EntityManager entityManager;

    public StudentDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    //inject entity manager




    //implement save methods
    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(int id) {
       Student student = entityManager.find(Student.class,id);
       return student;
    }

    @Override
    public List<Student> findByLastName(String lName) {

        TypedQuery<Student> findByLastNameQuery =
                //here the names Student and lastname are java class and variable names
                //entities and entity fields names not the database table names
                entityManager.createQuery("From Student where lastname=:theData",Student.class);

        findByLastNameQuery.setParameter("theData",lName);

        return findByLastNameQuery.getResultList();
    }

    @Override
    @Transactional
    public void updateStudent(Student student) {
        entityManager.merge(student);
    }
}
