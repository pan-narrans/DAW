DROP DATABASE IF EXISTS form_deseos;
CREATE DATABASE form_deseos CHARACTER SET utf8mb4;
USE form_deseos;

CREATE TABLE form(
  id INT AUTO_INCREMENT PRIMARY KEY,

  nombre VARCHAR(200) NOT NULL,
  direccion VARCHAR(200) NOT NULL,
  email VARCHAR(100) NOT NULL,

  localidad VARCHAR(100) NOT NULL,
  provincia VARCHAR(100) NOT NULL,

  deseos TEXT NOT NULL,
  seguimiento BOOLEAN DEFAULT FALSE

);