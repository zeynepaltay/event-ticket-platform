package domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "events")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Event {
    @Id
    @Column(updatable = false , nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name= "name", nullable = false)
    private String name;

    @Column(name= "start", nullable = false)
    private LocalDateTime start;

    @Column(name= "end", nullable = false)
    private LocalDateTime end;

    @Column(name= "venue", nullable = false)
    private String venue;

    @Column(name="sales_start")
    private LocalDateTime salesStart;

    @Column(name="sales_end")
    private LocalDateTime salesEnd;

    private EventStatusEnum status;
}
