CREATE TYPE LEVEL AS ENUM ('Trainee','Junior','Middle','Senior');
CREATE TABLE worker
(
    ID       SERIAL PRIMARY KEY,
    NAME     VARCHAR(1000) CHECK ( length(NAME) > 1 ) NOT NULL,
    BIRTHDAY DATE CHECK ( date_part('year', BIRTHDAY) > 1900 ),
    LEVEL    LEVEL                                    NOT NULL,
    SALARY   int CHECK ( SALARY > 100 AND SALARY < 100000 )
);
CREATE TABLE client
(
    ID       SERIAL PRIMARY KEY,
    NAME     VARCHAR(1000) CHECK ( length(NAME) > 1 ) NOT NULL
);
CREATE TABLE project
(
    ID       SERIAL PRIMARY KEY,
    CLIENT_ID INT REFERENCES client(ID),
    START_DATE DATE,
    FINISH_DATE DATE
);
CREATE TABLE project_worker
(
    PROJECT_ID INT REFERENCES project(ID),
    WORKER_ID INT REFERENCES worker(ID),
    CONSTRAINT project_worker_pk PRIMARY KEY (PROJECT_ID, WORKER_ID)
);