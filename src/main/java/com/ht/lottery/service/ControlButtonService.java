package com.ht.lottery.service;

import com.ht.lottery.entity.ControlButton;

public interface ControlButtonService {
    Integer update(ControlButton controlButton);

    ControlButton selectOne();

    Integer getStatus();
}
