package com.yegor.dal;

import com.yegor.model.LotStatusEntity;

import java.util.List;

/**
 * Created by YegorKost on 26.04.2017.
 */
public interface LotStatusDao {
    LotStatusEntity addLotStatus(LotStatusEntity lotStatus);
    LotStatusEntity getLotStatus(int id);
    List<LotStatusEntity> getAllLotsStatuses();
    LotStatusEntity updateLotStatus(LotStatusEntity lotStatus);
    void deleteLotStatus(LotStatusEntity lotStatus);
}
