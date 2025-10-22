package poly.edu.controller;

import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import poly.edu.model.Mail;
import poly.edu.service.MailService;

@Controller
@RequestMapping("/mail")
public class MailController {

    @Autowired
    MailService mailService;

    @GetMapping("/form")
    public String showMailForm() {
        return "mail";
    }

    @ResponseBody
    @PostMapping("/send")
    public String sendDirect(@ModelAttribute Mail mail) {
        try {
            mailService.send(mail);
            return "Mail của bạn đã được gửi đi";
        } catch (MessagingException e) {
            // Log the error for debugging but don't expose details to user
            e.printStackTrace();
            return "Lỗi: Không thể gửi email. Vui lòng kiểm tra lại thông tin.";
        }
    }

    @ResponseBody
    @PostMapping("/push")
    public String pushToQueue(@ModelAttribute Mail mail) {
        try {
            mailService.push(mail);
            return "Mail đã được thêm vào hàng đợi";
        } catch (Exception e) {
            // Log the error for debugging but don't expose details to user
            e.printStackTrace();
            return "Lỗi: Không thể thêm email vào hàng đợi.";
        }
    }
}
