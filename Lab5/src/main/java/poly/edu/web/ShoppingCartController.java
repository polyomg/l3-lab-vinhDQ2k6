package poly.edu.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import poly.edu.entity.Item;

@Controller
public class ShoppingCartController {
    @Autowired
    ShoppingCartService cart;

    @RequestMapping("/cart/view")
    public String view(Model model) {
        model.addAttribute("cart", cart);
        return "cart/index";
    }

    @GetMapping("/cart/add/{id}")
    public String add(@PathVariable("id") Integer id) {
        Item added = cart.add(id);
        // đồng bộ thông tin từ "DB"
        Item dbItem = DB.items.get(id);
        if (added != null && dbItem != null) {
            added.setName(dbItem.getName());
            added.setPrice(dbItem.getPrice());
        }
        return "redirect:/cart/view";
    }

    @GetMapping("/cart/remove/{id}")
    public String remove(@PathVariable("id") Integer id) {
        cart.remove(id);
        return "redirect:/cart/view";
    }

    @PostMapping("/cart/update/{id}")
    public String update(@PathVariable("id") Integer id, @RequestParam("qty") int qty) {
        cart.update(id, qty);
        return "redirect:/cart/view";
    }

    @GetMapping("/cart/clear")
    public String clear() {
        cart.clear();
        return "redirect:/cart/view";
    }
}
