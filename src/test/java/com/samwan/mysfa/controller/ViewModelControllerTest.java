/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.mysfa.controller;

import com.samwan.mysfa.controllers.VisitModeController;
import com.samwan.mysfa.model.VisitModes;
import com.samwan.mysfa.services.VisitModeService;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.context.MessageSource;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author smwangi
 */
public class ViewModelControllerTest {
    
    @Mock
    VisitModeService visitModeService;
    
    @Mock
    MessageSource messageSource;
    
    @InjectMocks
    VisitModeController visitModeController;
    
    @Spy
    List<VisitModes> visitModes = new ArrayList<>();
    
    @Spy
    ModelMap modelMap;
    
    @Mock
    BindingResult bindingResult;
    
    @BeforeMethod
    public void setup(){
        MockitoAnnotations.initMocks(this);
        visitModes = getVisitModes();
    }
    
    private List<VisitModes> getVisitModes(){
        
       VisitModes visitMode = new VisitModes();
       visitMode.setName("Walk in");
       visitMode.setModeId(new Long("1"));
       
       VisitModes visitMode2 = new VisitModes();
       visitMode2.setName("Impromptu");
       visitMode2.setModeId(new Long("2"));
        
       visitModes.add(visitMode);
       visitModes.add(visitMode2);
       
       return visitModes;
    }
    
    @Test
    public void listVisitModes(){
        when(visitModeService.fetchAll(Boolean.valueOf("true"))).thenReturn(visitModes);
        Assert.assertEquals("allVisitModes", visitModeController.listViewModes(modelMap));
    }
}
