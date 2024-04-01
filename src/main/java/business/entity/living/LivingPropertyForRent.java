package business.entity.living;

import business.entity.LivingBaseProperty;

import java.time.LocalDateTime;

public class LivingPropertyForRent extends LivingBaseProperty {
    private String rentType;

    private int prepaidMonths;

    public LivingPropertyForRent(float price, String address, Float square, int numberOfRooms, int floor, int totalFloors, LocalDateTime timeAdded, String furnishing, String metroStation, String rentType, int prepaidMonths) {
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
}
