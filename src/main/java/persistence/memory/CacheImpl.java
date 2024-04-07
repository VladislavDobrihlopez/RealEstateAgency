package persistence.memory;

import business.entity.BaseProperty;
import business.entity.CommercialPropertyBase;
import business.entity.LivingPropertyBase;
import business.entity.commercial.OfficeProperty;
import business.entity.commercial.WarehouseProperty;
import business.entity.living.LivingPropertyForRent;
import business.entity.living.LivingPropertyForSale;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CacheImpl {
    private final Map<String, List<BaseProperty>> cache = new HashMap<>();

    public boolean isInitialized = false;

    public <T extends BaseProperty> void initialize(List<T> items) {
        if (!isInitialized) {
            for (T item : items) {
                upsert(item);
            }
            isInitialized = true;
        }
    }

    public List<BaseProperty> extractAll() {
        List<BaseProperty> total = new ArrayList<>();
        for (Map.Entry<String, List<BaseProperty>> entry: cache.entrySet()) {
            if (entry.getValue() == null) throw new IllegalStateException();
            total.addAll(entry.getValue());
        }
        return total;
    }

    public void clear() {
        cache.clear();
    }

    public void upsert(BaseProperty item) {
        String key = getKey(item);
        List<BaseProperty> items;
        if (cache.containsKey(key)) {
            items = cache.get(key);
            items.add(item);
            // TODO add logic to ensure unique state
        } else {
            items = new ArrayList<>();
            items.add(item);
        }

        cache.put(key, items);
    }

    public void remove(BaseProperty item) {
        String key = getKey(item);
        List<BaseProperty> items;
        if (cache.containsKey(key)) {
            items = cache.get(key);
            items.remove(item);
            cache.put(key, items);
        }
    }

    private String getKey(BaseProperty item) {
        String className = null;
        if (item instanceof CommercialPropertyBase) {
            if (item instanceof OfficeProperty) {
                className = OfficeProperty.class.getSimpleName();
            }
            else if (item instanceof WarehouseProperty) {
                className = WarehouseProperty.class.getSimpleName();
            }
        } else if (item instanceof LivingPropertyBase) {
            if (item instanceof LivingPropertyForRent) {
                className = LivingPropertyForRent.class.getSimpleName();
            }
            else if (item instanceof LivingPropertyForSale) {
                className = LivingPropertyForSale.class.getSimpleName();
            }
        }
        if (className == null) throw new IllegalStateException();
        return className;
    }
}
