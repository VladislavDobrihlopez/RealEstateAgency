package business.entity;

import com.google.gson.Gson;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class BaseProperty implements Serializable {

    protected static Gson gson = new Gson();

    protected float price;

    protected String address;

    protected float square;

    protected int numberOfRooms;

    protected int floor;

    protected int totalFloors;

    protected LocalDate timeAdded;

    public BaseProperty(float price, String address, Float square, int numberOfRooms, int floor, int totalFloors, LocalDate timeAdded) {
        this.price = price;
        this.address = address;
        this.square = square;
        this.numberOfRooms = numberOfRooms;
        this.floor = floor;
        this.totalFloors = totalFloors;
        this.timeAdded = timeAdded;
    }

    public float getPrice() {
        return price;
    }

    public String getAddress() {
        return address;
    }

    public Float getSquare() {
        return square;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public int getFloor() {
        return floor;
    }

    public int getTotalFloors() {
        return totalFloors;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setSquare(Float square) {
        this.square = square;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public void setTotalFloors(int totalFloors) {
        this.totalFloors = totalFloors;
    }

    public LocalDate getTimeAdded() {
        return timeAdded;
    }

    public void setTimeAdded(LocalDate timeAdded) {
        this.timeAdded = timeAdded;
    }

    @Override
    public String toString() {
        return "{\"цена\":" + getPrice() + ", \"адрес\":\"" + getAddress() + "\", \"площадь\":" + getSquare() + ", \"количество комнат\":" + getNumberOfRooms() + ", \"этаж\":" + getFloor() + ", \"общее количество этажей\":" + getTotalFloors() + ", \"время добавления\":\"" + getTimeAdded() + "\"}";
    }
}
