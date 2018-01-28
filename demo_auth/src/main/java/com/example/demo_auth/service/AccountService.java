package com.example.demo_auth.service;

import com.example.demo_auth.models.Account;
import com.example.demo_auth.models.Role;
import com.example.demo_auth.repository.AccountMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class AccountService  {

    /**
     * The Logger for this class.
     */
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AccountMapper repository;


    @Autowired
    private RoleService roleService;

    public Collection<Account> findAll() {
        Collection<Account> accounts = repository.getAll();
        return accounts;
    }

    public Account findByUsername(String username) {
        Account account = repository.getByUsername(username);
        return account;
    }

    public Account createNewAccount(Account account) throws Exception {

        // Add the simple user role
        Role role = roleService.findByCode("ROLE_USER");
        Set<Role> roles = new HashSet<>();
        roles.add(role);

        // Validate the password
        if (account.getPassword().length() < 8){
            throw new Exception("password should be greater than 8 characters");
        }

        // Encode the password
        account.setPassword(new BCryptPasswordEncoder().encode(account.getPassword()));

        // Create the role
        account.setRoles(roles);
        return repository.create(account);
    }
}
