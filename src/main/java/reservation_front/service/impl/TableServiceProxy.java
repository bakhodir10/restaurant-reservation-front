package reservation_front.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import reservation_front.domain.DiningTable;
import reservation_front.dto.DiningTableDto;
import reservation_front.service.TableService;

import java.util.List;

@Service
public class TableServiceProxy implements TableService {

    @Autowired
    private RestTemplate restTemplate;

    private final String ONE_URL = "http://localhost:8088/dining-tables/{id}";
    private final String ALL_URL = "http://localhost:8088/dining-tables/";

    @Override
    public DiningTable get(Long id) {
        return restTemplate.getForObject(ONE_URL, DiningTable.class, id);
    }

    @Override
    public List<DiningTable> getAll() {
        ResponseEntity<List<DiningTable>> response =
                restTemplate.exchange(ALL_URL, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<DiningTable>>() {
                        });
        return response.getBody();
    }

    @Override
    public DiningTable add(DiningTableDto p) {
        return restTemplate.postForObject(ALL_URL, p, DiningTable.class);
    }

    @Override
    public void update(Long id, DiningTable p) {
        restTemplate.put(ONE_URL, p, id);
    }

    @Override
    public void delete(Long id) {
        restTemplate.delete(ONE_URL, id);
    }

}
