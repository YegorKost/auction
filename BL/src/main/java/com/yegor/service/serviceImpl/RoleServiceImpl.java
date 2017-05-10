package com.yegor.service.serviceImpl;

import com.yegor.dal.RoleDao;
import com.yegor.model.RoleEntity;
import com.yegor.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by YegorKost on 10.05.2017.
 */
@Service
public class RoleServiceImpl implements RoleService {

    private final RoleDao roleDao;

    @Autowired
    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public RoleEntity addRole(RoleEntity role) {
        return roleDao.addRole(role);
    }

    @Override
    public RoleEntity getRole(int id) {
        return roleDao.getRole(id);
    }

    @Override
    public List<RoleEntity> getAllRoles() {
        return roleDao.getAllRoles();
    }

    @Override
    public RoleEntity updateRole(RoleEntity role) {
        return roleDao.updateRole(role);
    }

    @Override
    public void deleteRole(RoleEntity role) {
        roleDao.deleteRole(role);
    }
}
