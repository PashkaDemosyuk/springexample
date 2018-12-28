package models;

import lombok.*;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Positions")
public class Positions {

    public Positions(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @Column(name = "position_name", nullable = false)
    private String positionName;

    @OneToMany(mappedBy = "position")
    private Set<DevelopersPositions> developerPositions;

    public Positions(long id, String positionName) {
        this.id = id;
        this.positionName = positionName;
    }

    public void init(){
        System.out.println("Init Positions, id: " + this.id);
    }

    public void destroy(){
        System.out.println("Destroy Positions, id: " + this.id);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public Set<DevelopersPositions> getDeveloperPositions() {
        return developerPositions;
    }

    public void setDeveloperPositions(Set<DevelopersPositions> developerPositions) {
        this.developerPositions = developerPositions;
    }
}
