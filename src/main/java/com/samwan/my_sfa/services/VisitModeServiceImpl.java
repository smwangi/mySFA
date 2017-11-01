/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.my_sfa.services;

import com.samwan.my_sfa.dao.VisitModeDao;
import com.samwan.my_sfa.model.CrmVisitModes;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author smwangi
 */
@Component
public class VisitModeServiceImpl implements VisitModeService {

    @Autowired
    private VisitModeDao _visitModeDao;
    
    @Override
    public List<CrmVisitModes> fetchAll(Boolean isActive) {
        return _visitModeDao.fetchAll(isActive);
    }

    @Override
    public CrmVisitModes fetchOne(Long id) {
       return _visitModeDao.fetchOne(id);
    }

    @Override
    public CrmVisitModes save(CrmVisitModes entity) {
      return _visitModeDao.save(entity);
    }

    @Override
    public CrmVisitModes update(CrmVisitModes entity) {
       return _visitModeDao.update(entity);
    }

    @Override
    public CrmVisitModes saveorupdate(CrmVisitModes entity) {
       return _visitModeDao.saveorupdate(entity);
    }
    
}
