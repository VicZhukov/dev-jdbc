CREATE TABLE IF NOT EXISTS worker (
    id INT PRIMARY KEY,
    name VARCHAR NOT NULL,
        CHECK (LENGTH(name) >= 2 AND LENGTH(name) <= 1000),
    birthday DATE,
        CHECK (YEAR(birthday) > 1900),
    level ENUM ('Trainee', 'Junior', 'Middle', 'Senior') NOT NULL,
    salary INT,
        CHECK (100 <= salary AND salary <= 100000)
);

CREATE TABLE IF NOT EXISTS client (
    id INT PRIMARY KEY,
    name VARCHAR NOT NULL,
        CHECK (LENGTH(name) >= 2 AND LENGTH(name) <= 1000)
);

CREATE TABLE IF NOT EXISTS project (
    id INT PRIMARY KEY,
    client_id INT,
    start_date TIMESTAMP,
        CHECK (YEAR(start_date) > 2022),
    finish_date TIMESTAMP,
        CHECK (YEAR(finish_date) > 2022),
        FOREIGN KEY (client_id) REFERENCES client(id)
);

CREATE TABLE IF NOT EXISTS project_worker (
    project_id INT NOT NULL,
    worker_id INT NOT NULL,
        PRIMARY KEY (project_id, worker_id),
        FOREIGN KEY (project_id) REFERENCES project (id),
        FOREIGN KEY (worker_id) REFERENCES worker (id)
);