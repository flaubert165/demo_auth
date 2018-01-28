package com.example.demo_auth.service;

import com.example.demo_auth.models.Role;
import com.example.demo_auth.repository.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleMapper repository;

    public Role findById(Long id) {
        Role role = repository.getById(id);
        return role;
    }

    public Role findByCode(String code) {
        return repository.getByCode(code);
    }
}

