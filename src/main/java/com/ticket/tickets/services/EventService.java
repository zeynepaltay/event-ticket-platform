package com.ticket.tickets.services;

import com.ticket.tickets.domain.CreateEventRequest;
import com.ticket.tickets.domain.entities.Event;

import java.util.UUID;

public interface EventService {
    Event createEvent(UUID organizerId, CreateEventRequest event);
}
