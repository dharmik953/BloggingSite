package com.training.bloggingsite.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class CriteriaQueryBuilder <T>{

    private EntityManager em;
    private Class<T> getClass;
    private CriteriaBuilder cb;
    private CriteriaQuery<T> cq;
    private Root<T> root;



    public CriteriaQueryBuilder(Class<T> getClass,EntityManager em) {
        this.em = em;
        this.getClass = getClass;
        this.cb = em.getCriteriaBuilder();
        this.cq = cb.createQuery(getClass);
        this.root = cq.from(getClass);
    }

    public <F> List<T> getResultWhereColumnEqual(String column, F value) {
        cq.select(root).where(cb.equal( root.get(column), value));
        return em.createQuery(cq).getResultList();
    }

    public List<T> getResultWhereColumnIsNull(String column) {
        cq.select(root).where(cb.isNull( root.get(column)));
        return em.createQuery(cq).getResultList();
    }

    public List<T> getAll() {
        cq.select(root).where(cb.gt(root.get("id"),0));
        System.out.println("From Data Base ->>>>>"+em.createQuery(cq).getResultList());
        return em.createQuery(cq).getResultList();
    }

}
