package com.codegym.repository.impl;

import com.codegym.model.Comment;
import com.codegym.repository.CommentRepository;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CommentRepositoryImpl implements CommentRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Comment comment) {
        if(comment.getId() !=null) {
            em.merge(comment);
        } else {
            em.persist(comment);
        }
    }

    @Override
    public List<Comment> getAll() {
//        TypedQuery<Comment> query = em.createQuery("select c from Comment c", Comment.class);
//        return query.getResultList();
        return null;
    }

    @Override
    public Comment findById(Long id) {
//        TypedQuery<Comment> query = em.createQuery("select c from Comment c where c.id=:id", Comment.class);
//        query.setParameter("id", id);
//        try {
//            return query.getSingleResult();
//        } catch (NoResultException e) {
//            return null;
//        }
        return null;
    }
}
