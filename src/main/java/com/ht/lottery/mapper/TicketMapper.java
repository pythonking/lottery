package com.ht.lottery.mapper;

import com.ht.lottery.entity.Ticket;
import com.ht.lottery.entity.vo.RaffleUserVO;
import com.ht.lottery.entity.vo.TicketDTO;
import com.ht.lottery.entity.vo.TicketVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TicketMapper {
    int deleteByPrimaryKey(Integer id);


    int insert(Ticket record);

    Ticket selectByPrimaryKey(Integer id);

    int update(Ticket record);

    List<TicketVO> listTicketVO(@Param("usercode") String usercode, @Param("status") Integer status);

    TicketVO selectByCode(String ticketCode);

    List<Ticket> listTicket(Ticket ticket);

    Ticket selectOne(Ticket ticket);

    List<RaffleUserVO> listRaffleUser();

    /**
     * 统计优惠券报表
     *
     * @return
     */
    List<TicketDTO> listTicketDTO();
}