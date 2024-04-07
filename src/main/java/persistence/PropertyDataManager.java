package persistence;

import business.entity.BaseProperty;
import persistence.local.PropertyDatabaseManager;
import persistence.memory.CacheImpl;

import java.util.List;

public class PropertyDataManager {
    private PropertyDatabaseManager databaseManager;
    private CacheImpl cache;

    public <T extends BaseProperty> List<T> getAll() {
        List<BaseProperty> items = databaseManager.getAll();
        cache.initialize(items);
        return (List<T>) items;
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
}
