package com.ht.lottery.controller.web;

import com.ht.lottery.constant.TicketConstans;
import com.ht.lottery.entity.ControlButton;
import com.ht.lottery.result.AjaxResult;
import com.ht.lottery.service.ControlButtonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/control")
public class ControlButtonController {
    @Autowired
    private ControlButtonService controlButtonService;

    /**
     * 修改
     *
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public AjaxResult update(ControlButton controlButton) {
        Integer count = controlButtonService.update(controlButton);
        if (1 != count) {
            return AjaxResult.error(TicketConstans.SYSTEM_UPDATE_ERROR_MSG);
        }
        return AjaxResult.success();
    }

    @RequestMapping("/list")
    public String list(Model model) {
        ControlButton controlButton = controlButtonService.selectOne();
        model.addAttribute("controlButton", controlButton);
        return "/control/list";
    }

    @RequestMapping("/forbidden")
    public String forbidden(ControlButton controlButton) {
        controlButtonService.update(controlButton);
        return "redirect:/control/list";
    }
}
