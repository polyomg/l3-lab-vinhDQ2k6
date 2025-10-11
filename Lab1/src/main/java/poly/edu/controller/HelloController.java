package poly.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Exposes a simple greeting endpoint and forwards data to the hello view.
 */
@Controller
public class HelloController {

    /**
     * Supplies title and subject attributes to the hello template.
     *
     * @param model view model
     * @return hello view name
     */
    @GetMapping("/poly/hello")
    public String hello(Model model) {
        model.addAttribute("title", "FPT Polytechnic");
        model.addAttribute("subject", "Spring Boot MVC - Duong Quang Vinh");
        return "hello";
    }
}