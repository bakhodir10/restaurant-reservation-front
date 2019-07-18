package reservation_front.service;

import reservation_front.domain.DiningTable;
import reservation_front.dto.DiningTableDto;

import java.util.List;

public interface TableService {

    DiningTable get(Long id);

    List<DiningTable> getAll();

    DiningTable add(DiningTableDto p);

    void update(Long id, DiningTable p);

    void delete(Long id);
}
