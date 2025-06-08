package com.ticket.tickets.services;

import com.ticket.tickets.domain.CreateEventRequest;
import com.ticket.tickets.domain.entities.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface EventService {
    Event createEvent(UUID organizerId, CreateEventRequest event);
    Page<Event> listEventsForOrganizer(UUID organizerId, Pageable pageable);
    Optional<Event> getEventOrganizer(UUID organizerId, UUID id);

}
