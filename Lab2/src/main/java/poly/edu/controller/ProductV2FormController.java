package poly.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import poly.edu.entity.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Product V2 demo.
 * ?1 current (newest), ?2 next (second), ?3 list (all, newest first).
 */
@Controller
@RequestMapping("/productV2")
public class ProductV2FormController {
    // newest first
    private final List<Product> items = new ArrayList<>();

    /**
     * Share list (?3)
     */
    @ModelAttribute("products")
    public List<Product> products() {
        return items;
    }

    /**
     * Show form. Seed once.
     */
    @GetMapping("/form")
    public String form(Model model) {
        if (items.isEmpty()) items.add(0, new Product("iPhone 30", 5000.0));
        addCurrentAndNext(model);
        return "productV2Form";
    }

    /**
     * Save -> put at top
     */
    @PostMapping("/save")
    public String save(@ModelAttribute("product") Product p, Model model) {
        if (p.getName() != null || p.getPrice() != null) items.add(0, new Product(p.getName(), p.getPrice()));
        addCurrentAndNext(model);
        return "productV2Form";
    }

    private void addCurrentAndNext(Model model) {
        Product current = items.isEmpty() ? null : items.get(0); // ?1
        Product next = items.size() > 1 ? items.get(1) : null;   // ?2
        model.addAttribute("product", current);
        model.addAttribute("nextProduct", next);
    }
}