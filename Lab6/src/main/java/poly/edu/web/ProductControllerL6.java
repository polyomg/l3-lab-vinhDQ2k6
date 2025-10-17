package poly.edu.web;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import poly.edu.model.Product;
import poly.edu.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/lab6/product")
class ProductControllerL6 {

    final
    ProductRepository productRepo;

    public ProductControllerL6(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    @GetMapping("/sort")
    public String sort(Model model, @RequestParam("field") Optional<String> field) {
        // sắp xếp giảm dần theo field, mặc định là price
        Sort sort = Sort.by(Sort.Direction.DESC, field.orElse("price"));
        // giữ lại giá trị đã chọn
        model.addAttribute("field", field.orElse("price"));

        // truy vấn sắp xếp
        List<Product> items = productRepo.findAll(sort);
        model.addAttribute("items", items);
        return "SortProduct";
    }

    @GetMapping("/page")
    public String paginate(Model model, @RequestParam("page") Optional<Integer> p) {
        Pageable pageable = PageRequest.of(p.orElse(0), 5);
        Page<Product> page = productRepo.findAll(pageable);
        model.addAttribute("page", page);
        return "Pagination";
    }
}
