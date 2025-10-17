package poly.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import poly.edu.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
}