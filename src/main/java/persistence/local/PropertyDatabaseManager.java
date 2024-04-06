package persistence.local;

import business.entity.BaseProperty;

import java.util.Collection;
import java.util.List;

public interface PropertyDatabaseManager {
    public void saveAll(Collection<BaseProperty> properties);
    public List<BaseProperty> getAll();
}
