package business;

import business.entity.BaseProperty;

import java.util.Collection;

public interface PropertyFilteringInteractor {
    public Collection<BaseProperty> searchInPriceRange(Collection<BaseProperty> items, float minPrice, float maxPrice);

    public Collection<BaseProperty> filterByLocation(Collection<BaseProperty> items, String location);
}

