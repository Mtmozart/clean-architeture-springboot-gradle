package br.com.curso.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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
    private Integer attempt;
    @Column(name = "Blocked", nullable = false)
    private Boolean blocked;
    @Column(name = "CreatedAt", nullable = false)
    private LocalDateTime createdAt;
    @Column(name = "UpdateAt")
    private LocalDateTime updateAt;

<<<<<<< HEAD:infrastructure/src/main/java/br/com/curso/infrastructure/entity/TransactionPinEntity.java
    public TransactionPinEntity(String pin, Integer attempt, Boolean blocked, LocalDateTime createdAt, LocalDateTime updateAt) {
        this.pin = pin;
        this.attempt = attempt;
        this.blocked = blocked;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }
=======

>>>>>>> 5b89a9e... finalizando o repository e entities:infrastucture/src/main/java/br/com/curso/entity/TransactionPinEntity.java
}
