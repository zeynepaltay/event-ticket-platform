package com.ticket.tickets.mappers;

import com.ticket.tickets.domain.dtos.ListTicketResponseDto;
import com.ticket.tickets.domain.dtos.ListTicketTicketTypeResponseDto;
import com.ticket.tickets.domain.entities.Ticket;
import com.ticket.tickets.domain.entities.TicketType;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TicketMapper {
    ListTicketTicketTypeResponseDto toListTicketTicketTypeResponseDto(TicketType ticketType);

    ListTicketResponseDto toListTicketResponseDto(Ticket ticket);

}
