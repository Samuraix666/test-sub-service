CREATE TABLE users
(
    id            SERIAL PRIMARY KEY,
    full_name     VARCHAR(255) NOT NULL,
    email         VARCHAR(255) NOT NULL UNIQUE,
    date_of_birth DATE         NOT NULL,
    is_active     BOOLEAN      NOT NULL DEFAULT TRUE
);

CREATE TABLE subscriptions
(
    id              SERIAL PRIMARY KEY,
    service_name    VARCHAR(255) NOT NULL,
    start_date      DATE         NOT NULL,
    end_date        DATE,
    is_active       BOOLEAN      NOT NULL DEFAULT TRUE,
    monthly_payment BIGINT,
    user_id         BIGINT       NOT NULL REFERENCES users (id)
);
