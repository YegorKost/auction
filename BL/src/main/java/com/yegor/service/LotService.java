package com.yegor.service;

import com.yegor.model.LotEntity;

import java.util.List;

/**
 * Created by YegorKost on 10.05.2017.
 */
public interface LotService {
    LotEntity addLot(LotEntity lot);
    LotEntity getLot(long id);
    List<LotEntity> getLotsByName(String name);
    List<LotEntity> getAllLots();
    LotEntity updateLot(LotEntity lot);
    void deleteLot(LotEntity lot);
}
