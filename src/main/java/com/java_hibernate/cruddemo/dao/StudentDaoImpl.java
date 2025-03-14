package com.java_hibernate.cruddemo.dao;

import com.java_hibernate.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao{

    //define field for entity manager
    private EntityManager entityManager;

    //inject entity manager using constructor injection
    @Autowired
    public StudentDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // implement save method
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);

    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findall() {
        //create query
        TypedQuery<Student> tehQuery = entityManager.createQuery("FROM Student",Student.class);
//        TypedQuery<Student> tehQuery = entityManager.createQuery("FROM Student order by  lastName desc",Student.class);
        //return query results
        return tehQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        //create query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName=:theData",Student.class);

        //set query parameters
        theQuery.setParameter("theData",theLastName);
        //return query results
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void Update(Student theStudent) {
        entityManager.merge(theStudent);

    }

    @Override
    @Transactional
    public void delete(Integer id) {
        //retrieve the student
        Student theStudent = entityManager.find(Student.class,id);
        //delete the student
        entityManager.remove(theStudent);

    }
}
