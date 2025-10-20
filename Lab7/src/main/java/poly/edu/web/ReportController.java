package poly.edu.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import poly.edu.repository.ProductDAO;
import poly.edu.repository.ReportProjection;

import java.util.List;

@Controller
@RequestMapping("/report")
public class ReportController {
    @Autowired
    ProductDAO dao;

    //Link: http://localhost:8080/report/inventory-by-category
    @RequestMapping("/inventory-by-category")
    public String inventory(Model model) {
        List<ReportProjection> items = dao.getInventoryByCategory();
        model.addAttribute("items", items);
        return "report/inventory-by-category";
    }
}
