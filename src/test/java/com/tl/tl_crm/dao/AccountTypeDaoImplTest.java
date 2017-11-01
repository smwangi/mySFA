/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tl.tl_crm.dao;

import com.tl.tl_crm.model.CrmAccounttypes;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author smwangi
 */
public class AccountTypeDaoImplTest extends EntityDaoImplTest {

    @Autowired
    private AbstractBaseDao<CrmAccounttypes,Integer> abstractDao;
    
    @Autowired
    @Mock
    AccountTypeDao _acAccountTypeDao;
      
    @Override
    protected IDataSet getDataSet() throws Exception {
        IDataSet dataSet = new FlatXmlDataSet(this.getClass().getClassLoader().getResource("CRM_ACCOUNTTYPES.xml"));
        return dataSet;
    }
   
    public void init(){
         abstractDao.setEntity(CrmAccounttypes.class);
    }
      
    @Test
    public   void findOne() {
        init();
        System.out.println("Dao "+_acAccountTypeDao);
      
        Assert.notNull(_acAccountTypeDao.fetchOne(BigDecimal.ONE.longValue()));
	Assert.isNull(_acAccountTypeDao.fetchOne(BigDecimal.TEN.longValue()));
    }
    
    @Test
    public void fetchAll() {
        init();
//        Assert.notEmpty(_acAccountTypeDao.fetchAll());
  //      Assert.isTrue(_acAccountTypeDao.fetchAll().stream().count() > 0);
    }
    
    @Test
    public void save(){
        CrmAccounttypes accounttypes = new CrmAccounttypes();
        accounttypes.setAType("Type");
        accounttypes.setAccountTypeId(BigDecimal.TEN.longValue());
        accounttypes.setIsactive(BigInteger.ONE);
        accounttypes.setIsdeleted(BigInteger.ZERO);
        _acAccountTypeDao.save(accounttypes);
        Assert.notNull(_acAccountTypeDao);
        
    }
    
}
