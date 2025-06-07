package com.ticket.tickets.controllers;

import com.ticket.tickets.domain.CreateEventRequest;
import com.ticket.tickets.domain.dtos.CreateEventRequestDto;
import com.ticket.tickets.domain.dtos.CreateEventResponseDto;
import com.ticket.tickets.domain.dtos.ListEventResponseDto;
import com.ticket.tickets.domain.entities.Event;
import com.ticket.tickets.mappers.EventMapper;
import com.ticket.tickets.services.EventService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/events")
@RequiredArgsConstructor
public class EventController {
    private final EventMapper eventMapper;
    private final EventService eventService;

    @PostMapping
    public ResponseEntity<CreateEventResponseDto> createEvent(
            @AuthenticationPrincipal Jwt jwt,
            @Valid @RequestBody CreateEventRequestDto createEventRequestDto){
        CreateEventRequest createEventRequest = eventMapper.fromDto(createEventRequestDto);
        UUID userid = parseUserId(jwt);

        Event createdEEvent = eventService.createEvent(userid, createEventRequest);
        CreateEventResponseDto createEventResponseDto= eventMapper.toDto(createdEEvent);
        return new ResponseEntity<>(createEventResponseDto, HttpStatus.CREATED);
}

    @GetMapping
    public ResponseEntity<Page<ListEventResponseDto>> listEvents(
            @AuthenticationPrincipal Jwt jwt,
            Pageable pageable){
        UUID userid = parseUserId(jwt);
        Page<Event> events = eventService.listEventsForOrganizer(userid, pageable);
        return ResponseEntity.ok(events.map(eventMapper::toListEventResponseDto));
    }

    private UUID parseUserId(Jwt jwt){
        return UUID.fromString(jwt.getSubject());
    }
}
