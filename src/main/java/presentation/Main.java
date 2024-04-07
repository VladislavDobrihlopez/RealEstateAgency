package presentation;

import business.entity.BaseProperty;
import business.entity.commercial.OfficeProperty;
import business.entity.living.LivingPropertyForRent;
import persistence.PropertyDataManager;
import persistence.local.PropertiesDatabaseManagerImpl;
import persistence.local.PropertyDatabaseManager;
import persistence.memory.CacheImpl;
import presentation.menu.MainMenu;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        test();
        CacheImpl cache = new CacheImpl();
        PropertyDataManager manager = new PropertyDataManager(new PropertiesDatabaseManagerImpl(), cache);
            new MainMenu(manager).create();
    }

    private static void test() {
        PropertyDatabaseManager manager = new PropertiesDatabaseManagerImpl();
        Collection<BaseProperty> properties = new ArrayList<>();
        properties.add(new OfficeProperty(
                2000.0f,                // price
                "456 Business Blvd",    // address
                150.0f,                 // square
                5,                      // numberOfRooms
                3,                      // floor
                10,                     // totalFloors
                LocalDate.now(),   // timeAdded
                "High-speed internet, Parking" // amenities
        ));
        properties.add(new LivingPropertyForRent(
                1500.0f,                // price
                "123 Main St",          // address
                100.0f,                 // square
                3,                      // numberOfRooms
                2,                      // floor
                5,                      // totalFloors
                LocalDate.now(),   // timeAdded
                "Furnished",            // furnishing
                "Central Station",      // metroStation
                "Monthly",              // rentType
                1                       // prepaidMonths
        ));

        manager.saveAll(properties);
        List<BaseProperty> propertyList = manager.getAll();
        for (BaseProperty property: propertyList) {
            System.out.println(property.toString());
        }
    }
}
