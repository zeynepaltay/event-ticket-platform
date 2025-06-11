package com.ticket.tickets.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetPublishedEventDetailsTicketTypesResponseDto {
    private UUID eventId;
    private String name;
    private Double price;
    private String description;
}
