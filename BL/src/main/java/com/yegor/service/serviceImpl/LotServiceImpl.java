package com.yegor.service.serviceImpl;

import com.yegor.dal.LotDao;
import com.yegor.model.LotEntity;
import com.yegor.service.LotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by YegorKost on 10.05.2017.
 */
@Service
public class LotServiceImpl implements LotService {

    private final LotDao lotDao;

    @Autowired
    public LotServiceImpl(LotDao lotDao) {
        this.lotDao = lotDao;
    }

    @Override
    public LotEntity addLot(LotEntity lot) {
        return lotDao.addLot(lot);
    }

    @Override
    public LotEntity getLot(long id) {
        return lotDao.getLot(id);
    }

    @Override
    public List<LotEntity> getLotsByName(String name) {
        return lotDao.getLotsByName(name);
    }

    @Override
    public List<LotEntity> getAllLots() {
        return lotDao.getAllLots();
    }

    @Override
    public LotEntity updateLot(LotEntity lot) {
        return lotDao.updateLot(lot);
    }

    @Override
    public void deleteLot(LotEntity lot) {
        lotDao.deleteLot(lot);
    }
}
