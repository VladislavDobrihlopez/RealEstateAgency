package business;

import business.entity.BaseProperty;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class PropertySearchEngine {

    private PropertySearchEngine() {}

    private String location = null;
    private Float minPrice = null;
    private Float maxPrice = null;
    private Integer numberOfRooms = null;
    private Integer floor = null;
    private Integer totalFloors = null;
    private LocalDateTime timeAdded = null;

    public List<BaseProperty> search(Collection<BaseProperty> items) {
        return items.stream().filter(baseProperty -> {
            boolean shouldTake = true;
            if (timeAdded != null && !(baseProperty.getTimeAdded().isAfter(timeAdded))) shouldTake = false;
            if (minPrice != null && (baseProperty.getPrice() < minPrice || baseProperty.getPrice() > maxPrice))
                shouldTake = false;
            if (numberOfRooms != null && baseProperty.getNumberOfRooms() != numberOfRooms) shouldTake = false;
            if (floor != null && baseProperty.getFloor() != floor) shouldTake = false;
            if (totalFloors != null && baseProperty.getTotalFloors() != totalFloors) shouldTake = false;
            if (location != null && !baseProperty.getAddress().toLowerCase().contains(location)) shouldTake = false;

            return shouldTake;
        }).collect(Collectors.toList());
    }

    public static class SearchEngineBuilder {
        private PropertySearchEngine instance;

        public SearchEngineBuilder buildSearch() {
            instance = new PropertySearchEngine();
            return this;
        }

        public SearchEngineBuilder byLocation(String location) {
            instance.location = location.trim().toLowerCase();
            return this;
        }

        public SearchEngineBuilder byPriceRange(Float minPrice, Float maxPrice) {
            instance.minPrice = minPrice;
            instance.maxPrice = maxPrice;
            return this;
        }

        public SearchEngineBuilder byNumberOfRooms(int rooms) {
            instance.numberOfRooms = rooms;
            return this;
        }

        public SearchEngineBuilder byFloor(int floor) {
            instance.floor = floor;
            return this;
        }

        public SearchEngineBuilder byTotalFloors(int floors) {
            instance.totalFloors = floors;
            return this;
        }

        public SearchEngineBuilder takeFrom(LocalDateTime startTime) {
            instance.timeAdded = startTime;
            return this;
        }

        public PropertySearchEngine build() {
            return instance;
        }
    }
}
