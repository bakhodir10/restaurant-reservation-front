package reservation_front.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import reservation_front.domain.FileStorage;
import reservation_front.domain.Restaurant;
import reservation_front.service.FileStorageService;
import reservation_front.service.impl.RestaurantServiceProxy;

import java.io.IOException;

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
    public String add(Restaurant restaurant, @RequestParam MultipartFile attachFileObj) throws IOException {
        System.out.println("Attachment Name?= " + attachFileObj.getOriginalFilename() + "\n");
        if (!attachFileObj.getOriginalFilename().equals("")) {
            FileStorage fileUploadObj = new FileStorage();
            fileUploadObj.setName(attachFileObj.getOriginalFilename());
            fileUploadObj.setData(attachFileObj.getBytes());

            // Calling The Db Method To Save The Uploaded File In The Db
            this.fileStorageService.add(fileUploadObj);
            System.out.println("File Is Successfully Uploaded & Saved In The Database.... Hurrey!\n");
        }
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
