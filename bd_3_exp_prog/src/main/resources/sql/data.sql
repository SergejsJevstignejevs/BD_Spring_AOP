INSERT INTO "AppUser" ("id", "name", "email", "password") VALUES (nextval('AppUserSeq'), 'sergejs', 'jevstignejevss@gmail.com', '$2a$10$1IABEPvtAwb3O/P2fAJx0.w0OZBH/Fxqhncsjpd73z/bbfl9Y.WVe');
INSERT INTO "AppUserAuthority" ("id", "authority", "user_id") VALUES (nextval('AppUserAuthoritySeq'), 'ROLE_USER', (SELECT "id" FROM "AppUser" WHERE "email" = 'jevstignejevss@gmail.com'));
INSERT INTO "AppUserAuthority" ("id", "authority", "user_id") VALUES (nextval('AppUserAuthoritySeq'), 'ROLE_ADMIN', (SELECT "id" FROM "AppUser" WHERE "email" = 'jevstignejevss@gmail.com'));

