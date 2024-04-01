package business.entity;

import java.time.LocalDateTime;

public abstract class BaseProperty {
    private float price;

    private String address;

    private Float square;

    private int numberOfRooms;

    private int floor;

    private int totalFloors;

    private LocalDateTime timeAdded;

    public BaseProperty(float price, String address, Float square, int numberOfRooms, int floor, int totalFloors, LocalDateTime timeAdded) {
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

    public LocalDateTime getTimeAdded() {
        return timeAdded;
    }

    public void setTimeAdded(LocalDateTime timeAdded) {
        this.timeAdded = timeAdded;
    }
}
