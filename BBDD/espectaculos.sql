CREATE DATABASE VENTA_AUTOMATICA;
USE VENTA_AUTOMATICA;

/* ESPECTACULOS (COD_ESPECTACULO, NOMBRE, TIPO, FECHA_INICIAL, FECHA_FINAL, INTERPRETE, COD_RECINTO) */
/* nos falta la fk a recintos */
CREATE TABLE ESPECTACULOS(
  cod_espectaculo VARCHAR(5) PRIMARY KEY,
  nombre VARCHAR(50) NOT NULL,
  tipo ENUM("T1", "T2", "T3") DEFAULT "T1",
  fecha_inicial DATE NOT NULL,
  fecha_final DATE NULL,
  interprete VARCHAR(50),
  cod_recinto INT,

  CONSTRAINT ck_fechas
    CHECK (fecha_final > fecha_inicial)
);

/* RECINTOS (COD_RECINTO, NOMBRE, DIRECCION, CIUDAD, TELEFONO, HORARIO) */
CREATE TABLE RECINTOS(
  cod_recinto INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(50) NOT NULL UNIQUE,
  direccion VARCHAR(100) NOT NULL,
  ciudad VARCHAR(30) NOT NULL,
  tlf VARCHAR(11),
  horario ENUM("H1", "H2") DEFAULT "H2",

  CONSTRAINT ck_horario
    CHECK (horario = "H1" OR horario = "H")
);

/* creamos la fk que nos faltaba */
ALTER TABLE ESPECTACULOS
  ADD CONSTRAINT fk_ESP_REC_cod_recinto
    FOREIGN KEY (cod_recinto) REFERENCES RECINTOS(cod_recinto)
    ON UPDATE CASCADE ON DELETE CASCADE;

/* ZONAS_RECINTOS (COD_RECINTO, ZONA, CAPACIDAD) */
CREATE TABLE ZONAS_RECINTOS(
  cod_recinto INT,
  zona ENUM("Z1", "Z2", "Z3") DEFAULT "Z1",
  capacidad INT,

  PRIMARY KEY (cod_recinto, zona),

  CONSTRAINT fk_ZON_REC_cod_recinto
    FOREIGN KEY (cod_recinto) REFERENCES RECINTOS(cod_recinto)
    ON UPDATE CASCADE ON DELETE CASCADE,
    
  CONSTRAINT ck_capacidad
    CHECK (capacidad BETWEEN 0 and 500),
  CONSTRAINT ck_zona
    CHECK (zona IN ("Z1", "Z2", "Z3"))
);

/* PRECIOS_ESPECTACULOS (COD_ESPECTACULO, COD_RECINTO, ZONA, PRECIO) */
CREATE TABLE PRECIOS_ESPECTACULOS(
  cod_espectaculo VARCHAR(5),
  cod_recinto INT,
  zona VARCHAR(5),
  pvp NUMERIC(5,2),

  PRIMARY KEY (cod_espectaculo, cod_recinto),

  CONSTRAINT fk_PRE_ESP_cod_espectaculo
    FOREIGN KEY (cod_espectaculo) REFERENCES ESPECTACULOS(cod_espectaculo)
    ON UPDATE CASCADE ON DELETE CASCADE,
  CONSTRAINT fk_PRE_REC_cod_recinto
    FOREIGN KEY (cod_recinto) REFERENCES RECINTOS(cod_recinto)
    ON UPDATE CASCADE ON DELETE CASCADE
);