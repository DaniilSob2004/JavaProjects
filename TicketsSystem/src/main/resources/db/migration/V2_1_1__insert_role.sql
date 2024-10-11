insert into Customer(id, name, email, phone, encrypted_password)
values (7, 'admin', 'admin@gmail.com', '+380654785412', '$2a$10$NlXcRl7SyECPSmc3hEThl.AByQe6fLRk5XUJO6Rd5x.ghAmXPkVwi');

insert into user_role(id, role_name)
values (1, 'ROLE_ADMIN'),
       (2, 'ROLE_USER');

insert into customer_role(id, customer_id, role_role_id)
values (1, 7, 1);