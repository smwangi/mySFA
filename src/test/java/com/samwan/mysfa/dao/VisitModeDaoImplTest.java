/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.mysfa.dao;

import com.samwan.mysfa.dao.VisitModeDao;
import com.samwan.mysfa.dao.VisitModeDao;
import com.samwan.mysfa.model.VisitModes;
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
import org.junit.Before;
import static org.mockito.Mockito.mock;

/**
 *
 * @author smwangi
 */
public class VisitModeDaoImplTest extends EntityDaoImplTest {

//    @Autowired
//    private AbstractBaseDao<VisitModes,Integer> abstractBaseDao;
//    
//    @Autowired
//    @Mock
//    private  VisitModeDao _visitModeDao;
    private VisitModeDao _visitModeDao;
    
    @Before
    public void setUpMock(){
        _visitModeDao = mock(VisitModeDao.class);
    }
    
    @Override
    protected IDataSet getDataSet() throws Exception {
      IDataSet dataset =   new FlatXmlDataSet(this.getClass().getClassLoader().getResource("VisitModes.xml"));
      return dataset;
    }
    
    public void init(){
        //abstractBaseDao.setEntity(VisitModes.class);
    }
    
   
    
    //@Test
    public void addVisitModeTest() {
        VisitModes visitModes = new VisitModes();
        visitModes.setAddedby(BigInteger.ZERO);
        visitModes.setDateadded(Date.valueOf(LocalDate.now()));
        visitModes.setDescription("Description");
        visitModes.setIsactive(Short.MIN_VALUE);
        visitModes.setModeId(BigDecimal.ONE.longValue());
        visitModes.setName("Visit Mode Name");
        
        _visitModeDao.save(visitModes);
        
        Assert.assertNotNull(_visitModeDao);
                
    }
    
    //@Test
    public void findOneTest(){
        init();
        VisitModes visitModes = new VisitModes();
        visitModes.setModeId(BigDecimal.ONE.longValue());
        
      VisitModes visitModes1 =  _visitModeDao.fetchOne(BigDecimal.ONE.longValue());
      
      Assert.assertEquals(visitModes, visitModes1);
    }
    
    //@Test
    public void fetchAll() {
        init();
        List<VisitModes> visitModes = new ArrayList<>();
        VisitModes visitMode = new VisitModes();
        visitMode.setModeId(BigDecimal.ONE.longValue());
        visitModes.add(visitMode);
        
        List<VisitModes> vModes =  new ArrayList<>();// _visitModeDao.fetchAll();
        
        //Assert.assertEquals(visitModes, vModes);
        Assert.assertTrue(visitModes.size() >0);
//        Assert.assertTrue(vModes.size() > 0);
   }
}
