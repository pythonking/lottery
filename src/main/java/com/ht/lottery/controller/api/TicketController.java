package com.ht.lottery.controller.api;

import com.ht.lottery.entity.vo.RaffleUserVO;
import com.ht.lottery.entity.vo.TicketVO;
import com.ht.lottery.result.AjaxResult;
import com.ht.lottery.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    /**
     * 查询用户卡券信息
     *
     * @return
     */
    @RequestMapping("/list")
    public AjaxResult listTicket(@RequestParam String usercode, @RequestParam(defaultValue = "0", required = false) Integer status) {
        List<TicketVO> ticketVOList = ticketService.listTicketVO(usercode, status);
        return AjaxResult.successWithData(ticketVOList);
    }

    /**
     * 中奖用户
     *
     * @return
     */
    @RequestMapping("/user/list")
    public AjaxResult listRaffleUser() {
        List<RaffleUserVO> raffleUserVOList = ticketService.listRaffleUser();
        return AjaxResult.successWithData(raffleUserVOList);
    }
}
