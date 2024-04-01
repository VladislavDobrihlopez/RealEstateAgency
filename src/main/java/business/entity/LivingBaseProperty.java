package business.entity;

import java.time.LocalDateTime;

public abstract class LivingBaseProperty extends BaseProperty {
    private String furnishing;
    private String metroStation;

    public LivingBaseProperty(float price, String address, Float square, int numberOfRooms, int floor, int totalFloors, LocalDateTime timeAdded, String furnishing, String metroStation) {
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
