package hibernate.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pan")  
public class Pan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pan_id")  
    private int panId;

    @Column(name = "panholder_name")
    private String panholderName;

    @Column(name = "pan_number")
    private String panNumber;

    // Getters & Setters
    public int getPanId() {
        return panId;
    }

    public void setPanId(int panId) {
        this.panId = panId;
    }

    public String getPanholderName() {
        return panholderName;
    }

    public void setPanholderName(String panholderName) {
        this.panholderName = panholderName;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    // toString
    @Override
    public String toString() {
        return "Pan [panId=" + panId + ", panholderName=" + panholderName + ", panNumber=" + panNumber + "]";
    }

    // Constructors
    public Pan(String panholderName, String panNumber) {
        this.panholderName = panholderName;
        this.panNumber = panNumber;
    }
    
    public Pan(int panId, String panholderName, String panNumber) {
        this.panId = panId;
        this.panholderName = panholderName;
        this.panNumber = panNumber;
    }


    public Pan() {
    }
}
