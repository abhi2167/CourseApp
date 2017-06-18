DROP table IF EXISTS TOPIC;
DROP table IF EXISTS COURSE;
CREATE TABLE topic (
  id         VARCHAR PRIMARY KEY,
  name VARCHAR(255),
  description  VARCHAR(255)
);

CREATE TABLE course (
  id   VARCHAR PRIMARY KEY,
  name VARCHAR(255),
  description  VARCHAR(255),
  topic_Id VARCHAR,
  FOREIGN KEY (topic_Id) REFERENCES topic(id)
);

INSERT INTO topic (id, description, name)
VALUES (1,'Java Courses','Java');

INSERT INTO topic (id, description, name)
VALUES (2,'Ruby Courses','Ruby');