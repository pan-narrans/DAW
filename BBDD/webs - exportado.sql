-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 29-10-2021 a las 12:13:29
-- Versión del servidor: 10.1.35-MariaDB
-- Versión de PHP: 7.2.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `webs`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `blog`
--

CREATE TABLE `blog` (
  `cd_web` int(11) NOT NULL,
  `n_entradas` int(11) NOT NULL DEFAULT '0',
  `n_etiquetas` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `convencional`
--

CREATE TABLE `convencional` (
  `cd_web` int(11) NOT NULL,
  `n_entradas` int(11) NOT NULL DEFAULT '0',
  `publicidad` tinyint(1) NOT NULL DEFAULT '0',
  `marcos` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `crear`
--

CREATE TABLE `crear` (
  `cd_web` int(11) NOT NULL,
  `cd_usuario` varchar(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empresa`
--

CREATE TABLE `empresa` (
  `cd_empresa` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `actividad` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `habla`
--

CREATE TABLE `habla` (
  `cd_web` int(11) NOT NULL,
  `cd_idioma` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `idiomas`
--

CREATE TABLE `idiomas` (
  `cd_idioma` int(11) NOT NULL,
  `descripcion` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `nif` varchar(9) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `fechaNac` date NOT NULL,
  `titulacion` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `web`
--

CREATE TABLE `web` (
  `cd_web` int(11) NOT NULL,
  `url` varchar(60) NOT NULL,
  `titulo` varchar(30) NOT NULL,
  `tematica` varchar(20) NOT NULL,
  `tipo` enum('Wiki','Blog','Convencional') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `wiki`
--

CREATE TABLE `wiki` (
  `cd_web` int(11) NOT NULL,
  `n_entradas` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `blog`
--
ALTER TABLE `blog`
  ADD PRIMARY KEY (`cd_web`);

--
-- Indices de la tabla `convencional`
--
ALTER TABLE `convencional`
  ADD PRIMARY KEY (`cd_web`);

--
-- Indices de la tabla `crear`
--
ALTER TABLE `crear`
  ADD PRIMARY KEY (`cd_web`,`cd_usuario`),
  ADD KEY `fk_CRE_USUARIOS_nif` (`cd_usuario`);

--
-- Indices de la tabla `empresa`
--
ALTER TABLE `empresa`
  ADD PRIMARY KEY (`cd_empresa`),
  ADD UNIQUE KEY `nombre` (`nombre`);

--
-- Indices de la tabla `habla`
--
ALTER TABLE `habla`
  ADD PRIMARY KEY (`cd_web`,`cd_idioma`),
  ADD KEY `fk_HAB_IDIOMAS_cd_web` (`cd_idioma`);

--
-- Indices de la tabla `idiomas`
--
ALTER TABLE `idiomas`
  ADD PRIMARY KEY (`cd_idioma`),
  ADD UNIQUE KEY `descripcion` (`descripcion`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`nif`);

--
-- Indices de la tabla `web`
--
ALTER TABLE `web`
  ADD PRIMARY KEY (`cd_web`),
  ADD UNIQUE KEY `url` (`url`),
  ADD UNIQUE KEY `titulo` (`titulo`);

--
-- Indices de la tabla `wiki`
--
ALTER TABLE `wiki`
  ADD PRIMARY KEY (`cd_web`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `empresa`
--
ALTER TABLE `empresa`
  MODIFY `cd_empresa` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `idiomas`
--
ALTER TABLE `idiomas`
  MODIFY `cd_idioma` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `web`
--
ALTER TABLE `web`
  MODIFY `cd_web` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `blog`
--
ALTER TABLE `blog`
  ADD CONSTRAINT `fk_BLO_WEB_cd_web` FOREIGN KEY (`cd_web`) REFERENCES `web` (`cd_web`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `convencional`
--
ALTER TABLE `convencional`
  ADD CONSTRAINT `fk_CON_WEB_cd_web` FOREIGN KEY (`cd_web`) REFERENCES `web` (`cd_web`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `crear`
--
ALTER TABLE `crear`
  ADD CONSTRAINT `fk_CRE_USUARIOS_nif` FOREIGN KEY (`cd_usuario`) REFERENCES `usuarios` (`nif`),
  ADD CONSTRAINT `fk_CRE_WEB_cd_web` FOREIGN KEY (`cd_web`) REFERENCES `web` (`cd_web`);

--
-- Filtros para la tabla `habla`
--
ALTER TABLE `habla`
  ADD CONSTRAINT `fk_HAB_IDIOMAS_cd_web` FOREIGN KEY (`cd_idioma`) REFERENCES `idiomas` (`cd_idioma`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_HAB_WIKI_cd_web` FOREIGN KEY (`cd_web`) REFERENCES `wiki` (`cd_web`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `wiki`
--
ALTER TABLE `wiki`
  ADD CONSTRAINT `fk_WIK_WEB_cd_web` FOREIGN KEY (`cd_web`) REFERENCES `web` (`cd_web`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
