/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.my_sfa.services;

import com.samwan.my_sfa.dao.ActivityTypeDao;
import com.samwan.my_sfa.model.CrmActivityTypes;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author smwangi
 */
public class ActivityTypeServiceImpl implements ActivityTypeService{

    @Autowired
    ActivityTypeDao _activityTypeDao;
    
    @Override
    public List<CrmActivityTypes> fetchAll(Boolean isActive) {
        return _activityTypeDao.fetchAll(isActive);
    }

    @Override
    public CrmActivityTypes fetchOne(Long id) {
       return _activityTypeDao.fetchOne(id);
    }

    @Override
    public CrmActivityTypes save(CrmActivityTypes entity) {
       return _activityTypeDao.save(entity);
    }

    @Override
    public CrmActivityTypes update(CrmActivityTypes entity) {
       return _activityTypeDao.update(entity);
    }

    @Override
    public CrmActivityTypes saveorupdate(CrmActivityTypes entity) {
        return _activityTypeDao.saveorupdate(entity);
    }
    
}
