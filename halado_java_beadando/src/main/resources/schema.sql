CREATE TABLE people (
    person_id BIGINT PRIMARY KEY auto_increment,
    name VARCHAR(32),
    age INT,
);

CREATE TABLE details (
    detail_id BIGINT PRIMARY KEY auto_increment,
    person_id BIGINT REFERENCES people (person_id),
    name VARCHAR(16),
    level VARCHAR(16)
);

CREATE TABLE events (
    event_id BIGINT PRIMARY KEY auto_increment,
    location VARCHAR(64),
    event_date TIMESTAMP,
);

CREATE TABLE people_events (
  person_id BIGINT NOT NULL REFERENCES people (person_id),
  event_id BIGINT NOT NULL REFERENCES events (event_id),
  PRIMARY KEY (person_id, event_id),
);