CREATE DATABASE `schedule` /*!40100 DEFAULT CHARACTER SET latin1 */;
CREATE TABLE `friday` (
  `Time` varchar(200) NOT NULL,
  `Subject` varchar(200) DEFAULT NULL,
  `Counter` int(11) NOT NULL,
  PRIMARY KEY (`Counter`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `monday` (
  `Time` varchar(200) NOT NULL,
  `Subject` varchar(200) DEFAULT NULL,
  `Counter` int(11) NOT NULL,
  PRIMARY KEY (`Counter`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `thursday` (
  `Time` varchar(200) NOT NULL,
  `Subject` varchar(200) DEFAULT NULL,
  `Counter` int(11) NOT NULL,
  PRIMARY KEY (`Counter`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `sunday` (
  `Time` varchar(200) NOT NULL,
  `Subject` varchar(200) DEFAULT NULL,
  `Counter` int(11) NOT NULL,
  PRIMARY KEY (`Counter`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `saturday` (
  `Time` varchar(200) NOT NULL,
  `Subject` varchar(200) DEFAULT NULL,
  `Counter` int(11) NOT NULL,
  PRIMARY KEY (`Counter`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `tuesday` (
  `Time` varchar(200) NOT NULL,
  `Subject` varchar(200) DEFAULT NULL,
  `Counter` int(11) NOT NULL,
  PRIMARY KEY (`Counter`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `wednesday` (
  `Time` varchar(200) NOT NULL,
  `Subject` varchar(200) DEFAULT NULL,
  `Counter` int(11) NOT NULL,
  PRIMARY KEY (`Counter`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
