# petshop

# postgres local
docker run -p 5432:5432 --name petshop-postgres -e POSTGRES_PASSWORD=petshop -e POSTGRES_USER=petshop -e POSTGRES_DB=petshop -d postgres
CREATE SCHEMA IF NOT exists AUTHORIZATION petshop;
CREATE TABLE petshop.animal (
animal_id bigserial NOT NULL,
tx_name varchar(4000) NOT NULL,
ir_age integer NOT null,
CONSTRAINT animal_pkey PRIMARY KEY (animal_id)
);

CREATE TABLE petshop.people (
people_id bigserial NOT NULL,
tx_name varchar(4000) NOT NULL,
ir_age integer NOT null,
CONSTRAINT people_pkey PRIMARY KEY (people_id)
);
