-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Mar 07, 2019 at 01:54 PM
-- Server version: 5.7.24-log
-- PHP Version: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `task21`
--

-- --------------------------------------------------------

--
-- Table structure for table `characters`
--

CREATE TABLE `characters` (
  `id` int(11) NOT NULL,
  `name` varchar(22) NOT NULL,
  `level` int(11) NOT NULL,
  `userId` int(30) NOT NULL,
  `classId` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `characters`
--

INSERT INTO `characters` (`id`, `name`, `level`, `userId`, `classId`) VALUES
(1, 'xXSephirothXx', 55, 16, 2),
(2, 'xXKingJengXx', 60, 16, 1),
(3, 'xXChinaTownXx', 69, 17, 4),
(5, 'Karl Franz', 70, 18, 1),
(6, 'Hames Bond', 70, 18, 5),
(7, 'Warlos', 1, 19, 2),
(8, 'Hemlok', 77, 19, 4),
(9, 'Pardoni', 83, 20, 3),
(10, 'xXNagasSadowXx', 44, 20, 5);

-- --------------------------------------------------------

--
-- Table structure for table `class`
--

CREATE TABLE `class` (
  `id` int(11) NOT NULL,
  `name` text NOT NULL,
  `ability1` text NOT NULL,
  `ability2` text NOT NULL,
  `ability3` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `class`
--

INSERT INTO `class` (`id`, `name`, `ability1`, `ability2`, `ability3`) VALUES
(1, 'Paladin', 'Hammer of Justice', 'Flash of Light', 'Redemption'),
(2, 'Druid', 'Dash', 'Travel form', 'Revive'),
(3, 'Warlock', 'Create Healthstone', 'Soul', 'Ritual of Summoning'),
(4, 'White Mage', 'Stone', 'Cure', 'Aero'),
(5, 'Bard', 'Straight Shot', 'Barrage', 'Rain of Death');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(16) NOT NULL,
  `password` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `username`, `password`) VALUES
(16, 'Ralf', 'Fajardo'),
(17, 'Birry', 'Infanteri'),
(18, 'Bartek', 'PolishName'),
(19, 'Quoc', 'Trani'),
(20, 'Michaelus', 'Nostradamus');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `characters`
--
ALTER TABLE `characters`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`),
  ADD KEY `userId` (`userId`),
  ADD KEY `classId` (`classId`),
  ADD KEY `userId_2` (`userId`),
  ADD KEY `classId_2` (`classId`);

--
-- Indexes for table `class`
--
ALTER TABLE `class`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`),
  ADD UNIQUE KEY `password` (`password`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `characters`
--
ALTER TABLE `characters`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `class`
--
ALTER TABLE `class`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `characters`
--
ALTER TABLE `characters`
  ADD CONSTRAINT `characters_ibfk_1` FOREIGN KEY (`classId`) REFERENCES `class` (`id`),
  ADD CONSTRAINT `characters_ibfk_2` FOREIGN KEY (`userId`) REFERENCES `user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
