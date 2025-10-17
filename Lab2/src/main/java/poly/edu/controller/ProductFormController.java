package poly.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import poly.edu.entity.Product;

/**
 * Product form demo: show + post back same page.
 */
@Controller
@RequestMapping("/product")
public class ProductFormController {

    /**
     * Show form. Optional query fills fields.
     */
    @GetMapping("/form")
    public String form(@RequestParam(required = false) String name,
                       @RequestParam(required = false) Double price,
                       Model model) {
        Product p = new Product();
        if (name != null) p.setName(name);
        if (price != null) p.setPrice(price);
        model.addAttribute("product", p);
        return "productForm";
    }

    /**
     * Handle submit then show again
     */
    @PostMapping("/save")
    public String save(Product product, Model model) {
        model.addAttribute("product", product);
        return "productForm";
    }
}