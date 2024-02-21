package com.example.flightticketbooking.controller;

import java.util.List;
// import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.flightticketbooking.model.Ticket;
// import com.example.flightticketbooking.model.Users;
import com.example.flightticketbooking.service.TicketService;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    public TicketService ticketService;

    @GetMapping("/get")
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @GetMapping("/get/{id}")
    public Ticket getTicketById(@PathVariable Long id) {
        return ticketService.getTicketById(id);
    }

    @PostMapping("/post")
    public Ticket createTicket(@RequestBody Ticket ticket) {
        return ticketService.saveOrUpdateTicket(ticket);
    }

    @PutMapping("/put/{id}")
    public Ticket updateTicket(@PathVariable Long id, @RequestBody Ticket ticket) {
        ticket.setId(id);
        return ticketService.saveOrUpdateTicket(ticket);
    }

    @DeleteMapping("/del/{id}")
    public void deleteTicket(@PathVariable Long id) {
        Ticket deletedTicket = ticketService.getTicketById(id);
        if (deletedTicket != null) {
            ticketService.deleteTicket(id);
            System.out.println("Ticket with ID " + id + " has been deleted successfully.");
        } else {
            System.out.println("Ticket with ID " + id + " not found.");
        }
    }
    // @PostMapping("/adduser")
    // public Users postMethodUsers(@RequestBody Users user)
    // {
    //     return ticketService.postUser(user);
    // }
    // @GetMapping("/user")
    // public List<Users> getMetodUsers()
    // {
    //     return ticketService.getUser();
    // }
    // @GetMapping("/user/{id}")
    // public Optional<Users> getMetodUsersbyId(@PathVariable Long id)
    // {
    //     return ticketService.getUserbyId(id);
    // }
    // @PutMapping("/uput/{id}")
    // public Users putMtehodUsers(@PathVariable Long id,@RequestBody Users user)
    // {
    //     return ticketService.putUser(id, user);
    // }
    // @DeleteMapping("/userdel/{id}")
    // public String delMethodUsers(@PathVariable Long id)
    // {
    //     return ticketService.deleteUser(id);
    // }
    // @GetMapping("/username")
    // public List<Users> getByusername(@RequestParam(name="Uname") String name)
    // {
    //     return ticketService.getUsername(name);
    // }
}