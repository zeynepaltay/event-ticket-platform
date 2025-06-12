package com.ticket.tickets.services;

import com.ticket.tickets.domain.entities.Ticket;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface TicketTypeService {
    Ticket purchaseTicketType(UUID userId, UUID ticketTypeId);
}
