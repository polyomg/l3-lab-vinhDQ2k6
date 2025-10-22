package poly.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Provides a form to input rectangle dimensions and computes area and perimeter.
 */
@Controller
@RequestMapping("/rectangle")
public class RectangleController {

    /**
     * Renders the calculator view.
     *
     * @return rectangle calculator view name
     */
    @GetMapping("/form")
    public String form() {
        return "rectangleCalc";
    }

    /**
     * Validates inputs and computes area and perimeter.
     *
     * @param width  rectangle width (non-negative)
     * @param height rectangle height (non-negative)
     * @param model  view model to expose inputs and results
     * @return calculator view with feedback
     */
    @PostMapping("/calc")
    public String calculate(@RequestParam(required = false) Double width,
                            @RequestParam(required = false) Double height,
                            Model model) {
        model.addAttribute("width", width);
        model.addAttribute("height", height);
        if (width == null || height == null) {
            model.addAttribute("message", "Please enter both width and height.");
            model.addAttribute("success", false);
            return "rectangleCalc";
        }
        if (width < 0 || height < 0) {
            model.addAttribute("message", "Width and height must be non-negative.");
            model.addAttribute("success", false);
            return "rectangleCalc";
        }
        double area = width * height;
        double perimeter = 2 * (width + height);
        model.addAttribute("area", area);
        model.addAttribute("perimeter", perimeter);
        model.addAttribute("success", true);
        model.addAttribute("message", "Calculation successful.");
        return "rectangleCalc";
    }
}