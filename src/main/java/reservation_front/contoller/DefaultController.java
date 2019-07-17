package reservation_front.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {

    @GetMapping("/")
    public String mainPage() {
        return "/restaurant/restaurant-list";
    }
}
