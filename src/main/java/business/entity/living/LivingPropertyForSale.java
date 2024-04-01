package business.entity.living;

import business.entity.LivingBaseProperty;

import java.time.LocalDateTime;

public class LivingPropertyForSale extends LivingBaseProperty {

    public LivingPropertyForSale(float price, String address, Float square, int numberOfRooms, int floor, int totalFloors, LocalDateTime timeAdded, String furnishing, String metroStation) {
        super(price, address, square, numberOfRooms, floor, totalFloors, timeAdded, furnishing, metroStation);
    }
}
