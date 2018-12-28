package models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import lombok.*;
import javax.persistence.*;

@MappedSuperclass
@Qualifier("abstractUser") //связывание по имени
public class AbstractUser {

    public AbstractUser(){

    }

    @Autowired
    public AbstractUser(long id, String password, String login) {
        this.id = id;
        this.password = password;
        this.login = login;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    protected long id;

    @Column(name = "password", nullable = false)
    protected String password;

    @Column(name = "login", nullable = false)
    @Value("")
    protected String login;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
