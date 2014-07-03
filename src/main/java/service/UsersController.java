package service;

import dao.UsersDao;
import entities.Users;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class UsersController {

	private final Users user = new Users();
    private final UsersDao userDao = new UsersDao();

	public String create() {
        this.userDao.save(this.user);
		return "individu?faces-redirect=true";
	}

	public void delete(long id) {
	}

	public List<Users> getAll() {
		return this.userDao.getAll();
	}

	public Users getUser() {
		return user;
	}

    public void connect()
    {
        if(this.userDao.findUserByEmailAndPassword(this.user) != null)
        {
            System.out.println("coonecté");
        }
        else
        {
            System.out.println("pas connecté");
        }
    }
}
