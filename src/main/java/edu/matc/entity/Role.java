package edu.matc.entity;

import edu.matc.persistence.GenericDao;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name = "Role")
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;

    @Column(name = "role_name")
    private String roleName;

    @Column(name="username")
    private String userName;

    @OneToOne
    @Column(name = "user_id")
    private User userId;


    public Role() {
    }

    public Role(String roleName, String userName, User userId) {
        this.roleName = roleName;
        this.userName = userName;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public void addRole(String roleName, String userName, User userId) {
        Role role = new Role();

        role.setRoleName(roleName);
        role.setUserName(userName);
        role.setUserId(userId);

        GenericDao<Role> dao = new GenericDao<>(Role.class);
        dao.insert(role);
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", userName='" + userName + '\'' +
                ", userId=" + userId +
                '}';
    }
}
