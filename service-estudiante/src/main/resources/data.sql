-- Crear la tabla de estudientes
CREATE TABLE tbl_estudiante (
                             id INT PRIMARY KEY AUTO_INCREMENT,
                             number_id VARCHAR(20) NOT NULL,
                             first_name VARCHAR(255) NOT NULL,
                             last_name VARCHAR(255) NOT NULL,
                             email VARCHAR(255) NOT NULL,
                             photo_url VARCHAR(255),
                             state VARCHAR(50) NOT NULL
);

-- Insertar datos en la tabla de estudientes
INSERT INTO tbl_estudiante (number_id, first_name, last_name, email, photo_url, state)
VALUES ('222222222', 'Ana', 'López', 'ana.lopez@email.com', 'url_foto_ana', 'Active');

INSERT INTO tbl_estudiante (number_id, first_name, last_name, email, photo_url, state)
VALUES ('333333333', 'Carlos', 'Martínez', 'carlos.martinez@email.com', 'url_foto_carlos', 'Active');

INSERT INTO tbl_estudiante (number_id, first_name, last_name, email, photo_url, state)
VALUES ('444444444', 'Laura', 'García', 'laura.garcia@email.com', 'url_foto_laura', 'Inactive');