package com.ticket.tickets.services.impl;

import com.ticket.tickets.domain.entities.Ticket;
import com.ticket.tickets.domain.entities.TicketStatusEnum;
import com.ticket.tickets.domain.entities.TicketType;
import com.ticket.tickets.domain.entities.User;
import com.ticket.tickets.exceptions.TicketSoldOutException;
import com.ticket.tickets.exceptions.TicketTypeNotFoundException;
import com.ticket.tickets.exceptions.UserNotFoundException;
import com.ticket.tickets.repositories.TicketRepository;
import com.ticket.tickets.repositories.TicketTypeRepository;
import com.ticket.tickets.repositories.UserRepository;
import com.ticket.tickets.services.QrCodeService;
import com.ticket.tickets.services.TicketTypeService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TicketTypeServiceImpl implements TicketTypeService {

    private final UserRepository userRepository;
    private final TicketRepository ticketRepository;
    private final TicketTypeRepository ticketTypeRepository;
    private final QrCodeService qrCodeService;

    @Override
    @Transactional
    public Ticket purchaseTicket(UUID userId, UUID ticketTypeId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(
                String.format("User with id %s not found", userId)));

        TicketType ticketType = ticketTypeRepository.findByIdWithLock(ticketTypeId).orElseThrow(() -> new TicketTypeNotFoundException(
                String.format("Ticket type with id %s not found", ticketTypeId)));

        int purchasedTickets = ticketRepository.countByTicketTypeId(ticketTypeId);
        Integer totalAvailable = ticketType.getTotalAvailable();

        if(purchasedTickets + 1 > totalAvailable) {
            throw new TicketSoldOutException();
        }

        Ticket ticket = new Ticket();
        ticket.setStatus(TicketStatusEnum.PURCHASED);
        ticket.setTicketType(ticketType);
        ticket.setPurchaser(user);

        Ticket savedTicket = ticketRepository.save(ticket);
        qrCodeService.generateQrCode(savedTicket);
        return ticketRepository.save(savedTicket);
    }
}
