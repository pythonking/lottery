package com.ht.lottery.controller.web;

import com.ht.lottery.entity.TicketType;
import com.ht.lottery.entity.vo.TicketDTO;
import com.ht.lottery.service.TicketInsertService;
import com.ht.lottery.service.TicketService;
import com.ht.lottery.service.TicketTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/ticketCount")
public class TicketCountController {
    @Autowired
    private TicketService ticketService;
    @Autowired
    private TicketTypeService ticketTypeService;
    @Autowired
    private TicketInsertService ticketInsertService;

    @RequestMapping("/list")
    public String list(Model model) {
        List<TicketDTO> ticketDTOList = ticketService.listTicketDTO();
        model.addAttribute("ticketDTOList", ticketDTOList);
        return "ticket/count";
    }

    @RequestMapping("/{id:\\d+}")
    public String newTicket(@PathVariable Integer id, Model model) {
        TicketType ticketType = ticketTypeService.selectByPrimaryKey(id);
        model.addAttribute("ticketType", ticketType);
        return "ticket/new";
    }

    @RequestMapping("/add")
    public String addTicket(TicketDTO ticketDTO) {
        ticketInsertService.batchInsert(ticketDTO.getNum(), ticketDTO.getTypeId());
        return "redirect:/ticketCount/list";
    }
}
