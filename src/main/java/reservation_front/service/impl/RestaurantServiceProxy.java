package reservation_front.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import reservation_front.domain.Restaurant;
import reservation_front.service.RestaurantService;

import java.util.List;

@Service
public class RestaurantServiceProxy implements RestaurantService {

    @Autowired
    private RestTemplate restTemplate;

    private final String ONE_URL = "http://localhost:8088/restaurants/{id}";
    private final String ALL_URL = "http://localhost:8088/restaurants/";

    @Override
    public Restaurant get(Long id) {
        return restTemplate.getForObject(ONE_URL, Restaurant.class, id);
    }

    @Override
    public List<Restaurant> getAll() {
        ResponseEntity<List<Restaurant>> response =
                restTemplate.exchange(ALL_URL + "/list", HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Restaurant>>() {
                        });
        return response.getBody();
    }

    @Override
    public Restaurant add(Restaurant p) {
        return restTemplate.postForObject(ALL_URL, p, Restaurant.class);
    }

    @Override
    public void update(Long id, Restaurant p) {
        restTemplate.put(ONE_URL, p, id);
    }

    @Override
    public void delete(Long id) {
        restTemplate.delete(ONE_URL, id);
    }

}
