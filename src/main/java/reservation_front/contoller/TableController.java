package reservation_front.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import reservation_front.dto.DiningTableDto;
import reservation_front.service.TableService;

@Controller
public class TableController {

    @Autowired
    private TableService tableService;

    @PostMapping("/admin/restaurants/{restaurantId}/dining-tables")
    public String add(@PathVariable Long restaurantId) {
        tableService.add(new DiningTableDto(5L, restaurantId));
        return "redirect:/admin/restaurants";
    }
}
