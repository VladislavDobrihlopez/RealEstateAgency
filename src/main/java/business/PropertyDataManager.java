package business;

import business.entity.BaseProperty;
import persistence.local.PropertyDatabaseManager;
import persistence.memory.CacheImpl;

import java.util.List;

public class PropertyDataManager<T extends BaseProperty> {
    private PropertyDatabaseManager databaseManager;
    private CacheImpl cache;

    public List<T> getAll() {
        // TODO()
        return null;
    }

    public void create(T item) {

    }

    public void update(T item) {

    }

    public void delete(T item) {

    }

    public void saveAllIntoDb() {

    }
}
