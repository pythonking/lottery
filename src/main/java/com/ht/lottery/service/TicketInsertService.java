package com.ht.lottery.service;

import com.ht.lottery.entity.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TicketInsertService {
    @Autowired
    private TicketService ticketService;

    public void batchInsert(Integer num, Integer typeId) {
        int i = 0;
        while (i < num) {
            Ticket ticket = new Ticket(UUID.randomUUID().toString().replace("-", "").toLowerCase(), typeId);
            ticketService.insert(ticket);
            i++;
        }
    }
}
