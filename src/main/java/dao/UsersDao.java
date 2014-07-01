package dao;

import entities.Users;

import java.util.List;

/**
 * Created by nicolas on 01/07/14.
 */
public class UsersDao extends AbstractDao<Users, Long> {


    public List<Users> getAll()
    {
        return this.list(Users.class);
    }

    @Override
    public Users find(Class<Users> type, Long id) {
        return null;
    }
}
