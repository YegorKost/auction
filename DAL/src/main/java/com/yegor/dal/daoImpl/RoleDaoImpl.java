package com.yegor.dal.daoImpl;

import com.yegor.dal.RoleDao;
import com.yegor.model.RoleEntity;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * Created by YegorKost on 01.05.2017.
 */
@Transactional
@Repository
public class RoleDaoImpl implements RoleDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(RoleDaoImpl.class);

    private SessionFactory sessionFactory;

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        LOGGER.info("------- Getting SessionFactory {} ", sessionFactory);
        this.sessionFactory = sessionFactory;
    }

    @Override
    public RoleEntity addRole(RoleEntity roleEntity) {
        Serializable id = sessionFactory
                .getCurrentSession()
                .save(roleEntity);
        LOGGER.info("Adding the role with id - {}", id);
        return roleEntity;
    }

    @Override
    public RoleEntity getRole(int id) {
        RoleEntity roleEntity = sessionFactory
                .getCurrentSession()
                .get(RoleEntity.class, id);
        LOGGER.info("Getting the role with id - {}", roleEntity.getId());
        return roleEntity;
    }

    @Override
    public List<RoleEntity> getAllRoles() {
        List<RoleEntity> allRoles = sessionFactory
                .getCurrentSession()
                .createNamedQuery("getAllRoles", RoleEntity.class)
                .getResultList();
        LOGGER.info("Getting all roles");
        return allRoles;
    }

    @Override
    public RoleEntity updateRole(RoleEntity roleEntity) {
        sessionFactory
                .getCurrentSession()
                .update(roleEntity);
        LOGGER.info("Updating the role with id - {}", roleEntity.getId());
        return roleEntity;
    }

    @Override
    public void deleteRole(RoleEntity roleEntity) {
        sessionFactory
                .getCurrentSession()
                .delete(roleEntity);
        LOGGER.info("Deleting the role with id - {} successful", roleEntity.getId());
    }
}
