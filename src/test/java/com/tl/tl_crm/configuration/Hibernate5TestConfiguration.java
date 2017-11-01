/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tl.tl_crm.configuration;

import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author smwangi
 */
//@Configuration
@EnableTransactionManagement
@ComponentScan({"com.tl.tl_crm.dao"})
//@PropertySource(value = "file:${user.home}/wildfly/crm_configs/nightly_application.properties")
public class Hibernate5TestConfiguration {
    //private static HIbernate5TestConfiguration hibernateConnector;
     private SessionFactory sessionFactory;
    private Configuration cfg;
    
    @Autowired
    public Environment environment;
    
    /**
	 * Initialize dataSource
	 * 
	 * @return DataSource
	 */
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		return dataSource;
	}

	/**
	 * Initialize hibernate properties
	 * 
	 * @return Properties
	 */
	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put(AvailableSettings.DIALECT, "org.hibernate.dialect.H2Dialect");
		properties.put(AvailableSettings.SHOW_SQL, "true");
		properties.put(AvailableSettings.STATEMENT_BATCH_SIZE, "20");
		properties.put(AvailableSettings.HBM2DDL_AUTO, "create-drop");
		properties.put(AvailableSettings.CURRENT_SESSION_CONTEXT_CLASS, "org.springframework.orm.hibernate5.SpringSessionContext");
		return properties;
	}
	
	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(getDataSource());
		sessionFactory.setPackagesToScan(new String[] { "com.tl.tl_crm.model" });
		sessionFactory.setHibernateProperties(getHibernateProperties());
		return sessionFactory;
	}


	/**
	 * Initialize Transaction Manager
	 * 
	 * @param sessionFactory
	 * @return HibernateTransactionManager
	 */
	@Bean
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);
		return txManager;
	}
    
   /* private Hibernate5TestConfiguration() throws HibernateException {
        //Build the config
        cfg = new Configuration();
        /**
         * Connection Information
         */
        /*cfg.setProperty("hibernate.connection.driver_class", "org.h2.Driver");//environment.getRequiredProperty("DB_DRIVER_CLASS"));
        cfg.setProperty("hibernate.connection.url", "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE");//environment.getRequiredProperty("DB_URL"));
        cfg.setProperty("hibernate.connection.username", "sa");//environment.getRequiredProperty("DB_USERNAME"));//"root"
        cfg.setProperty("hibernate.connection.password", "");//environment.getRequiredProperty("DB_PASSWORD"));
        cfg.setProperty("hibernate.show_sql", "true");
        */
        /**
         * Map Resource
         */
       /* cfg.addPackage("com.tl.tl_crm.model");
        //cfg.addResource("file:${user.home}/wildfly/crm_configs/nightly_application.properties");
        
        sessionFactory = cfg.buildSessionFactory();
    
    }*/
    
      /*public static synchronized HIbernate5TestConfiguration getInstance() throws HibernateException {
        if (hibernateConnector == null) {
            hibernateConnector = new HIbernate5TestConfiguration();
        }

        return hibernateConnector;
    }

    public Session getSession() throws HibernateException {
        Session session = sessionFactory.openSession();
        if (!session.isConnected()) {
            this.reconnect();
        }
        return session;
    }

    private void reconnect() throws HibernateException {
        this.sessionFactory = cfg.buildSessionFactory();
    }*/

}
