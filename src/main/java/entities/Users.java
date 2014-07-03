package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "Users")
public class Users {

	private Long id;

	@Size(min = 1, max = 30, message = "Le nom est obligatoire est doit contenir au plus 30 caractères !")
	private String name;

	@Size(min = 1, max = 30, message = "Le prénom est obligatoire est doit contenir au plus 30 caractères !")
	private String firstname;

	@NotNull(message = "L'âge est obligatoire")
	@Min(value = 0, message = "L'âge ne peut pas être négatif")
	@Max(value = 150, message = "L'âge est incorrect")
	private Integer age;

    @Size(min = 1, message = "Veuillez renseigner votre adresse email")
    @Column(name = "user_mail")
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    private String mail;

    @Size(min = 1, message = "Veuillez renseigner votre mot de passe")
    @Column(name = "user_password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;

    @Id
    @GeneratedValue
    @Column(name = "user_id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    @Column(name = "user_name")
	public String getName() {
		return name;
	}

	public void setName(String nom) {
		this.name = nom;
	}

    @Column(name = "user_firstname")
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String prenom) {
		this.firstname = prenom;
	}

    @Column(name="user_age")
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
