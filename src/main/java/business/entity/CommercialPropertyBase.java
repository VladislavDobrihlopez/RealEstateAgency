package business.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

public abstract class CommercialPropertyBase extends BaseProperty implements Serializable {
    private String amenities;

    public CommercialPropertyBase(float price, String address, Float square, int numberOfRooms, int floor, int totalFloors, LocalDateTime timeAdded, String amenities) {
        super(price, address, square, numberOfRooms, floor, totalFloors, timeAdded);
        this.amenities = amenities;
    }

    public String getAmenities() {
        return amenities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }
}
