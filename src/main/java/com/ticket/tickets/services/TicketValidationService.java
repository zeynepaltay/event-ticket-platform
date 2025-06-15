package com.ticket.tickets.services;

import com.ticket.tickets.domain.entities.Ticket;
import com.ticket.tickets.domain.entities.TicketValidation;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface TicketValidationService {
    TicketValidation validateTicketByQrCode(UUID qrCodeId);
    TicketValidation validateTicketManually(UUID ticketId);
}
