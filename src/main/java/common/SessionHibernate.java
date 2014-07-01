package common;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

/**
 * Created by nicolas on 21/05/14.
 */
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
