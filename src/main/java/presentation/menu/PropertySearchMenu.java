package presentation.menu;

import business.PropertySearchEngine;
import business.PropertySorter;
import business.entity.BaseProperty;
import business.entity.commercial.OfficeProperty;
import business.entity.commercial.WarehouseProperty;
import business.entity.living.LivingPropertyForRent;
import business.entity.living.LivingPropertyForSale;
import persistence.PropertyDataManager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PropertySearchMenu extends MenuBase {

    private final PropertyDataManager manager;
    private final PropertySearchEngine.SearchEngineBuilder searchEngineBuilder;
    private PropertySorter.SortStrategy strategy = null;

    public PropertySearchMenu(PropertyDataManager manager) {
        super(new String[]{
                "Упорядочить по времени создания",
                "Упорядочить по стоимости",
                "Фильтр по местонахождению",
                "Фильтр по стоимости [мин...макс]",
                "Фильтр по количеству комнат",
                "Фильтр по этажу",
                "Фильтр по общему количеству этажей",
                "Фильтр по времени (показать объявления не старее)",
                "Сбросить фильтры",
                "Сбросить сортировку",
                "Вернуться обратно"
        });
        this.manager = manager;
        this.searchEngineBuilder = PropertySearchEngine.SearchEngineBuilder.buildSearch();
        setOptionCallbacks(new Runnable[]{
                () -> strategy = PropertySorter.SortStrategy.BY_TIME,
                () -> strategy = PropertySorter.SortStrategy.BY_PRICE,
                null,
                null,
                null,
                null,
                null,
                null,
                searchEngineBuilder::reset,
                () -> strategy = null,
                this::destroy
        });
    }

    private <T extends BaseProperty> List<T> query(List<T> items) {
        List<T> newItems = new ArrayList<>(items);
        // apply sorting
        if (strategy != null) {
            switch (strategy) {
                case BY_TIME:
                    newItems = PropertySorter.sortByTimeAdded(newItems);
                    break;
                case BY_PRICE:
                    newItems = PropertySorter.sortByPrice(newItems);
                    break;
            }
        }
        // apply filtering
        return searchEngineBuilder.build().search(newItems);
    }

    @Override
    protected void create() {
        while (isAlive) {
            System.out.println("(1) Коммерческая недвижимость");
            System.out.println("(1.1) Офисы");
            list(query(manager.getAll(OfficeProperty.class)));
            System.out.println("(1.2) Склады");
            list(query(manager.getAll(WarehouseProperty.class)));

            System.out.println("(2) Жилая недвижимость");
            System.out.println("(2.1) Для аренды");
            list(query(manager.getAll(LivingPropertyForRent.class)));
            System.out.println("(2.2) Для продажи");
            list(query(manager.getAll(LivingPropertyForSale.class)));

            System.out.println();
            list(OPTIONS);

            int option = getIntInput(String.format(ACTION_CHOOSE_OPTION, 1, OPTIONS.length));

            if (validateOption(option, OPTIONS.length)) {
                performAction(option - 1);
            }
        }
    }

    @Override
    protected void onUnhandledAction(int optionNumber) {
        super.onUnhandledAction(optionNumber);
        switch (optionNumber) {
            case 2:
                String location = getStringInput("Введите местоположение:").trim();
                searchEngineBuilder.byLocation(location);
                break;
            case 3:
                float minPrice = getFloatInput("Введите мин стоимость:");
                float maxPrice = getFloatInput("Введите макс стоимость:");
                if (minPrice > maxPrice) {
                    System.out.println("Ошибка. Минимальная стоимость не может быть выше максимальной");
                } else {
                    searchEngineBuilder.byPriceRange(minPrice, maxPrice);
                }
                break;
            case 4:
                int numberOfRooms = getIntInput("Введите количество комнат:");
                searchEngineBuilder.byNumberOfRooms(numberOfRooms);
                break;
            case 5:
                int floor = getIntInput("Введите искомый этаж:");
                searchEngineBuilder.byFloor(floor);
                break;
            case 6:
                int totalFloors = getIntInput("Введите общее кол-во этажей:");
                searchEngineBuilder.byTotalFloors(totalFloors);
                break;
            case 7:
                int day = getIntInput("Введите день: ");
                int month = getIntInput("Введите месяц: ");
                int year = getIntInput("Введите год: ");
                try {
                    searchEngineBuilder.takeFrom(LocalDate.of(year, month, day));
                } catch (Exception e) {
                    System.out.println("Время введено некорректно");
                }
                break;
        }
    }
}
