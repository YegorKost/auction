package com.yegor.dal.daoImpl;

import com.yegor.model.RoleEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by YegorKost on 01.05.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class RoleDaoImplTest extends DalTest{
    @Test
    public void addRole() throws Exception {
        RoleEntity newRole = new RoleEntity();
        newRole.setRole("newRole");
        roleDao.addRole(newRole);
        assertEquals(newRole, roleDao.getRole(newRole.getId()));
    }

    @Test
    public void getRole() throws Exception {
        assertEquals(role1, roleDao.getRole(role1.getId()));
        assertEquals(role2, roleDao.getRole(role2.getId()));
        assertEquals(role3, roleDao.getRole(role3.getId()));
    }

    @Test
    public void getAllRoles() throws Exception {
        List<RoleEntity> allRoles = roleDao.getAllRoles();
        assertEquals(3, allRoles.size());
        assertTrue(allRoles.contains(role1));
        assertTrue(allRoles.contains(role2));
        assertTrue(allRoles.contains(role3));
    }

    @Test
    public void updateRole() throws Exception {
        RoleEntity role = roleDao.getRole(role1.getId());
        assertEquals("admin", role.getRole());
        role.setRole("updated");
        roleDao.updateRole(role);
        assertEquals("updated", roleDao.getRole(role1.getId()).getRole());
    }

    @Test
    public void deleteRole() throws Exception {
        List<RoleEntity> allRoles = roleDao.getAllRoles();
        assertEquals(3, allRoles.size());
        assertTrue(allRoles.contains(role3));
        roleDao.deleteRole(role3);
        allRoles = roleDao.getAllRoles();
        assertEquals(2, allRoles.size());
        assertFalse(allRoles.contains(role3));
    }

    @Test(expected = Exception.class)
    public void deleteRole1() throws Exception {
        roleDao.deleteRole(role1);
    }

}