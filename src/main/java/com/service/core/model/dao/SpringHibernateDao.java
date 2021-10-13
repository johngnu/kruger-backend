package com.service.core.model.dao;

import org.hibernate.transform.AliasToEntityMapResultTransformer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

@Repository
public class SpringHibernateDao implements Dao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void persist(Object entity) {
        entityManager.persist(entity);
        entityManager.flush();
        entityManager.clear();
    }

    @Override
    @Transactional
    public void update(Object entity) {
        entityManager.merge(entity);
    }

    @Override
    @Transactional
    public void persist(Object[] entities) {
        for (Object entity : entities) {
            persist(entity);
        }
    }

    @Override
    @Transactional
    public void delete(Object entity) {
        entityManager.remove(entity);
    }

    @Override
    @Transactional
    public void delete(Class entityClass, Serializable id) {
        Object entity = get(entityClass, id);
        entityManager.remove(entity);
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional(readOnly = true)
    public List findAll(Class entityClass) {
        return entityManager.createQuery("from " + entityClass.getName()).getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Object get(Class entityClass, Serializable id) {
        return entityManager.find(entityClass, id);
    }

    @Override
    public List executeQueryListMapResult(String SQL) {
        Query query = entityManager.createNativeQuery(SQL).unwrap(org.hibernate.query.Query.class)
                .setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);;
        return query.getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Object executeSigleResult(String SQL) {
        Query query = entityManager.createNativeQuery(SQL).unwrap(org.hibernate.query.Query.class)
                .setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
        return query.getSingleResult();
    }
}
