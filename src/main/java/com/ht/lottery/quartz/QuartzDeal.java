package com.ht.lottery.quartz;

import com.ht.lottery.service.TicketTypeService;
import com.ht.lottery.service.UserService;
import com.ht.lottery.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuartzDeal {
    /**
     * 日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserService userService;
    @Autowired
    private TicketTypeService ticketTypeService;

    /**
     * 用户抽奖次数统一加1
     */
    public void addUserNum() {
        Integer count = userService.batchDealZeroUserNum();
        LOGGER.info("用户抽奖次数统一加1的数量: " + count);
    }

    /**
     * 初始化每天奖品数量
     */
    public void initTicketTypeDailyNum() {
        Integer count = ticketTypeService.initTicketTypeDailyNum();
        LOGGER.info("初始化每天奖品数量: " + count);
    }

    /**
     * 修改奖品为可使用状态
     */
    public void updateTicketTypeStatusWhoIsZero() {
        Integer count = ticketTypeService.updateTicketTypeStatusWhoIsZero();
        LOGGER.info("修改奖品为可使用状态数量: " + count);
    }
}
