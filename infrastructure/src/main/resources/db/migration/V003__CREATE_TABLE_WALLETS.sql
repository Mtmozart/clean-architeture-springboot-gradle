CREATE TABLE wallets (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    balance DECIMAL(10, 2) NOT NULL,
    userId VARCHAR(36) NOT NULL UNIQUE,
    transactionPinId BIGINT NOT NULL UNIQUE,
    createdAt DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updatedAt DATETIME,
    FOREIGN KEY (userId) REFERENCES users(id),
    FOREIGN KEY (transactionPinId) REFERENCES transactions_pin(id)
);
