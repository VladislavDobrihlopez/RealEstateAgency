package business.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class CommercialPropertyBase extends BaseProperty implements Serializable {
    private String amenities;

    public CommercialPropertyBase(float price, String address, Float square, int numberOfRooms, int floor, int totalFloors, LocalDate timeAdded, String amenities) {
        super(price, address, square, numberOfRooms, floor, totalFloors, timeAdded);
        this.amenities = amenities;
    }

    public String getAmenities() {
        return amenities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    @Override
    public String toString() {
        return "{\"цена\":" + getPrice() + ", \"адрес\":\"" + getAddress() + "\", \"площадь\":" + getSquare() + ", \"количество комнат\":" + getNumberOfRooms() + ", \"этаж\":" + getFloor() + ", \"общее количество этажей\":" + getTotalFloors() + ", \"время добавления\":\"" + getTimeAdded() + "\", \"удобства\":\"" + getAmenities() + "\"}";
    }
}
