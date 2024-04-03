package br.com.curso.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserEntityRepository extends JpaRepository<UserEntityRepository, UUID> {
}
