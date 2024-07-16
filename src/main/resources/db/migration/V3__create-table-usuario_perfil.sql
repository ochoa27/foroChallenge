CREATE TABLE IF NOT EXISTS Usuario_Perfil  (
                                usuario_id BIGINT,
                                perfil_id BIGINT,
                                PRIMARY KEY (usuario_id, perfil_id),
                                FOREIGN KEY (usuario_id) REFERENCES usuarios(id),
                                FOREIGN KEY (perfil_id) REFERENCES perfil(id)
);