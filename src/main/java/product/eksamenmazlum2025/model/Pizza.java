package product.eksamenmazlum2025.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pizzaID;
    private String titel;
    private int pris;

    //Relations
    @OneToMany(mappedBy = "pizza")
    @Column(nullable = false)
    @JsonManagedReference
    private List<Levering> levering;

    public Pizza(int pizzaID, String titel, int pris, List<Levering> levering) {
        this.pizzaID = pizzaID;
        this.titel = titel;
        this.pris = pris;
        this.levering = levering;
    }

    public Pizza() {
    }

    public int getPizzaID() {
        return pizzaID;
    }

    public void setPizzaID(int pizzaID) {
        this.pizzaID = pizzaID;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public int getPris() {
        return pris;
    }

    public void setPris(int pris) {
        this.pris = pris;
    }

    public List<Levering> getLevering() {
        return levering;
    }

    public void setLevering(List<Levering> levering) {
        this.levering = levering;
    }
}
