package reservation_front.service;

import reservation_front.domain.Restaurant;

import java.util.List;

public interface RestaurantService {

    Restaurant get(Long id);

    List<Restaurant> getAll();

    Long add(Restaurant p);

    void update(Long id, Restaurant p);

    void delete(Long id);
}
