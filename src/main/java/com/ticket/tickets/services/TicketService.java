package com.ticket.tickets.services;

import com.ticket.tickets.domain.entities.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface TicketService {

    Page<Ticket> listTicketsForUser(UUID userId, Pageable pageable);
}
