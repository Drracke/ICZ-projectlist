CREATE TABLE PERSON
(
    -- rodne cislo ako ID
    id            VARCHAR(255) PRIMARY KEY,
    first_name    VARCHAR(255),
    last_name     VARCHAR(255),
    email         VARCHAR(255)
);

CREATE SEQUENCE company_id_seq;
CREATE TABLE COMPANY
(
    -- rodne cislo ako ID
    id            SERIAL PRIMARY KEY,
    company_name  VARCHAR(255),
    ico           VARCHAR(255)
);


CREATE TABLE PROJECT
(
    id                  SERIAL PRIMARY KEY,
    project_name        VARCHAR(225),
    project_short       VARCHAR(20),
    customer_company    INTEGER,
    FOREIGN KEY (customer_company) REFERENCES COMPANY (id)
);

CREATE TABLE PROJECT_ROLE
(
    id                  SERIAL PRIMARY KEY,
    role_name           VARCHAR(255)
);

CREATE TABLE ASSIGNMENT
(
    id                  SERIAL PRIMARY KEY,
    project_id          INTEGER,
    person_id           VARCHAR(255),
    role_id             INTEGER,
    FOREIGN KEY (project_id) REFERENCES PROJECT (id),
    FOREIGN KEY (person_id) REFERENCES PERSON (id),
    FOREIGN KEY (role_id) REFERENCES PROJECT_ROLE (id)

);


