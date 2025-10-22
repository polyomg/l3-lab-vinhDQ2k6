package poly.edu.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import poly.edu.model.AccessLog;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AccessHistoryController {

    @GetMapping("/access-history")
    public String showAccessHistory(HttpSession session, Model model) {
        @SuppressWarnings("unchecked")
        List<AccessLog> accessLogs = (List<AccessLog>) session.getAttribute("accessLogs");
        if (accessLogs == null) {
            accessLogs = new ArrayList<>();
        }
        model.addAttribute("accessLogs", accessLogs);
        return "access-history";
    }
}
