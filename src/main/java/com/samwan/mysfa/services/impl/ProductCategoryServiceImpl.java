/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.mysfa.services.impl;

import com.samwan.mysfa.dao.ProductCategoryDao;
import com.samwan.mysfa.model.Categories;
import com.samwan.mysfa.services.ProductCategoryService;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author smwangi
 */
public class ProductCategoryServiceImpl implements ProductCategoryService{

    @Autowired
    ProductCategoryDao _productCategoryDao;
    
    @Override
    public List<Categories> fetchAll(Boolean isActive) {
       return _productCategoryDao.fetchAll(isActive);
    }

    @Override
    public Categories fetchOne(Long id) {
       return _productCategoryDao.fetchOne(id);
    }

    @Override
    public Categories save(Categories entity) {
       return _productCategoryDao.save(entity);
    }

    @Override
    public Categories update(Categories entity) {
        return _productCategoryDao.update(entity);
    }

    @Override
    public Categories saveorupdate(Categories entity) {
        return _productCategoryDao.saveorupdate(entity);
    }
    
}
