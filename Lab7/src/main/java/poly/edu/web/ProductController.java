package poly.edu.web;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import poly.edu.model.Product;
import poly.edu.repository.ProductDAO;
import poly.edu.repository.ProductProjection;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductDAO dao;

    @RequestMapping(value = "/search")
    public String search(Model model,
                         @RequestParam("min") Optional<Double> min,
                         @RequestParam("max") Optional<Double> max) {
        Double minPrice = min.orElse(0.0);
        Double maxPrice = max.orElse(Double.MAX_VALUE);
//        List<Product> items = dao.findByPrice(minPrice, maxPrice);
        List<Product> items = dao.findByPriceBetween(minPrice, maxPrice);
        if (items == null) items = Collections.emptyList();
        model.addAttribute("items", items);
        return "product/search";
    }

    @RequestMapping("/search-and-page")
    public String searchAndPage(Model model,
                                @RequestParam("keywords") Optional<String> kw,
                                @RequestParam("p") Optional<Integer> p,
                                HttpSession session) {
        Object attr = session.getAttribute("keywords");
        String stored = (attr != null) ? attr.toString() : "";
        String kwords = kw.orElse(stored);
        session.setAttribute("keywords", kwords);
        Pageable pageable = PageRequest.of(p.orElse(0), 5);
        Page<ProductProjection> page;
        if (kwords == null || kwords.trim().isEmpty()) {
            page = dao.findAllWithCategory(pageable);
        } else {
            page = dao.findAllByNameLike("%" + kwords + "%", pageable);
        }
        model.addAttribute("page", page);
        return "product/search-and-page";
    }
}