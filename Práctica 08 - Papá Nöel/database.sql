# SCRIP PARA GENERAR LA BASE DE DATOS NECESARIA PARA CREAR LA WEB
DROP DATABASE IF EXISTS papanoel;
CREATE DATABASE papanoel CHARACTER SET utf8mb4;
USE papanoel;

CREATE TABLE formulario(
  id INT AUTO_INCREMENT PRIMARY KEY,
  optn1 VARCHAR(50),
  optn2 VARCHAR(50),
  optn3 VARCHAR(50),
  dinero ENUM('si', 'no'),
  color ENUM('azul', 'plata', 'rojo', 'negro'),
  email VARCHAR(20),
  condiciones VARCHAR(20) DEFAULT 'NO ACEPTADAS'
);