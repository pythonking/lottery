package com.ht.lottery.service;

import com.ht.lottery.entity.TicketType;

import java.util.List;

/**
 * @author king
 */
public interface TicketTypeService {
    Integer deleteByPrimaryKey(Integer id);

    Integer insert(TicketType ticketType);

    TicketType selectByPrimaryKey(Integer id);

    Integer update(TicketType ticketType);

    List<TicketType> listTicketType(TicketType ticketType);

    Integer initTicketTypeDailyNum();

    Integer updateTicketTypeStatusWhoIsZero();

    List<TicketType> listAllTicketType();
}