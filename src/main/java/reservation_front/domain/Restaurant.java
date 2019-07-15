package reservation_front.domain;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@ToString
public class Restaurant {

    @NotNull
    private Long id;

    @NotNull
    @Min(value = 3)
    private String name;
}
