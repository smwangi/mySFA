/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.mysfa.services.impl;

import com.samwan.mysfa.model.Salestages;
import com.samwan.mysfa.services.SalesStageService;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.samwan.mysfa.dao.SaleStageDao;

/**
 *
 * @author smwangi
 */
@Service
public class SalesStageServiceImpl implements SalesStageService {

    @Inject
    public SaleStageDao salesStageDao;
    
    @Override
    public List<Salestages> fetchAll(Boolean isActive) {
        return salesStageDao.fetchAll(isActive);
    }

    @Override
    public Salestages fetchOne(Long id) {
        return salesStageDao.fetchOne(id);
    }

    @Override
    public Salestages save(Salestages entity) {
        return salesStageDao.save(entity);
    }

    @Override
    public Salestages update(Salestages entity) {
        return salesStageDao.update(entity);
    }

    @Override
    public Salestages saveorupdate(Salestages entity) {
        return salesStageDao.saveorupdate(entity);
    }
    
}
