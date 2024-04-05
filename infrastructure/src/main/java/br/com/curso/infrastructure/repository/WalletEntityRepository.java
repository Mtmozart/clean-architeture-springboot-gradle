package br.com.curso.infrastructure.repository;


import br.com.curso.infrastructure.entity.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WalletEntityRepository extends JpaRepository<WalletEntity, UUID> {
}
