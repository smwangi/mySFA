/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.mysfa.services.impl;

import com.samwan.mysfa.dao.VisitModeDao;
import com.samwan.mysfa.model.VisitModes;
import com.samwan.mysfa.services.VisitModeService;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author smwangi
 */
@Component
@Service
public class VisitModeServiceImpl implements VisitModeService {

    @Autowired
    private VisitModeDao _visitModeDao;
    
    @Override
    public List<VisitModes> fetchAll(Boolean isActive) {
        return _visitModeDao.fetchAll(isActive);
    }

    @Override
    public VisitModes fetchOne(Long id) {
       return _visitModeDao.fetchOne(id);
    }

    @Override
    public VisitModes save(VisitModes entity) {
      return _visitModeDao.save(entity);
    }

    @Override
    public VisitModes update(VisitModes entity) {
       return _visitModeDao.update(entity);
    }

    @Override
    public VisitModes saveorupdate(VisitModes entity) {
       return _visitModeDao.saveorupdate(entity);
    }
    
}
