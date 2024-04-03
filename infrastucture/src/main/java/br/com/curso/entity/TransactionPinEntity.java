package br.com.curso.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TransactionPin")
@Entity
public class TransactionPinEntity {
    @Column(name = "id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Pin", nullable = false)
    private String pin;
    @Column(name = "Attempt", nullable = false)
    private String attempt;
    @Column(name = "Blocked", nullable = false)
    private Boolean blocked;
    @Column(name = "CreatedAt", nullable = false)
    private LocalDateTime createdAt;
    @Column(name = "UpdateAt")
    private LocalDateTime updateAt;

}
