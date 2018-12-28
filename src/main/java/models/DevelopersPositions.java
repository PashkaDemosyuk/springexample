package models;

import org.springframework.beans.factory.annotation.Autowired;
import lombok.*;
import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Developers_Positions")
public class DevelopersPositions {

    public DevelopersPositions(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "developer_id")
    private Developer developer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "position_id")
    private Positions position;

    @Column(name = "salary", nullable = false)
    private int salary;

    @Column(name = "month", nullable = false)
    private Date month;

    @Autowired
    public DevelopersPositions(long id, Developer developer, Positions position, Set<Project> projects, int salary, Date month) {
        this.id = id;
        this.developer = developer;
        this.position = position;
        this.salary = salary;
        this.month = month;
    }

    public void init(){
        System.out.println("Init DevelopersPositions, id: " + this.id);
    }

    public void destroy(){
        System.out.println("Destroy DevelopersPositions, id: " + this.id);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }

    public Positions getPosition() {
        return position;
    }

    public void setPosition(Positions position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Date getMonth() {
        return month;
    }

    public void setMonth(Date month) {
        this.month = month;
    }
}
