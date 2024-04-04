package business.entity.living;

import business.entity.LivingPropertyBase;

import java.io.Serializable;
import java.time.LocalDateTime;

public class LivingPropertyForRentBase extends LivingPropertyBase implements Serializable {
    private String rentType;

    private int prepaidMonths;

    public LivingPropertyForRentBase(float price, String address, Float square, int numberOfRooms, int floor, int totalFloors, LocalDateTime timeAdded, String furnishing, String metroStation, String rentType, int prepaidMonths) {
        super(price, address, square, numberOfRooms, floor, totalFloors, timeAdded, furnishing, metroStation);
        this.rentType = rentType;
        this.prepaidMonths = prepaidMonths;
    }

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType;
    }

    public int getPrepaidMonths() {
        return prepaidMonths;
    }

    public void setPrepaidMonths(int prepaidMonths) {
        this.prepaidMonths = prepaidMonths;
    }

    @Override
    public String toString() {
        return gson.toJson(this);
    }
}
