CREATE TYPE LOG_LEVEL AS ENUM ('INFO', 'DEBUG', 'ERROR');

CREATE TABLE log_data (
    id SERIAL PRIMARY KEY,
    level LOG_LEVEL NOT NULL,
    src TEXT NOT NULL,
    message TEXT NOT NULL
);