package business.entity.living;

import business.entity.LivingPropertyBase;

import java.io.Serializable;
import java.time.LocalDate;

public class LivingPropertyForSale extends LivingPropertyBase implements Serializable {

    public LivingPropertyForSale(float price, String address, Float square, int numberOfRooms, int floor, int totalFloors, LocalDate timeAdded, String furnishing, String metroStation) {
        super(price, address, square, numberOfRooms, floor, totalFloors, timeAdded, furnishing, metroStation);
    }

    @Override
    public String toString() {
        return "{\"цена\":" + getPrice() + ", \"адрес\":\"" + getAddress() + "\", \"площадь\":" + getSquare() + ", \"количество комнат\":" + getNumberOfRooms() + ", \"этаж\":" + getFloor() + ", \"общее количество этажей\":" + getTotalFloors() + ", \"время добавления\":\"" + getTimeAdded() + "\", \"мебель\":\"" + getFurnishing() + "\", \"метро\":\"" + getMetroStation() + "\"}";
    }
}
