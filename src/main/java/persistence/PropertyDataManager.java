package persistence;

import business.entity.BaseProperty;
import persistence.local.PropertyDatabaseManager;
import persistence.memory.CacheImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PropertyDataManager {

    private final PropertyDatabaseManager databaseManager;
    private final CacheImpl cache;

    public PropertyDataManager(PropertyDatabaseManager databaseManager, CacheImpl cache) {
        this.databaseManager = databaseManager;
        this.cache = cache;
    }

    public List<BaseProperty> getAll() {
        return provideData();
    }

    public <T extends BaseProperty> List<T> getAll(Class<T> tClass) {
        List<BaseProperty> items = provideData();

        return items.stream()
                .filter(tClass::isInstance)
                .map(tClass::cast)
                .collect(Collectors.toList());
    }

    public void create(BaseProperty item) {
        cache.upsert(item);
    }

    public void update(BaseProperty item) {
        cache.upsert(item);
    }

    public void delete(BaseProperty item) {
        cache.remove(item);
    }

    public void saveAllIntoDb() {
        List<BaseProperty> items = cache.extractAll();
        databaseManager.saveAll(items);
    }

    private List<BaseProperty> provideData() {
        List<BaseProperty> items;
        if (cache.isInitialized) {
            items = cache.extractAll();
        } else {
            items = databaseManager.getAll();
            cache.initialize(items);
        }
        return new ArrayList<>(items);
    }
}
