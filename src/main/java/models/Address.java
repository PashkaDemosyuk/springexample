package models;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "Address")
@Service
public class Address
{

    public Address(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "homeNumber", nullable = false)
    private int homeNumber;

    @Column(name = "roomNumber", nullable = false)
    private int roomNumber;

    //for ComponentScan @Services + @ComponentScan

    public Address(@Value("0")long id, @Value("")String street, @Value("0")int homeNumber, @Value("0")int roomNumber) {
        this.id = id;
        this.street = street;
        this.homeNumber = homeNumber;
        this.roomNumber = roomNumber;
    }

    public void init(){
        System.out.println("Init Address, id: " + this.id);
    }

    public void destroy(){
        System.out.println("Destroy Address, id: " + this.id);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(int homeNumber) {
        this.homeNumber = homeNumber;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }
}
