package com.ht.lottery.service.impl;

import com.ht.lottery.entity.TicketType;
import com.ht.lottery.exception.ServiceException;
import com.ht.lottery.mapper.TicketTypeMapper;
import com.ht.lottery.service.TicketTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketTypeServiceImpl implements TicketTypeService {
    /**
     * 日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TicketTypeServiceImpl.class);
    @Autowired
    private TicketTypeMapper ticketTypeMapper;

    @Override
    public Integer deleteByPrimaryKey(Integer id) {
        return ticketTypeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer insert(TicketType ticketType) {
        try {
            return ticketTypeMapper.insert(ticketType);
        } catch (Exception e) {
            LOGGER.error("方法 insert 异常,{}", e);
            throw new ServiceException();
        }
    }

    @Override
    public TicketType selectByPrimaryKey(Integer id) {
        return ticketTypeMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer update(TicketType ticketType) {
        return ticketTypeMapper.update(ticketType);
    }

    @Override
    public List<TicketType> listTicketType(TicketType ticketType) {
        try {
            return ticketTypeMapper.listTicketType(ticketType);
        } catch (Exception e) {
            LOGGER.error("方法 listTicketType 异常,{}", e);
            throw new ServiceException();
        }
    }

    @Override
    public Integer initTicketTypeDailyNum() {
        try {
            return ticketTypeMapper.initTicketTypeDailyNum();
        } catch (Exception e) {
            LOGGER.error("方法 initTicketTypeDailyNum 异常,{}", e);
            throw new ServiceException();
        }
    }

    @Override
    public Integer updateTicketTypeStatusWhoIsZero() {
        Integer count = null;
        try {
            count = ticketTypeMapper.updateTicketTypeStatusWhoIsZero();
        } catch (Exception e) {
            LOGGER.error("方法 updateTicketTypeStatusWhoIsZero 异常,{}", e);
        }
        return count;
    }

    @Override
    public List<TicketType> listAllTicketType() {
        try {
            return ticketTypeMapper.listAllTicketType();
        } catch (Exception e) {
            LOGGER.error("方法 listAllTicketType 异常,{}", e);
            throw new ServiceException();
        }
    }
}
