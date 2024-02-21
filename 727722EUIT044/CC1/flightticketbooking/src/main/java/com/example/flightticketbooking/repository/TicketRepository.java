package com.example.flightticketbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.flightticketbooking.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> 
{

}