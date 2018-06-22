package com.ht.lottery.service;

import com.ht.lottery.entity.vo.TicketVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Leo on 2018/6/14
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TicketServiceTestCase {
    @Autowired
    private TicketInsertService ticketInsertService;
    @Autowired
    private TicketService ticketService;

    @Test
    public void testInsertTicket() {
        ticketInsertService.batchInsert(1, 1);
        ticketInsertService.batchInsert(100, 2);
        ticketInsertService.batchInsert(1000, 3);
        ticketInsertService.batchInsert(50, 4);
        ticketInsertService.batchInsert(100, 5);
        ticketInsertService.batchInsert(10000, 6);
    }

    @Test
    public void testSelectByCode() {
        TicketVO ticketVO = ticketService.selectByCode("615727a9f5b5471195aaf16676bda1aa");
        System.out.println(ticketVO);
    }
}
