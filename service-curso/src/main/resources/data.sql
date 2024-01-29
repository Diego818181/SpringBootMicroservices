-- Crear la tabla de cursos
CREATE TABLE tbl_curso (
    id INT PRIMARY KEY AUTO_INCREMENT,
    number_id VARCHAR(20) NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    photo_url VARCHAR(255),
    state VARCHAR(50) NOT NULL
);

-- Insertar datos en la tabla de clientes
INSERT INTO tbl_curso (number_id, first_name, last_name, email, photo_url, region_id, state)
VALUES ('1104048713', 'Jaime', 'Guzmán', 'profesor@tec.com', '', 1, 'CR');
