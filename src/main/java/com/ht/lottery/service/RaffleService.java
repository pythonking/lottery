package com.ht.lottery.service;

import com.ht.lottery.entity.Raffle;
import com.ht.lottery.result.AjaxResult;

import java.util.List;

/**
 * @author king
 */
public interface RaffleService {
    Integer deleteByPrimaryKey(Integer id);

    Integer insert(Raffle raffle);

    Raffle selectByPrimaryKey(Integer id);

    Integer update(Raffle raffle);

    Raffle selectByUsercodeAndTicketCode(String usercode, String ticketCode);

    /**
     * 查询优惠券列表
     *
     * @param raffle
     * @return
     */
    List<Raffle> listRaffle(Raffle raffle);

    /**
     * 使用优惠券
     *
     * @param raffle
     * @return
     */
    AjaxResult useRaffle(Raffle raffle);

    /**
     * 抽取优惠券
     *
     * @param usercode
     * @return
     */
    AjaxResult getRaffle(String usercode);
}