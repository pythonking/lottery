package com.ht.lottery.controller.api;

import com.ht.lottery.constant.TicketConstans;
import com.ht.lottery.entity.Raffle;
import com.ht.lottery.entity.User;
import com.ht.lottery.entity.vo.TicketVO;
import com.ht.lottery.result.AjaxResult;
import com.ht.lottery.service.RaffleService;
import com.ht.lottery.service.TicketService;
import com.ht.lottery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/raffle")
public class RaffleController {
    @Autowired
    private RaffleService raffleService;
    @Autowired
    private TicketService ticketService;
    @Autowired
    private UserService userService;

    /**
     * 使用卡券-->预留接口
     *
     * @return
     */
    @RequestMapping("/use")
    public AjaxResult useRaffle(@RequestParam String usercode, @RequestParam String ticketCode) {
        Raffle raffle = raffleService.selectByUsercodeAndTicketCode(usercode, ticketCode);
        if (null == raffle) {
            return AjaxResult.error(TicketConstans.TICKET_NO_EXIST);
        }
        if (TicketConstans.STATE_USE.equals(raffle.getStatus())) {
            return AjaxResult.error(TicketConstans.TICKET_HAS_USED);
        }
        TicketVO ticketVO = ticketService.selectByCode(ticketCode);
        if (new Date().after(ticketVO.getUseEndTime())) {
            return AjaxResult.error(TicketConstans.TICKET_TIME_AFTER);
        }
        if (new Date().before(ticketVO.getUseStartTime())) {
            return AjaxResult.error(TicketConstans.TICKET_TIME_BEFORE);
        }
        return raffleService.useRaffle(raffle);
    }

    /**
     * 抽取卡券
     *
     * @return
     */
    @RequestMapping("/get")
    public AjaxResult getRaffle(@RequestParam String usercode) {
        //判断用户是否还有抽奖次数
        User user = userService.selectByUsercode(usercode);
        if (user == null || user.getNum() == null || user.getNum() <= 0) {
            return AjaxResult.error(TicketConstans.TICKET_TIME_OVER);
        }
        //抽取卡券
        AjaxResult ajaxResult = raffleService.getRaffle(usercode);
        return ajaxResult;
    }
}
