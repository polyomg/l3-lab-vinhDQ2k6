package poly.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Result page flows:
 * /b forward -> model message
 * /c redirect -> param message
 * /d plain text body
 */
@Controller
public class resultController {

    /**
     * Show page
     */
    @RequestMapping("/a")
    public String m1() {
        return "result";
    }

    /**
     * Forward keeps model
     */
    @RequestMapping("/b")
    public String m2(Model model) {
        model.addAttribute("message", "I come from b");
        return "forward:/a"; // keep model
    }

    /**
     * Redirect adds query param
     */
    @RequestMapping("/c")
    public String m3(RedirectAttributes params) {
        params.addAttribute("message", "I come from c");
        return "redirect:/a";
    }

    /**
     * Raw text
     */
    @ResponseBody
    @RequestMapping("/d")
    public String m4() {
        return "I come from d";
    }
}