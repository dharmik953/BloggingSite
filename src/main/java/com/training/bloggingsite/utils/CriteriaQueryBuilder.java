package com.training.bloggingsite.utils;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CriteriaQueryBuilder {

    private CriteriaBuilder cb;

    @Autowired
    EntityManager em;

    @PostConstruct
    public void init() {
        this.cb = em.getCriteriaBuilder();
    }

    public <F,T> List<T> getResultWhereColumnEqual(String column, F value,Class<T> clazz) {
        CriteriaQuery<T> cq = cb.createQuery(clazz);
        Root<T> root = cq.from(clazz);
        cq.select(root).where(cb.equal( root.get(column), value));
        return em.createQuery(cq).getResultList();
    }

    public <T> List<T> getResultWhereColumnIsNull(String column,Class<T> clazz) {
        CriteriaQuery<T> cq = cb.createQuery(clazz);
        Root<T> root = cq.from(clazz);
        cq.select(root).where(cb.isNull( root.get(column)));
        return em.createQuery(cq).getResultList();
    }

    public <T> List<T> getAll(Class<T> clazz) {
        CriteriaQuery<T> cq = cb.createQuery(clazz);
        Root<T> root = cq.from(clazz);
        cq.select(root).where(cb.gt(root.get("id"),0));
        return em.createQuery(cq).getResultList();
    }

    public <T,F> void deleteById(String column,F id,Class<T> clazz){
        CriteriaDelete<T> cq = cb.createCriteriaDelete(clazz);
        Root<T> root = cq.from(clazz);
        cq.where(root.get(column).in(id));
        em.createQuery(cq).executeUpdate();
    }

}
