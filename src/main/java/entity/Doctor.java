package entity;

import javax.persistence.*;

@Entity
@Table(name = "doctor")
@NamedQuery(name = "doctor.getAll", query = "SELECT s from Doctor s")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false, insertable = true, updatable = true)
    Integer  id;
    @Column(name = "name")
    String name;
    @Column(name = "phone")
    String phone;
    @Column(name = "speciality")
    String speciality;
    @Column(name = "date_in")
    String date_in;
    @Column(name = "room")
    int room;

    public Doctor() {

    }

    public Integer  getId() {
        return id;
    }

    public void setId(Integer  id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getDate_in() {
        return date_in;
    }

    public void setDate_in(String date_in) {
        this.date_in = date_in;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public Doctor( String name, String phone, String speciality, String date_in, int room,Integer id){
        this.id=id;
        this.name=name;
        this.phone=phone;
        this.speciality=speciality;
        this.date_in=date_in;
        this.room=room;
    }
}
