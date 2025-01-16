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

    public Drone(int droneID, UUID serialUUID, Driftstatus driftstatus, Station station, List<Levering> leverings) {
        this.droneID = droneID;
        this.serialUUID = serialUUID;
        this.driftstatus = driftstatus;
        this.station = station;
        this.leverings = leverings;
    }

    public Drone() {
    }

    public int getDroneID() {
        return droneID;
    }

    public void setDroneID(int droneID) {
        this.droneID = droneID;
    }

    public UUID getSerialUUID() {
        return serialUUID;
    }

    public void setSerialUUID(UUID serialUUID) {
        this.serialUUID = serialUUID;
    }

    public Driftstatus getDriftstatus() {
        return driftstatus;
    }

    public void setDriftstatus(Driftstatus driftstatus) {
        this.driftstatus = driftstatus;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public List<Levering> getLeverings() {
        return leverings;
    }

    public void setLeverings(List<Levering> leverings) {
        this.leverings = leverings;
    }
}
