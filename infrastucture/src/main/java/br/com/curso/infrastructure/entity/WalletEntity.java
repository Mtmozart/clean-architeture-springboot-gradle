package br.com.curso.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Wallets")
@Entity
public class WalletEntity {
    @Column(name = "id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Balance", nullable = false)
    private BigDecimal balance;

    @OneToOne
    @JoinColumn(name = "userId")
    private UserEntity userEntity;

    @OneToOne
    @JoinColumn(name = "TransactionPin")
    private TransactionPinEntity transactionPinEntity;

    @Column(name = "CreatedAt", nullable = false)
    private LocalDateTime createdAt;
    @Column(name = "UpdateAt")
    private LocalDateTime updateAt;


    public WalletEntity(BigDecimal balance, UserEntity userEntity, TransactionPinEntity transactionPinEntity, LocalDateTime createdAt, LocalDateTime updateAt) {
        this.balance = balance;
        this.userEntity = userEntity;
        this.transactionPinEntity = transactionPinEntity;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }
}
