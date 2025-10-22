package poly.edu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import poly.edu.model.Account;

public interface AccountDAO extends JpaRepository<Account, String> {
}
