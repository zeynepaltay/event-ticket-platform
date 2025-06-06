package com.ticket.tickets.controllers;

import com.ticket.tickets.domain.CreateEventRequest;
import com.ticket.tickets.domain.dtos.CreateEventRequestDto;
import com.ticket.tickets.domain.dtos.CreateEventResponseDto;
import com.ticket.tickets.domain.entities.Event;
import com.ticket.tickets.mappers.EventMapper;
import com.ticket.tickets.services.EventService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        UUID userid = UUID.fromString(jwt.getSubject());

        Event createdEEvent = eventService.createEvent(userid, createEventRequest);
        CreateEventResponseDto createEventResponseDto= eventMapper.toDto(createdEEvent);
        return new ResponseEntity<>(createEventResponseDto, HttpStatus.CREATED);
}
}
