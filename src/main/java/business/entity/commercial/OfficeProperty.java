package business.entity.commercial;

import business.entity.CommercialPropertyBase;

public class OfficeProperty extends CommercialPropertyBase {

    public OfficeProperty(String address, Float square, int numberOfRooms, int floor, int totalFloors, String amenities) {
        super(address, square, numberOfRooms, floor, totalFloors, amenities);
    }
}
