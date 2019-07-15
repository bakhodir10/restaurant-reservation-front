package reservation_front.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import reservation_front.domain.Restaurant;
import reservation_front.service.RestaurantService;

import java.net.URI;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class RestaurantServiceProxy implements RestaurantService {

    @Autowired
    private RestTemplate restTemplate;

    private final String restaurantsUrl = "http://localhost:8088/restaurants/{id}";
    private final String restaurantUrl = "http://localhost:8088/restaurant/";

    @Override
    public Restaurant get(Long id) {
        return restTemplate.getForObject(restaurantsUrl, Restaurant.class, id);
    }

    @Override
    public List<Restaurant> getAll() {
        ResponseEntity<List<Restaurant>> response =
                restTemplate.exchange(restaurantUrl, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Restaurant>>() {
                        });
        return response.getBody();
    }

    @Override
    public Long add(Restaurant p) {
        URI uri = restTemplate.postForLocation(restaurantUrl, p);
        if (uri == null) {
            return null;
        }
        Matcher m = Pattern.compile(".*/restaurant/(\\d+)").matcher(uri.getPath());
        m.matches();
        return Long.parseLong(m.group(1));
    }

    @Override
    public void update(Long id, Restaurant p) {
        restTemplate.put(restaurantsUrl, p, id);
    }

    @Override
    public void delete(Long id) {
        restTemplate.delete(restaurantsUrl, id);
    }

}
