package poly.edu.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Handles authentication flow: shows login form and processes credentials.
 */
@Controller
public class AuthController {

    /**
     * Injected request used to read form parameters.
     */
    @Autowired
    private HttpServletRequest request;

    /**
     * Displays the login view.
     *
     * @return login view name
     */
    @GetMapping("/login/form")
    public String form() {
        return "login";
    }

    /**
     * Validates submitted credentials and redirects to the calculator on success.
     *
     * @param model view model for feedback messages when login fails
     * @return redirect to calculator on success; login view on failure
     */
    @PostMapping("/login/check")
    public String login(Model model) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean ok = "Poly".equals(username) && "123".equals(password);
        if (ok) return "redirect:/rectangle/form";
        model.addAttribute("success", false);
        model.addAttribute("message", "Invalid username or password");
        model.addAttribute("username", username);
        return "login";
    }
}