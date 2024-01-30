-- Crear la tabla de cursos
CREATE TABLE tbl_curso (
                           id INT PRIMARY KEY AUTO_INCREMENT,
                           number_id VARCHAR(20) NOT NULL,
                           name VARCHAR(255) NOT NULL,
                           description VARCHAR(255) NOT NULL,
                           period VARCHAR(255) NOT NULL,
                           state VARCHAR(50) NOT NULL
);

-- Insertar datos en la tabla de cursos
INSERT INTO tbl_curso (number_id, name, description, period, state) VALUES ('2548', 'Matemáticas', 'Curso de matemáticas', 'oct/2023-feb/2024', 'Active');
INSERT INTO tbl_curso (number_id, name, description, period, state) VALUES ('2549', 'Historia', 'Curso de historia', 'ene/2024-may/2024', 'Active');
INSERT INTO tbl_curso (number_id, name, description, period, state) VALUES ('2550', 'Inglés Avanzado', 'Curso de inglés avanzado', 'mar/2024-jul/2024', 'Active');
INSERT INTO tbl_curso (number_id, name, description, period, state) VALUES ('2551', 'Programación Java', 'Curso de programación en Java', 'abr/2024-ago/2024', 'Active');

--test