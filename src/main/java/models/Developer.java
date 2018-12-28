package models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import lombok.*;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Developers")
//@Service
public class Developer extends AbstractUser{

    //  for ComponentScan @Services + @ComponentScan
//    public Developer(Address address){
//        super((long)1, "1111", "login");
//        this.address = address;
//    }

    static public long id;

    @Column(name = "experience", nullable = false)
    private int experience;

    @Column(name = "birthday", nullable = false)
    private Date birthday;

    @OneToMany(mappedBy = "developer")
    private Set<DevelopersPositions> developerPositions;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ADDRESS_ID")
    private Address address;

    public Developer(){}

    public Developer(@Value("0") long id, @Value("")String password, @Value("")String login, @Value("0")int experience, @Value("01/01/2011")Date birtday, Address address) {
        super(id, password, login);
        this.experience = experience;
        this.birthday = birtday;
        this.address = address;
    }

    public void init(){
        System.out.println("Init Developer, id: " + this.id);
    }

    public void destroy(){
        System.out.println("Destroy Developer, id: " + this.id);
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Set<DevelopersPositions> getDeveloperPositions() {
        return developerPositions;
    }

    public void setDeveloperPositions(Set<DevelopersPositions> developerPositions) {
        this.developerPositions = developerPositions;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
