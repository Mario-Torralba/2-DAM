-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-10-2023 a las 21:26:49
-- Versión del servidor: 10.4.14-MariaDB
-- Versión de PHP: 7.4.10

SET FOREIGN_KEY_CHECKS=0;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

CREATE DATABASE IF NOT EXISTS `di23` DEFAULT CHARACTER SET latin1 COLLATE latin1_spanish_ci;
USE `di23`;

CREATE TABLE `USUARIO` (
  `ID_USUARIO` int(11) UNSIGNED NOT NULL,
  `NOMBRE` varchar(40) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `APELLIDO_1` varchar(40) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `APELLIDO_2` varchar(40) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `SEXO` char(1) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL DEFAULT '',
  `FECHA_ALTA` date DEFAULT NULL,
  `MAIL` varchar(100) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL DEFAULT '',
  `MOVIL` varchar(15) NOT NULL DEFAULT '',
  `LOGIN` varchar(40) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `PASS` varchar(32) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `ACTIVO` char(1) NOT NULL DEFAULT 'N'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
 
CREATE TABLE `MENU` (
  `ID_MENU` int(11) UNSIGNED NOT NULL,
  `TITULO` varchar(40) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `ID_PADRE` int(11) UNSIGNED NOT NULL,
  `ACCION` varchar(100) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL,
  `ORDEN` int(11) UNSIGNED NOT NULL,
  `PRIVADO` char(1) NOT NULL DEFAULT 'N'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `PERMISO` (
  `ID_PERMISO` int(11) UNSIGNED NOT NULL,
  `ID_MENU` int(11) UNSIGNED NOT NULL,
  `NOMBRE_PERMISO` varchar(40) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `ROL` (
  `ID_ROL` int(11) UNSIGNED NOT NULL,
  `NOMBRE_ROL` varchar(40) CHARACTER SET latin1 COLLATE latin1_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE PERMISO_USUARIO(
  `ID_PERMISO_USUARIO` int(11) UNSIGNED NOT NULL,
  `ID_PERMISO` int(11) UNSIGNED NOT NULL,
  `ID_USUARIO` int(11) UNSIGNED NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE PERMISO_ROL(
  `ID_PERMISO_ROL` int(11) UNSIGNED NOT NULL,
  `ID_PERMISO` int(11) UNSIGNED NOT NULL,
  `ID_ROL` int(11) UNSIGNED NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE ROL_USUARIO(
  `ID_ROL_USUARIO` int(11) UNSIGNED NOT NULL,
  `ID_ROL` int(11) UNSIGNED NOT NULL,
  `ID_USUARIO` int(11) UNSIGNED NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=latin1;




ALTER TABLE `USUARIO`
  ADD PRIMARY KEY (`ID_USUARIO`),
  ADD UNIQUE KEY `login` (`login`);


ALTER TABLE `USUARIO`
  MODIFY `ID_USUARIO` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=498;


ALTER TABLE `MENU`
  ADD PRIMARY KEY (`ID_MENU`);
  

ALTER TABLE `PERMISO`
  ADD PRIMARY KEY (`ID_PERMISO`),
  ADD CONSTRAINT `FK_PERMISO_MENU` FOREIGN KEY (`ID_MENU`) REFERENCES `MENU` (`ID_MENU`);

ALTER TABLE `ROL`
  ADD PRIMARY KEY (`ID_ROL`);


ALTER TABLE `PERMISO_USUARIO`
  ADD PRIMARY KEY (`ID_PERMISO_USUARIO`),
  ADD CONSTRAINT `FK_PERMISO_USUARIO_PERMISO` FOREIGN KEY (`ID_PERMISO`) REFERENCES `PERMISO` (`ID_PERMISO`),
  ADD CONSTRAINT `FK_PERMISO_USUARIO_USUARIO` FOREIGN KEY (`ID_USUARIO`) REFERENCES `USUARIO` (`ID_USUARIO`);
  

ALTER TABLE `PERMISO_ROL`
  ADD PRIMARY KEY (`ID_PERMISO_ROL`),
  ADD CONSTRAINT `FK_PERMISO_ROL_PERMISO` FOREIGN KEY (`ID_PERMISO`) REFERENCES `PERMISO` (`ID_PERMISO`),
  ADD CONSTRAINT `FK_PERMISO_ROL_ROL` FOREIGN KEY (`ID_ROL`) REFERENCES `ROL` (`ID_ROL`);

ALTER TABLE `ROL_USUARIO`
  ADD PRIMARY KEY (`ID_ROL_USUARIO`),
  ADD CONSTRAINT `FK_ROL_USUARIO_ROL` FOREIGN KEY (`ID_ROL`) REFERENCES `ROL` (`ID_ROL`),
  ADD CONSTRAINT `FK_ROL_USUARIO_USUARIO` FOREIGN KEY (`ID_USUARIO`) REFERENCES `USUARIO` (`ID_USUARIO`);




INSERT INTO `USUARIO` (`ID_USUARIO`, `NOMBRE`, `APELLIDO_1`, `APELLIDO_2`, `SEXO`, `FECHA_ALTA`, `MAIL`, `MOVIL`, `LOGIN`, `PASS`, `ACTIVO`) VALUES
(1, 'mario', 'xxxx', 'xx', 'H', '2020-10-01', 'javier@2si2023.es', '976466599', 'mario', '81dc9bdb52d04dc20036dbd8313ed055', 'S'),
(2, 'admin', 'ad', 'ad', 'H', '2020-10-02', 'admin@2si2023.es', '976466590', 'admin', '21232f297a57a5a743894a0e4a801fc3', 'S'),
(3, 'marie', 'xxxx', 'xx', 'H', '2020-10-01', 'javier@2si2023.es', '976466599', 'marie', '81dc9bdb52d04dc20036dbd8313ed055', 'S'),
(7, 'Maria', 'Fernandez', 'Castro', 'H', '0000-00-00', 'mfernandez@2si2023.es', '2342423', 'safdfa', 'e10adc3949ba59abbe56e057f20f883e', 'S'),
(8, 'Felipe', 'Smit', 'Fernandez', 'H', '2020-11-23', 'fsmit@2si2023.com', '976466599', 'fperez', 'e10adc3949ba59abbe56e057f20f883e', 'S'),
(103, 'Carine ', 'Schmitt', '', 'M', '2020-02-15', 'Schmitt@2si2023.es', '64103103', 'Schmitt', '202cb962ac59075b964b07152d234b70', 'S'),
(112, 'Jean', 'King', '', 'H', '2020-02-15', 'King@2si2023.es', '64112112', 'King', '202cb962ac59075b964b07152d234b70', 'S'),
(114, 'Peter', 'Ferguson', '', 'H', '2020-02-15', 'Ferguson@2si2023.es', '64114114', 'Ferguson', '202cb962ac59075b964b07152d234b70', 'S'),
(119, 'Janine ', 'Labrune', '', 'M', '2020-02-15', 'Labrune@2si2023.es', '64119119', 'Labrune', '202cb962ac59075b964b07152d234b70', 'S'),
(121, 'Jonas ', 'Bergulfsen', '', 'H', '2020-02-15', 'Bergulfsen@2si2023.es', '64121121', 'Bergulfsen', '202cb962ac59075b964b07152d234b70', 'S'),
(124, 'Susan', 'Nelson', '', 'H', '2020-02-15', 'Nelson@2si2023.es', '64124124', 'Nelson', '202cb962ac59075b964b07152d234b70', 'S'),
(125, 'Zbyszek ', 'Piestrzeniewicz', '', 'H', '2020-02-15', 'Piestrzeniewicz@2si2023.es', '64125125', 'Piestrzeniewicz', '202cb962ac59075b964b07152d234b70', 'N'),
(128, 'Roland', 'Keitel', '', 'H', '2020-02-15', 'Keitel@2si2023.es', '64128128', 'Keitel', '202cb962ac59075b964b07152d234b70', 'S'),
(129, 'Julie', 'Murphy', '', 'M', '2020-02-15', 'Murphy@2si2023.es', '64129129', 'Murphy', '202cb962ac59075b964b07152d234b70', 'S'),
(131, 'Kwai', 'Lee', '', 'H', '2020-02-15', 'Lee@2si2023.es', '64131131', 'Lee', '202cb962ac59075b964b07152d234b70', 'N'),
(141, 'Diego ', 'Freyre', '', 'H', '2020-02-15', 'Freyre@2si2023.es', '64141141', 'Freyre', '202cb962ac59075b964b07152d234b70', 'S'),
(144, 'Christina ', 'Berglund', '', 'M', '2020-02-15', 'Berglund@2si2023.es', '64144144', 'Berglund', '202cb962ac59075b964b07152d234b70', 'N'),
(145, 'Jytte ', 'Petersen', '', 'H', '2020-02-15', 'Petersen@2si2023.es', '64145145', 'Petersen', '202cb962ac59075b964b07152d234b70', 'S'),
(146, 'Mary ', 'Saveley', '', 'M', '2020-02-15', 'Saveley@2si2023.es', '64146146', 'Saveley', '202cb962ac59075b964b07152d234b70', 'S'),
(148, 'Eric', 'Natividad', '', 'H', '2020-02-15', 'Natividad@2si2023.es', '64148148', 'Natividad', '202cb962ac59075b964b07152d234b70', 'N'),
(151, 'Jeff', 'Young', '', 'H', '2020-02-15', 'Young@2si2023.es', '64151151', 'Young', '202cb962ac59075b964b07152d234b70', 'S'),
(157, 'Kelvin', 'Leong', '', 'H', '2020-02-15', 'Leong@2si2023.es', '64157157', 'Leong', '202cb962ac59075b964b07152d234b70', 'S'),
(161, 'Juri', 'Hashimoto', '', 'H', '2020-02-15', 'Hashimoto@2si2023.es', '64161161', 'Hashimoto', '202cb962ac59075b964b07152d234b70', 'S'),
(166, 'Wendy', 'Victorino', '', 'M', '2020-02-15', 'Victorino@2si2023.es', '64166166', 'Victorino', '202cb962ac59075b964b07152d234b70', 'S'),
(167, 'Veysel', 'Oeztan', '', 'H', '2020-02-15', 'Oeztan@2si2023.es', '64167167', 'Oeztan', '202cb962ac59075b964b07152d234b70', 'N'),
(168, 'Keith', 'Franco', '', 'H', '2020-02-15', 'Franco@2si2023.es', '64168168', 'Franco', '202cb962ac59075b964b07152d234b70', 'S'),
(169, 'Isabel ', 'de Castro', '', 'M', '2020-02-15', 'de Castro@2si2023.es', '64169169', 'de Castro', '202cb962ac59075b964b07152d234b70', 'S'),
(171, 'Martine ', 'Ranc', '', 'H', '2020-02-15', 'Ranc@2si2023.es', '64171171', 'Ranc', '202cb962ac59075b964b07152d234b70', 'S'),
(172, 'Marie', 'Bertrand', '', 'M', '2020-02-15', 'Bertrand@2si2023.es', '64172172', 'Bertrand', '202cb962ac59075b964b07152d234b70', 'N'),
(173, 'Jerry', 'Tseng', '', 'H', '2020-02-15', 'Tseng@2si2023.es', '64173173', 'Tseng', '202cb962ac59075b964b07152d234b70', 'N'),
(175, 'Julie', 'King2', '', 'M', '2020-02-15', 'King2@2si2023.es', '64175175', 'King2', '202cb962ac59075b964b07152d234b70', 'S'),
(177, 'Mory', 'Kentary', '', 'H', '2020-02-15', 'Kentary@2si2023.es', '64177177', 'Kentary', '202cb962ac59075b964b07152d234b70', 'S'),
(181, 'Michael', 'Frick', '', 'H', '2020-02-15', 'Frick4@2si2023.es', '64181181', 'Frick4', '202cb962ac59075b964b07152d234b70', 'S'),
(186, 'Matti', 'Karttunen', '', 'H', '2020-02-15', 'Karttunen@2si2023.es', '64186186', 'Karttunen', '202cb962ac59075b964b07152d234b70', 'S'),
(187, 'Rachel', 'Ashworth', '', 'M', '2020-02-15', 'Ashworth@2si2023.es', '64187187', 'Ashworth', '202cb962ac59075b964b07152d234b70', 'S'),
(189, 'Dean', 'Cassidy', '', 'H', '2020-02-15', 'Cassidy@2si2023.es', '64189189', 'Cassidy', '202cb962ac59075b964b07152d234b70', 'S'),
(198, 'Leslie', 'Taylor', '', 'M', '2020-02-15', 'Taylor@2si2023.es', '64198198', 'Taylor', '202cb962ac59075b964b07152d234b70', 'S'),
(201, 'Elizabeth', 'Devon', '', 'H', '2020-02-15', 'Devon@2si2023.es', '64201201', 'Devon', '202cb962ac59075b964b07152d234b70', 'S'),
(202, 'Yoshi ', 'Tamuri', '', 'H', '2020-02-15', 'Tamuri@2si2023.es', '64202202', 'Tamuri', '202cb962ac59075b964b07152d234b70', 'S'),
(204, 'Miguel', 'Barajas', '', 'H', '2020-02-15', 'Barajas@2si2023.es', '64204204', 'Barajas', '202cb962ac59075b964b07152d234b70', 'S'),
(205, 'Julie', 'Young', '', 'M', '2020-02-15', 'Young2@2si2023.es', '64205205', 'Young2', '202cb962ac59075b964b07152d234b70', 'S'),
(206, 'Brydey', 'Walker', '', 'H', '2020-02-15', 'Walker@2si2023.es', '64206206', 'Walker', '202cb962ac59075b964b07152d234b70', 'N'),
(209, 'Fréderique ', 'Citeaux', '', 'H', '2020-02-15', 'Citeaux@2si2023.es', '64209209', 'Citeaux', '202cb962ac59075b964b07152d234b70', 'S'),
(211, 'Mike', 'Gao', '', 'H', '2020-02-15', 'Gao@2si2023.es', '64211211', 'Gao', '202cb962ac59075b964b07152d234b70', 'S'),
(216, 'Eduardo ', 'Saavedra', '', 'H', '2020-02-15', 'Saavedra@2si2023.es', '64216216', 'Saavedra', '202cb962ac59075b964b07152d234b70', 'N'),
(219, 'Mary', 'Young', 'y', 'M', '2020-02-15', 'Young3@2si2023.es', '64219219', 'Young3', '202cb962ac59075b964b07152d234b70', 'S'),
(223, 'Horst ', 'Kloss', '', 'H', '2020-02-15', 'Kloss@2si2023.es', '64223223', 'Kloss', '202cb962ac59075b964b07152d234b70', 'N'),
(227, 'Palle', 'Ibsen', '', 'H', '2020-02-15', 'Ibsen@2si2023.es', '64227227', 'Ibsen', '202cb962ac59075b964b07152d234b70', 'S'),
(233, 'Jean ', 'Fresni?re', '', 'H', '2020-02-15', 'Fresni?re@2si2023.es', '64233233', 'Fresni?re', '202cb962ac59075b964b07152d234b70', 'S'),
(237, 'Alejandra ', 'Camino', '', 'M', '2020-02-15', 'Camino@2si2023.es', '64237237', 'Camino', '202cb962ac59075b964b07152d234b70', 'S'),
(239, 'Valarie', 'Thompson', '', 'M', '2020-02-15', 'Thompson2@2si2023.es', '64239239', 'Thompson2', '202cb962ac59075b964b07152d234b70', 'S'),
(240, 'Helen ', 'Bennett', '', 'M', '2020-02-15', 'Bennett@2si2023.es', '64240240', 'Bennett', '202cb962ac59075b964b07152d234b70', 'S'),
(242, 'Annette ', 'Roulet', '', 'M', '2020-02-15', 'Roulet@2si2023.es', '64242242', 'Roulet', '202cb962ac59075b964b07152d234b70', 'S'),
(247, 'Renate ', 'Messner', '', 'H', '2020-02-15', 'Messner@2si2023.es', '64247247', 'Messner', '202cb962ac59075b964b07152d234b70', 'S'),
(249, 'Paolo', 'Accorti', '', 'H', '2020-02-15', 'Accorti@2si2023.es', '64249249', 'accorti', '202cb962ac59075b964b07152d234b70', 'S'),
(250, 'Daniel', 'Da Silva', '', 'H', '2020-02-15', 'Da Silva@2si2023.es', '64250250', 'Da Silva', '202cb962ac59075b964b07152d234b70', 'S'),
(256, 'Daniel ', 'Tonini', '', 'H', '2020-02-15', 'Tonini@2si2023.es', '64256256', 'Tonini', '202cb962ac59075b964b07152d234b70', 'S'),
(259, 'Henriette ', 'Pfalzheim', '', 'H', '2020-02-15', 'Pfalzheim@2si2023.es', '64259259', 'Pfalzheim', '202cb962ac59075b964b07152d234b70', 'S'),
(260, 'Elizabeth ', 'Lincoln', '', 'M', '2020-02-15', 'Lincoln@2si2023.es', '64260260', 'Lincoln', '202cb962ac59075b964b07152d234b70', 'S'),
(273, 'Peter ', 'Franken', '', 'H', '2020-02-15', 'Franken@2si2023.es', '64273273', 'Franken', '202cb962ac59075b964b07152d234b70', 'S'),
(276, 'Anna', 'OHara', '', 'M', '2020-02-15', 'OHara@2si2023.es', '64276276', 'OHara', '202cb962ac59075b964b07152d234b70', 'S'),
(278, 'Giovanni ', 'Rovelli', '', 'H', '2020-02-15', 'Rovelli@2si2023.es', '64278278', 'Rovelli', '202cb962ac59075b964b07152d234b70', 'S'),
(282, 'Adrian', 'Huxley', '', 'H', '2020-02-15', 'Huxley@2si2023.es', '64282282', 'Huxley', '202cb962ac59075b964b07152d234b70', 'S'),
(286, 'Marta', 'Hernandez', '', 'M', '2020-02-15', 'Hernandez3@2si2023.es', '64286286', 'Hernandez3', '202cb962ac59075b964b07152d234b70', 'N'),
(293, 'Ed', 'Harrison', '', 'H', '2020-02-15', 'Harrison@2si2023.es', '64293293', 'Harrison', '202cb962ac59075b964b07152d234b70', 'N'),
(298, 'Mihael', 'Holz', '', 'H', '2020-02-15', 'Holz@2si2023.es', '64298298', 'Holz', '202cb962ac59075b964b07152d234b70', 'S'),
(299, 'Jan', 'Klaeboe', '', 'H', '2020-02-15', 'Klaeboe@2si2023.es', '64299299', 'Klaeboe', '202cb962ac59075b964b07152d234b70', 'S'),
(303, 'Bradley', 'Schuyler', '', 'H', '2020-02-15', 'Schuyler@2si2023.es', '64303303', 'Schuyler', '202cb962ac59075b964b07152d234b70', 'S'),
(307, 'Mel', 'Andersen', '', 'H', '2020-02-15', 'Andersen@2si2023.es', '64307307', 'Andersen', '202cb962ac59075b964b07152d234b70', 'S'),
(311, 'Pirkko', 'Koskitalo', '', 'H', '2020-02-15', 'Koskitalo@2si2023.es', '64311311', 'Koskitalo', '202cb962ac59075b964b07152d234b70', 'S'),
(314, 'Catherine ', 'Dewey', '', 'H', '2020-02-15', 'Dewey@2si2023.es', '64314314', 'Dewey', '202cb962ac59075b964b07152d234b70', 'S'),
(319, 'Steve', 'Frick', '', 'H', '2020-02-15', 'Frick2@2si2023.es', '64319319', 'Frick2', '202cb962ac59075b964b07152d234b70', 'S'),
(320, 'Wing', 'Huang', '', 'H', '2020-02-15', 'Huang@2si2023.es', '64320320', 'Huang', '202cb962ac59075b964b07152d234b70', 'S'),
(321, 'Julie', 'Brown', '', 'M', '2020-02-15', 'Brown@2si2023.es', '64321321', 'Brown', '202cb962ac59075b964b07152d234b70', 'S'),
(323, 'Mike', 'Graham', '', 'H', '2020-02-15', 'Graham@2si2023.es', '64323323', 'Graham', '202cb962ac59075b964b07152d234b70', 'S'),
(324, 'Ann ', 'Brown', '', 'M', '2020-02-15', 'Brown2@2si2023.es', '64324324', 'Brown2', '202cb962ac59075b964b07152d234b70', 'S'),
(328, 'William', 'Brown', '', 'H', '2020-02-15', 'Brown3@2si2023.es', '64328328', 'Brown3', '202cb962ac59075b964b07152d234b70', 'S'),
(333, 'Ben', 'Calaghan', '', 'H', '2020-02-15', 'Calaghan@2si2023.es', '64333333', 'Calaghan', '202cb962ac59075b964b07152d234b70', 'S'),
(334, 'Kalle', 'Suominen', '', 'H', '2020-02-15', 'Suominen@2si2023.es', '64334334', 'Suominen', '202cb962ac59075b964b07152d234b70', 'S'),
(335, 'Philip ', 'Cramer', '', 'H', '2020-02-15', 'Cramer@2si2023.es', '64335335', 'Cramer', '202cb962ac59075b964b07152d234b70', 'S'),
(339, 'Francisca', 'Cervantes', '', 'M', '2020-02-15', 'Cervantes@2si2023.es', '64339339', 'Cervantes', '202cb962ac59075b964b07152d234b70', 'S'),
(344, 'Jesus', 'Fernandez', '', 'H', '2020-02-15', 'Fernandez@2si2023.es', '64344344', 'Fernandez', '202cb962ac59075b964b07152d234b70', 'S'),
(347, 'Brian', 'Chandler', '', 'H', '2020-02-15', 'Chandler@2si2023.es', '64347347', 'Chandler', '202cb962ac59075b964b07152d234b70', 'S'),
(348, 'Patricia ', 'McKenna', '', 'M', '2020-02-15', 'McKenna@2si2023.es', '64348348', 'McKenna', '202cb962ac59075b964b07152d234b70', 'S'),
(350, 'Laurence ', 'Lebihan', '', 'H', '2020-02-15', 'Lebihan@2si2023.es', '64350350', 'Lebihan', '202cb962ac59075b964b07152d234b70', 'N'),
(353, 'Paul ', 'Henriot', '', 'H', '2020-02-15', 'Henriot@2si2023.es', '64353353', 'Henriot', '202cb962ac59075b964b07152d234b70', 'S'),
(356, 'Armand', 'Kuger', '', 'H', '2020-02-15', 'Kuger@2si2023.es', '64356356', 'Kuger', '202cb962ac59075b964b07152d234b70', 'S'),
(357, 'Wales', 'MacKinlay', '', 'H', '2020-02-15', 'MacKinlay@2si2023.es', '64357357', 'MacKinlay', '202cb962ac59075b964b07152d234b70', 'S'),
(361, 'Karin', 'Josephs', '', 'H', '2020-02-15', 'Josephs@2si2023.es', '64361361', 'Josephs', '202cb962ac59075b964b07152d234b70', 'S'),
(362, 'Juri', 'Yoshido', '', 'H', '2020-02-15', 'Yoshido@2si2023.es', '64362362', 'Yoshido', '202cb962ac59075b964b07152d234b70', 'N'),
(363, 'Dorothy', 'Young', '', 'M', '2020-02-15', 'Young4@2si2023.es', '64363363', 'Young4', '202cb962ac59075b964b07152d234b70', 'S'),
(369, 'Lino ', 'Rodriguez', '', 'H', '2020-02-15', 'Rodriguez@2si2023.es', '64369369', 'Rodriguez', '202cb962ac59075b964b07152d234b70', 'S'),
(376, 'Braun', 'Urs', '', 'H', '2020-02-15', 'Urs@2si2023.es', '64376376', 'Urs', '202cb962ac59075b964b07152d234b70', 'S'),
(379, 'Allen', 'Nelson', '', 'H', '2020-02-15', 'Nelson2@2si2023.es', '64379379', 'Nelson2', '202cb962ac59075b964b07152d234b70', 'S'),
(381, 'Pascale ', 'Cartrain', '', 'H', '2020-02-15', 'Cartrain@2si2023.es', '64381381', 'Cartrain', '202cb962ac59075b964b07152d234b70', 'S'),
(382, 'Georg ', 'Pipps', '', 'H', '2020-02-15', 'Pipps@2si2023.es', '64382382', 'Pipps', '202cb962ac59075b964b07152d234b70', 'S'),
(385, 'Arnold', 'Cruz', '', 'H', '2020-02-15', 'Cruz@2si2023.es', '64385385', 'Cruz', '202cb962ac59075b964b07152d234b70', 'S'),
(386, 'Maurizio ', 'Moroni', '', 'H', '2020-02-15', 'Moroni@2si2023.es', '64386386', 'Moroni', '202cb962ac59075b964b07152d234b70', 'S'),
(398, 'Akiko', 'Shimamura', '', 'H', '2020-02-15', 'Shimamura@2si2023.es', '64398398', 'Shimamura', '202cb962ac59075b964b07152d234b70', 'S'),
(406, 'Dominique', 'Perrier', '', 'H', '2020-02-15', 'Perrier@2si2023.es', '64406406', 'Perrier', '202cb962ac59075b964b07152d234b70', 'S'),
(409, 'Rita ', 'MÍller', '', 'M', '2020-02-15', 'M?ller@2si2023.es', '64409409', 'MIller', '202cb962ac59075b964b07152d234b70', 'S'),
(412, 'Sarah', 'McRoy', '', 'M', '2020-02-15', 'McRoy@2si2023.es', '64412412', 'McRoy', '202cb962ac59075b964b07152d234b70', 'S'),
(415, 'Michael', 'Donnermeyer', '', 'H', '2020-02-15', 'Donnermeyer@2si2023.es', '64415415', 'Donnermeyer', '202cb962ac59075b964b07152d234b70', 'S'),
(424, 'Maria', 'Hernandez', '', 'M', '2020-02-15', 'Hernandez2@2si2023.es', '64424424', 'Hernandez2', '202cb962ac59075b964b07152d234b70', 'S'),
(443, 'Alexander ', 'Feuer', '', 'H', '2020-02-15', 'Feuer@2si2023.es', '64443443', 'Feuer', '202cb962ac59075b964b07152d234b70', 'S'),
(447, 'Dan', 'Lewis', '', 'H', '2020-02-15', 'Lewis@2si2023.es', '64447447', 'Lewis', '202cb962ac59075b964b07152d234b70', 'S'),
(448, 'Martha', 'Larsson', '', 'M', '2020-02-15', 'Larsson@2si2023.es', '64448448', 'Larsson', '202cb962ac59075b964b07152d234b70', 'S'),
(450, 'Sue', 'Frick', '', '', '2020-02-15', 'Frick3@2si2023.es', '64450450', 'Frick3', '202cb962ac59075b964b07152d234b70', 'S'),
(452, 'Roland ', 'Mendel', '', 'H', '2020-02-15', 'Mendel@2si2023.es', '64452452', 'Mendel', '202cb962ac59075b964b07152d234b70', 'S'),
(455, 'Leslie', 'Murphy', '', 'M', '2020-02-15', 'Murphy2@2si2023.es', '64455455', 'Murphy2', '202cb962ac59075b964b07152d234b70', 'S'),
(456, 'Yu', 'Choi', '', 'H', '2020-02-15', 'Choi@2si2023.es', '64456456', 'Choi', '202cb962ac59075b964b07152d234b70', 'S'),
(458, 'Martín ', 'Sommer', '', 'H', '2020-02-15', 'Sommer@2si2023.es', '64458458', 'Sommer', '202cb962ac59075b964b07152d234b70', 'S'),
(459, 'Sven ', 'Ottlieb', '', 'H', '2020-02-15', 'Ottlieb@2si2023.es', '64459459', 'Ottlieb', '202cb962ac59075b964b07152d234b70', 'S'),
(462, 'Violeta', 'Benitez', '', 'M', '2020-02-15', 'Benitez@2si2023.es', '64462462', 'Benitez', '202cb962ac59075b964b07152d234b70', 'S'),
(465, 'Carmen', 'Anton', '', 'H', '2020-02-15', 'Anton@2si2023.es', '64465465', 'Anton', '202cb962ac59075b964b07152d234b70', 'S'),
(471, 'Sean', 'Clenahan', '', 'H', '2020-02-15', 'Clenahan@2si2023.es', '64471471', 'Clenahan', '202cb962ac59075b964b07152d234b70', 'S'),
(473, 'Franco', 'Ricotti', '', 'H', '2020-02-15', 'Ricotti@2si2023.es', '64473473', 'Ricotti', '202cb962ac59075b964b07152d234b70', 'S'),
(475, 'Steve', 'Thompson', '', 'H', '2020-02-15', 'Thompson3@2si2023.es', '64475475', 'Thompson3', '202cb962ac59075b964b07152d234b70', 'S'),
(477, 'Hanna ', 'Moos', '', 'M', '2020-02-15', 'Moos@2si2023.es', '64477477', 'Moos', '202cb962ac59075b964b07152d234b70', 'S'),
(480, 'Alexander ', 'Semenov', '', 'H', '2020-02-15', 'Semenov@2si2023.es', '64480480', 'Semenov', '202cb962ac59075b964b07152d234b70', 'S'),
(481, 'Raanan', 'Altagar,G M', '', 'H', '2020-02-15', 'Altagar,G M@2si2023.es', '64481481', 'Altagar,G M', '202cb962ac59075b964b07152d234b70', 'N'),
(484, 'José Pedro ', 'Roel', '', 'H', '2020-02-15', 'Roel@2si2023.es', '64484484', 'Roel', '202cb962ac59075b964b07152d234b70', 'S'),
(486, 'Rosa', 'Salazar', '', 'M', '2020-02-15', 'Salazar@2si2023.es', '64486486', 'Salazar', '202cb962ac59075b964b07152d234b70', 'S'),
(487, 'Sue', 'Taylor', '', 'M', '2020-02-15', 'Taylor2@2si2023.es', '64487487', 'Taylor2', '202cb962ac59075b964b07152d234b70', 'S'),
(489, 'Thomas ', 'Smith', '', 'H', '2020-02-15', 'Smith@2si2023.es', '64489489', 'Smith', '202cb962ac59075b964b07152d234b70', 'S'),
(495, 'Valarie', 'Franco', '', 'M', '2020-02-15', 'Franco2@2si2023.es', '64495495', 'Franco2', '202cb962ac59075b964b07152d234b70', 'S'),
(496, 'Tony', 'Snowden', '', 'H', '2020-02-15', 'Snowden@2si2023.es', '64496496', 'Snowden', '202cb962ac59075b964b07152d234b70', 'N'),
(497, 'ss', 'ss', '', 'H', '2022-12-07', 'asfsdf@sfsd.es', '', 'javier22', '25d55ad283aa400af464c76d713c07ad', 'S');


INSERT INTO `MENU` (`ID_MENU`, `TITULO`, `ID_PADRE`, `ACCION`, `ORDEN`, `PRIVADO`) VALUES
(1, 'Home', 0, 'returnHomePage()', 1, false),
(2, 'Link', 0, '', 2, false),
(3, 'Disabled', 0, '', 3, false),
(4, 'Crud', 0, '', 4, false),
(5, 'Administrador', 0, '', 5, true),
(6, 'Seguridad', 0, '', 6, true),
(7, 'Usuarios', 4, "peticion('Usuarios', 'getVistaUsuarios')", 1, true),
(8, 'Pedidos', 4, "peticion('Pedidos', 'getVistaUsuarios')", 2, true),
(9, 'Something else here', 4, '', 3, true),
(10, 'Mtto. Menú y permisos', 6, "peticion('Seguridad','getVistaSeguridad')", 1, true),
(11, 'Undefined', 6, '', 2, true);


INSERT INTO `PERMISO` (`ID_PERMISO`, `ID_MENU`, `NOMBRE_PERMISO`) VALUES
(1,1,'VerHome'),
(2,2,'VerLink'),
(3,3,'VerDisabled'),
(4,4,'VerCrud'),
(5,5,'VerAdministracion'),
(6,6,'VerSeguridad'),
(7,7,'VerUsuarios'),
(8,8,'VerPedidos'),
(9,9,'VerSomethingElseHere'),
(10,10,'mantenimientoBuscarMenus'),
(11,10,'mantenimientoCrearMenus'),
(12,10,'mantenimientoBorrarMenus'),
(13,10,'mantenimientoEditarMenus'),
(14,11,'verUndefined');


INSERT INTO `ROL` (`ID_ROL`,`NOMBRE_ROL`) VALUES
(1,'Administrador'),
(2,'Visitante');

INSERT INTO `PERMISO_USUARIO` (`ID_PERMISO_USUARIO`, `ID_PERMISO`, `ID_USUARIO`) VALUES

(1,1,1), -- mario
(2,2,1), -- mario
(3,3,1), -- mario
(4,4,1), -- mario
(5,7,1), -- mario
(6,8,1), -- mario
(7,9,1), -- mario

(8,1,2), -- Admin
(9,2,2), -- Admin
(10,3,2), -- Admin
(11,4,2), -- Admin
(12,5,2), -- Admin
(13,6,2), -- Admin
(14,7,2), -- Admin
(15,8,2), -- Admin
(16,9,2), -- Admin
(17,10,2), -- Admin
(18,11,2), -- Admin
(19,12,2), -- Admin
(20,13,2), -- Admin
(21,14,2); -- Admin



INSERT INTO `PERMISO_ROL` (`ID_PERMISO_ROL`, `ID_PERMISO`, `ID_ROL`) VALUES

(1,1,2), -- mario
(2,2,2), -- mario
(3,3,2), -- mario
(4,4,2), -- mario
(5,5,2), -- mario
(6,6,2), -- mario
(7,7,2), -- mario

(8,1,1), -- Admin
(9,2,1), -- Admin
(10,3,1), -- Admin
(11,4,1), -- Admin
(12,5,1), -- Admin
(13,6,1), -- Admin
(14,7,1), -- Admin
(15,8,1), -- Admin
(16,9,1), -- Admin
(17,10,1), -- Admin
(18,11,1), -- Admin
(19,12,1), -- Admin
(20,13,1), -- Admin
(21,14,1); -- Admin

INSERT INTO `ROL_USUARIO` (`ID_ROL_USUARIO`, `ID_ROL`, `ID_USUARIO`) VALUES
(1,1,2),
(2,2,1);


COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;


-- SELECT
--     PU.ID_PERMISO_USUARIO,
--     P.ID_PERMISO,
--     P.NOMBRE_PERMISO,
--     RU.ID_ROL_USUARIO,
--     R.ID_ROL,
--     R.NOMBRE_ROL,
--     M.ID_MENU,
--     M.TITULO,
--     M.ID_PADRE,
--     M.ACCION,
--     M.ORDEN,
--     M.PRIVADO
-- FROM USUARIO U
-- INNER JOIN PERMISO_USUARIO PU ON U.ID_USUARIO = PU.ID_USUARIO
-- INNER JOIN PERMISO P ON PU.ID_PERMISO = P.ID_PERMISO
-- INNER JOIN ROL_USUARIO RU ON U.ID_USUARIO = RU.ID_USUARIO
-- INNER JOIN ROL R ON RU.ID_ROL = R.ID_ROL
-- INNER JOIN MENU M ON P.ID_MENU = M.ID_MENU
-- WHERE U.ID_USUARIO = 2
-- ORDER BY M.ID_PADRE ASC, M.ORDEN ASC;

-- SELECT
--     M.ID_MENU,
--     M.TITULO,
--     M.ID_PADRE,
--     M.ACCION,
--     M.ORDEN,
--     M.PRIVADO,
--     P.ID_PERMISO,
--     P.NOMBRE_PERMISO,
--     PU.ID_PERMISO_USUARIO,
--     R.ID_ROL,
--     R.NOMBRE_ROL,
--     RU.ID_ROL_USUARIO
-- FROM MENU M
-- LEFT JOIN PERMISO P ON M.ID_MENU = P.ID_MENU
-- LEFT JOIN PERMISO_USUARIO PU ON P.ID_PERMISO = PU.ID_PERMISO AND PU.ID_USUARIO = 2
-- LEFT JOIN ROL_USUARIO RU ON RU.ID_USUARIO = 2
-- LEFT JOIN ROL R ON RU.ID_ROL = R.ID_ROL
-- ORDER BY M.ID_PADRE ASC, M.ORDEN ASC;

ALTER TABLE `ROL_USUARIO` DROP FOREIGN KEY `FK_ROL_USUARIO_ROL`;


ALTER TABLE `ROL_USUARIO` DROP FOREIGN KEY `FK_ROL_USUARIO_USUARIO`;


ALTER TABLE `PERMISO_ROL` DROP FOREIGN KEY `FK_PERMISO_ROL_ROL`;


ALTER TABLE `PERMISO_ROL` DROP FOREIGN KEY `FK_PERMISO_ROL_PERMISO`;


ALTER TABLE `PERMISO_USUARIO` DROP FOREIGN KEY `FK_PERMISO_USUARIO_PERMISO`;


ALTER TABLE `PERMISO_USUARIO` DROP FOREIGN KEY `FK_PERMISO_USUARIO_USUARIO`;


ALTER TABLE `PERMISO` DROP FOREIGN KEY `FK_PERMISO_MENU`;


ALTER TABLE `MENU` DROP PRIMARY KEY;


ALTER TABLE `PERMISO` DROP PRIMARY KEY;


ALTER TABLE `ROL` DROP PRIMARY KEY;


ALTER TABLE `PERMISO_USUARIO` DROP PRIMARY KEY;


ALTER TABLE `PERMISO_ROL` DROP PRIMARY KEY;


ALTER TABLE `ROL_USUARIO` DROP PRIMARY KEY;

