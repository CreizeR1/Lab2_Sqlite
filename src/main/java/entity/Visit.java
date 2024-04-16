package entity;
import javax.persistence.*;

@Entity
@Table(name = "visit")
@NamedQuery(name = "visit.getAll", query = "SELECT v from Visit v")
public class Visit {
    @ManyToOne
    @JoinColumn(name = "id_patient")
    Patient id_patient;
    @ManyToOne
    @JoinColumn(name = "id_doctor")
    Doctor id_doctor;
    @ManyToOne
    @JoinColumn(name = "id_disease")
    Disease id_disease;
    @Column(name = "date")
    String date;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false, insertable = true, updatable = true)
    Integer id;
    public Visit(Patient id_patient, Doctor id_doctor, Disease id_disease, String date, Integer id){
        this.id=id;
        this.id_patient=id_patient;
        this.id_doctor=id_doctor;
        this.id_disease=id_disease;
        this.date=date;
    }

    public Visit() {

    }




    public void setDate(String date) {
        this.date = date;
    }
    public String getDate(){
        return date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
