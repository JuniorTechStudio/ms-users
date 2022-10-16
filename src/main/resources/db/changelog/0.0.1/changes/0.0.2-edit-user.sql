ALTER TABLE users.users
    ADD COLUMN user_name varchar;
ALTER TABLE users.users
    ADD COLUMN telegram_id varchar;
ALTER TABLE users.users
    ADD COLUMN is_blocked boolean