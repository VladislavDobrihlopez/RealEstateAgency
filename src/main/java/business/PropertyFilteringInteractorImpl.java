package business;

import business.entity.BaseProperty;

import java.util.Collection;
import java.util.stream.Collectors;

public class PropertyFilteringInteractorImpl implements PropertyFilteringInteractor {
    private static final double EPS = 1e-5;

    @Override
    public Collection<BaseProperty> searchInPriceRange(Collection<BaseProperty> items, float minPrice, float maxPrice) {
        return items.stream()
                .filter(
                        baseProperty -> baseProperty.getPrice() + EPS >= minPrice && baseProperty.getPrice() - EPS <= maxPrice
                ).collect(Collectors.toList());
    }

    @Override
    public Collection<BaseProperty> filterByLocation(Collection<BaseProperty> items, String location) {
        return items.stream()
                .filter(
                        baseProperty -> baseProperty.getAddress().contains(location)
                ).collect(Collectors.toList());
    }
}
