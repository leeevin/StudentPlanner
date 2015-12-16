#CREATE DATABASE `schedule` /*!40100 DEFAULT CHARACTER SET latin1 */;
#SET SQL_SAFE_UPDATES = 0;

CREATE TABLE `monday` (

  `Time` varchar(200) NOT NULL,
  `Schedule` varchar(200) DEFAULT NULL,
  `Counter` int(11) NOT NULL,
  PRIMARY KEY (`Counter`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO `schedule`.`monday` (`Time`, `Counter`) VALUES ('7:00 AM', '1');
INSERT INTO `schedule`.`monday` (`Time`, `Counter`) VALUES ('7:30 AM', '2');
INSERT INTO `schedule`.`monday` (`Time`, `Counter`) VALUES ('8:00 AM', '3');
INSERT INTO `schedule`.`monday` (`Time`, `Counter`) VALUES ('8:30 AM', '4');
INSERT INTO `schedule`.`monday` (`Time`, `Counter`) VALUES ('9:00 AM', '5');
INSERT INTO `schedule`.`monday` (`Time`, `Counter`) VALUES ('9:30 AM', '6');
INSERT INTO `schedule`.`monday` (`Time`, `Counter`) VALUES ('10:00 AM', '7');
INSERT INTO `schedule`.`monday` (`Time`, `Counter`) VALUES ('10:30 AM', '8');
INSERT INTO `schedule`.`monday` (`Time`, `Counter`) VALUES ('11:00 AM', '9');
INSERT INTO `schedule`.`monday` (`Time`, `Counter`) VALUES ('11:30 PM', '10');
INSERT INTO `schedule`.`monday` (`Time`, `Counter`) VALUES ('12:00 PM', '11');
INSERT INTO `schedule`.`monday` (`Time`, `Counter`) VALUES ('12:30 PM', '12');
INSERT INTO `schedule`.`monday` (`Time`, `Counter`) VALUES ('1:00 PM', '13');
INSERT INTO `schedule`.`monday` (`Time`, `Counter`) VALUES ('1:30 PM', '14');
INSERT INTO `schedule`.`monday` (`Time`, `Counter`) VALUES ('2:00 PM', '15');
INSERT INTO `schedule`.`monday` (`Time`, `Counter`) VALUES ('2:30 PM', '16');
INSERT INTO `schedule`.`monday` (`Time`, `Counter`) VALUES ('3:00 PM', '17');
INSERT INTO `schedule`.`monday` (`Time`, `Counter`) VALUES ('3:30 PM', '18');
INSERT INTO `schedule`.`monday` (`Time`, `Counter`) VALUES ('4:00 PM', '19');
INSERT INTO `schedule`.`monday` (`Time`, `Counter`) VALUES ('4:30 PM', '20');
INSERT INTO `schedule`.`monday` (`Time`, `Counter`) VALUES ('5:00 PM', '21');
INSERT INTO `schedule`.`monday` (`Time`, `Counter`) VALUES ('5:30 PM', '22');
INSERT INTO `schedule`.`monday` (`Time`, `Counter`) VALUES ('6:00 PM', '23');
INSERT INTO `schedule`.`monday` (`Time`, `Counter`) VALUES ('6:30 PM', '24');
INSERT INTO `schedule`.`monday` (`Time`, `Counter`) VALUES ('7:00 PM', '25');
INSERT INTO `schedule`.`monday` (`Time`, `Counter`) VALUES ('7:30 PM', '26');

CREATE TABLE tuesday LIKE monday; 
INSERT tuesday SELECT * FROM monday;

CREATE TABLE wednesday LIKE monday; 
INSERT wednesday SELECT * FROM monday;

CREATE TABLE thursday LIKE monday;
INSERT thursday SELECT * FROM monday;

CREATE TABLE friday LIKE monday; 
INSERT friday SELECT * FROM monday;

CREATE TABLE saturday LIKE monday; 
INSERT saturday SELECT * FROM monday;

CREATE TABLE sunday LIKE monday; 
INSERT sunday SELECT * FROM monday;

UPDATE `schedule`.`monday` SET `Schedule`='Prog Apps Lab S326' WHERE `Counter`='5';
UPDATE `schedule`.`monday` SET `Schedule`='Prog Apps Lab S326' WHERE `Counter`='6';
UPDATE `schedule`.`monday` SET `Schedule`='Prog Apps Lab S326' WHERE `Counter`='7';
UPDATE `schedule`.`monday` SET `Schedule`='Database Lec S425' WHERE `Counter`='8';
UPDATE `schedule`.`monday` SET `Schedule`='Database Lec S425' WHERE `Counter`='9';
UPDATE `schedule`.`monday` SET `Schedule`='Software Engineering S425' WHERE `Counter`='17';
UPDATE `schedule`.`monday` SET `Schedule`='Software Engineering S425' WHERE `Counter`='18';
UPDATE `schedule`.`monday` SET `Schedule`='Statistics S521' WHERE `Counter`='19';
UPDATE `schedule`.`monday` SET `Schedule`='Statistics S521' WHERE `Counter`='20';

UPDATE `schedule`.`tuesday` SET `Schedule`='SIA S426' WHERE `Counter`='15';
UPDATE `schedule`.`tuesday` SET `Schedule`='SIA S426' WHERE `Counter`='16';
UPDATE `schedule`.`tuesday` SET `Schedule`='SPI S425' WHERE `Counter`='19';
UPDATE `schedule`.`tuesday` SET `Schedule`='SPI S425' WHERE `Counter`='20';

UPDATE `schedule`.`wednesday` SET `Schedule`='Software Engineering S425' WHERE `Counter`='17';
UPDATE `schedule`.`wednesday` SET `Schedule`='Software Engineering S425' WHERE `Counter`='18';
UPDATE `schedule`.`wednesday` SET `Schedule`='Statistics S521' WHERE `Counter`='19';
UPDATE `schedule`.`wednesday` SET `Schedule`='Statistics S521' WHERE `Counter`='20';

UPDATE `schedule`.`thursday` SET `Schedule`='Prog Apps Lab S326' WHERE `Counter`='5';
UPDATE `schedule`.`thursday` SET `Schedule`='Prog Apps Lab S326' WHERE `Counter`='6';
UPDATE `schedule`.`thursday` SET `Schedule`='Prog Apps Lab S326' WHERE `Counter`='7';
UPDATE `schedule`.`thursday` SET `Schedule`='Database Lec S425' WHERE `Counter`='8';
UPDATE `schedule`.`thursday` SET `Schedule`='Database Lec S425' WHERE `Counter`='9';
UPDATE `schedule`.`thursday` SET `Schedule`='SIA S426' WHERE `Counter`='15';
UPDATE `schedule`.`thursday` SET `Schedule`='SIA S426' WHERE `Counter`='16';
UPDATE `schedule`.`thursday` SET `Schedule`='SPI S425' WHERE `Counter`='19';
UPDATE `schedule`.`thursday` SET `Schedule`='SPI S425' WHERE `Counter`='20';

UPDATE `schedule`.`friday` SET `Schedule`='Software Engineering S425' WHERE `Counter`='17';
UPDATE `schedule`.`friday` SET `Schedule`='Software Engineering S425' WHERE `Counter`='18';
UPDATE `schedule`.`friday` SET `Schedule`='Statistics S521' WHERE `Counter`='19';
UPDATE `schedule`.`friday` SET `Schedule`='Statistics S521' WHERE `Counter`='20';

UPDATE `schedule`.`saturday` SET `Schedule`='SIA S426' WHERE `Counter`='15';
UPDATE `schedule`.`saturday` SET `Schedule`='SIA S426' WHERE `Counter`='16';
UPDATE `schedule`.`saturday` SET `Schedule`='SPI S425' WHERE `Counter`='19';
UPDATE `schedule`.`saturday` SET `Schedule`='SPI S425' WHERE `Counter`='20';
