package br.com.curso.infrastructure.entity;

import br.com.curso.core.domain.enums.UserTypeEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Users")
@Entity
public class UserEntity {

    @Column(name = "id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "Email", nullable = false)
    private String email;
    @Column(name = "Password", nullable = false)
    private String password;
    @Column(name = "TaxNumber", nullable = false)
    private String taxNumber;
    @Column(name = "Fullname", nullable = false)
    private String fullname;
    @Column(name = "Type", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserTypeEnum type;
    @Column(name = "CreatedAt", nullable = false)
    private LocalDateTime createdAt;
    @Column(name = "UpdateAt")
    private LocalDateTime updateAt;


}