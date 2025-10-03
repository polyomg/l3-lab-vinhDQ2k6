package poly.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import poly.edu.entity.Staff;

import java.util.List;

@Controller
@RequestMapping("/staff")
public class staffListController {

    List<Staff> list = List.of(
            Staff.builder().id("user1@gmail.com").fullname("nguyễn văn user1").level(0).build(),
            Staff.builder().id("user2@gmail.com").fullname("nguyễn văn user2").level(1).build(),
            Staff.builder().id("user3@gmail.com").fullname("nguyễn văn user3").level(2).build(),
            Staff.builder().id("user4@gmail.com").fullname("nguyễn văn user4").level(2).build(),
            Staff.builder().id("user5@gmail.com").fullname("nguyễn văn user5").level(1).build(),
            Staff.builder().id("user6@gmail.com").fullname("nguyễn văn user6").level(0).build());

    @RequestMapping("/list")
    public String list(Model model) {
        model.addAttribute("list", list);
        return "staffList";
    }

    @RequestMapping("/list/status")
    public String listStatus(Model model) {
        model.addAttribute("list", list);
        return "staffListStatus";
    }

    @RequestMapping("/list/control")
    public String listControl(Model model) {
        model.addAttribute("list", list);
        return "staffListControl";
    }
}