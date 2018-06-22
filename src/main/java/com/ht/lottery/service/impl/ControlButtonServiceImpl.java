package com.ht.lottery.service.impl;

import com.ht.lottery.entity.ControlButton;
import com.ht.lottery.mapper.ControlButtonMapper;
import com.ht.lottery.service.ControlButtonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ControlButtonServiceImpl implements ControlButtonService {
    @Autowired
    private ControlButtonMapper controlButtonMapper;

    @Override
    public Integer update(ControlButton controlButton) {
        return controlButtonMapper.update(controlButton);
    }

    @Override
    public ControlButton selectOne() {
        return controlButtonMapper.selectOne();
    }

    @Override
    public Integer getStatus() {
        Integer status = null;
        ControlButton controlButton = this.selectOne();
        if (null != controlButton) {
            status = controlButton.getStatus();
        }
        return status;
    }
}
