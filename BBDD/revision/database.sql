DROP DATABASE IF EXISTS EMPRESA;
CREATE DATABASE EMPRESA CHARACTER SET utf8mb4;
USE EMPRESA;

CREATE TABLE Empleados(
  dni INTEGER(8) PRIMARY KEY,
  nombre VARCHAR (10) NOT NULL,
  apellido1 VARCHAR (15) NOT NULL,
  apellido2 VARCHAR (15),
  direcc1 VARCHAR (25),
  direcc2 VARCHAR (25),
  ciudad VARCHAR (20),
  provincia VARCHAR (20),
  cod_postal VARCHAR (5),
  sexo ENUM("H", "M"),
  fecha_nac DATE
);

CREATE TABLE Departamentos(
  dpto_cod INTEGER(5) PRIMARY KEY,
  nombre_dpto VARCHAR (30) NOT NULL UNIQUE,
  dpto_padre INTEGER (5),
  presupuesto INTEGER NOT NULL,
  pres_actual INTEGER,

  CONSTRAINT fk_DEPT_DEPT_dpto_padre
    FOREIGN KEY (dpto_padre) REFERENCES Departamentos(dpto_cod)
);

CREATE TABLE Universidades(
  univ_cod INTEGER(5) PRIMARY KEY,
  nombre_univ VARCHAR (25) NOT NULL,
  ciudad VARCHAR (20),
  municipio VARCHAR (2),
  cod_postal VARCHAR (5)
);

CREATE TABLE Trabajos(  
  trabajo_cod INTEGER(5) PRIMARY KEY,
  nombre_trab VARCHAR (20) NOT NULL UNIQUE,
  año INTEGER,
  salario_min INTEGER (2) NOT NULL,
  salario_max INTEGER (2) NOT NULL
);

CREATE TABLE Estudios(
  empleado_dni INTEGER(8),
  universidad INTEGER(5),
  año INTEGER,
  grado VARCHAR (3),
  especialidad VARCHAR (20),

  PRIMARY KEY (empleado_dni, universidad, grado),

  CONSTRAINT fk_EST_EMP_empleado_dni
    FOREIGN KEY (empleado_dni) REFERENCES Empleados(dni),
  CONSTRAINT fk_EST_UNI_universidad
    FOREIGN KEY (universidad) REFERENCES Universidades(univ_cod)
);

CREATE TABLE Historial_Laboral(
  empleado_dni INTEGER (8),
  trabajo_cod INTEGER (5),
  fecha_inicio DATE,
  fecha_fin DATE,
  dpto_cod INTEGER (5),
  supervisor_dni INTEGER (8),

  PRIMARY KEY (empleado_dni, trabajo_cod, fecha_inicio),

  CONSTRAINT fk_HLAB_EMP_empleado_dni
    FOREIGN KEY (empleado_dni) REFERENCES Empleados(dni),
  CONSTRAINT fk_HLAB_EMP_supervisor_dni
    FOREIGN KEY (supervisor_dni) REFERENCES Empleados(dni),
  CONSTRAINT fk_HLAB_TRAB_trabajo_cod
    FOREIGN KEY (trabajo_cod) REFERENCES Trabajos(trabajo_cod),
  CONSTRAINT fk_HLAB_DEPT_dpto_cod
    FOREIGN KEY (dpto_cod) REFERENCES Departamentos(dpto_cod)
);

CREATE TABLE Historial_Salarial(
  empleado_dni INTEGER (8),
  salario INTEGER (8) NOT NULL,
  fecha_comienzo DATE,
  fecha_fin DATE,

  PRIMARY KEY (empleado_dni, salario, fecha_comienzo),

  
  CONSTRAINT fk_HSAL_EMP_empleado_dni
    FOREIGN KEY (empleado_dni) REFERENCES Empleados(dni)
);



-- -----------------------------
-- --------- INSERTS -----------
-- -----------------------------

INSERT INTO Empleados VALUES( 00000001,'Pedro', 'Picapiedra','Martinez','Cueva de los Picapiedra', 'Cueva de los Mármol', 'Piedradura', 'Sedimento', 28452, 'H', '1998-06-09');
INSERT INTO Empleados VALUES( 00000002,'Pablo', 'Mármol','Rodrigez','Cueva de los Mármol', 'Cueva de los Picapiedra', 'Piedradura', 'Sedimento', 28452, 'H', '1999-06-09');

INSERT INTO Departamentos VALUES(00001, 'Piedras', NULL, 500, 100);
INSERT INTO Departamentos VALUES(00002, 'Losas', 00001, 100, 100);

INSERT INTO Universidades VALUES(00001, 'Muchas Piedras', 'Piedradura', 'Sedimento', 28452);
INSERT INTO Universidades VALUES(00002, 'Pedriza', 'Piedradura', 'Sedimento', 28452);

INSERT INTO Estudios VALUES(00000001, 00001, 2010, 'Estudios Pedrológicos Superiores', 'Sedimentárieas');
INSERT INTO Estudios VALUES(00000002, 00001, 2010, 'Estudios Pedrológicos Superiores', 'Volcánicas');

INSERT INTO Trabajos VALUES(00001, 'Picapedrero', 1000, 5000);
INSERT INTO Trabajos VALUES(00001, 'Supervisor de Picapedreros', 2000, 7000);

INSERT INTO Historial_Laboral VALUES();
INSERT INTO Historial_Laboral VALUES();

INSERT INTO Historial_Salarial VALUES();
INSERT INTO Historial_Salarial VALUES();