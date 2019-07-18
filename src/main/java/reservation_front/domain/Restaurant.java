package reservation_front.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Set;

@Data
@ToString
public class Restaurant implements Serializable {
    private Long id;
    private String name;
    private Address address;
    private Set<DiningTable> diningTables;
    private FileStorage image;
}
