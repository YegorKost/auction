package com.yegor.dal;

import com.yegor.model.RoleEntity;

import java.util.List;

/**
 * Created by YegorKost on 26.04.2017.
 */
public interface RoleDao {
    RoleEntity addRole(RoleEntity role);
    RoleEntity getRole(int id);
    List<RoleEntity> getAllRoles();
    RoleEntity updateRole(RoleEntity role);
    void deleteRole(RoleEntity role);
}
