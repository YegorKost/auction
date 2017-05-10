package com.yegor.dal;

import com.yegor.model.LotEntity;

import java.util.List;

/**
 * Created by YegorKost on 26.04.2017.
 */
public interface LotDao {
    LotEntity addLot(LotEntity lot);
    LotEntity getLot(long id);
    List<LotEntity> getLotsByName(String name);
    List<LotEntity> getAllLots();
    LotEntity updateLot(LotEntity lot);
    void deleteLot(LotEntity lot);
}
