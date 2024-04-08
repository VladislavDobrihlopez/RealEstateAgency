package presentation.menu;


import persistence.PropertyDataManager;

public class MainMenu extends MenuBase {

    private static final String HEADER_TITLE = "Добро пожаловать в агентство недвижимости!";
    private static final String CREDENTIALS = "Разработано Войтовым Владиславом, dobrihlopez@gmail.com";

    public MainMenu(PropertyDataManager manager) {
        super(
                new String[]{"Перейти в раздел работы с недвижимостью", "Сохранить"},
                new Runnable[]{() -> new ViewerMenu(manager).create(), manager::saveAllIntoDb}
        );
    }

    private void printContent() {
        System.out.println(HEADER_TITLE);
        System.out.println(CREDENTIALS);

        while (isAlive) {

            list(OPTIONS);
            int option = getIntInput(String.format(ACTION_CHOOSE_OPTION, 1, OPTIONS.length));

            if (validateOption(option, OPTIONS.length)) {
                performAction(option - 1);
            }
        }
    }

    @Override
    public void create() {
        printContent();
    }
}
