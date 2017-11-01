/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.my_sfa.service;

import com.samwan.my_sfa.model.CrmAccounttypes;
import java.util.ArrayList;
import java.util.List;
import org.mockito.InjectMocks;
import static org.mockito.Matchers.any;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import org.mockito.Spy;
import org.testng.annotations.Test;
import com.samwan.my_sfa.dao.AccountTypeDao;

/**
 *
 * @author smwangi
 */
public class AccounttypeServiceImplTest {
    @Mock
    AccountTypeDao _aAccounttypeDao;
    
    @InjectMocks
    AccounttypeServiceImplTest accounttypeServiceImplTest;
    
    @Spy
    List<CrmAccounttypes> accTypes = new ArrayList<>();
    
    @Test
    public void save(){
        //doNothing().when(_aAccounttypeDao).save(any(CrmAccounttypes.class));
        
    }
}
