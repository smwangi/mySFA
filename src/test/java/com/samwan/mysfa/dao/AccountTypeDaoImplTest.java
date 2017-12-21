/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.mysfa.dao;

import com.samwan.mysfa.model.AccountTypes;
import com.samwan.mysfa.services.impl.AccountTypeServiceImpl;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.junit.Before;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.mockito.Mockito.*;
import org.springframework.util.Assert;
import org.testng.annotations.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author smwangi
 */

public class AccountTypeDaoImplTest extends EntityDaoImplTest {
       
    @Autowired
    private AccountTypeDao accountTypeDao;
    
    @Autowired
    private AbstractBaseDao<AccountTypes,Long> abstractBaseDao;
   
    @Override
    protected IDataSet getDataSet() throws Exception {
        IDataSet dataSet = new FlatXmlDataSet(this.getClass().getClassLoader().getResource("AccountTypes.xml"));
        return dataSet;
    }
         
    @Test
    public   void findOne() {
        System.out.println("Dao "+accountTypeDao);
        assertNotNull(accountTypeDao);
        abstractBaseDao.setEntity(AccountTypes.class);
        assertNotNull(abstractBaseDao);
       // when(accountTypeDao.save(any(AccountTypes.class))).thenReturn(new AccountTypes());
      // AccountTypes acc = new AccountTypes();
      // acc.setAType("");
      // assertThat(_accountTypeService.save(acc), is(notNullValue()));
      // assertNull(accountTypeDao);
        Assert.notNull(accountTypeDao.fetchOne(new Long("1")));
	//Assert.isNull(_accountTypeDao.fetchOne(BigDecimal.TEN.longValue()));
    }
    
    //@Test
    public void fetchAll() {
        
//        Assert.notEmpty(_acAccountTypeDao.fetchAll());
  //      Assert.isTrue(_acAccountTypeDao.fetchAll().stream().count() > 0);
    }
    
   // @Test
    public void save(){
        AccountTypes accounttypes = new AccountTypes();
        accounttypes.setAType("Type");
        accounttypes.setAccountTypeId(BigDecimal.TEN.longValue());
        accounttypes.setIsactive(BigInteger.ONE);
        accounttypes.setIsdeleted(BigInteger.ZERO);
       // _accountTypeDao.save(accounttypes);
        Assert.notNull(accountTypeDao);
        
    }
    
}
