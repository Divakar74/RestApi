package com.example.flightticketbooking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.flightticketbooking.model.Ticket;
import com.example.flightticketbooking.model.Users;
import com.example.flightticketbooking.repository.TicketRepository;
import com.example.flightticketbooking.repository.UserRepo;

@Service

public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    UserRepo userRepo;
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }
    public Ticket getTicketById(Long id) {
        return ticketRepository.findById(id).orElse(null);
    }

    public Ticket saveOrUpdateTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }
    public Users postUser(Users user)
    {
        return userRepo.save(user);
    }
    public List<Users> getUser()
    {
        return userRepo.findAll();
    }
    @SuppressWarnings("null")
    public Optional<Users> getUserbyId(Long id)
    {
        return userRepo.findById(id);
    }
    @SuppressWarnings("null")
    public Users putUser(Long id,Users user)
    {
          Users userAvail = userRepo.findById(id).orElse(null);
          if(userAvail!=null)
          {
            userAvail.setUsername(user.getUsername());
            userAvail.setUserpass(user.getUserpass());
            userAvail.setUsermailid(user.getUsermailid());
            return userRepo.saveAndFlush(userAvail);
          }
          else
          return null;
    }
    public String deleteUser(Long id)
    {
        userRepo.deleteById(id);
        return "User DELETED";
    }
    public List<Users> getUsername(String name)
    {
        return userRepo.findByUsername(name);
    }
}