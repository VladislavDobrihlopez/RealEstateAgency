package persistence.memory;

import java.util.List;

public interface Cache<T> {
    public boolean isInitialized();

    public void initialize(List<T> items);

    public List<T> extractAll();

    public void clear();

    public void upsert(T item);

    public void remove(T item);
}
