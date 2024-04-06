CREATE TABLE Users (
    Id VARCHAR(50) NOT NULL PRIMARY KEY,
    Email VARCHAR(70) NOT NULL UNIQUE,
    Password VARCHAR(50) NOT NULL,
    TaxNumber VARCHAR(15) NOT NULL UNIQUE,
    Fullname VARCHAR(70) NOT NULL,
    Type VARCHAR(30) NOT NULL,
    CreatedAt DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    UpdateAt DATETIME
);