package entity;
import javax.persistence.*;
@Entity
@Table(name = "disease")
@NamedQuery(name = "disease.getAll", query = "SELECT c from Disease c")
public class Disease {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_disease",nullable = false, insertable = true, updatable = true)
    Integer  id_disease;
    @Column(name = "name", length = 255)
    String name;
    @Column(name = "sign")
    String sign;
    public Disease(Integer  id_disease, String name, String sign){
        this.id_disease=id_disease;
        this.name=name;
        this.sign=sign;
    }

    public Disease() {

    }

    public Integer  getId_disease() {
        return id_disease;
    }

    public void setId_disease(Integer  id_disease) {
        this.id_disease = id_disease;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
