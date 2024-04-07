package business.entity.living;

import business.entity.LivingPropertyBase;

import java.io.Serializable;
import java.time.LocalDateTime;

public class LivingPropertyForSale extends LivingPropertyBase implements Serializable {

    public LivingPropertyForSale(float price, String address, Float square, int numberOfRooms, int floor, int totalFloors, LocalDateTime timeAdded, String furnishing, String metroStation) {
        super(price, address, square, numberOfRooms, floor, totalFloors, timeAdded, furnishing, metroStation);
    }

    @Override
    public String toString() {
        return gson.toJson(this);
    }
}
