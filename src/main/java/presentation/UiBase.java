package presentation;

import java.util.List;
import java.util.Scanner;

public abstract class UiBase {

    protected static final String TRY_AGAIN = "Введено некорректное значение. Попробуйте снова";

    private static final Scanner inputSteam = new Scanner(System.in);

    protected void list(Object[] items) {
        if (items.length == 0) return;
        for (int i = 0; i < items.length; i++) {
            System.out.printf("%d) %s\n", i + 1, items[i].toString());
        }
    }

    protected void list(List<?> items) {
        if (items == null || items.isEmpty()) return;
        for (int i = 0; i < items.size(); i++) {
            System.out.printf("%d) %s\n", i + 1, items.get(i).toString());
        }
    }

    protected String getStringInput(String output) {
        System.out.println(output);
        return inputSteam.next();
    }

    protected int getIntInput(String output, String error) {
        System.out.println(output);
        while (true) {
            try {
                return Integer.parseInt(inputSteam.nextLine());
            } catch (Exception e) {
                System.out.println(error);
            }
        }
    }

    protected int getIntInput(String output) {
        return getIntInput(output, TRY_AGAIN);
    }

    protected float getFloatInput(String output, String error) {
        System.out.println(output);
        while (true) {
            try {
                return Float.parseFloat(inputSteam.nextLine());
            } catch (Exception e) {
                System.out.println(error);
            }
        }
    }

    protected float getFloatInput(String output) {
        return getFloatInput(output, TRY_AGAIN);
    }
}
