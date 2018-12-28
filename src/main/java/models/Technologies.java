package models;

import javax.persistence.*;

public class Technologies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @Column(name = "technology_name", nullable = false)
    private String technologyName;

    public Technologies(long id, String technologyName) {
        this.id = id;
        this.technologyName = technologyName;
    }

    public void init(){
        System.out.println("Init Technologies, id: " + this.id);
    }

    public void destroy(){
        System.out.println("Destroy Technologies, id: " + this.id);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTechnologyName() {
        return technologyName;
    }

    public void setTechnologyName(String technologyName) {
        this.technologyName = technologyName;
    }
}
