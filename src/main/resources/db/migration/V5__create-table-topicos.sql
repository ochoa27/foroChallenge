CREATE TABLE IF NOT EXISTS Topicos  (
                        id BIGINT PRIMARY KEY AUTO_INCREMENT,
                        titulo VARCHAR(255) NOT NULL,
                        mensaje TEXT NOT NULL,
                        fechaCreacion TIMESTAMP NOT NULL,
                        status VARCHAR(50) NOT NULL,
                        autor_id BIGINT,
                        curso_id BIGINT,
                        FOREIGN KEY (autor_id) REFERENCES usuarios(id),
                        FOREIGN KEY (curso_id) REFERENCES cursos(id)
);