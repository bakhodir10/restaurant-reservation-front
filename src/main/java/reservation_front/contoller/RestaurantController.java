package reservation_front.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RestaurantController {

//    @Autowired
//    private RestaurantService restaurantService;

    @GetMapping("/")
    public String mainPage() {
        return "index";
    }
}
