/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.mysfa.services.impl;

import com.samwan.mysfa.dao.ActivityTypeDao;
import com.samwan.mysfa.model.ActivityTypes;
import com.samwan.mysfa.services.ActivityTypeService;
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
    public List<ActivityTypes> fetchAll(Boolean isActive) {
        return _activityTypeDao.fetchAll(isActive);
    }

    @Override
    public ActivityTypes fetchOne(Long id) {
       return _activityTypeDao.fetchOne(id);
    }

    @Override
    public ActivityTypes save(ActivityTypes entity) {
       return _activityTypeDao.save(entity);
    }

    @Override
    public ActivityTypes update(ActivityTypes entity) {
       return _activityTypeDao.update(entity);
    }

    @Override
    public ActivityTypes saveorupdate(ActivityTypes entity) {
        return _activityTypeDao.saveorupdate(entity);
    }
    
}
