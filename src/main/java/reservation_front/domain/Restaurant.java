package reservation_front.domain;

import lombok.Data;
import lombok.ToString;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@ToString
public class Restaurant implements Serializable {

    private Long id;

    @NotNull
    private String name;
    @Valid
    private Address address;
}
