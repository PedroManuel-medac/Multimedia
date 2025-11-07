CREATE TABLE IF NOT EXISTS usuarios (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(50),
  edad INT
);

INSERT INTO usuarios(nombre, edad) VALUES
('Pilar', 18),
('José', 26);
