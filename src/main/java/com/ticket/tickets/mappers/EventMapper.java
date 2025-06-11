package com.ticket.tickets.mappers;

import com.ticket.tickets.domain.CreateEventRequest;
import com.ticket.tickets.domain.CreateTicketTypeRequest;
import com.ticket.tickets.domain.UpdateEventRequest;
import com.ticket.tickets.domain.UpdateTicketTypeRequest;
import com.ticket.tickets.domain.dtos.*;
import com.ticket.tickets.domain.entities.Event;
import com.ticket.tickets.domain.entities.TicketType;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EventMapper {
    CreateTicketTypeRequest fromDto (CreateTicketTypeRequestDto dto);

    CreateEventRequest fromDto (CreateEventRequestDto dto);

    CreateEventResponseDto toDto(Event event);

    ListEventTicketTypeResponseDto toDto(TicketType ticketType);

    ListEventResponseDto toListEventResponseDto(Event event);

    GetEventDetailsTicketTypesResponseDto toGetEventDetailsTicketTypesResponseDto(TicketType ticketType);

    GetEventDetailsResponseDto toGetEventDetailsResponseDto(Event event);

    UpdateTicketTypeRequest fromDto (UpdateTicketTypeRequestDto dto);

    UpdateEventRequest fromDto (UpdateEventRequestDto dto);

    UpdateTicketTypeResponseDto toUpdateTicketTypeResponseDto(TicketType ticketType);

    UpdateEventResponseDto toUpdateEventResponseDto(Event event);

    ListPublishedEventResponseDto toListPublishedEventResponseDto(Event event);

    GetPublishedEventDetailsResponseDto toGetPublishedEventDetailsResponseDto(Event event);

    GetPublishedEventDetailsTicketTypesResponseDto toGetPublishedEventDetailsTicketTypesResponseDto(TicketType ticketType);
}
