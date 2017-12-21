/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samwan.mysfa.configuration;

import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

/**
 *
 * @author smwangi
 */
//@Configuration
//@EnableTransactionManagement
//@ComponentScan({"com.tl.tl_crm.configuration"})
//@PropertySource(value = "file:${user.home}/wildfly/crm_configs/nightly_application.properties")
public class Hibernate5Configuration {
    
    private static Hibernate5Configuration hibernateConnector;
    // private SessionFactory sessionFactory;
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
		dataSource.setDriverClassName(environment.getRequiredProperty("DB_DRIVER_CLASS"));
		dataSource.setUrl(environment.getRequiredProperty("DB_URL"));
		dataSource.setUsername(environment.getRequiredProperty("DB_USERNAME"));
		dataSource.setPassword(environment.getRequiredProperty("DB_PASSWORD"));
		return dataSource;
	}

	/**
	 * Initialize hibernate properties
	 * 
	 * @return Properties
	 */
	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put(AvailableSettings.DIALECT, environment.getRequiredProperty("hibernate.dialect"));
		properties.put(AvailableSettings.SHOW_SQL, environment.getRequiredProperty("hibernate.show_sql"));
		properties.put(AvailableSettings.STATEMENT_BATCH_SIZE, environment.getRequiredProperty("hibernate.batch.size"));
		properties.put(AvailableSettings.HBM2DDL_AUTO, environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
		properties.put(AvailableSettings.CURRENT_SESSION_CONTEXT_CLASS, environment.getRequiredProperty("hibernate.current.session.context.class"));
		return properties;
	}
	
	@Bean
	public SessionFactory getSessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(getDataSource());
		sessionFactory.setPackagesToScan(new String[] { "com.samwan.my_sfa.model" });
		sessionFactory.setHibernateProperties(getHibernateProperties());
		return sessionFactory.getObject();
	}


	/**
	 * Initialize Transaction Manager
	 * 
	 * @param sessionFactory
	 * @return HibernateTransactionManager
	 
	@Bean
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);
		return txManager;
	}
    */
    
    //private Hibernate5Configuration() throws HibernateException {
        //Build the config
        //cfg = new Configuration();
        /**
         * Connection Information
         */
        /*cfg.setProperty("hibernate.connection.driver_class", "oracle.jdbc.driver.OracleDriver");//environment.getRequiredProperty("DB_DRIVER_CLASS"));
        cfg.setProperty("hibernate.connection.url", "jdbc:oracle:thin:@197.232.25.77:1521:orcl");//environment.getRequiredProperty("DB_URL"));
        cfg.setProperty("hibernate.connection.username", "tangazoletucrm");//environment.getRequiredProperty("DB_USERNAME"));//"root"
        cfg.setProperty("hibernate.connection.password", "tangazoletucrmv10RACL3");//environment.getRequiredProperty("DB_PASSWORD"));
        cfg.setProperty("hibernate.show_sql", "true");
        */
        /**
         * Map Resource
         */
        //cfg.addPackage("com.tl.tl_crm.model");
        //cfg.addResource("file:${user.home}/wildfly/crm_configs/nightly_application.properties");
        
        //sessionFactory = cfg.buildSessionFactory();
    
    //}
    
      /*public static synchronized Hibernate5Configuration getInstance() throws HibernateException {
        if (hibernateConnector == null) {
            hibernateConnector = new Hibernate5Configuration();
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
