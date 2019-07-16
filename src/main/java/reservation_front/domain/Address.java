package reservation_front.domain;

import lombok.Data;

@Data
public class Address {
    private String street;
    private String city;
    private Integer zipCode;
    private String state;
}
