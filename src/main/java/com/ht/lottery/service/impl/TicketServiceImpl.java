package com.ht.lottery.service.impl;

import com.ht.lottery.entity.Ticket;
import com.ht.lottery.entity.vo.RaffleUserVO;
import com.ht.lottery.entity.vo.TicketDTO;
import com.ht.lottery.entity.vo.TicketVO;
import com.ht.lottery.exception.ServiceException;
import com.ht.lottery.mapper.TicketMapper;
import com.ht.lottery.service.TicketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {
    /**
     * 日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TicketServiceImpl.class);
    @Autowired
    private TicketMapper ticketMapper;

    @Override
    public Integer deleteByPrimaryKey(Integer id) {
        return ticketMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer insert(Ticket ticket) {
        return ticketMapper.insert(ticket);
    }

    @Override
    public Ticket selectByPrimaryKey(Integer id) {
        return ticketMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer update(Ticket ticket) {
        return ticketMapper.update(ticket);
    }

    @Override
    public List<TicketVO> listTicketVO(String usercode, Integer status) {
        return ticketMapper.listTicketVO(usercode, status);
    }

    @Override
    public TicketVO selectByCode(String ticketCode) {
        try {
            return ticketMapper.selectByCode(ticketCode);
        } catch (Exception e) {
            LOGGER.error("方法 selectByCode 异常,{}", e);
            throw new ServiceException();
        }
    }

    @Override
    public List<Ticket> listTicket(Ticket ticket) {
        return ticketMapper.listTicket(ticket);
    }

    @Override
    public Ticket selectOne(Ticket ticket) {
        return ticketMapper.selectOne(ticket);
    }

    @Override
    public List<RaffleUserVO> listRaffleUser() {
        try {
            return ticketMapper.listRaffleUser();
        } catch (Exception e) {
            LOGGER.error("方法 listRaffleUser 异常,{}", e);
            throw new ServiceException();
        }
    }

    @Override
    public List<TicketDTO> listTicketDTO() {
        try {
            return ticketMapper.listTicketDTO();
        } catch (Exception e) {
            LOGGER.error("方法 listTicketDTO 异常,{}", e);
            throw new ServiceException();
        }
    }
}
