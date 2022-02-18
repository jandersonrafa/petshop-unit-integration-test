# petshop

# postgres local
docker run -p 5432:5432 --name petshop-postgres -e POSTGRES_PASSWORD=petshop -e POSTGRES_USER=petshop -e POSTGRES_DB=petshop -d postgres
CREATE SCHEMA IF NOT exists AUTHORIZATION petshop;
CREATE TABLE petshop.pet (
pet_id bigserial NOT NULL,
tx_name varchar(4000) NOT NULL,
ir_age integer NOT null,
CONSTRAINT pet_pkey PRIMARY KEY (pet_id)
);

CREATE TABLE petshop.person (
person_id bigserial NOT NULL,
tx_name varchar(4000) NOT NULL,
ir_age integer NOT null,
CONSTRAINT person_pkey PRIMARY KEY (person_id)
);
