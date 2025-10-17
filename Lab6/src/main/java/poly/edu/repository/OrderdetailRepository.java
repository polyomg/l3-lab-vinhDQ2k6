package poly.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import poly.edu.model.Orderdetail;

@Repository
public interface OrderdetailRepository extends JpaRepository<Orderdetail, Long> {
}