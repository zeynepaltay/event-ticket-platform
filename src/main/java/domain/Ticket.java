package domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name ="tickets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {
    @Id
    @Column(name ="id", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name ="status", nullable = false)
    @Enumerated(EnumType.STRING)
    private TicketStatusEnum status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket_type_id")
    private TicketType ticketType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "purchaser_id")
    private User purchaser;

    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL)
    private List<TicketValidation> validations= new ArrayList<>();

    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL)
    private List<QrCode> qrCode = new ArrayList<>();

    @CreatedDate
    @Column(name ="created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "update_at", nullable = false)
    private LocalDateTime updatedAt;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(id, ticket.id) && status == ticket.status && Objects.equals(createdAt, ticket.createdAt) && Objects.equals(updatedAt, ticket.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, createdAt, updatedAt);
    }
}
