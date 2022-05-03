-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 29-04-2022 a las 01:59:56
-- Versión del servidor: 10.4.22-MariaDB
-- Versión de PHP: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `Rutinas`
--


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Competicion`
--

CREATE TABLE `Competicion` (
  `id` int(11) NOT NULL,
  `nombre` varchar(10) NOT NULL,
  `fecha` date NOT NULL,
  `categoria` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `Competicion`
--

INSERT INTO `Competicion` (`id`, `nombre`, `fecha`, `categoria`) VALUES
(1, 'cOMP1', '2022-06-15', 'CADETE'),
(2, 'comp2', '2022-07-21', 'CADETE'),
(3, 'comp3', '2022-04-22', 'CADETE'),
(4, 'comp4', '2022-04-13', 'CADETE'),
(6, 'compt6', '2022-05-27', 'CADETE'),
(7, 'comp7', '2022-06-09', 'ADULTO'),
(9, 'comp9', '2022-05-25', 'ADULTO');

--
-- Disparadores `Competicion`
--


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `CompeticionParticipante`
--

CREATE TABLE `CompeticionParticipante` (
  `idCompeticion` int(11) NOT NULL,
  `idParticipante` int(11) NOT NULL,
  `fecha_inscripcion` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `CompeticionParticipante`
--

INSERT INTO `CompeticionParticipante` (`idCompeticion`, `idParticipante`, `fecha_inscripcion`) VALUES
(1, 1, '2022-04-29'),
(2, 2, '2022-04-29'),
(4, 4, '2022-04-29'),
(6, 1, '2022-04-29'),
(6, 2, '2022-04-29'),
(6, 4, '2022-04-29'),
(6, 5, '2022-04-29'),
(9, 8, '2022-04-29'),
(9, 10, '2022-04-29');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Participante`
--

CREATE TABLE `Participante` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `Participante`
--

INSERT INTO `Participante` (`id`, `nombre`, `fecha`) VALUES
(1, 'p1', '2008-07-09'),
(2, 'p2', '2008-03-09'),
(3, 'p3', '2012-07-09'),
(4, 'P4', '2008-07-09'),
(5, 'p5', '2008-07-09'),
(8, 'p8', '2001-02-12'),
(10, 'p10', '0201-12-13');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `Competicion`
--
ALTER TABLE `Competicion`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `CompeticionParticipante`
--
ALTER TABLE `CompeticionParticipante`
  ADD PRIMARY KEY (`idCompeticion`,`idParticipante`,`fecha_inscripcion`);

--
-- Indices de la tabla `Participante`
--
ALTER TABLE `Participante`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
