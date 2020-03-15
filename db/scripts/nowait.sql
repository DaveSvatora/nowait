CREATE SCHEMA postgres AUTHORIZATION postgres;
CREATE SEQUENCE eventsequence START 1;
CREATE SEQUENCE linesequence START 1;
CREATE TABLE postgres.event (
    event_num bigint DEFAULT nextval('eventsequence') PRIMARY KEY NOT NULL,
    event_name text NOT NULL,
    event_date date DEFAULT CURRENT_DATE NOT NULL
);

CREATE TABLE postgres.event_queue (
    event_num bigint REFERENCES postgres.event,
    serving_num bigint DEFAULT nextval('linesequence') PRIMARY KEY NOT NULL,
    name text NOT NULL,
    phone_num text NOT NULL,
    start_time time without time zone DEFAULT CURRENT_TIME NOT NULL,
    next_in_line time without time zone DEFAULT '01:01:01' NOT NULL,
    end_time time without time zone DEFAULT '01:01:01' NOT NULL
);