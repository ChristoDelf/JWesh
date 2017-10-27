-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Lun 23 Octobre 2017 à 14:10
-- Version du serveur :  5.7.9
-- Version de PHP :  5.6.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `forum`
--

-- --------------------------------------------------------

--
-- Structure de la table `post`
--

DROP TABLE IF EXISTS `post`;
CREATE TABLE IF NOT EXISTS `post` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `text` varchar(2000) NOT NULL,
  `author` int(11) NOT NULL,
  `date` date NOT NULL,
  `topic` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Contenu de la table `post`
--

INSERT INTO `post` (`id`, `text`, `author`, `date`, `topic`) VALUES
(1, 'OK, mais comment on fait ?', 2, '2017-10-16', 3),
(2, 'Facile !', 2, '2017-10-16', 3),
(3, 'Ah bon ? Comprends pas !', 1, '2017-10-16', 3),
(4, 'Je ne sais pas trop', 3, '2017-10-20', 4),
(5, 'Il faut combien d''aiguilles ?', 3, '2017-10-20', 2);

-- --------------------------------------------------------

--
-- Structure de la table `topic`
--

DROP TABLE IF EXISTS `topic`;
CREATE TABLE IF NOT EXISTS `topic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `creator` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Contenu de la table `topic`
--

INSERT INTO `topic` (`id`, `title`, `creator`) VALUES
(1, 'Coudre un passepoil', 1),
(2, 'Tricoter en rond', 2),
(3, 'Placer une tirette', 2),
(4, 'Qu''est-ce qu''un biais ?', 1),
(5, 'Nouvelle en couture. Help !!!!', 3);

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(50) NOT NULL,
  `password` varchar(60) NOT NULL,
  `statut` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Contenu de la table `user`
--

INSERT INTO `user` (`id`, `login`, `password`, `statut`) VALUES
(1, 'admin', '$2a$10$D04uHbbFHWB6L.epWlqe6OzIi215LQSWxQ6iWNAaWFHroHDV/e/Cq', 1),
(3, 'sev', '$2a$10$SDSVM1MuwSl7Ky3F0dJXaO9Le47cW9vEiNACKGhu2XlIICVi2lSnu', 1);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
