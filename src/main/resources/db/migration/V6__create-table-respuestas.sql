CREATE TABLE IF NOT EXISTS Respuestas (
                           id BIGINT PRIMARY KEY AUTO_INCREMENT,
                           mensaje TEXT NOT NULL,
                           fechaCreacion TIMESTAMP NOT NULL,
                           autor_id BIGINT,
                           topico_id BIGINT,
                           solucion BOOLEAN NOT NULL DEFAULT FALSE,
                           FOREIGN KEY (autor_id) REFERENCES usuarios(id),
                           FOREIGN KEY (topico_id) REFERENCES topicos(id)
);