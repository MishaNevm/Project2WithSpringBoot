package com.example.Project2Boot.dao;

import com.example.Project2Boot.models.Book;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Component
public class BookDAO {

    private final EntityManager entityManager;

    @Autowired
    public BookDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public List<Book> findAllFreeBooks() {
        try (Session session = entityManager.unwrap(Session.class)) {
            return session.createQuery("select b from Book b where b.owner=null", Book.class).getResultList();
        }
    }

}
