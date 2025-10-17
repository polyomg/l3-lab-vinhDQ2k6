package poly.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import poly.edu.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {
}