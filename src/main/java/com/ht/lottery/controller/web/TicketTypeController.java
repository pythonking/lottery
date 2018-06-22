package com.ht.lottery.controller.web;

import com.ht.lottery.entity.TicketType;
import com.ht.lottery.service.TicketTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/ticketType")
public class TicketTypeController {
    @Autowired
    private TicketTypeService ticketTypeService;

    @RequestMapping("/list")
    public String list(Model model) {
        List<TicketType> ticketTypeList = ticketTypeService.listAllTicketType();
        model.addAttribute("ticketTypeList", ticketTypeList);
        return "ticketType/list";
    }

    @RequestMapping("/forbidden")
    public String forbidden(TicketType ticketType) {
        ticketTypeService.update(ticketType);
        return "redirect:/ticketType/list";
    }

    @RequestMapping("/{id:\\d+}")
    public String edit(@PathVariable Integer id, Model model) {
        TicketType ticketType = ticketTypeService.selectByPrimaryKey(id);
        model.addAttribute("ticketType", ticketType);
        return "ticketType/edit";
    }

    @RequestMapping("/update")
    public String update(TicketType ticketType) {
        ticketTypeService.update(ticketType);
        return "redirect:/ticketType/list";
    }

    @RequestMapping("/new")
    public String add() {
        return "ticketType/new";
    }

    @RequestMapping("/add")
    public String add(TicketType ticketType) {
        ticketTypeService.insert(ticketType);
        return "redirect:/ticketType/list";
    }
}
