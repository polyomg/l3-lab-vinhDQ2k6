package poly.edu.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Controller
public class AccountController {
    @Autowired
    private CookieService cookieService;
    @Autowired
    private ParamService paramService;
    @Autowired
    private SessionService sessionService;

    @GetMapping("/account/login")
    public String login1(Model model) {
        String rememberedUser = cookieService.getValue("user");
        boolean remembered = rememberedUser != null && !rememberedUser.isEmpty();
        model.addAttribute("username", remembered ? rememberedUser : "");
        model.addAttribute("remember", remembered);
        return "/account/login";
    }

    @PostMapping("/account/login")
    public String login2(Model model) {
        String username = paramService.getString("username", "");
        String password = paramService.getString("password", "");
        boolean remember = paramService.getBoolean("remember", false);

        // validate credentials
        if ("poly".equals(username) && "123".equals(password)) {
            // save username in session
            sessionService.set("username", username);

            // handle remember cookie (10 days) or remove it
            if (remember) {
                cookieService.add("user", username, 24 * 10);
            } else {
                cookieService.remove("user");
            }

            return "redirect:/";
        }

        // failed login: keep entered values
        model.addAttribute("username", username);
        model.addAttribute("remember", remember);
        return "/account/login";
    }

    @GetMapping("/account/register")
    public String registerForm() {
        return "/account/register";
    }

    @PostMapping("/account/register")
    public String registerSubmit(Model model,
                                 @RequestParam("username") String username,
                                 @RequestParam("password") String password,
                                 @RequestParam("photo") MultipartFile photo) {
        // Save uploaded image to webroot (under /uploads)
        File saved = null;
        if (photo != null && !photo.isEmpty()) {
            saved = paramService.save(photo, "/uploads");
        }
        model.addAttribute("username", username);
        model.addAttribute("saved", saved != null);
        model.addAttribute("photoName", saved != null ? saved.getName() : "");
        model.addAttribute("photoUrl", saved != null ? "/uploads/" + saved.getName() : "");
        model.addAttribute("message", saved != null ? "Đăng ký thành công và đã lưu hình." :
                "Đăng ký thành công nhưng không có hình hoặc lưu hình thất bại.");
        return "/account/register";
    }
}