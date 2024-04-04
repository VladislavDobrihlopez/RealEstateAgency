package business.entity.commercial;

import business.entity.CommercialPropertyBase;

import java.io.Serializable;
import java.time.LocalDateTime;

public class OfficeProperty extends CommercialPropertyBase implements Serializable {

    public OfficeProperty(float price, String address, Float square, int numberOfRooms, int floor, int totalFloors, LocalDateTime timeAdded, String amenities) {
        super(price, address, square, numberOfRooms, floor, totalFloors, timeAdded, amenities);
    }

    @Override
    public String toString() {
        return gson.toJson(this);
    }
}
