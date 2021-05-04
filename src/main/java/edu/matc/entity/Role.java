package edu.matc.entity;

import edu.matc.persistence.GenericDao;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * The class for Role - Hibernate.
 */
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


    /**
     * Instantiates a new Role.
     */
    public Role() {
    }

    /**
     * Instantiates a new Role.
     *
     * @param roleName the role name
     * @param userName the user name
     * @param userId   the user id
     */
    public Role(String roleName, String userName, User userId) {
        this.roleName = roleName;
        this.userName = userName;
        this.userId = userId;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets role name.
     *
     * @return the role name
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * Sets role name.
     *
     * @param roleName the role name
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * Gets user name.
     *
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets user name.
     *
     * @param userName the user name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets user id.
     *
     * @return the user id
     */
    public User getUserId() {
        return userId;
    }

    /**
     * Sets user id.
     *
     * @param userId the user id
     */
    public void setUserId(User userId) {
        this.userId = userId;
    }

    /**
     * Add role.
     *
     * @param roleName the role name
     * @param userName the user name
     * @param userId   the user id
     */
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
