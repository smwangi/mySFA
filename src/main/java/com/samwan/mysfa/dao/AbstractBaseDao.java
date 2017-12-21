/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.mysfa.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author smwangi
 */
@Component
public abstract class AbstractBaseDao<E,PK extends Serializable> /*implements  BaseDao<E,PK>*/{
    
    private Class<E> entity;
    
    @SuppressWarnings("unchecked")
	public AbstractBaseDao(){
		this.entity =(Class<E>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}
    
    @Autowired
    private SessionFactory sessionFactory;

    public final Session  getSession(){
        return  sessionFactory.getCurrentSession();
    }
    
    public Class<E> getEntity(){
        return entity;
    }
    
    public void setEntity(Class<E> entity){
        this.entity = entity;
    }
     
    //@Override
    public E fetchOne(Long id) {
       return (E) getSession().get(entity, id);
    }

    //@Override
    public List<E> fetchAll(Boolean isActive) {
        /*CriteriaQuery criteriaQuery = getSession().getCriteriaBuilder().createQuery(entity);
        criteriaQuery.select(criteriaQuery.from(entity));
        Query q = getSession().createQuery(criteriaQuery);
        
       return q.getResultList();*///getCurrentSession().createQuery("FROM " +entity.getSimpleName() ).list();
       Criteria criteria = getSession().createCriteria(entity);
       criteria.add(Restrictions.eq("isactive", isActive));
       List<E> result = (List<E>)criteria.uniqueResult();
       return result;
    }

    //@Override
    public E saveorupdate(E entity) {
        getSession().saveOrUpdate(entity);
        return entity;
    }
    
    //@Override
    public E save(E entity) {
        getSession().save(entity);
       return entity;
    }

    //@Override
    public E update(E entity) {
        getSession().update(entity);
        return entity;
    }

    public E deactivate(E entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public E activate(E entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
