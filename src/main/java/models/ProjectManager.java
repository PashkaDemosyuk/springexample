package models;

import javax.persistence.*;

@Entity
@Table(name = "ProjectManagers")
public class ProjectManager extends AbstractUser{

    public static long id;

    public ProjectManager(){

    }

    public ProjectManager(long id, String password, String login) {
        super(id,password,login);
    }

    public void init(){
        System.out.println("Init ProjectManagers, id: " + this.id);
    }

    public void destroy(){
        System.out.println("Destroy ProjectManagers, id: " + this.id);
    }

}
