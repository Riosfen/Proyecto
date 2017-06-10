-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 10-06-2017 a las 01:59:31
-- Versión del servidor: 10.1.21-MariaDB
-- Versión de PHP: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `hibernate`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `ID` int(11) NOT NULL,
  `DNI` varchar(9) NOT NULL,
  `NOMBRE` varchar(50) NOT NULL,
  `APELLIDO` varchar(50) NOT NULL,
  `FECHA_NACIMIENTO` date NOT NULL,
  `TELEFONO` varchar(9) NOT NULL,
  `DIRECCION` varchar(150) NOT NULL,
  `SEXO` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`ID`, `DNI`, `NOMBRE`, `APELLIDO`, `FECHA_NACIMIENTO`, `TELEFONO`, `DIRECCION`, `SEXO`) VALUES
(101, '34144431L', 'Tobias', 'Heath Rodriquez', '1982-11-28', '914840408', '945-7600 Sed Avenida', 0),
(102, '60654937I', 'Norman', 'Kaufman Oneil', '1985-03-08', '957404789', '3762 Dolor C.', 1),
(103, '32674548C', 'Hollee', 'Monroe Sanford', '1965-10-01', '457039511', 'Apartado núm.: 112, 223 Tempus Calle', 0),
(104, '33911543T', 'Xantha', 'Salinas Chan', '1976-07-12', '160050636', 'Apartado núm.: 967, 5639 Non, Av.', 0),
(105, '65239274W', 'Lana', 'Holt Hendrix', '2013-08-28', '223525209', '5354 Montes, Carretera', 2),
(106, '69972384F', 'Jerome', 'Pitts Delaney', '1964-02-19', '187513356', 'Apdo.:181-4137 Nam Avda.', 2),
(107, '98935922N', 'Tanner', 'Foster Newman', '1967-11-28', '211162992', '9407 Auctor ', 0),
(108, '64086278P', 'Xandra', 'Phillips Mclean', '1958-12-05', '311193654', 'Apdo.:907-9797 Integer Avenida', 0),
(109, '76622920W', 'Carly', 'Owen Ramirez', '2013-04-09', '626137830', '4186 Natoque C/', 1),
(110, '59099236Y', 'Nerea', 'Christensen Dunlap', '1971-10-11', '314324600', 'Apdo.:663-7964 Non Avda.', 1),
(111, '76772130M', 'Brenden', 'Rollins Arnold', '2004-03-18', '981030687', '901 Mollis C/', 1),
(112, '44528849N', 'Dacey', 'Wolf Garner', '1963-06-30', '589108536', '631-649 At, Calle', 1),
(113, '95090169Z', 'Kenneth', 'Landry Rowland', '1968-02-28', '378877235', 'Apartado núm.: 605, 3028 A, Ctra.', 0),
(114, '81630302G', 'Wynter', 'Valenzuela Byrd', '1990-07-14', '957359365', 'Apartado núm.: 184, 5231 Vestibulum Avenida', 2),
(115, '63023190K', 'Raja', 'Huber Franks', '1987-06-16', '236801945', '3931 Volutpat Calle', 2),
(116, '54441356N', 'Ivy', 'Sloan Obrien', '1999-04-13', '973225438', 'Apartado núm.: 500, 2875 Ut, Avda.', 0),
(117, '42568695P', 'Allistair', 'Arnold Davidson', '1970-05-07', '615518470', '5615 Nam C/', 2),
(118, '27813646T', 'Lee', 'Kane Sloan', '1950-08-13', '477421615', 'Apdo.:114-7514 Non Avda.', 1),
(119, '43290397H', 'Halee', 'Jensen Underwood', '2003-06-25', '425848855', 'Apdo.:651-9762 Neque C/', 0),
(120, '37141649V', 'Orlando', 'Burris Potter', '1985-01-06', '577851783', 'Apartado núm.: 573, 4837 Facilisis, Avenida', 0),
(121, '54378335Q', 'Nola', 'Horton Reese', '1990-09-11', '960847185', '3567 Nec Carretera', 1),
(122, '67394016Q', 'Dalton', 'Duke Huber', '1997-04-14', '814135098', 'Apartado núm.: 552, 7782 Pede, ', 0),
(123, '73496615Y', 'Jordan', 'Oliver Walsh', '1994-12-15', '526931353', 'Apartado núm.: 273, 2194 Malesuada Carretera', 0),
(124, '17206892B', 'Griffin', 'Conner Norman', '2004-04-10', '298590850', '6433 Nonummy Ctra.', 1),
(125, '73966351E', 'Dean', 'Rojas Watts', '2001-03-25', '894493278', '566-7854 Felis. ', 0),
(126, '61486018X', 'Kelly', 'Salazar Stark', '1985-08-06', '542878730', 'Apartado núm.: 968, 4784 Purus C.', 1),
(127, '76137794R', 'Dominique', 'Collins Mcfarland', '1976-06-21', '698746827', 'Apdo.:832-7373 Donec C/', 0),
(128, '28444264F', 'Steel', 'Chavez Morris', '1987-06-10', '756618226', '3347 Purus Calle', 2),
(129, '30167789L', 'Zia', 'Richmond Norris', '2008-09-29', '556395027', '120-5876 Nec, ', 0),
(130, '49046314I', 'Abigail', 'Peters Henderson', '2013-03-02', '184355775', '4794 Vitae Avda.', 2),
(131, '67128267V', 'Samuel', 'Washington Ellis', '1955-03-16', '118423322', '9637 Tempor Ctra.', 2),
(132, '85795170T', 'Gay', 'French Jones', '2004-02-01', '466359070', 'Apdo.:403-8822 Nec C/', 2),
(133, '15054392D', 'Daryl', 'Curtis Poole', '2001-09-04', '683583380', '342-1853 Viverra. ', 0),
(134, '40245134L', 'Ivana', 'Arnold Salas', '1969-07-23', '840904258', 'Apartado núm.: 164, 5429 In, Ctra.', 0),
(135, '63970326E', 'Zorita', 'White Hammond', '2005-04-16', '237630488', 'Apdo.:870-9212 Magna Calle', 0),
(136, '18888233M', 'Jennifer', 'Erickson Fernandez', '1987-06-28', '657597003', 'Apdo.:922-9770 Velit. Ctra.', 2),
(137, '94721871C', 'Chantale', 'Mcclain Carroll', '1991-02-27', '569966667', 'Apartado núm.: 979, 7130 Commodo Av.', 0),
(138, '54657036F', 'Jonas', 'Mcconnell Villarreal', '2008-11-05', '395307330', '9579 Ut C.', 1),
(139, '51326309P', 'Kellie', 'Decker Powell', '1951-04-26', '130297413', '403-7911 Mi C/', 1),
(140, '20917718P', 'Illana', 'Ramsey Patrick', '1986-10-24', '664300546', '9645 In, Calle', 0),
(141, '29010200R', 'Ima', 'Robbins Foreman', '2012-09-23', '865209295', '3433 Libero Av.', 2),
(142, '60551611M', 'Bert', 'Riggs Woods', '1962-11-29', '669263084', 'Apdo.:186-4418 Ultrices. Ctra.', 0),
(143, '11954638B', 'Heather', 'Todd Hooper', '1980-02-13', '858002781', '8155 Pede, Av.', 0),
(144, '26298541Q', 'Matthew', 'Roth Hickman', '2012-12-15', '828955727', 'Apartado núm.: 861, 9200 Pede, Calle', 2),
(145, '92711905S', 'Stephen', 'Greene Patton', '1973-03-22', '115513790', 'Apdo.:939-9131 Leo. Av.', 1),
(146, '39443332M', 'Lareina', 'Boyer Irwin', '1952-02-19', '319980101', 'Apartado núm.: 291, 1725 Lacinia ', 2),
(147, '74319310Z', 'Rae', 'Matthews Bass', '1983-06-05', '138389524', '6860 Lorem Carretera', 2),
(148, '79549703V', 'Kelsie', 'Cervantes Mendez', '2003-07-21', '136430162', 'Apdo.:976-683 Vitae Carretera', 0),
(149, '87121317V', 'Calvin', 'Snow Duncan', '1973-09-22', '126633609', 'Apdo.:459-9110 Proin C.', 2),
(150, '18075617D', 'Lila', 'Coleman Fisher', '1953-08-02', '823802148', '3723 Cum C/', 2),
(151, '81844709L', 'Vladimir', 'Hewitt Barber', '1991-11-11', '363411445', 'Apdo.:549-6602 Magna. Avenida', 0),
(152, '73349079J', 'Shelly', 'Norris Franks', '1998-03-29', '386871974', 'Apdo.:849-1626 Curabitur Carretera', 0),
(153, '31757751B', 'Keane', 'Fulton Foley', '2010-05-07', '555367248', '312-4054 Amet C/', 2),
(154, '73337738S', 'Oprah', 'Pratt Carroll', '2006-08-18', '589322808', '629-9218 Ornare. Calle', 1),
(155, '61748211C', 'Jana', 'Hubbard Lambert', '1960-02-04', '559740488', '167-9065 Nunc Ctra.', 1),
(156, '21491986O', 'Vaughan', 'Graham Horton', '1967-05-22', '890899615', 'Apartado núm.: 701, 9929 Ipsum Av.', 1),
(157, '54202860X', 'Malik', 'Sims Mayer', '1982-05-02', '444038484', 'Apartado núm.: 862, 3847 Ipsum. Avda.', 2),
(158, '95366407K', 'Channing', 'Pacheco Anthony', '1991-03-10', '345505867', '8179 A Avenida', 1),
(159, '98541352C', 'Hamilton', 'Ware Pittman', '2014-07-16', '147042559', 'Apartado núm.: 772, 9838 Lectus Calle', 0),
(160, '56991157D', 'Zachary', 'Martinez Byrd', '2004-07-20', '595003344', '979-4501 Feugiat. Ctra.', 1),
(161, '50936820V', 'Victoria', 'Alford Pacheco', '1999-05-10', '580577279', '1813 Tellus Ctra.', 2),
(162, '77811066M', 'Madeson', 'Downs Hahn', '1969-07-13', '572610987', 'Apdo.:461-3843 Habitant Avenida', 2),
(163, '54270537O', 'Timothy', 'Jennings Gentry', '2006-07-17', '485928092', 'Apartado núm.: 852, 4771 Curabitur C/', 0),
(164, '26403401Y', 'Jaquelyn', 'Marks Cantrell', '1969-12-19', '806273945', '6796 Est C.', 1),
(165, '31464800H', 'Callie', 'Carrillo Nguyen', '1998-10-03', '137931837', '843-9783 Ac, Avda.', 1),
(166, '53145291W', 'Marah', 'Taylor Burt', '1951-12-12', '226717015', 'Apartado núm.: 425, 5228 Nunc C.', 2),
(167, '68819594O', 'Brenna', 'Oneil Cervantes', '2011-08-14', '823775805', 'Apartado núm.: 295, 9573 Aliquam C/', 0),
(168, '16423538C', 'Nerea', 'Oneil Aguirre', '1968-06-27', '639197387', '7328 Aliquam ', 1),
(169, '75446661L', 'Isaiah', 'Aguirre Rodriquez', '2007-02-09', '834930411', '7445 Curabitur Av.', 2),
(170, '88763155W', 'Irma', 'Henson Nash', '1961-02-20', '897599195', '6345 Adipiscing. Avda.', 0),
(171, '81930821E', 'Kiayada', 'Vargas Hartman', '1982-12-13', '972091808', 'Apartado núm.: 206, 8587 Ipsum Avda.', 2),
(172, '76365523E', 'Bert', 'Franklin Wong', '1966-03-05', '683756270', 'Apartado núm.: 330, 2960 Velit Carretera', 1),
(173, '96844565H', 'Willow', 'Fowler Bush', '1957-10-22', '313554898', '598-6273 Nisi C/', 0),
(174, '34931322T', 'Kirsten', 'Nichols Roberson', '1958-02-04', '990270193', 'Apartado núm.: 768, 8502 Faucibus. Av.', 2),
(175, '39997013Z', 'Kyla', 'Fuentes Pennington', '1993-07-31', '316874518', 'Apartado núm.: 632, 2305 Facilisis C.', 1),
(176, '91312591C', 'Clayton', 'Jacobs Gordon', '2006-04-11', '598326830', 'Apartado núm.: 507, 3503 Tincidunt, Calle', 1),
(177, '62992322N', 'Jolene', 'Bowen Delaney', '1973-07-16', '370477731', 'Apdo.:929-1689 Augue C.', 2),
(178, '52597170G', 'Olivia', 'Montgomery Lynch', '1950-08-14', '958597008', '566-7935 Donec ', 1),
(179, '15641153U', 'Nasim', 'Jacobs Massey', '1961-09-10', '238184159', '398-491 Lobortis Ctra.', 2),
(180, '16528661V', 'Ezekiel', 'Moore Mccall', '1989-01-13', '908988136', '682-1618 Fringilla Ctra.', 2),
(181, '78677792K', 'Clarke', 'Morse Wheeler', '1973-09-15', '559015152', '5179 Molestie Calle', 2),
(182, '96539112A', 'Quynn', 'Mullen Patrick', '2013-01-22', '672949137', 'Apdo.:903-3729 Lectus Calle', 1),
(183, '88249592G', 'Kirsten', 'Hicks Nichols', '1994-11-27', '974520413', '5730 Velit Carretera', 1),
(184, '36587753O', 'Evelyn', 'Lindsey Johnston', '1952-03-17', '449621868', 'Apartado núm.: 229, 4573 Neque. C.', 0),
(185, '82383676H', 'Tamekah', 'Hammond Lewis', '1997-11-03', '666694155', 'Apdo.:180-6809 At ', 0),
(186, '38320848T', 'Alika', 'Woodward Mcneil', '1966-05-13', '299930147', '2226 Eget ', 0),
(187, '80894578Y', 'Abel', 'Brady Noel', '2008-03-08', '256827871', 'Apartado núm.: 810, 8592 Nonummy. C.', 1),
(188, '21000234J', 'Salvador', 'Jacobson Small', '1990-12-14', '785816876', 'Apartado núm.: 293, 4222 Adipiscing Carretera', 1),
(189, '51327074I', 'Teagan', 'Kirk Gibson', '1962-02-10', '428286609', 'Apdo.:276-5049 Lorem Ctra.', 0),
(190, '25836679L', 'Otto', 'Cooke Hogan', '1953-08-26', '777174966', '2107 In Avda.', 2),
(191, '63508463P', 'Nyssa', 'Cantrell Stout', '1980-08-21', '753186706', '7837 Cursus Calle', 2),
(192, '98904703Z', 'Isadora', 'Parker Williamson', '1961-10-31', '294261954', '2777 Feugiat Avda.', 2),
(193, '99297175Z', 'Lucas', 'Atkins Battle', '1994-10-08', '579623930', '520-1195 Enim. C/', 2),
(194, '38346956L', 'Carly', 'Salinas Holden', '1958-04-12', '962286781', '2097 Turpis C.', 2),
(195, '90299983F', 'Jescie', 'Wells Walters', '1989-05-05', '169597625', '7180 Convallis Av.', 1),
(196, '59893846G', 'Madonna', 'Ramsey Shepard', '1953-08-18', '104282644', '4785 Dolor Avenida', 0),
(197, '51795276X', 'Madonna', 'Serrano Cobb', '2016-02-21', '529582712', '9742 Aliquet Ctra.', 1),
(198, '17076436F', 'Karen', 'Roman Pitts', '1996-03-22', '903653252', '856-5596 Egestas Calle', 2),
(199, '44967958Q', 'Xanthus', 'Roth Bartlett', '2002-12-03', '715403923', '720-6490 Mauris C/', 0),
(200, '80256518K', 'Ifeoma', 'Holden Garcia', '1972-02-14', '347506747', '2011 Cursus ', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `juego`
--

CREATE TABLE `juego` (
  `ID` int(11) NOT NULL,
  `NOMBRE` varchar(150) NOT NULL,
  `EDAD_MINIMA` int(2) NOT NULL,
  `PRECIO` decimal(10,2) NOT NULL,
  `TIPOJUEGO` int(4) NOT NULL,
  `STOCK` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `juego`
--

INSERT INTO `juego` (`ID`, `NOMBRE`, `EDAD_MINIMA`, `PRECIO`, `TIPOJUEGO`, `STOCK`) VALUES
(9, 'Supernova', 0, '17.03', 6, 49),
(10, 'Gears of War 4', 18, '27.37', 9, 37),
(11, 'BattleBorn', 18, '73.09', 1, 22),
(12, 'Budget Cuts', 16, '64.84', 12, 25),
(13, 'End of Nations', 7, '19.79', 10, 29),
(14, 'MechWarrior Online', 7, '1.23', 6, 48),
(15, 'Watch Dogs 2', 0, '42.02', 10, 5),
(16, 'Battlefield 3', 18, '15.60', 10, 33),
(17, 'The Unspoken', 16, '97.56', 7, 36),
(18, 'Metal Gear Rising: Revengeance', 18, '30.82', 7, 25),
(19, 'Darksiders 2', 7, '86.71', 8, 28),
(20, 'ADR1FT', 16, '42.34', 0, 22),
(21, 'Shadow Warrior 2', 7, '89.24', 11, 9),
(22, 'Wolfenstein: The New Order', 7, '96.69', 9, 1),
(23, 'Daylight', 0, '63.97', 9, 18),
(24, 'AirMech', 16, '89.41', 7, 2),
(25, 'EVE: Valkyrie', 0, '90.85', 1, 42),
(26, 'Anomaly 2', 16, '59.50', 0, 36),
(27, 'Batman: Arkham City', 0, '25.75', 11, 29),
(28, 'XCOM Enemy Unknown', 7, '77.12', 10, 49),
(29, 'Kingdoms of Amalur: Reckoning', 18, '67.32', 7, 9),
(30, 'World of Warcraft: Legion', 16, '29.16', 2, 5),
(31, 'Planetside 2', 18, '67.47', 5, 9),
(32, 'Brawlhalla', 16, '60.43', 8, 12),
(33, 'Guild Wars 2', 18, '89.79', 7, 9),
(34, 'Planetside 2', 7, '67.06', 4, 49),
(35, 'Marvel Heroes', 16, '1.08', 7, 16),
(36, 'Mad Max', 18, '9.46', 11, 35),
(37, 'Titanfall 2', 0, '63.57', 12, 42),
(38, 'Oceanhorn: Monster of Uncharted Seas', 7, '26.33', 2, 15),
(39, 'Heroes of Newerth', 0, '3.92', 7, 29),
(40, 'AION', 0, '99.06', 1, 29),
(41, 'Watch Dogs 2', 16, '17.08', 10, 15),
(42, 'Elder Scrolls Online', 18, '21.83', 0, 35),
(43, 'Lords of the Fallen', 16, '51.85', 6, 8),
(44, 'Crysis 2', 0, '14.49', 6, 21),
(45, 'Arizona Sunshine', 7, '35.55', 3, 24),
(46, 'Max Payne 3', 16, '6.78', 5, 13),
(47, 'Batman: Arkham City', 18, '38.13', 2, 41),
(48, ' Resident Evil 6', 7, '39.95', 9, 8),
(49, 'Max Payne 3', 7, '1.75', 6, 8),
(50, 'Borderlands: The Pre-Sequel!', 18, '89.45', 6, 41),
(51, 'Dirty Bomb', 0, '90.10', 0, 23),
(52, 'Tom Clancy\'s Splinter Cell® Blacklist', 16, '88.63', 5, 0),
(53, 'Tom Clancy\'s Splinter Cell® Blacklist', 16, '27.94', 3, 40),
(54, 'AirMech', 0, '71.87', 10, 30),
(55, 'The Witness', 0, '45.81', 8, 24),
(56, 'Remember Me', 16, '75.73', 7, 35),
(57, 'Battlefield 3', 16, '27.07', 8, 28),
(58, 'Tom Clancy\'s Rainbow Six Siege', 16, '32.20', 7, 13),
(59, 'Assassin’s Creed Unity', 16, '88.38', 1, 33),
(60, 'The Secret World', 7, '57.98', 11, 4),
(61, 'Oceanhorn: Monster of Uncharted Seas', 0, '56.04', 12, 50),
(62, 'Mass Effect 3', 16, '43.30', 11, 37),
(63, 'Tom Clancy\'s Splinter Cell® Blacklist', 7, '20.94', 4, 7),
(64, 'The Assembly', 16, '20.56', 2, 44),
(65, 'The Unspoken', 16, '94.90', 3, 39),
(66, 'Blacklight: Retribution', 16, '30.68', 12, 7),
(67, 'Warhammer 40,000: Eternal Crusade', 16, '37.42', 12, 22),
(68, 'Mirror’s Edge Catalyst', 7, '87.89', 7, 48),
(69, 'Everest VR', 16, '92.37', 12, 19),
(70, 'Borderlands: The Pre-Sequel!', 7, '74.85', 2, 21),
(71, 'Tom Clancy’s The Division', 7, '54.63', 12, 14),
(72, 'Dead by Daylight', 18, '78.42', 2, 48),
(73, 'Torchlight 2', 7, '13.88', 5, 16),
(74, 'Umbrella Corps', 7, '44.98', 11, 8),
(75, 'Street Fighter IV: Arcade Edition', 0, '12.12', 5, 27),
(76, 'Serious Sam 3: BFE', 18, '15.63', 3, 18),
(77, 'Batman: Arkham City', 0, '87.67', 2, 40),
(78, 'Street Fighter V', 7, '45.13', 1, 44),
(79, ' Resident Evil 6', 18, '25.94', 11, 44),
(80, 'The Secret World', 18, '16.19', 8, 26),
(81, 'Remember Me', 7, '43.40', 4, 3),
(82, 'Tom Clancy\'s Splinter Cell® Blacklist', 0, '97.96', 2, 36),
(83, 'Thunderbird: The Legend Begins', 16, '86.09', 9, 6),
(84, 'Shadow Warrior 2', 18, '3.20', 2, 50),
(85, 'Call of Duty: Black Ops 2', 18, '58.96', 4, 33),
(86, 'Edge of Nowhere', 16, '69.87', 8, 21),
(87, 'Anomaly 2', 0, '57.52', 9, 47),
(88, 'Heroes and Generals', 7, '83.84', 0, 9),
(89, 'Homeworld: Remastered', 7, '79.52', 6, 48),
(90, 'War Thunder', 7, '86.35', 5, 34),
(91, 'Warface', 16, '26.52', 9, 42),
(92, 'KILLING FLOOR 2', 0, '59.16', 8, 29),
(93, 'The Crew', 16, '42.42', 7, 6),
(94, 'Gas Guzzlers: Combat Carnage', 7, '44.84', 10, 47),
(95, 'Borderlands 2', 16, '14.09', 10, 12),
(96, 'Red Bull Air Race – The Game ', 16, '82.26', 4, 21),
(97, 'XCOM: Enemy Within', 7, '45.14', 12, 7),
(98, 'Titanfall 2', 16, '5.89', 7, 24),
(99, 'Gas Guzzlers: Combat Carnage', 18, '56.23', 12, 50),
(100, 'AirMech', 0, '76.23', 10, 25),
(101, 'World of Tanks', 18, '93.14', 1, 15),
(102, 'The Bureau: XCOM Declassified', 0, '27.38', 1, 39),
(103, 'YAIBA: NINJA GAIDEN Z', 16, '47.35', 0, 21),
(104, 'Mad Max', 7, '27.61', 5, 28),
(105, 'Budget Cuts', 18, '71.83', 0, 22),
(106, 'Section 8 Prejudice', 16, '82.54', 8, 45),
(107, 'Aliens: Colonial Marines', 0, '80.11', 11, 28),
(108, 'Dark Souls II', 0, '50.53', 3, 20);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `linea_venta`
--

CREATE TABLE `linea_venta` (
  `ID` int(11) NOT NULL,
  `ID_JUEGO` int(11) NOT NULL,
  `ID_VENTA` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--

CREATE TABLE `venta` (
  `ID` int(11) NOT NULL,
  `FECHA` date NOT NULL,
  `ID_CLIENTE` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `juego`
--
ALTER TABLE `juego`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `linea_venta`
--
ALTER TABLE `linea_venta`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `venta`
--
ALTER TABLE `venta`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=201;
--
-- AUTO_INCREMENT de la tabla `juego`
--
ALTER TABLE `juego`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=109;
--
-- AUTO_INCREMENT de la tabla `venta`
--
ALTER TABLE `venta`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
