package com.yegor.service;

import com.yegor.model.LotStatusEntity;

import java.util.List;

/**
 * Created by YegorKost on 10.05.2017.
 */
public interface LotStatusService {
    LotStatusEntity addLotStatus(LotStatusEntity lotStatus);
    LotStatusEntity getLotStatus(int id);
    List<LotStatusEntity> getAllLotsStatuses();
    LotStatusEntity updateLotStatus(LotStatusEntity lotStatus);
    void deleteLotStatus(LotStatusEntity lotStatus);
}
