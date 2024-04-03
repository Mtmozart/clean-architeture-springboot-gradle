package br.com.curso.entity;

import br.com.curso.core.domain.enums.UserTypeEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Type;
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
    @Enumerated
    private UserTypeEnum type;
    @Column(name = "CreatedAt", nullable = false)
    private LocalDateTime createdAt;
    @Column(name = "UpdateAt")
    private LocalDateTime updateAt;

    public UserEntity(UUID id, String email, String password, String taxNumber, String fullname, UserTypeEnum type) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.taxNumber = taxNumber;
        this.fullname = fullname;
        this.type = type;
        this.createdAt = LocalDateTime.now();
    }
}
