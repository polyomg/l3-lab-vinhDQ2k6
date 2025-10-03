package poly.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Demo: mix PathVariable x + param y, then redirect showing both.
 */
@Controller
public class XYFormController {

    /**
     * Show form
     */
    @GetMapping("/param/form")
    public String form() {
        return "xyForm";
    }

    /**
     * Save and redirect with values
     */
    @PostMapping("/param/save/{x}")
    public String save(@PathVariable String x, @RequestParam String y) {
        return "redirect:/param/form?x=" + x + "&y=" + y;
    }
}