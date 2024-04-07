package business.entity.commercial;

import business.entity.CommercialPropertyBase;

import java.io.Serializable;
import java.time.LocalDate;

public class OfficeProperty extends CommercialPropertyBase implements Serializable {

    public OfficeProperty(float price, String address, Float square, int numberOfRooms, int floor, int totalFloors, LocalDate timeAdded, String amenities) {
        super(price, address, square, numberOfRooms, floor, totalFloors, timeAdded, amenities);
    }

    @Override
    public String toString() {
        return "{\"цена\":" + getPrice() + ", \"адрес\":\"" + getAddress() + "\", \"площадь\":" + getSquare() + ", \"количество комнат\":" + getNumberOfRooms() + ", \"этаж\":" + getFloor() + ", \"общее количество этажей\":" + getTotalFloors() + ", \"время добавления\":\"" + getTimeAdded() + "\", \"удобства\":\"" + getAmenities() + "\"}";
    }
}
