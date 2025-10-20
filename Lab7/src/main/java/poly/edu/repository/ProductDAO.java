package poly.edu.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import poly.edu.model.Product;

import java.util.List;

public interface ProductDAO extends JpaRepository<Product, Integer> {
    //    @Query("FROM Product o WHERE o.price BETWEEN ?1 AND ?2")
//    List<Product> findByPrice(double minPrice, double maxPrice);
    List<Product> findByPriceBetween(double minPrice, double maxPrice);

    @Query(value = "SELECT p.id as id, p.name as name, p.price as price, c.name as categoryName FROM Product p LEFT JOIN p.category c",
            countQuery = "SELECT count(p) FROM Product p")
    Page<ProductProjection> findAllWithCategory(Pageable pageable);

    //    @Query(value = "SELECT p.id as id, p.name as name, p.price as price, c.name as categoryName FROM Product p LEFT JOIN p.category c WHERE p.name LIKE ?1",
//            countQuery = "SELECT count(p) FROM Product p WHERE p.name LIKE ?1")
//    Page<ProductProjection> findByNameWithCategory(String name, Pageable pageable);
    Page<ProductProjection> findAllByNameLike(String name, Pageable pageable);

    @Query("SELECT o.category.name AS group, sum(o.price) AS sum, count(o) AS count "
            + " FROM Product o"
            + " GROUP BY o.category.name"
            + " ORDER BY sum(o.price) DESC")
    List<ReportProjection> getInventoryByCategory();
}