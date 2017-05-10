package com.yegor.dal.daoImpl;

import com.yegor.dal.LotDao;
import com.yegor.model.LotEntity;
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
public class LotDaoImpl implements LotDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(LotDaoImpl.class);

    private SessionFactory sessionFactory;

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        LOGGER.info("------- Getting SessionFactory {} ", sessionFactory);
        this.sessionFactory = sessionFactory;
    }

    @Override
    public LotEntity addLot(LotEntity lotEntity) {
        Serializable id = sessionFactory
                .getCurrentSession()
                .save(lotEntity);
        LOGGER.info("Adding the lot with id {}", id);
        return lotEntity;
    }

    @Override
    public LotEntity getLot(long id) {
        LotEntity lotEntity = sessionFactory
                .getCurrentSession()
                .get(LotEntity.class, id);
        LOGGER.info("Getting the lot with id - {}", lotEntity.getId());
        return lotEntity;
    }

    @Override
    public List<LotEntity> getLotsByName(String name) {
        List<LotEntity> lots = sessionFactory
                .getCurrentSession()
                .createNamedQuery("getLotsByName", LotEntity.class)
                .setParameter("name", name)
                .getResultList();
        return lots;
    }

    @Override
    public List<LotEntity> getAllLots() {
        List<LotEntity> allLots = sessionFactory
                .getCurrentSession()
                .createNamedQuery("getAllLots", LotEntity.class)
                .getResultList();
        LOGGER.info("Getting all roles");
        return allLots;
    }

    @Override
    public LotEntity updateLot(LotEntity lotEntity) {
        sessionFactory
                .getCurrentSession()
                .update(lotEntity);
        LOGGER.info("Updating the lot with id - {}", lotEntity.getId());
        return lotEntity;
    }

    @Override
    public void deleteLot(LotEntity lotEntity) {
        sessionFactory
                .getCurrentSession()
                .delete(lotEntity);
        LOGGER.info("Deleting the lot with id - {} successful", lotEntity.getId());
    }
}
