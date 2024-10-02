CREATE TABLE IF NOT EXISTS public.ticket_status (
    id SERIAL PRIMARY KEY,
    status_name VARCHAR(20) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS public.Place (
    id SERIAL PRIMARY KEY,
    address VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS public.Event (
    id SERIAL PRIMARY KEY,
    event_date TIMESTAMP NOT NULL,
    name VARCHAR(255) NOT NULL,
    place_id INT REFERENCES public.Place(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS public.Customer (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    phone VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS public.Ticket (
    id SERIAL PRIMARY KEY,
    cost FLOAT NOT NULL,
    number INT NOT NULL,
    customer_id INT REFERENCES public.Customer(id) ON DELETE SET NULL,
    event_id INT REFERENCES public.Event(id) ON DELETE CASCADE,
    status_id INT REFERENCES public.ticket_status(id) NOT NULL
);