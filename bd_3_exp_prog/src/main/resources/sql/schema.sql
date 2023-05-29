--Sequences
CREATE SEQUENCE "AppUserSeq";
CREATE SEQUENCE "AppUserAuthoritySeq";
--Tables
CREATE TABLE IF NOT EXISTS "AppUser" (
    "id" BIGINT NOT NULL AUTO_INCREMENT,
    "name" VARCHAR(30) NOT NULL,
    "email" VARCHAR(255) NOT NULL,
    "password" VARCHAR(255) NOT NULL,
    "balance" FLOAT NOT NULL DEFAULT 100,
    "enabled" BOOLEAN NOT NULL DEFAULT true,
    "account_non_expired" BOOLEAN NOT NULL DEFAULT true,
    "credentials_non_expired" BOOLEAN NOT NULL DEFAULT true,
    "account_non_locked" BOOLEAN NOT NULL DEFAULT true,
    PRIMARY KEY ("id")
);
CREATE TABLE IF NOT EXISTS "AppUserAuthority" (
    "id" BIGINT NOT NULL AUTO_INCREMENT,
    "authority" VARCHAR(50) NOT NULL,
    "user_id" BIGINT NOT NULL,
    PRIMARY KEY ("id"),
    CONSTRAINT "FK_AppUserAuthority_user_id" FOREIGN KEY ("user_id")
        REFERENCES "AppUser"("id")
        ON DELETE CASCADE
);