-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-03-2021 a las 21:18:36
-- Versión del servidor: 10.4.14-MariaDB
-- Versión de PHP: 7.2.34

DROP DATABASE IF EXISTS libros;
CREATE DATABASE libros CHARACTER SET utf8mb4;
USE libros;


SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `libros`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libro`
--

CREATE TABLE `libro` (
  `libro` int(5) NOT NULL,
  `titulo` varchar(30) NOT NULL,
  `autor` varchar(30) DEFAULT NULL,
  `numpag` int(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `libro`
--

INSERT INTO `libro` (`libro`, `titulo`, `autor`, `numpag`) VALUES
(1, 'La Leccion', 'E.Ionesco', 155),
(2, 'El libro de la reposteria', 'Angela Landa', 166),
(3, 'Hamlet', 'Shakespeare', 150),
(4, 'Discurso del metodo', 'R.Descartes', 182),
(5, 'El libro de arena', 'J.L.Borges', 121),
(6, 'Una dama en apuros', 'VT. Sharpe', 255),
(7, 'La Republica o el Estado', 'Platon', 303),
(8, 'Job', 'J.Roth', 189),
(9, 'El viejo y el mar', 'E.Hemingwey', 154),
(10, 'En las profundidades', 'A.C.Clarke', 196);

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
(1, 2, '2030-04-02', '2031-12-02'),
(1, 7, '2006-05-02', '2031-12-02'),
(3, 2, '2010-05-02', '2031-12-02'),
(4, 1, '2015-03-02', '2019-04-02'),
(4, 7, '2005-04-02', '2020-04-02'),
(4, 7, '2015-03-02', '2018-03-02'),
(4, 8, '2021-04-02', '2031-12-02'),
(5, 2, '2001-05-02', '2031-12-02'),
(5, 3, '2002-02-02', '2015-02-02'),
(5, 3, '2015-01-02', '2019-01-02'),
(5, 3, '2022-01-02', '2031-01-02'),
(8, 3, '2008-05-02', '2031-12-02'),
(8, 8, '2002-05-02', '2031-12-02');

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
