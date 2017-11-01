/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.my_sfa.services;

import com.samwan.my_sfa.dao.ProductCategoryDao;
import com.samwan.my_sfa.model.CrmProductscategories;
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
    public List<CrmProductscategories> fetchAll(Boolean isActive) {
       return _productCategoryDao.fetchAll(isActive);
    }

    @Override
    public CrmProductscategories fetchOne(Long id) {
       return _productCategoryDao.fetchOne(id);
    }

    @Override
    public CrmProductscategories save(CrmProductscategories entity) {
       return _productCategoryDao.save(entity);
    }

    @Override
    public CrmProductscategories update(CrmProductscategories entity) {
        return _productCategoryDao.update(entity);
    }

    @Override
    public CrmProductscategories saveorupdate(CrmProductscategories entity) {
        return _productCategoryDao.saveorupdate(entity);
    }
    
}
