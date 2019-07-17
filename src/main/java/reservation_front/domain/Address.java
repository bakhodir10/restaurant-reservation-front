package reservation_front.domain;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class Address implements Serializable {
    
    @NotNull
    private String street;
    @NotNull
    private String city;
    @NotNull
    private Integer zipCode;
    @NotNull
    private String state;
}
