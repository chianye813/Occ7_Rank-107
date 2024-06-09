-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: May 05, 2024 at 04:46 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `assignment2`
--

-- --------------------------------------------------------

--
-- Table structure for table `assignment2`
--

CREATE TABLE `assignment2` (
  `Name` varchar(25) NOT NULL,
  `Age` int(11) NOT NULL,
  `Position` varchar(20) NOT NULL,
  `Salary` double NOT NULL,
  `Height` double NOT NULL,
  `Weight` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `assignment2`
--

INSERT INTO `assignment2` (`Name`, `Age`, `Position`, `Salary`, `Height`, `Weight`) VALUES
('Jarret Allen', 35, 'Center', 500, 1.93, 90),
('Kevin Durant', 35, 'Forward', 2500, 1.93, 90),
('Lebron James', 39, 'Forward', 2500, 2.01, 113),
('Luka Doncic', 21, 'Guard', 3500, 1.98, 103),
('Stephen Curry', 35, 'Guard', 2000, 1.93, 90);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `assignment2`
--
ALTER TABLE `assignment2`
  ADD PRIMARY KEY (`Name`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
