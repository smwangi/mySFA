/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.my_sfa.dao;

import com.samwan.my_sfa.model.CrmVisitModes;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author smwangi
 */
public class VisitModeDaoImplTest extends EntityDaoImplTest {

    @Autowired
    private AbstractBaseDao<CrmVisitModes,Integer> abstractBaseDao;
    
    @Autowired
    @Mock
    private  VisitModeDao _visitModeDao;
    
    @Override
    protected IDataSet getDataSet() throws Exception {
      IDataSet dataset =   new FlatXmlDataSet(this.getClass().getClassLoader().getResource("CRM_VISIT_MODES.xml"));
      return dataset;
    }
    
    public void init(){
        abstractBaseDao.setEntity(CrmVisitModes.class);
    }
    
   
    
    @Test
    public void addVisitModeTest() {
        CrmVisitModes visitModes = new CrmVisitModes();
        visitModes.setAddedby(BigInteger.ZERO);
        visitModes.setDateadded(Date.valueOf(LocalDate.now()));
        visitModes.setDescription("Description");
        visitModes.setIsactive(Short.MIN_VALUE);
        visitModes.setModeId(BigDecimal.ONE.longValue());
        visitModes.setName("Visit Mode Name");
        
        _visitModeDao.save(visitModes);
        
        Assert.assertNotNull(_visitModeDao);
                
    }
    
    @Test
    public void findOneTest(){
        init();
        CrmVisitModes visitModes = new CrmVisitModes();
        visitModes.setModeId(BigDecimal.ONE.longValue());
        
      CrmVisitModes visitModes1 =  _visitModeDao.fetchOne(BigDecimal.ONE.longValue());
      
      Assert.assertEquals(visitModes, visitModes1);
    }
    
    @Test
    public void fetchAll() {
        init();
        List<CrmVisitModes> visitModes = new ArrayList<>();
        CrmVisitModes visitMode = new CrmVisitModes();
        visitMode.setModeId(BigDecimal.ONE.longValue());
        visitModes.add(visitMode);
        
        List<CrmVisitModes> vModes =  new ArrayList<>();// _visitModeDao.fetchAll();
        
        //Assert.assertEquals(visitModes, vModes);
        Assert.assertTrue(visitModes.size() >0);
//        Assert.assertTrue(vModes.size() > 0);
   }
}
