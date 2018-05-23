package lv.myProject.java2.App.Domain;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="users")
public class User {

    @Column(name="UserName", nullable = false)
    String userName;
    @Column(name="Password", nullable = false)
    String userPassword;

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userName, user.userName) &&
                Objects.equals(userPassword, user.userPassword) &&
                Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userName, userPassword, id);
    }
}
