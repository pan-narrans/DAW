-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 29-03-2022 a las 22:56:38
-- Versión del servidor: 10.4.22-MariaDB
-- Versión de PHP: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


DROP DATABASE IF EXISTS libros_soluciones;
CREATE DATABASE libros_soluciones CHARACTER SET utf8mb4;
USE libros_soluciones;


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `Libros`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `renovar` (IN `soc` INT, IN `lib` INT)  BEGIN
DECLARE SW INT DEFAULT 0;

SELECT COUNT(*) into SW
FROM prestamo PR
WHERE PR.socio=soc
AND PR.libro=lib
AND PR.fdevolucion>=NOW();

IF SW<>1 THEN
	SELECT "Prestamo no activo o error BBDD";
 ELSE
    UPDATE prestamo SET fdevolucion=fechaDevolucion(NOW())
    WHERE socio=soc
	AND libro=lib
	AND fdevolucion>=NOW();
    SELECT CONCAT_WS("","RENOVACION DEL LIBRO", lib, "RENOVADO POR EL USUARIO", soc, "HASTA LA FECHA", fechaDevolucion(NOW()));
END IF;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updateTiempoLectura` ()  BEGIN
UPDATE libro SET tiempoLectura = tiempoLectura(libro.numpag);
END$$

--
-- Funciones
--
CREATE DEFINER=`root`@`localhost` FUNCTION `fechaDevolucion` (`fecha` DATE) RETURNS DATE BEGIN
return DATE_ADD(fecha, INTERVAL 15 day);
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `fechaEntrega` (`fecha` DATE) RETURNS DATE BEGIN
 return DATE_ADD(fecha,INTERVAL 15 DAY);
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `getIdLibro` (`Lib` VARCHAR(30)) RETURNS INT(11) BEGIN
DECLARE aux INTEGER DEFAULT 0;
SELECT L.libro INTO aux FROM libro L 
WHERE UPPER(L.titulo) like UPPER(lib);
IF ISNULL(aux)THEN
	SET aux=0;
END IF;
return aux;
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `getNumDisponible` (`lib` VARCHAR(30)) RETURNS INT(11) BEGIN
return (SELECT E.disponible
FROM ejemplares E 
WHERE E.libro=getIdLibro(lib));
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `getNumPrestamos` (`soc` INT) RETURNS INT(11) BEGIN

RETURN(SELECT COUNT(*) FROM prestamo PR 
WHERE PR.socio=soc 
AND PR.fdevolucion>NOW());
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `posiblePrestamo` (`soc` INT, `lib` VARCHAR(30)) RETURNS TINYINT(1) BEGIN
DECLARE SW BOOLEAN DEFAULT FALSE;
DECLARE C INTEGER DEFAULT 0;

SELECT COUNT(*) INTO C
FROM prestamo 
WHERE prestamo.socio = soc
AND getIdLibro(lib)=prestamo.libro
AND prestamo.fdevolucion>NOW();

IF getNumDisponible(lib)>0 AND getNumPrestamos(soc)<3 AND C=0 THEN
   SET SW=TRUE;
END IF;

RETURN SW;
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `tiempoLectura` (`numPag` INT) RETURNS DECIMAL(5,2) BEGIN
DECLARE coc, rest INT;
DECLARE pagH INT DEFAULT 50;
DECLARE inc INT DEFAULT 5;
DECLARE tiempo FLOAT DEFAULT 0;
DECLARE ac INT DEFAULT 0;

WHILE numPag>=pagH DO
   SET tiempo=tiempo+1;
   SET numPag=numPag-pagH+inc;
   SET ac=ac+inc;
   SET inc=inc+1;
   
   
END WHILE;
RETURN tiempo + numPag/(pagH+ac);
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ejemplares`
--

CREATE TABLE `ejemplares` (
  `libro` int(11) NOT NULL,
  `reservado` int(11) NOT NULL,
  `disponible` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `ejemplares`
--

INSERT INTO `ejemplares` (`libro`, `reservado`, `disponible`) VALUES
(1, 0, 3),
(2, 1, 0),
(3, 0, 1),
(4, 0, 2),
(5, 1, 0),
(6, 0, 3),
(7, 0, 1),
(8, 2, 0),
(9, 1, 0),
(10, 0, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libro`
--

CREATE TABLE `libro` (
  `libro` int(5) NOT NULL,
  `titulo` varchar(30) NOT NULL,
  `autor` varchar(30) DEFAULT NULL,
  `numpag` int(4) DEFAULT NULL,
  `tiempoLectura` decimal(5,2) DEFAULT 0.00,
  `numEjemplares` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `libro`
--

INSERT INTO `libro` (`libro`, `titulo`, `autor`, `numpag`, `tiempoLectura`, `numEjemplares`) VALUES
(1, 'La Leccion', 'E.Ionesco', 155, '3.34', 3),
(2, 'El libro de la reposteria', 'Angela Landa', 166, '3.50', 1),
(3, 'Hamlet', 'Shakespeare', 150, '3.26', 1),
(4, 'Discurso del metodo', 'R.Descartes', 182, '4.11', 2),
(5, 'El libro de arena', 'J.L.Borges', 121, '2.52', 1),
(6, 'Una dama en apuros', 'VT. Sharpe', 255, '5.47', 3),
(7, 'La Republica o el Estado', 'Platon', 303, '6.51', 1),
(8, 'Job', 'J.Roth', 189, '4.20', 2),
(9, 'El viejo y el mar', 'E.Hemingwey', 154, '3.32', 1),
(10, 'En las profundidades', 'A.C.Clarke', 196, '4.29', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prestamo`
--

CREATE TABLE `prestamo` (
  `libro` int(5) NOT NULL,
  `socio` int(5) NOT NULL,
  `fprestamo` date NOT NULL,
  `fdevolucion` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `prestamo`
--

INSERT INTO `prestamo` (`libro`, `socio`, `fprestamo`, `fdevolucion`) VALUES
(1, 2, '2021-04-02', '2021-04-07'),
(1, 7, '2022-01-02', '2022-01-17'),
(2, 3, '2022-03-02', '2022-03-12'),
(2, 5, '2022-03-23', '2022-04-07'),
(3, 2, '2022-02-02', '2022-02-17'),
(4, 1, '2021-03-22', '2021-04-02'),
(4, 6, '2022-03-21', '2022-03-29'),
(4, 7, '2021-03-02', '2021-01-15'),
(4, 8, '2022-03-02', '2022-03-12'),
(5, 2, '2022-03-21', '2022-04-05'),
(5, 3, '2022-01-02', '2022-01-17'),
(6, 2, '2022-01-14', '2022-01-23'),
(7, 3, '2002-01-12', '2022-01-17'),
(8, 3, '2022-03-22', '2022-04-02'),
(8, 8, '2002-05-02', '2022-04-07'),
(9, 1, '2022-03-21', '2022-04-05');

--
-- Disparadores `prestamo`
--
DELIMITER $$
CREATE TRIGGER `nuevoPrestamo` BEFORE INSERT ON `prestamo` FOR EACH ROW BEGIN


SET NEW.fdevolucion=DATE_FORMAT(fechaEntrega(NOW()),'%y-%m-%d');

END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `socio`
--

CREATE TABLE `socio` (
  `socio` int(5) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `telefono` varchar(10) DEFAULT NULL,
  `falta` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `socio`
--

INSERT INTO `socio` (`socio`, `nombre`, `telefono`, `falta`) VALUES
(1, 'Juan Perez Lozano', '617315863', '0000-00-00'),
(2, 'Luis Romero Sanchez', '959253987', '0000-00-00'),
(3, 'Pedro Lopez Rojas', '954553153', '2010-05-01'),
(4, 'Santiago Gonzalez Lleida', '954435993', '0000-00-00'),
(5, 'Fernando Domingo Gomez', '955634281', '2028-01-02'),
(6, 'Luis Daza Zamora', '954435113', '0000-00-00'),
(7, 'Antonio Ossorio Melgar', '609257167', '2017-07-01'),
(8, 'Javier Romero Gonzalez', '617583100', '2005-05-05');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `ejemplares`
--
ALTER TABLE `ejemplares`
  ADD PRIMARY KEY (`libro`);

--
-- Indices de la tabla `libro`
--
ALTER TABLE `libro`
  ADD PRIMARY KEY (`libro`);

--
-- Indices de la tabla `prestamo`
--
ALTER TABLE `prestamo`
  ADD PRIMARY KEY (`libro`,`socio`,`fprestamo`),
  ADD KEY `socio` (`socio`);

--
-- Indices de la tabla `socio`
--
ALTER TABLE `socio`
  ADD PRIMARY KEY (`socio`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `prestamo`
--
ALTER TABLE `prestamo`
  ADD CONSTRAINT `prestamo_ibfk_1` FOREIGN KEY (`libro`) REFERENCES `libro` (`libro`),
  ADD CONSTRAINT `prestamo_ibfk_2` FOREIGN KEY (`socio`) REFERENCES `socio` (`socio`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
