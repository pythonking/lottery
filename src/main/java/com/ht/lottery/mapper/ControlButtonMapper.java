package com.ht.lottery.mapper;

import com.ht.lottery.entity.ControlButton;

public interface ControlButtonMapper {
    int update(ControlButton controlButton);

    ControlButton selectOne();
}