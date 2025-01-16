package product.eksamenmazlum2025.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import product.eksamenmazlum2025.model.enums.Driftstatus;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Drone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int droneID;
    @Column(nullable = false)
    /*
    serialUUID.randomUUID(), kald på metoden så den generer en random værdi for dig.
     */
    private UUID serialUUID;
    private Driftstatus driftstatus;


    //Relations
    @ManyToOne
    @JoinColumn(name = "stationFK", nullable = false)
    @JsonBackReference
    private Station station;

    @OneToMany(mappedBy = "drone")
    @Column(nullable = true)
    @JsonManagedReference
    private List<Levering> leverings;



}
