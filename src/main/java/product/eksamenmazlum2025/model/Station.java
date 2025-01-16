package product.eksamenmazlum2025.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;


import java.util.ArrayList;
import java.util.List;

@Entity
/*
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

 */
public class Station {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stationID;
    private String latitude;
    private String longitude;

    @OneToMany(mappedBy = "station")
    @JsonManagedReference
    private List<Drone> droneList;

    public Station(int stationID, String latitude, String longitude, List<Drone> droneList) {
        this.stationID = stationID;
        this.latitude = latitude;
        this.longitude = longitude;
        this.droneList = droneList;
    }

    public Station() {
    }

    public int getStationID() {
        return stationID;
    }

    public void setStationID(int stationID) {
        this.stationID = stationID;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public List<Drone> getDroneList() {
        return droneList;
    }

    public void setDroneList(List<Drone> droneList) {
        this.droneList = droneList;
    }
}
