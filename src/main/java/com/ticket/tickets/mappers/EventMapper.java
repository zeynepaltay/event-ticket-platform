package com.ticket.tickets.mappers;

import com.ticket.tickets.domain.CreateEventRequest;
import com.ticket.tickets.domain.CreateTicketTypeRequest;
import com.ticket.tickets.domain.dtos.CreateEventRequestDto;
import com.ticket.tickets.domain.dtos.CreateEventResponseDto;
import com.ticket.tickets.domain.dtos.CreateTicketTypeRequestDto;
import com.ticket.tickets.domain.entities.Event;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EventMapper {
    CreateTicketTypeRequest fromDto (CreateTicketTypeRequestDto dto);

    CreateEventRequest fromDto (CreateEventRequestDto dto);

    CreateEventResponseDto toDto(Event event);
}
