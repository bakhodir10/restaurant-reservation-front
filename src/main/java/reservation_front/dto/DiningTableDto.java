package reservation_front.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class DiningTableDto implements Serializable {

    private Long id;
    private Long capacity;
    private Long restaurantId;

    public DiningTableDto(Long capacity, Long restaurantId) {
        this.capacity = capacity;
        this.restaurantId = restaurantId;
    }
}
