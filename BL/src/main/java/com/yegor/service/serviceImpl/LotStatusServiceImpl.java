package com.yegor.service.serviceImpl;

import com.yegor.dal.LotStatusDao;
import com.yegor.model.LotStatusEntity;
import com.yegor.service.LotStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by YegorKost on 10.05.2017.
 */
@Service
public class LotStatusServiceImpl implements LotStatusService {

    private final LotStatusDao lotStatusDao;

    @Autowired
    public LotStatusServiceImpl(LotStatusDao lotStatusDao) {
        this.lotStatusDao = lotStatusDao;
    }

    @Override
    public LotStatusEntity addLotStatus(LotStatusEntity lotStatus) {
        return lotStatusDao.addLotStatus(lotStatus);
    }

    @Override
    public LotStatusEntity getLotStatus(int id) {
        return lotStatusDao.getLotStatus(id);
    }

    @Override
    public List<LotStatusEntity> getAllLotsStatuses() {
        return lotStatusDao.getAllLotsStatuses();
    }

    @Override
    public LotStatusEntity updateLotStatus(LotStatusEntity lotStatus) {
        return lotStatusDao.updateLotStatus(lotStatus);
    }

    @Override
    public void deleteLotStatus(LotStatusEntity lotStatus) {
        lotStatusDao.deleteLotStatus(lotStatus);
    }
}
