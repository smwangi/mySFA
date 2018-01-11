/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.mysfa.service;

import com.samwan.mysfa.dao.VisitModeDao;
import com.samwan.mysfa.model.VisitModes;
import com.samwan.mysfa.services.impl.VisitModeServiceImpl;
import java.math.BigDecimal;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;
import java.util.ArrayList;
import org.mockito.Spy;

/**
 *
 * @author smwangi
 */
public class VisitModeServiceImplTest {
    
    @Mock
    VisitModeDao visitModeDao;
    
    @InjectMocks
    VisitModeServiceImpl visitModeServiceImpl;
    
    @Spy
    List<VisitModes> visitModes = new ArrayList<>();
    
    @BeforeClass
    public void initMocks() {
       MockitoAnnotations.initMocks(this);
       visitModes = getVisitModes();
    }
    
    @Test
    public void findOne() {
        VisitModes visitModes = this.visitModes.get(1);
        
        
        //Mockito.doNothing().when(_dao).fetchOne(BigDecimal.ONE);
        when(visitModeDao.fetchOne(new Long("2"))).thenReturn(visitModes);
        visitModeServiceImpl.fetchOne(new Long("2"));
        verify(visitModeDao,atLeastOnce()).fetchOne(new Long("2"));
    }
    
    private List<VisitModes> getVisitModes() {
        VisitModes vMode1 = new VisitModes();
        vMode1.setModeId(new Long("1"));
        vMode1.setIsactive(Boolean.valueOf("TRUE"));
        vMode1.setName("Itenarary");
        
        VisitModes vMode2 = new VisitModes();
        vMode2.setModeId(new Long("2"));
        vMode2.setIsactive(Boolean.valueOf("TRUE"));
        vMode2.setName("Itenarary 2");
        
        visitModes.add(vMode1);
        visitModes.add(vMode2);
        return visitModes;
    }
}
