-- Categorías base para la app
INSERT INTO categorias (nombre) VALUES ('POLITICA') ON CONFLICT (nombre) DO NOTHING;
INSERT INTO categorias (nombre) VALUES ('ECONOMIA') ON CONFLICT (nombre) DO NOTHING;
INSERT INTO categorias (nombre) VALUES ('DEPORTES') ON CONFLICT (nombre) DO NOTHING;
INSERT INTO categorias (nombre) VALUES ('TECNOLOGIA') ON CONFLICT (nombre) DO NOTHING;

-- Usuario admin de prueba, para poder crear/borrar categorías sin registrar uno a mano
-- email: admin@idontknow.com | password: admin123 (ya viene hasheado con BCrypt)
INSERT INTO usuarios (nombre, email, password, role, fecha_registro)
VALUES ('Administrador', 'admin@idontknow.com', '$2b$10$HDw0cr7bycH3W.lqZ63kcutolqK1MoH.jhRwtWTpAYRKGIY.KnJr6', 'ADMIN', CURRENT_TIMESTAMP)
    ON CONFLICT (email) DO NOTHING;