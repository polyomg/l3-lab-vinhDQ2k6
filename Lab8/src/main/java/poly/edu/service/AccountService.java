package poly.edu.service;

import poly.edu.model.Account;

import java.util.Optional;

public interface AccountService {
    Optional<Account> findById(String username);

    Account authenticate(String username, String password);
}
