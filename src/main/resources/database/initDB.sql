CREATE TABLE IF NOT EXISTS customers.clients
(
    id    INTEGER PRIMARY KEY ,
    name  VARCHAR(200) NOT NULL ,
    email VARCHAR(254) NOT NULL ,
    phone VARCHAR(50)  NOT NULL ,
    active BOOLEAN NOT NULL
);
CREATE SEQUENCE customers.clients_id_seq START WITH 3 INCREMENT BY 1;

-- DROP TABLE IF EXISTS customers.clients;
-- DROP SEQUENCE IF EXISTS customers.clients_id_seq;