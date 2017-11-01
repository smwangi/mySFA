/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.my_sfa.service;

import com.samwan.my_sfa.dao.VisitModeDao;
import com.samwan.my_sfa.model.CrmVisitModes;
import com.samwan.my_sfa.services.VisitModeServiceImpl;
import java.math.BigDecimal;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author smwangi
 */
public class VisitModeServiceImplTest {
    
    @Mock
    VisitModeDao _dao;
    
    @InjectMocks
    VisitModeServiceImpl _service;
    
    @BeforeMethod
    public void initMocks() {
       MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void findOne() {
        CrmVisitModes visitModes = new CrmVisitModes();
        
        //Mockito.doNothing().when(_dao).fetchOne(BigDecimal.ONE);
        when(_dao.fetchOne(BigDecimal.ONE.longValue())).thenReturn(visitModes);
        _service.fetchOne(BigDecimal.ONE.longValue());
        verify(_dao,atLeastOnce()).fetchOne(BigDecimal.ONE.longValue());
    }
}
