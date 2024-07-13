    package business;

    import static org.junit.jupiter.api.Assertions.assertEquals;

    import java.time.LocalDate;
    import java.util.ArrayList;
    import java.util.List;

    import org.junit.jupiter.api.BeforeEach;
    import org.junit.jupiter.api.Test;

    import business.entity.BaseProperty;

    public class PropertySorterTest {

        private BaseProperty property1;
        private BaseProperty property2;
        private BaseProperty property3;

        @BeforeEach
        public void setUp() {
            property1 = new MockProperty(100000, "123 Main St", 100.0f, 3, 2, 5, LocalDate.now().minusDays(1));
            property2 = new MockProperty(150000, "456 Elm St", 120.0f, 4, 3, 6, LocalDate.now().minusDays(2));
            property3 = new MockProperty(200000, "789 Oak St", 150.0f, 5, 4, 7, LocalDate.now());
        }

        @Test
        public void testSortByPrice() {
            List<BaseProperty> properties = new ArrayList<>();
            properties.add(property2);
            properties.add(property1);
            properties.add(property3);

            List<BaseProperty> sortedProperties = PropertySorter.sortByPrice(properties);

            assertEquals(property1, sortedProperties.get(0));
            assertEquals(property2, sortedProperties.get(1));
            assertEquals(property3, sortedProperties.get(2));
        }

        @Test
        public void testSortByTimeAdded() {
            List<BaseProperty> properties = new ArrayList<>();
            properties.add(property2);
            properties.add(property1);
            properties.add(property3);

            List<BaseProperty> sortedProperties = PropertySorter.sortByTimeAdded(properties);

            assertEquals(property2, sortedProperties.get(0));
            assertEquals(property1, sortedProperties.get(1));
            assertEquals(property3, sortedProperties.get(2));
        }

        private class MockProperty extends BaseProperty {
            public MockProperty(float price, String address, Float square, int numberOfRooms, int floor, int totalFloors, LocalDate timeAdded) {
                super(price, address, square, numberOfRooms, floor, totalFloors, timeAdded);
            }
        }
    }
