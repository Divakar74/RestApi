package com.example.flightticketbooking.controller;

import java.util.List;

import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.flightticketbooking.model.Ticket;
import com.example.flightticketbooking.model.User;
import com.example.flightticketbooking.service.TicketService;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;


    @GetMapping("/get")
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets1();
    }
     
    @GetMapping("/api/product/{offset}/{pagesize}")
    public ResponseEntity<List<Ticket>> getMethodName(@PathVariable int offset,@PathVariable int pagesize) {
        return ResponseEntity.status(200).body(ticketService.getpage(offset,pagesize));
    }
    
    @GetMapping("/api/product/{offset}/{pagesize}/{field}")
    public ResponseEntity<List<Ticket>> getMethod(@PathVariable int offset,@PathVariable int pagesize,@PathVariable String field) {
        return ResponseEntity.status(200).body(ticketService.getpagesort(offset,pagesize,field));
    }



    @GetMapping("/{id}")
    public Ticket getTicketById(@PathVariable Long id) {
        return ticketService.getTicketById1(id);
    }

    @PostMapping("/post")
    public Ticket createTicket(@RequestBody Ticket ticket) {

        return ticketService.saveOrUpdateTicket1(ticket);
    }
    @PutMapping("/{id}")
    public Ticket updateTicket(@PathVariable Long id, @RequestBody Ticket ticket) {
        ticket.setId(id);
        User user = ticket.getUser();
        ticket.setUser(user);
        return ticketService.saveOrUpdateTicket1(ticket);
    }

    @DeleteMapping("/{id}")
    public void deleteTicket(@PathVariable Long id) {
        Ticket deletedTicket = ticketService.getTicketById1(id);
        if (deletedTicket != null) {
            ticketService.deleteTicket1(id);
            System.out.println("Ticket with ID " + id + " has been deleted successfully.");
        } else {
            System.out.println("Ticket with ID " + id + " not found.");
        }
    }
}