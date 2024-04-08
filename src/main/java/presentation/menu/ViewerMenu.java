package presentation.menu;

import persistence.PropertyDataManager;

public class ViewerMenu extends MenuBase {

    private static final String HEADER_TITLE = "Раздел работы с недвижимостью";

    public ViewerMenu(PropertyDataManager manager) {
        super(new String[]{
                "Найти недвижимость",
                "Добавить недвижимость",
                "Удалить недвижимость",
                "Вернуться назад",
        });
        setOptionCallbacks(new Runnable[]{
                () -> new PropertySearchMenu(manager).create(),
                () -> new AddPropertyMenu(manager).create(),
                () -> new DeletePropertyMenu(manager).create(),
                this::destroy,
        });
    }

    @Override
    public void create() {
        System.out.println(HEADER_TITLE);

        while (isAlive) {
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
        if (optionNumber == 3) {
            isAlive = false;
        }
    }
}
