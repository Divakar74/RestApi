package com.example.flightticketbooking.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.flightticketbooking.model.Ticket;
import com.example.flightticketbooking.model.User;
import com.example.flightticketbooking.repository.TicketRepository;

@Service

public class TicketService {
    @Autowired
    TicketRepository ticketRepository;

    public List<Ticket> getAllTickets1() {
        return ticketRepository.findAll();
    }
    @SuppressWarnings("null")
    public Ticket getTicketById1(Long id) {
        return ticketRepository.findById(id).orElse(null);
    }

    @SuppressWarnings("null")
    public Ticket saveOrUpdateTicket1(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @SuppressWarnings("null")
    public void deleteTicket1(Long id) {
        ticketRepository.deleteById(id);
    }
    public List<Ticket> getpage(int offset,int pagesize)
    {
        Pageable page=PageRequest.of(offset, pagesize);
        return ticketRepository.findAll(page).getContent();
    }
    
    public List<Ticket> getpagesort(int offset,int pagesize,String field)
    {
        return ticketRepository.findAll(PageRequest.of(offset, pagesize)
        .withSort(Sort.Direction.ASC,field)).getContent();
    }



}