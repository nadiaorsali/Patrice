package common;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;

/**
 * Created by nicolas on 21/05/14.
 */
@Singleton
public class SessionHibernate {
    private SessionFactory factory;


    @PostConstruct
    public void init() {
        factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    }

    @PreDestroy
    public void tearDown() {
        if (factory != null) {
            factory.close();
        }
    }

    public Session getInstance() {
        return factory.openSession();
    }
}
