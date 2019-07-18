package reservation_front.domain;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@Data
public class DiningTable implements Serializable {

    private Long id;
    private Long capacity;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private Restaurant restaurant;

    public DiningTable(Long capacity, Restaurant restaurant) {
        this.capacity = capacity;
        this.restaurant = restaurant;
    }
}