package poly.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poly.edu.dao.AccountDAO;
import poly.edu.model.Account;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountDAO accountDAO;

    @Override
    public Optional<Account> findById(String username) {
        return accountDAO.findById(username);
    }

    @Override
    public Account authenticate(String username, String password) {
        Optional<Account> optAccount = this.findById(username);
        if (optAccount.isPresent() && optAccount.get().getPassword().equals(password)) {
            return optAccount.get();
        }
        return null;
    }
}
