
-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 10, 2017 at 08:30 AM
-- Server version: 10.0.28-MariaDB
-- PHP Version: 5.2.17

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `u329292900_proye`
--

-- --------------------------------------------------------

--
-- Table structure for table `CLIENTE`
--

CREATE TABLE IF NOT EXISTS `CLIENTE` (
  `ID` int(11) NOT NULL,
  `DNI` varchar(9) COLLATE utf8_unicode_ci NOT NULL,
  `NOMBRE` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `APELLIDO` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `FECHA_NACIMIENTO` date NOT NULL,
  `SEXO` int(1) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `VENTA`
--

CREATE TABLE IF NOT EXISTS `VENTA` (
  `ID` int(11) NOT NULL,
  `CODIGO` int(11) NOT NULL,
  `FECHA` date NOT NULL,
  `ID_CLIENTE` int(11) NOT NULL,
  `ID_VIDEOJUEGO` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `VIDEOJUEGO`
--

CREATE TABLE IF NOT EXISTS `VIDEOJUEGO` (
  `ID` int(11) NOT NULL,
  `CODIGO` int(11) NOT NULL,
  `NOMBRE` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `TIPO` int(2) NOT NULL,
  `EDAD_MINIMA` int(3) NOT NULL,
  `PRECIO` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
