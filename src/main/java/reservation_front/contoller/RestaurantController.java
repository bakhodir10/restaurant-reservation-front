package reservation_front.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import reservation_front.domain.FileStorage;
import reservation_front.domain.Restaurant;
import reservation_front.service.FileStorageService;
import reservation_front.service.impl.RestaurantServiceProxy;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Base64;

@Controller
public class RestaurantController {

    @Autowired
    private FileStorageService fileStorageService;
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
    public String add(@Valid Restaurant restaurant, BindingResult bindingResult,
                      @RequestParam MultipartFile attachFileObj) throws IOException {
        if (bindingResult.hasErrors()) {
            return "redirect:/admin/restaurant/add";
        } else {
            System.out.println("Attachment Name?= " + attachFileObj.getOriginalFilename() + "\n");
            if (!attachFileObj.getOriginalFilename().equals("")) {
                FileStorage fileUploadObj = new FileStorage();
                fileUploadObj.setName(attachFileObj.getOriginalFilename());
                fileUploadObj.setData(attachFileObj.getBytes());
                byte[] bytes = attachFileObj.getBytes();
                String base64image = Base64.getEncoder().encodeToString(bytes);
                fileUploadObj.setBase64image(base64image);
                
                restaurant.setImage(fileUploadObj);
            }
            restaurantService.add(restaurant);
            return "redirect:/admin/restaurants";
        }
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
