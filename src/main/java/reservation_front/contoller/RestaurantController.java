package reservation_front.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import reservation_front.domain.Restaurant;
import reservation_front.service.impl.RestaurantServiceProxy;

import javax.validation.Valid;

@Controller(value = "/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantServiceProxy restaurantService;

    @PostMapping
    public String getOne(Model model) {
        model.addAttribute("restaurants", restaurantService.getAll());
        return "restaurants";
    }

    @GetMapping(value = "/{id}")
    public String getList(@PathVariable Long id, Model model) {
        model.addAttribute("restaurant", restaurantService.get(id));
        return "restaurant-detail";
    }

    @PostMapping(value = "/add")
    public String addOne(@Valid Restaurant restaurant, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "restaurant-add";
        } else {
            restaurantService.add(restaurant);
            return "redirect:/restaurant-detail/{" + restaurant.getId() + "}";
        }
    }
}
