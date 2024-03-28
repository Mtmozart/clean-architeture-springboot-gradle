package br.com.curso.core.domain;

import java.time.LocalDateTime;

public class TransactionPin {

    private Long id;
    private User user;
    private String pin;
    private Integer attempt;
    private Boolean blocker;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public TransactionPin(Long id, User user, String pin, Integer attempt, Boolean blocker, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.user = user;
        this.pin = pin;
        this.attempt = attempt;
        this.blocker = blocker;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public TransactionPin(User user, String pin, Integer attempt, Boolean blocker) {
        this.user = user;
        this.pin = pin;
        this.attempt = attempt;
        this.blocker = blocker;
        this.createdAt = LocalDateTime.now();
    }

    public TransactionPin() {
          }
}
