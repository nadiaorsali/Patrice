package service;

import dao.UsersDao;
import entities.Users;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class UsersController {

	private final Users individu = new Users();
    private final UsersDao individuDao = new UsersDao();

	public String create() {
        this.individuDao.save(this.individu);
		return "individu?faces-redirect=true";
	}

	public void delete(long id) {
	}

	public List<Users> getAll() {
		return this.individuDao.getAll();
	}

	public Users getIndividu() {
		return individu;
	}
}
