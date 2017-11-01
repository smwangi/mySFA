/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.my_sfa.dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author smwangi
 */
@Component
public interface BaseDao<E,PK extends Serializable> {
    
    E fetchOne(final Long id);
    
    List<E> fetchAll(Boolean isActive);
    
    E saveorupdate(final E entity);
    
    E save(final E entity);
    
    E update(final E entity);
    
    E deactivate(final E entity);
    
    E activate(final E entity);
    
   // List<T> getListByCriteria(DetachedCriteria detachedCriteria);
    
}
