package com.ht.lottery.mapper;

import com.ht.lottery.entity.Raffle;

import java.util.List;

public interface RaffleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Raffle record);

    Raffle selectByPrimaryKey(Integer id);

    int update(Raffle record);

    List<Raffle> listRaffle(Raffle raffle);
}