create table IF NOT EXISTS role (
    id serial not null constraint role_pkey primary key,
    role_name varchar(30)
);

CREATE TABLE IF NOT EXISTS customer_role (
    id SERIAL PRIMARY KEY,
    customer_id integer,
    role_role_id integer,
    FOREIGN KEY (customer_id) REFERENCES Customer (id)  ON DELETE CASCADE,
    FOREIGN KEY (role_role_id) REFERENCES role (id) ON DELETE CASCADE
);