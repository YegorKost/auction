package com.yegor.service;

import com.yegor.model.RoleEntity;

import java.util.List;

/**
 * Created by YegorKost on 10.05.2017.
 */
public interface RoleService {
    RoleEntity addRole(RoleEntity role);
    RoleEntity getRole(int id);
    List<RoleEntity> getAllRoles();
    RoleEntity updateRole(RoleEntity role);
    void deleteRole(RoleEntity role);
}
