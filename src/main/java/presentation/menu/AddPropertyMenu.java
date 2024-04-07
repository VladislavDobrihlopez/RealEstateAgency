package presentation.menu;

import business.entity.commercial.OfficeProperty;
import business.entity.commercial.WarehouseProperty;
import business.entity.living.LivingPropertyForRent;
import business.entity.living.LivingPropertyForSale;
import persistence.PropertyDataManager;

import java.time.LocalDate;

public class AddPropertyMenu extends MenuBase {

    private static final String HEADER_TITLE = "Раздел добавления недвижимости";

    private final PropertyDataManager dataManager;

    public AddPropertyMenu(PropertyDataManager dataManager) {
        super(new String[]{
                "Добавить коммерческую офисную недвижимость",
                "Добавить коммерческую складскую недвижимость",
                "Добавить жилую недвижимость для аренды",
                "Добавить жилую недвижимость для продажи",
                "Вернуться обратно"
        });
        setOptionCallbacks(new Runnable[]{
                this::addOfficeProperty,
                this::addWarehouseProperty,
                this::addLivingPropertyForRent,
                this::addLivingPropertyForSale,
                this::destroy
        });
        this.dataManager = dataManager;
    }

    @Override
    protected void create() {
        super.create();

        System.out.println(HEADER_TITLE);
        while (isAlive) {
            list(OPTIONS);
            int option = getIntInput(String.format(ACTION_CHOOSE_OPTION, 1, OPTIONS.length));

            if (validateOption(option, OPTIONS.length)) {
                performAction(option - 1);
            }
        }
    }

    private void addOfficeProperty() {
        float price = getFloatInput("Введите цену:");
        String address = getStringInput("Введите адрес:");
        float square = getFloatInput("Введите площадь:");
        int numberOfRooms = getIntInput("Введите количество комнат:");
        int floor = getIntInput("Введите этаж:");
        int totalFloors = getIntInput("Введите общее количество этажей:");
        LocalDate timeAdded = LocalDate.now();
        String amenities = getStringInput("Введите список удобств:");

        OfficeProperty officeProperty = new OfficeProperty(price, address, square, numberOfRooms, floor, totalFloors, timeAdded, amenities);
        dataManager.create(officeProperty);
        System.out.println("Коммерческая офисная недвижимость добавлена успешно.");
    }

    private void addWarehouseProperty() {
        float price = getFloatInput("Введите цену:");
        String address = getStringInput("Введите адрес:");
        float square = getFloatInput("Введите площадь:");
        int numberOfRooms = getIntInput("Введите количество комнат:");
        int floor = getIntInput("Введите этаж:");
        int totalFloors = getIntInput("Введите общее количество этажей:");
        LocalDate timeAdded = LocalDate.now();
        String amenities = getStringInput("Введите список удобств:");

        WarehouseProperty warehouseProperty = new WarehouseProperty(price, address, square, numberOfRooms, floor, totalFloors, timeAdded, amenities);
        dataManager.create(warehouseProperty);
        System.out.println("Коммерческая складская недвижимость добавлена успешно.");
    }

    private void addLivingPropertyForRent() {
        float price = getFloatInput("Введите цену:");
        String address = getStringInput("Введите адрес:");
        float square = getFloatInput("Введите площадь:");
        int numberOfRooms = getIntInput("Введите количество комнат:");
        int floor = getIntInput("Введите этаж:");
        int totalFloors = getIntInput("Введите общее количество этажей:");
        LocalDate timeAdded = LocalDate.now();
        String furnishing = getStringInput("Введите мебель:");
        String metroStation = getStringInput("Введите ближайшую станцию метро:");
        String rentType = getStringInput("Введите тип аренды:");
        int prepaidMonths = getIntInput("Введите количество предоплаченных месяцев:");

        LivingPropertyForRent livingPropertyForRent = new LivingPropertyForRent(price, address, square, numberOfRooms, floor, totalFloors, timeAdded, furnishing, metroStation, rentType, prepaidMonths);
        dataManager.create(livingPropertyForRent);
        System.out.println("Жилая недвижимость для аренды добавлена успешно.");
    }

    private void addLivingPropertyForSale() {
        float price = getFloatInput("Введите цену:");
        String address = getStringInput("Введите адрес:");
        float square = getFloatInput("Введите площадь:");
        int numberOfRooms = getIntInput("Введите количество комнат:");
        int floor = getIntInput("Введите этаж:");
        int totalFloors = getIntInput("Введите общее количество этажей:");
        LocalDate timeAdded = LocalDate.now();
        String furnishing = getStringInput("Введите мебель:");
        String metroStation = getStringInput("Введите ближайшую станцию метро:");

        LivingPropertyForSale livingPropertyForSale = new LivingPropertyForSale(price, address, square, numberOfRooms, floor, totalFloors, timeAdded, furnishing, metroStation);
        dataManager.create(livingPropertyForSale);
        System.out.println("Жилая недвижимость для продажи добавлена успешно.");
    }
}
