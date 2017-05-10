package com.yegor.dal.daoImpl;

import com.yegor.dal.LotStatusDao;
import com.yegor.model.LotStatusEntity;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * Created by YegorKost on 02.05.2017.
 */
@Transactional
@Repository
public class LotStatusDaoImpl implements LotStatusDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(LotStatusDaoImpl.class);

    private SessionFactory sessionFactory;

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        LOGGER.info("------- Getting SessionFactory {} ", sessionFactory);
        this.sessionFactory = sessionFactory;
    }

    @Override
    public LotStatusEntity addLotStatus(LotStatusEntity lotStatusEntity) {
        Serializable id = sessionFactory
                .getCurrentSession()
                .save(lotStatusEntity);
        LOGGER.info("Adding the lot status with id - {}", id);
        return lotStatusEntity;
    }

    @Override
    public LotStatusEntity getLotStatus(int id) {
        LotStatusEntity lotStatusEntity = sessionFactory
                .getCurrentSession()
                .get(LotStatusEntity.class, id);
        LOGGER.info("Getting the lot status with id - {}", lotStatusEntity.getId());
        return lotStatusEntity;
    }

    @Override
    public List<LotStatusEntity> getAllLotsStatuses() {
        List<LotStatusEntity> allLotsStatuses = sessionFactory
                .getCurrentSession()
                .createNamedQuery("getAllLotsStatuses", LotStatusEntity.class)
                .getResultList();
        LOGGER.info("Getting all lots statuses");
        return allLotsStatuses;
    }

    @Override
    public LotStatusEntity updateLotStatus(LotStatusEntity lotStatusEntity) {
        sessionFactory
                .getCurrentSession()
                .update(lotStatusEntity);
        LOGGER.info("Updating the lot status with id - {}", lotStatusEntity.getId());
        return lotStatusEntity;
    }

    @Override
    public void deleteLotStatus(LotStatusEntity lotStatusEntity) {
        sessionFactory
                .getCurrentSession()
                .delete(lotStatusEntity);
        LOGGER.info("Deleting the lot status with id - {} successful", lotStatusEntity.getId());
    }
}
