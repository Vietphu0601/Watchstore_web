package com.webwatch.TimeHub.service;

import java.util.List;

import com.webwatch.TimeHub.domain.Role;

public interface IRoleService {
    List<Role> findAll();

    Role findRoleByName(String role);
}
