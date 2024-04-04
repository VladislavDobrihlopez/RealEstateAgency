package business.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

public abstract class LivingPropertyBase extends BaseProperty implements Serializable {
    private String furnishing;
    private String metroStation;

    public LivingPropertyBase(float price, String address, Float square, int numberOfRooms, int floor, int totalFloors, LocalDateTime timeAdded, String furnishing, String metroStation) {
        super(price, address, square, numberOfRooms, floor, totalFloors, timeAdded);
        this.furnishing = furnishing;
        this.metroStation = metroStation;
    }

    public String getFurnishing() {
        return furnishing;
    }

    public void setFurnishing(String furnishing) {
        this.furnishing = furnishing;
    }

    public String getMetroStation() {
        return metroStation;
    }

    public void setMetroStation(String metroStation) {
        this.metroStation = metroStation;
    }
}
