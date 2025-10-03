package poly.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Demo: one page, 3 submit buttons (GET + POST variants).
 */
@Controller
public class OkController {

    /**
     * Show page
     */
    @RequestMapping("/ok")
    public String ok() {
        return "ok";
    }

    /**
     * POST button 1
     */
    @PostMapping("/ctrl/ok")
    public String post(Model model) {
        model.addAttribute("result", "POST: /ctrl/ok (OK 1)");
        return "ok";
    }

    /**
     * GET button 2
     */
    @GetMapping("/ctrl/ok")
    public String get(Model model) {
        model.addAttribute("result", "GET: /ctrl/ok (OK 2)");
        return "ok";
    }

    /**
     * POST button 3 (?x)
     */
    @PostMapping(value = "/ctrl/ok", params = "x")
    public String postWithX(Model model) {
        model.addAttribute("result", "POST: /ctrl/ok?x (OK 3)");
        return "ok";
    }
}