package presentation.menu;

import business.entity.BaseProperty;
import persistence.PropertyDataManager;

import java.util.List;

public class DeletePropertyMenu extends MenuBase {

    private static final String HEADER_TITLE = "Раздел удаления недвижимости";

    private final PropertyDataManager dataManager;

    public DeletePropertyMenu(PropertyDataManager dataManager) {
        super(new String[]{
                "Удалить",
                "Вернуться обратно"
        });
        setOptionCallbacks(new Runnable[]{
                this::deleteProperty,
                this::destroy
        });
        this.dataManager = dataManager;
    }

    private List<BaseProperty> items;

    @Override
    protected void create() {
        super.create();

        System.out.println(HEADER_TITLE);
        while (isAlive) {
            items = dataManager.getAll();
            list(items);

            list(OPTIONS);

            int option = getIntInput(String.format(ACTION_CHOOSE_OPTION, 1, OPTIONS.length));

            if (validateOption(option, OPTIONS.length)) {
                performAction(option - 1);
            }
        }
    }

    private void deleteProperty() {
        int numberOfPropertyEnqueuedForDeletion = getIntInput("Введите номер удаляемого объекта недвижимости:");

        if (numberOfPropertyEnqueuedForDeletion > 0 && numberOfPropertyEnqueuedForDeletion <= items.size()) {
            dataManager.delete(items.get(numberOfPropertyEnqueuedForDeletion - 1));
        } else {
            System.out.println("Некорректное значение");
        }
    }
}

