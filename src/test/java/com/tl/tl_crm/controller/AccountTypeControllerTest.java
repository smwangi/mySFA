/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tl.tl_crm.controller;

import com.tl.tl_crm.model.CrmAccounttypes;
import com.tl.tl_crm.services.AccountTypeService;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 *
 * @author smwangi
 */
public class AccountTypeControllerTest {
    
    @Mock
    private AccountTypeService _accountTypeService;
    
    @InjectMocks
    AccountTypeControllerTest _accountTypeControllerTest;
    
    @Spy
    List<CrmAccounttypes> accountTypes = new ArrayList<>();
    
    @Spy
    ModelMap model;
    
    @Mock
    BindingResult result;
    
    @BeforeClass
    public void init(){
        MockitoAnnotations.initMocks(this);
        accountTypes = getAccountTypes();
        
    }
    
    @Test
    public void ListCrmAccounttypes() {
        when(_accountTypeService.fetchAll(false)).thenReturn(accountTypes);
        //Assert.assertEquals(_accountTypeControllerTest.ListCrmAccounttypes(model), 0, 0);
    }
    
    private List<CrmAccounttypes> getAccountTypes(){
        List<CrmAccounttypes> crmAccounttypeses = new ArrayList<>();
        
        CrmAccounttypes accounttypes = new CrmAccounttypes();
        accounttypes.setAType("Type");
        accounttypes.setAccountTypeId(new BigInteger("1").longValue());
        accounttypes.setIsactive(BigInteger.ONE);
        accounttypes.setIsdeleted( BigInteger.ZERO);
        
        crmAccounttypeses.add(accounttypes);
        return crmAccounttypeses;
    }
}
