package entity;
import javax.persistence.*;

@Entity
@Table(name = "patient")
@NamedQuery(name = "patient.getAll", query = "SELECT p from Patient p")

public class Patient {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Column(name = "card")
    Integer  card;
    @Column(name = "name")
    String name;
    @Column(name = "birthday")
    String birthday;
    @Column(name = "male")
    boolean male;//1-мужчина 0-женщина
    public  Patient(Integer card, String name, String birthday, boolean male){
        this.card=card;
        this.name=name;
        this.birthday=birthday;
        this.male=male;
    }

    public Patient() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public boolean getMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    public Integer getCard() {
        return card;
    }

    public void setCard(Integer card) {
        this.card = card;
    }
}
