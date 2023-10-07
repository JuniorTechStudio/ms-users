ALTER TABLE users.users
    ADD CONSTRAINT users_unique UNIQUE (telegram_id);