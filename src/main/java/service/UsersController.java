package service;

import dao.UsersDao;
import entities.Users;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class UsersController implements Serializable {

	private Users user = new Users();
    private final UsersDao userDao = new UsersDao();

    public boolean isConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }

    private boolean connected =false;


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

    public void connect() throws IOException {
        System.out.println("Vérification des identifiants pour la connexion...");
        if(this.userDao.findUserByEmailAndPassword(this.user) != null) {
            System.out.println("Connexion accepté...");
            this.user = this.userDao.findUserByEmailAndPassword(this.user);
            this.connected = true;
            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            context.redirect("yourSpace.xhtml");
        }
        else {
            System.out.println("Connexion refusé...");
            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            context.redirect("index.xhtml");
        }
    }


}
