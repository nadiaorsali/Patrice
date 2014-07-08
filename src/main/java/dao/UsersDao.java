package dao;

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
        users.setId((long) 1);
        System.out.println(usersDao.get(Users.class, users.getId()).getMail());

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
        Session session = this.getSessionHibernate();
        org.hibernate.Transaction transaction = session.beginTransaction();
        Users userFinded = new Users();
        try{
            System.out.println("Finding a user by email and password ...");
            Query query = session.createQuery("from Users where user_mail = :mail and user_password = :password");
            query.setParameter("mail", user.getMail());
            query.setParameter("password", user.getPassword());
            userFinded = (Users) query.uniqueResult();
        } catch (RuntimeException re) {
            System.out.println("Error during finding a user by email and password : "+ re);
        } finally {
            session.close();
        }
        return userFinded;
    }
}
