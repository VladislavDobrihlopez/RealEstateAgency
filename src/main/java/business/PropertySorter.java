package business;

import business.entity.BaseProperty;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PropertySorter {
    public static <T extends BaseProperty> List<T> sortByPrice(List<T> items) {
        List<T> data = new ArrayList<>(items);
        data.sort((o1, o2) -> Float.compare(o1.getPrice(), o2.getPrice()));
        return data;
    }

    public static <T extends BaseProperty> List<T> sortByTimeAdded(List<T> items) {
        List<T> data = new ArrayList<>(items);
        data.sort(Comparator.comparing(T::getTimeAdded));
        return data;
    }

    public enum SortStrategy {
        BY_PRICE,
        BY_TIME,
    }
}
