package com.ticket.tickets.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListPublishedEventResponseDto {
    private UUID id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private String venue;
}
