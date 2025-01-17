package product.eksamenmazlum2025.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Levering {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int leveringID;

    @Column(nullable = false)
    private String adresse;

    @JsonFormat(pattern = "HH:mm")
    @Column(nullable = false)
    private LocalDateTime forventetLevering;
    @JsonFormat(pattern = "HH:mm")
    private LocalDateTime faktiskLevering;

    //Relations
    @ManyToOne
    @JoinColumn(name = "droneFK")
    @JsonBackReference
    private Drone drone;

    @ManyToOne
    @JoinColumn(name = "pizzaID")
    @JsonBackReference
    private Pizza pizza;


    public Levering(int leveringID, String adresse, LocalDateTime forventetLevering, LocalDateTime faktiskLevering, Drone drone, Pizza pizza) {
        this.leveringID = leveringID;
        this.adresse = adresse;
        this.forventetLevering = forventetLevering;
        this.faktiskLevering = faktiskLevering;
        this.drone = drone;
        this.pizza = pizza;
    }

    public Levering() {
    }

    public int getLeveringID() {
        return leveringID;
    }

    public void setLeveringID(int leveringID) {
        this.leveringID = leveringID;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public LocalDateTime getForventetLevering() {
        return forventetLevering;
    }

    public void setForventetLevering(LocalDateTime forventetLevering) {
        this.forventetLevering = forventetLevering;
    }

    public LocalDateTime getFaktiskLevering() {
        return faktiskLevering;
    }

    public void setFaktiskLevering(LocalDateTime faktiskLevering) {
        this.faktiskLevering = faktiskLevering;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public Drone getDrone() {
        return drone;
    }

    public void setDrone(Drone drone) {
        this.drone = drone;
    }
}
