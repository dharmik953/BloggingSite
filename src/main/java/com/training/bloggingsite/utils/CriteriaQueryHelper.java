package com.training.bloggingsite.utils;

import com.training.bloggingsite.entities.Post;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class CriteriaQueryHelper {
    Class<?> className;
    CriteriaBuilder criteriaBuilder;

    EntityManager entityManager;

    CriteriaQuery criteriaQuery;
    Root<?> root;

    public CriteriaQueryHelper(EntityManager entityManager, Class<?> className) {
        this.entityManager = entityManager;
        this.className = className;
        criteriaBuilder = entityManager.getCriteriaBuilder();
        criteriaQuery = criteriaBuilder.createQuery(className);
        root = criteriaQuery.from(className);
    }

    public CriteriaQueryHelper() {
    }

    public <T> List<T> getAllData(String... condition) {
        criteriaQuery.select(root);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    public <T> List<Post> getAllDataWhere(String columnName, T value) {

        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get(columnName), value));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    public <T> List<Post> getPaginatedData(int offset, int limit, String columnName, T value) {
        System.out.println("value for column"+((boolean)value));
        if ((boolean) value == false) {
            criteriaQuery.select(root);//if false then show all post to Admin
            return entityManager.createQuery(criteriaQuery).setFirstResult(offset).setMaxResults(limit).getResultList();

        }
        else {
            criteriaQuery.select(root).where(criteriaBuilder.equal(root.get(columnName), true));
        }


        return entityManager.createQuery(criteriaQuery.orderBy(criteriaBuilder.asc(root.get("title")))).setFirstResult(offset).setMaxResults(limit).getResultList();
    }

    public <T> int getCount(String columnName, T value) {
        if ((boolean) value == false) {

          return   getAllData("").size();///when verified is false return all post for admin view

        }

        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get(columnName), value));
        int count = entityManager.createQuery(criteriaQuery).getResultList().size();

        return count;

    }


}
