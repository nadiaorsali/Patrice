package common;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import javax.ejb.Singleton;

/**
 * Created by nicolas on 21/05/14.
 */
@Singleton
public class SessionHibernate {
    private SessionFactory factory;
    private Session session;

    public SessionHibernate()
    {
        factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    }

    public Session getInstance()
    {
        if(session == null)
        {
            session = factory.openSession();
        }
        return session;
    }
}
