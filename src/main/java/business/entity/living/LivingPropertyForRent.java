package business.entity.living;

import business.entity.LivingPropertyBase;

import java.io.Serializable;
import java.time.LocalDate;

public class LivingPropertyForRent extends LivingPropertyBase implements Serializable {

    private String rentType;
    private int prepaidMonths;

    public LivingPropertyForRent(float price, String address, Float square, int numberOfRooms, int floor, int totalFloors, LocalDate timeAdded, String furnishing, String metroStation, String rentType, int prepaidMonths) {
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
        return "{\"цена\":" + getPrice() + ", \"адрес\":\"" + getAddress() + "\", \"площадь\":" + getSquare() + ", \"количество комнат\":" + getNumberOfRooms() + ", \"этаж\":" + getFloor() + ", \"общее количество этажей\":" + getTotalFloors() + ", \"время добавления\":\"" + getTimeAdded() + "\", \"мебель\":\"" + getFurnishing() + "\", \"метро\":\"" + getMetroStation() + "\", \"тип аренды\":\"" + getRentType() + "\", \"предоплаченные месяцы\":" + getPrepaidMonths() + "}";
    }
}
