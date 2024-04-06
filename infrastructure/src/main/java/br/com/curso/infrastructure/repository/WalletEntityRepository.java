package br.com.curso.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WalletEntityRepository extends JpaRepository<WalletEntityRepository, UUID> {
}
