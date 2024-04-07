package business;

import business.entity.BaseProperty;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PropertySorter {
    public static List<BaseProperty> sortByPrice(List<BaseProperty> items) {
        List<BaseProperty> data = new ArrayList<>(items);
        data.sort((o1, o2) -> Float.compare(o1.getPrice(), o2.getPrice()));
        return data;
    }

    public static List<BaseProperty> sortByTimeAdded(List<BaseProperty> items) {
        List<BaseProperty> data = new ArrayList<>(items);
        data.sort(Comparator.comparing(BaseProperty::getTimeAdded));
        return data;
    }
}
