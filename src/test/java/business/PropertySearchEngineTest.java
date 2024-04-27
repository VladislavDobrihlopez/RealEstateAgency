package business;

import business.entity.BaseProperty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PropertySearchEngineTest {
    private final List<BaseProperty> properties = new ArrayList<>();

    @BeforeEach
    void setUp() {
        properties.clear();
        BaseProperty property1 = new MockProperty(100000, "123 Main St", 100.0f, 3, 2, 5, LocalDate.now());
        BaseProperty property2 = new MockProperty(150000, "456 Elm St", 120.0f, 4, 3, 6, LocalDate.now());
        BaseProperty property3 = new MockProperty(200000, "789 Oak St", 150.0f, 5, 4, 7, LocalDate.now());
        properties.add(property1);
        properties.add(property2);
        properties.add(property3);
    }

    @Test
    public void testFilterByLocation_should_return_main_street() {
        PropertySearchEngine searchEngine = PropertySearchEngine.SearchEngineBuilder.buildSearch()
                .byLocation("main")
                .build();

        List<BaseProperty> filteredProperties = searchEngine.search(properties);

        assertEquals(1, filteredProperties.size());
        assertEquals(getFirstProperty(), filteredProperties.get(0));
    }

    @Test
    public void testFilterByPriceRange_in_100000_150000_expects_2_properties() {
        PropertySearchEngine searchEngine = PropertySearchEngine.SearchEngineBuilder.buildSearch()
                .byPriceRange(100000f, 150000f)
                .build();

        List<BaseProperty> filteredProperties = searchEngine.search(properties);

        assertEquals(2, filteredProperties.size());
        assertEquals(getFirstProperty(), filteredProperties.get(0));
        assertEquals(getSecondProperty(), filteredProperties.get(1));
    }

    @Test
    public void testFilterByNumberOfRooms() {
        PropertySearchEngine searchEngine = PropertySearchEngine.SearchEngineBuilder.buildSearch()
                .byNumberOfRooms(4)
                .build();

        List<BaseProperty> filteredProperties = searchEngine.search(properties);

        assertEquals(1, filteredProperties.size());
        assertEquals(getSecondProperty(), filteredProperties.get(0));
    }

    @Test
    public void testFilterByFloor() {
       PropertySearchEngine searchEngine = PropertySearchEngine.SearchEngineBuilder.buildSearch()
                .byFloor(4)
                .build();

        List<BaseProperty> filteredProperties = searchEngine.search(properties);

        assertEquals(1, filteredProperties.size());
        assertEquals(getThirdProperty(), filteredProperties.get(0));
    }

    @Test
    public void testFilterByTotalFloors() {
       PropertySearchEngine searchEngine = PropertySearchEngine.SearchEngineBuilder.buildSearch()
                .byTotalFloors(5)
                .build();

        List<BaseProperty> filteredProperties = searchEngine.search(properties);

        assertEquals(1, filteredProperties.size());
        assertEquals(getFirstProperty(), filteredProperties.get(0));
    }

    @Test
    public void testFilterByTimeAdded() {
        LocalDate today = LocalDate.now();
        LocalDate yesterday = today.minusDays(1);
        LocalDate twoDaysAgo = today.minusDays(2);

        BaseProperty property1 = new MockProperty(100000, "123 Main St",
                100.0f, 3,
                2, 5, today);
        BaseProperty property2 = new MockProperty(150000, "456 Elm St",
                120.0f, 4,
                3, 6, yesterday);
        BaseProperty property3 = new MockProperty(200000, "789 Oak St",
                150.0f, 5,
                4, 7, twoDaysAgo);

        properties.clear();
        properties.add(property1);
        properties.add(property2);
        properties.add(property3);

        PropertySearchEngine.SearchEngineBuilder searchEngine = PropertySearchEngine.SearchEngineBuilder.buildSearch()
                .takeFrom(today);

        List<BaseProperty> filteredProperties = searchEngine.build().search(properties);

        assertEquals(1, filteredProperties.size());
        assertEquals(property1, filteredProperties.get(0));

        List<BaseProperty> filteredProperties2 = searchEngine.takeFrom(yesterday).build().search(properties);
        assertEquals(2, filteredProperties2.size());

        List<BaseProperty> filteredProperties3 = searchEngine.takeFrom(twoDaysAgo).build().search(properties);
        assertEquals(3, filteredProperties3.size());
    }

    @Test
    public void testFilterByLocationAndPriceRange() {
       PropertySearchEngine searchEngine = PropertySearchEngine.SearchEngineBuilder.buildSearch()
                .byLocation("elm")
                .byPriceRange(100000f, 160000f)
                .build();

        List<BaseProperty> filteredProperties = searchEngine.search(properties);

        assertEquals(1, filteredProperties.size());
        assertEquals(getSecondProperty(), filteredProperties.get(0));
    }

    @Test
    public void testFilterByNumberOfRoomsAndLocation() {
       PropertySearchEngine searchEngine = PropertySearchEngine.SearchEngineBuilder.buildSearch()
                .byNumberOfRooms(5)
                .byLocation("oak")
                .build();

        List<BaseProperty> filteredProperties = searchEngine.search(properties);

        assertEquals(1, filteredProperties.size());
        assertEquals(getThirdProperty(), filteredProperties.get(0));
    }

    @Test
    public void testFilterByNumberOfRoomsPriceRangeAndFloor() {
       PropertySearchEngine searchEngine = PropertySearchEngine.SearchEngineBuilder.buildSearch()
                .byNumberOfRooms(4)
                .byPriceRange(100000f, 200000f)
                .byFloor(3)
                .build();

        List<BaseProperty> filteredProperties = searchEngine.search(properties);

        assertEquals(1, filteredProperties.size());
        assertEquals(getSecondProperty(), filteredProperties.get(0));
    }

    private BaseProperty getFirstProperty() {
        return properties.get(0);
    }

    private BaseProperty getSecondProperty() {
        return properties.get(1);
    }

    private BaseProperty getThirdProperty() {
        return properties.get(2);
    }

    private static class MockProperty extends BaseProperty {
        public MockProperty(float price, String address, Float square, int numberOfRooms, int floor, int totalFloors, LocalDate timeAdded) {
            super(price, address, square, numberOfRooms, floor, totalFloors, timeAdded);
        }
    }
}