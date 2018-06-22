package com.ht.lottery.service;

import com.ht.lottery.entity.Ticket;
import com.ht.lottery.entity.vo.RaffleUserVO;
import com.ht.lottery.entity.vo.TicketDTO;
import com.ht.lottery.entity.vo.TicketVO;

import java.util.List;

/**
 * @author king
 */
public interface TicketService {
    Integer deleteByPrimaryKey(Integer id);


    Integer insert(Ticket ticket);

    Ticket selectByPrimaryKey(Integer id);

    Integer update(Ticket ticket);

    List<TicketVO> listTicketVO(String usercode, Integer status);

    TicketVO selectByCode(String ticketCode);

    List<Ticket> listTicket(Ticket ticket);

    Ticket selectOne(Ticket ticket);

    /**
     * 查看所有中奖用户
     *
     * @return
     */
    List<RaffleUserVO> listRaffleUser();
    /**
     * 统计优惠券报表
     *
     * @return
     */
    List<TicketDTO> listTicketDTO();
}