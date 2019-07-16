package reservation_front.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import reservation_front.domain.Restaurant;
import reservation_front.service.impl.RestaurantServiceProxy;

@Controller
public class RestaurantController {

    @Autowired
    private RestaurantServiceProxy restaurantService;

    @GetMapping("/admin/restaurants")
    public String viewList(@ModelAttribute Restaurant restaurant, Model model) {
        model.addAttribute("restaurants", restaurantService.getAll());
        return "/restaurant/restaurant-list";
    }

    @GetMapping("/admin/restaurant/add")
    public String viewAdd(@ModelAttribute Restaurant restaurant, Model model) {
        model.addAttribute("msg", "Add");
        return "/restaurant/restaurant-detail";
    }

    @GetMapping("/admin/restaurants/{id}")
    public String get(@PathVariable long id, Model model) {
        model.addAttribute("restaurant", restaurantService.get(id));
        model.addAttribute("msg", "Update");
        return "/restaurant/restaurant-detail";
    }

    @PostMapping("/admin/restaurant")
    public String add(Restaurant restaurant) {
        restaurantService.add(restaurant);
        return "redirect:/admin/restaurants";
    }

    @PostMapping("/admin/restaurants/{id}")
    public String update(Restaurant restaurant, @PathVariable long id) {
        restaurantService.update(id, restaurant); // restaurant.id already set by binding
        return "redirect:/admin/restaurants";
    }

    @PostMapping(value = "/admin/restaurants/delete")
    public String delete(long id) {
        restaurantService.delete(id);
        return "redirect:/admin/restaurants";
    }
}
