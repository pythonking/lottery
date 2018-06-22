package com.ht.lottery.mapper;

import com.ht.lottery.entity.TicketType;

import java.util.List;

public interface TicketTypeMapper {
    int deleteByPrimaryKey(Integer id);


    int insert(TicketType record);

    TicketType selectByPrimaryKey(Integer id);

    int update(TicketType record);

    List<TicketType> listTicketType(TicketType ticketType);

    Integer initTicketTypeDailyNum();

    Integer updateTicketTypeStatusWhoIsZero();

    List<TicketType> listAllTicketType();
}