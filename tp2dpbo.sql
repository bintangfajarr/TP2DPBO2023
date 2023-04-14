-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 14, 2023 at 06:29 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tp2dpbo`
--

-- --------------------------------------------------------

--
-- Table structure for table `akun`
--

CREATE TABLE `akun` (
  `id` int(11) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `username` varchar(16) NOT NULL,
  `password` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `akun`
--

INSERT INTO `akun` (`id`, `nama`, `username`, `password`) VALUES
(3, 'bintang', 'bintang', 'bintang'),
(6, 'Bintang Fajar', 'btg', 'btg'),
(7, 'bintang', 'bintanga', 'bintang');

-- --------------------------------------------------------

--
-- Table structure for table `creator`
--

CREATE TABLE `creator` (
  `id` int(11) NOT NULL,
  `nama_creator` varchar(50) NOT NULL,
  `logo_creator` varchar(255) NOT NULL,
  `asal_negara` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `creator`
--

INSERT INTO `creator` (`id`, `nama_creator`, `logo_creator`, `asal_negara`) VALUES
(9, 'Bandai Namco', 'BANDAI.png', 'Jepang'),
(13, 'Daban Model', 'daban.png', 'China'),
(14, 'Dragon Momoko', 'dramok.png', 'China');

-- --------------------------------------------------------

--
-- Table structure for table `gundam`
--

CREATE TABLE `gundam` (
  `id` int(11) NOT NULL,
  `nama_gundam` varchar(50) NOT NULL,
  `creator_gundam` int(11) NOT NULL,
  `jenis_gundam` varchar(50) NOT NULL,
  `ukuran_gundam` varchar(50) DEFAULT NULL,
  `gambar_gundam` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `gundam`
--

INSERT INTO `gundam` (`id`, `nama_gundam`, `creator_gundam`, `jenis_gundam`, `ukuran_gundam`, `gambar_gundam`) VALUES
(9, 'Sengoku Astray', 9, 'Master Grade', '1/1001', 'astray.jpg'),
(10, 'Astray Blue Flame', 13, 'Master Grade', '1/100', 'astrayblue.jpg'),
(11, 'Gerbera Tetra', 14, 'High Grade', '1/144', 'gerbera tetra.jpg');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `akun`
--
ALTER TABLE `akun`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `creator`
--
ALTER TABLE `creator`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `gundam`
--
ALTER TABLE `gundam`
  ADD PRIMARY KEY (`id`),
  ADD KEY `gundam_fk` (`creator_gundam`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `akun`
--
ALTER TABLE `akun`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `creator`
--
ALTER TABLE `creator`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `gundam`
--
ALTER TABLE `gundam`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `gundam`
--
ALTER TABLE `gundam`
  ADD CONSTRAINT `gundam_fk` FOREIGN KEY (`creator_gundam`) REFERENCES `creator` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
