package product.eksamenmazlum2025.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Levering {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int leveringID;

    @Column(nullable = false)
    private String adresse;

    @Column(nullable = false)
    private LocalDateTime forventetLevering;
    private LocalDateTime faktiskLevering;

    //Relations
    @ManyToOne
    @JoinColumn(name = "droneFK")
    private Drone drone;

    @ManyToOne
    @JoinColumn(name = "pizzaFK")
    private Pizza pizza;


}
