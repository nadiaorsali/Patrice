package dao;

import common.SessionHibernate;
import entities.Users;
import org.hibernate.Query;
import org.hibernate.classic.Session;

import java.util.List;

/**
 * Created by nicolas on 01/07/14.
 */
public class UsersDao extends AbstractDao<Users, Long> {
    public static void main(String[] args) {
        UsersDao usersDao = new UsersDao();
        Users users = new Users();
        users.setMail("machut.nicolas@gmail.com");
        users.setPassword("812AJH");
        System.out.println(usersDao.findUserByEmailAndPassword(users).getName());

    }


    public List<Users> getAll()
    {
        return this.list(Users.class);
    }

    @Override
    public Users find(Class<Users> type, Long id) {
        return null;
    }

    public Users findUserByEmailAndPassword(Users user)
    {
        Session session = new SessionHibernate().getInstance();
        org.hibernate.Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from Users where user_mail = :mail and user_password = :password");
        query.setParameter("mail", user.getMail());
        query.setParameter("password", user.getPassword());
        Users userFinded = new Users();
        userFinded = (Users) query.uniqueResult();
        session.close();
        return userFinded;
    }
}
