package entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by nicolas on 06/07/14.
 */
@Entity(name = "UserType")
public class UserType {
    private int uTypeId;
    private String uTypeLibelle;
    private List<Users> usersList;

    @OneToMany
    @JoinColumn(name = "user_id")
    public List<Users> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<Users> usersList) {
        this.usersList = usersList;
    }

    @Id
    @Column(name = "uType_id", nullable = false, insertable = true, updatable = true)
    public int getuTypeId() {
        return uTypeId;
    }

    public void setuTypeId(int uTypeId) {
        this.uTypeId = uTypeId;
    }

    @Basic
    @Column(name = "uType_libelle", nullable = false, insertable = true, updatable = true, length = 50)
    public String getuTypeLibelle() {
        return uTypeLibelle;
    }

    public void setuTypeLibelle(String uTypeLibelle) {
        this.uTypeLibelle = uTypeLibelle;
    }

}
