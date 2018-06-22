package com.ht.lottery.service.impl;

import com.ht.lottery.constant.TicketConstans;
import com.ht.lottery.entity.Raffle;
import com.ht.lottery.entity.Ticket;
import com.ht.lottery.entity.TicketType;
import com.ht.lottery.entity.User;
import com.ht.lottery.exception.ServiceException;
import com.ht.lottery.mapper.RaffleMapper;
import com.ht.lottery.result.AjaxResult;
import com.ht.lottery.service.RaffleService;
import com.ht.lottery.service.TicketService;
import com.ht.lottery.service.TicketTypeService;
import com.ht.lottery.service.UserService;
import com.ht.lottery.util.RaffleUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

@Service
public class RaffleServiceImpl implements RaffleService {
    /**
     * 日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(RaffleServiceImpl.class);
    @Autowired
    private RaffleMapper raffleMapper;
    @Autowired
    private TicketService ticketService;
    @Autowired
    private TicketTypeService ticketTypeService;
    @Autowired
    private UserService userService;

    @Override
    public Integer deleteByPrimaryKey(Integer id) {
        try {
            return raffleMapper.deleteByPrimaryKey(id);
        } catch (Exception e) {
            LOGGER.error("方法 deleteByPrimaryKey 异常,{}", e);
            throw new ServiceException();
        }
    }

    @Override
    public Integer insert(Raffle raffle) {
        try {
            return raffleMapper.insert(raffle);
        } catch (Exception e) {
            LOGGER.error("方法 insert 异常,{}", e);
            throw new ServiceException();
        }
    }

    @Override
    public Raffle selectByPrimaryKey(Integer id) {
        try {
            return raffleMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            LOGGER.error("方法 selectByPrimaryKey 异常,{}", e);
            throw new ServiceException();
        }
    }

    @Override
    public Integer update(Raffle raffle) {
        try {
            return raffleMapper.update(raffle);
        } catch (Exception e) {
            LOGGER.error("方法 update 异常,{}", e);
            throw new ServiceException();
        }
    }

    @Override
    public Raffle selectByUsercodeAndTicketCode(String usercode, String ticketCode) {
        Raffle raffle = null;
        List<Raffle> raffleList = this.listRaffle(new Raffle(usercode, ticketCode));
        if (!CollectionUtils.isEmpty(raffleList)) {
            raffle = raffleList.get(0);
        }
        return raffle;
    }

    @Override
    public List<Raffle> listRaffle(Raffle raffle) {
        try {
            return raffleMapper.listRaffle(raffle);
        } catch (Exception e) {
            LOGGER.error("方法 listRaffle 异常,{}", e);
            throw new ServiceException();
        }
    }

    @Override
    @Transactional
    public AjaxResult useRaffle(Raffle raffle) {
        Date nowDate = new Date();
        //修改我的卡券状态
        raffle.setStatus(TicketConstans.STATE_USE);
        raffle.setUseTime(nowDate);
        Ticket ticket = ticketService.selectByCode(raffle.getTicketCode());
        //修改票据为已经领取使用状态
        ticket = new Ticket(ticket.getId(), TicketConstans.STATE_RECEIVE);

        try {
            raffleMapper.update(raffle);
            ticketService.update(ticket);
            return AjaxResult.success();
        } catch (Exception e) {
            LOGGER.error("方法 useRaffle 异常,{}", e);
            throw new ServiceException();
        }
    }

    @Override
    @Transactional
    public AjaxResult getRaffle(String usercode) {
        try {
            //1.获取奖品类型
            List<TicketType> ticketTypeList = ticketTypeService.listTicketType(null);
            if (CollectionUtils.isEmpty(ticketTypeList)) {
                return AjaxResult.error(TicketConstans.ACTIVITY_NON_EXIST);
            }
            //2.随机抽奖
            TicketType ticketType = RaffleUtil.getTicketType(ticketTypeList);
            //3.修改卡券类型数量
            TicketType newTicketType = new TicketType();
            newTicketType.setId(ticketType.getId());
            newTicketType.setTotalNum(ticketType.getTotalNum() - 1);
            newTicketType.setDaliyNum(ticketType.getDaliyNum() - 1);
            ticketTypeService.update(newTicketType);
            //4.新增用户卡券-->分两步
            //4.1随机获取未使用卡券
            Ticket ticket = ticketService.selectOne(new Ticket(ticketType.getId(), TicketConstans.STATE_NO_USE));
            if (null == ticket) {
                return AjaxResult.error(TicketConstans.TICKET_NO_EXIST);
            }
            //4.2把卡券类型设为已被占用
            ticket.setStatus(TicketConstans.STATE_USE);
            ticket.setUseTime(new Date());
            ticketService.update(ticket);
            //5新增我的卡券
            String ticketCode = ticket.getCode();
            Raffle raffle = new Raffle(usercode, ticketCode);
            raffleMapper.insert(raffle);
            //6.把我的抽奖次数减1
            User user = userService.selectByUsercode(usercode);
            user.setNum(user.getNum() - 1);
            userService.update(user);

            return AjaxResult.successWithData(TicketConstans.TICKET_RAFFLE_SUCCESS, ticket);
        } catch (Exception e) {
            LOGGER.error("方法 getRaffle 异常,{}", e);
            throw new ServiceException();
        }
    }
}
