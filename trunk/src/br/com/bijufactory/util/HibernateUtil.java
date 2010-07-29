/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.bijufactory.util;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author HP
 */
public class HibernateUtil {

    private static SessionFactory sessionfactory;

    private static Logger log = Logger.getLogger(HibernateUtil.class);

    static {
        try {
           log.info("Criando Session Factory");
           sessionfactory = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
           log.info("Session Factory Criada");
           //Configuration conf =  new AnnotationConfiguration();
           //conf.addAnnotatedClass(BjProducts.class);
           // conf.configure("hibernate.cfg.xml");
           // sessionfactory = conf. buildSessionFactory();
           // SchemaExport se =  new SchemaExport(conf);
           // se.create(true, true);

        } catch (Throwable t){
              throw new ExceptionInInitializerError(t);
        }
    }

    public static SessionFactory getSessionFactory(){
        return sessionfactory;
    }

    public static Session getSession() {
        return sessionfactory.openSession();  
    }

    public static void shutdown(){
        getSessionFactory().close();
    }
}
