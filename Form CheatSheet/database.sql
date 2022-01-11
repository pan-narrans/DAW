DROP DATABASE IF EXISTS db_name;
CREATE DATABASE db_name CHARACTER SET utf8mb4;
USE db_name;

CREATE TABLE formulario(
  id INT AUTO_INCREMENT PRIMARY KEY,

  db_var_name_1 VARCHAR(200) NOT NULL,
  db_var_name_2 VARCHAR(200) NOT NULL,
  db_var_name_3 VARCHAR(200) NOT NULL,
  db_var_name_4 VARCHAR(200) NOT NULL,

  cheque_regalo ENUM('si', 'no') NOT NULL,
  hora_dormir ENUM('10-12', '+12') NOT NULL,
  condiciones VARCHAR(50) DEFAULT 'NO ACEPTADAS' NOT NULL
);