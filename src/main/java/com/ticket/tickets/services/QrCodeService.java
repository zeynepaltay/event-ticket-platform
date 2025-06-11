package com.ticket.tickets.services;

import com.ticket.tickets.domain.entities.QrCode;
import com.ticket.tickets.domain.entities.Ticket;
import org.springframework.stereotype.Service;

@Service
public interface QrCodeService {

    QrCode generateQrCode(Ticket ticket);
}
