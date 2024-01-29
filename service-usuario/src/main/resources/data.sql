
-- Crear la tabla de usuarios
CREATE TABLE tbl_usuario (
    id INT PRIMARY KEY AUTO_INCREMENT,
    number_id VARCHAR(20) NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    photo_url VARCHAR(255),
    state VARCHAR(50) NOT NULL
);

-- Insertar datos en la tabla de usuarios
INSERT INTO tbl_usuario (number_id, first_name, last_name, email, photo_url, state)
VALUES ('111111111', 'Jaime', 'Guzmán', 'profesor@tec.com', '', 'Active');
