/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.my_sfa.services;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author smwangi
 */
@Component
@Service
public interface BaseService<T,Integer> {
    List<T> fetchAll(Boolean isActive);
    
    T fetchOne(Long id);
    
    T save(T entity);
    
    T update(T entity);
    
    T saveorupdate(T entity);
}
