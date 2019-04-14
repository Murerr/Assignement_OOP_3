
DROP TABLE IF EXISTS `Classes`;

CREATE TABLE `Classes` (
  `idClasses` int(11) NOT NULL AUTO_INCREMENT,
  `classname` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`idClasses`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `Classes` (`idClasses`, `classname`) VALUES (1, 'qui');
INSERT INTO `Classes` (`idClasses`, `classname`) VALUES (2, 'ullam');
INSERT INTO `Classes` (`idClasses`, `classname`) VALUES (3, 'soluta');
INSERT INTO `Classes` (`idClasses`, `classname`) VALUES (4, 'quis');
INSERT INTO `Classes` (`idClasses`, `classname`) VALUES (5, 'omnis');


DROP TABLE IF EXISTS `Grades`;

CREATE TABLE `Grades` (
  `idGrades` int(11) NOT NULL AUTO_INCREMENT,
  `score` int(11) NOT NULL,
  `fk_idStudent` int(11) NOT NULL,
  `fk_idModule` int(11) NOT NULL,
  PRIMARY KEY (`idGrades`),
  KEY `fk_Module_Student1_idx` (`fk_idStudent`),
  KEY `fk_Module_Module2_idx` (`fk_idModule`),
  CONSTRAINT `fk_Module_Module2` FOREIGN KEY (`fk_idModule`) REFERENCES `Module` (`idModule`) ON DELETE CASCADE,
  CONSTRAINT `fk_Module_Student1` FOREIGN KEY (`fk_idStudent`) REFERENCES `Student` (`idStudent`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (1, 6, 1, 1);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (2, 50, 2, 2);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (3, 4, 3, 3);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (4, 14, 4, 4);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (5, 63, 5, 5);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (6, 45, 6, 6);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (7, 22, 7, 7);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (8, 25, 8, 8);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (9, 93, 9, 9);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (10, 17, 10, 10);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (11, 64, 11, 11);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (12, 72, 12, 12);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (13, 84, 13, 13);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (14, 14, 14, 14);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (15, 10, 15, 15);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (16, 80, 16, 16);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (17, 81, 17, 17);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (18, 66, 18, 18);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (19, 74, 19, 19);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (20, 23, 20, 20);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (21, 33, 1, 21);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (22, 41, 2, 22);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (23, 18, 3, 23);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (24, 60, 4, 24);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (25, 19, 5, 25);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (26, 51, 6, 1);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (27, 8, 7, 2);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (28, 82, 8, 3);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (29, 25, 9, 4);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (30, 17, 10, 5);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (31, 26, 11, 6);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (32, 59, 12, 7);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (33, 35, 13, 8);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (34, 90, 14, 9);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (35, 52, 15, 10);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (36, 4, 16, 11);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (37, 15, 17, 12);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (38, 63, 18, 13);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (39, 67, 19, 14);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (40, 87, 20, 15);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (41, 62, 1, 16);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (42, 1, 2, 17);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (43, 94, 3, 18);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (44, 62, 4, 19);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (45, 13, 5, 20);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (46, 6, 6, 21);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (47, 30, 7, 22);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (48, 14, 8, 23);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (49, 54, 9, 24);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (50, 2, 10, 25);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (51, 47, 11, 1);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (52, 51, 12, 2);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (53, 55, 13, 3);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (54, 99, 14, 4);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (55, 67, 15, 5);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (56, 0, 16, 6);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (57, 50, 17, 7);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (58, 60, 18, 8);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (59, 94, 19, 9);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (60, 89, 20, 10);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (61, 85, 1, 11);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (62, 37, 2, 12);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (63, 47, 3, 13);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (64, 90, 4, 14);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (65, 19, 5, 15);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (66, 7, 6, 16);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (67, 71, 7, 17);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (68, 73, 8, 18);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (69, 43, 9, 19);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (70, 92, 10, 20);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (71, 75, 11, 21);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (72, 53, 12, 22);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (73, 12, 13, 23);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (74, 26, 14, 24);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (75, 45, 15, 25);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (76, 63, 16, 1);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (77, 41, 17, 2);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (78, 98, 18, 3);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (79, 14, 19, 4);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (80, 88, 20, 5);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (81, 14, 1, 6);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (82, 87, 2, 7);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (83, 39, 3, 8);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (84, 79, 4, 9);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (85, 32, 5, 10);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (86, 50, 6, 11);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (87, 68, 7, 12);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (88, 59, 8, 13);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (89, 66, 9, 14);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (90, 52, 10, 15);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (91, 10, 11, 16);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (92, 90, 12, 17);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (93, 83, 13, 18);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (94, 86, 14, 19);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (95, 27, 15, 20);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (96, 65, 16, 21);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (97, 44, 17, 22);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (98, 79, 18, 23);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (99, 79, 19, 24);
INSERT INTO `Grades` (`idGrades`, `score`, `fk_idStudent`, `fk_idModule`) VALUES (100, 92, 20, 25);


DROP TABLE IF EXISTS `Module`;

CREATE TABLE `Module` (
  `idModule` int(11) NOT NULL AUTO_INCREMENT,
  `moduleName` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `code` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fk_idStudent` int(11) NOT NULL,
  `fk_idTeacher` int(11) NOT NULL,
  PRIMARY KEY (`idModule`),
  KEY `fk_Module_Student_idx` (`fk_idStudent`),
  KEY `fk_Module_Teacher1_idx` (`fk_idTeacher`),
  CONSTRAINT `fk_Module_Student` FOREIGN KEY (`fk_idStudent`) REFERENCES `Student` (`idStudent`) ON DELETE CASCADE,
  CONSTRAINT `fk_Module_Teacher1` FOREIGN KEY (`fk_idTeacher`) REFERENCES `Teacher` (`idTeacher`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `Module` (`idModule`, `moduleName`, `code`, `fk_idStudent`, `fk_idTeacher`) VALUES (1, 'delectus', '7224', 1, 1);
INSERT INTO `Module` (`idModule`, `moduleName`, `code`, `fk_idStudent`, `fk_idTeacher`) VALUES (2, 'corporis', '1004', 2, 2);
INSERT INTO `Module` (`idModule`, `moduleName`, `code`, `fk_idStudent`, `fk_idTeacher`) VALUES (3, 'qui', '1016', 3, 3);
INSERT INTO `Module` (`idModule`, `moduleName`, `code`, `fk_idStudent`, `fk_idTeacher`) VALUES (4, 'recusandae', '4743', 4, 4);
INSERT INTO `Module` (`idModule`, `moduleName`, `code`, `fk_idStudent`, `fk_idTeacher`) VALUES (5, 'est', '1149', 5, 5);
INSERT INTO `Module` (`idModule`, `moduleName`, `code`, `fk_idStudent`, `fk_idTeacher`) VALUES (6, 'aut', '2868', 6, 6);
INSERT INTO `Module` (`idModule`, `moduleName`, `code`, `fk_idStudent`, `fk_idTeacher`) VALUES (7, 'libero', '3343', 7, 7);
INSERT INTO `Module` (`idModule`, `moduleName`, `code`, `fk_idStudent`, `fk_idTeacher`) VALUES (8, 'molestiae', '9003', 8, 8);
INSERT INTO `Module` (`idModule`, `moduleName`, `code`, `fk_idStudent`, `fk_idTeacher`) VALUES (9, 'excepturi', '9622', 9, 9);
INSERT INTO `Module` (`idModule`, `moduleName`, `code`, `fk_idStudent`, `fk_idTeacher`) VALUES (10, 'aperiam', '8548', 10, 10);
INSERT INTO `Module` (`idModule`, `moduleName`, `code`, `fk_idStudent`, `fk_idTeacher`) VALUES (11, 'quis', '5517', 11, 1);
INSERT INTO `Module` (`idModule`, `moduleName`, `code`, `fk_idStudent`, `fk_idTeacher`) VALUES (12, 'porro', '9163', 12, 2);
INSERT INTO `Module` (`idModule`, `moduleName`, `code`, `fk_idStudent`, `fk_idTeacher`) VALUES (13, 'nihil', '5495', 13, 3);
INSERT INTO `Module` (`idModule`, `moduleName`, `code`, `fk_idStudent`, `fk_idTeacher`) VALUES (14, 'deserunt', '7924', 14, 4);
INSERT INTO `Module` (`idModule`, `moduleName`, `code`, `fk_idStudent`, `fk_idTeacher`) VALUES (15, 'magni', '2677', 15, 5);
INSERT INTO `Module` (`idModule`, `moduleName`, `code`, `fk_idStudent`, `fk_idTeacher`) VALUES (16, 'ullam', '7291', 16, 6);
INSERT INTO `Module` (`idModule`, `moduleName`, `code`, `fk_idStudent`, `fk_idTeacher`) VALUES (17, 'aut', '6941', 17, 7);
INSERT INTO `Module` (`idModule`, `moduleName`, `code`, `fk_idStudent`, `fk_idTeacher`) VALUES (18, 'recusandae', '6541', 18, 8);
INSERT INTO `Module` (`idModule`, `moduleName`, `code`, `fk_idStudent`, `fk_idTeacher`) VALUES (19, 'ea', '1141', 19, 9);
INSERT INTO `Module` (`idModule`, `moduleName`, `code`, `fk_idStudent`, `fk_idTeacher`) VALUES (20, 'dolor', '1022', 20, 10);
INSERT INTO `Module` (`idModule`, `moduleName`, `code`, `fk_idStudent`, `fk_idTeacher`) VALUES (21, 'aliquam', '7899', 1, 1);
INSERT INTO `Module` (`idModule`, `moduleName`, `code`, `fk_idStudent`, `fk_idTeacher`) VALUES (22, 'voluptatem', '5916', 2, 2);
INSERT INTO `Module` (`idModule`, `moduleName`, `code`, `fk_idStudent`, `fk_idTeacher`) VALUES (23, 'rerum', '6301', 3, 3);
INSERT INTO `Module` (`idModule`, `moduleName`, `code`, `fk_idStudent`, `fk_idTeacher`) VALUES (24, 'ad', '7796', 4, 4);
INSERT INTO `Module` (`idModule`, `moduleName`, `code`, `fk_idStudent`, `fk_idTeacher`) VALUES (25, 'vel', '9224', 5, 5);


DROP TABLE IF EXISTS `Student`;

CREATE TABLE `Student` (
  `idStudent` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `lastName` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `email` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `phone` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fk_idClasses` int(11) NOT NULL,
  PRIMARY KEY (`idStudent`),
  KEY `fk_Student_Classes1_idx` (`fk_idClasses`),
  CONSTRAINT `fk_Student_Classes1` FOREIGN KEY (`fk_idClasses`) REFERENCES `Classes` (`idClasses`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `Student` (`idStudent`, `name`, `lastName`, `dob`, `email`, `phone`, `fk_idClasses`) VALUES (1, 'Deondre', 'Bashirian', '2011-02-04', 'thompson.henri@example.com', '090.045.2259', 1);
INSERT INTO `Student` (`idStudent`, `name`, `lastName`, `dob`, `email`, `phone`, `fk_idClasses`) VALUES (2, 'Shanie', 'Swaniawski', '1986-08-31', 'jacobs.yasmin@example.org', '(493)261-5209x86555', 2);
INSERT INTO `Student` (`idStudent`, `name`, `lastName`, `dob`, `email`, `phone`, `fk_idClasses`) VALUES (3, 'Charlotte', 'Hegmann', '1985-05-25', 'jaeden.dach@example.org', '+29(4)5761219938', 3);
INSERT INTO `Student` (`idStudent`, `name`, `lastName`, `dob`, `email`, `phone`, `fk_idClasses`) VALUES (4, 'Werner', 'Fisher', '1985-08-30', 'emmie.harber@example.org', '1-967-004-7498', 4);
INSERT INTO `Student` (`idStudent`, `name`, `lastName`, `dob`, `email`, `phone`, `fk_idClasses`) VALUES (5, 'Tristin', 'Hermann', '1971-12-12', 'bobbie.blick@example.net', '113.581.5803', 5);
INSERT INTO `Student` (`idStudent`, `name`, `lastName`, `dob`, `email`, `phone`, `fk_idClasses`) VALUES (6, 'Hillary', 'Ziemann', '2010-12-08', 'stanton.edgardo@example.com', '(956)812-0231', 1);
INSERT INTO `Student` (`idStudent`, `name`, `lastName`, `dob`, `email`, `phone`, `fk_idClasses`) VALUES (7, 'Kailee', 'Raynor', '1972-01-04', 'makenna75@example.net', '1-448-438-8784x69908', 2);
INSERT INTO `Student` (`idStudent`, `name`, `lastName`, `dob`, `email`, `phone`, `fk_idClasses`) VALUES (8, 'Duane', 'Haag', '2012-11-09', 'frances80@example.org', '(614)553-2523x038', 3);
INSERT INTO `Student` (`idStudent`, `name`, `lastName`, `dob`, `email`, `phone`, `fk_idClasses`) VALUES (9, 'Keshawn', 'Tromp', '1993-03-24', 'nmarks@example.com', '1-521-642-7480x2578', 4);
INSERT INTO `Student` (`idStudent`, `name`, `lastName`, `dob`, `email`, `phone`, `fk_idClasses`) VALUES (10, 'Ulises', 'Hirthe', '2015-08-26', 'ibrekke@example.org', '159-059-2047', 5);
INSERT INTO `Student` (`idStudent`, `name`, `lastName`, `dob`, `email`, `phone`, `fk_idClasses`) VALUES (11, 'Berry', 'OHara', '2017-07-02', 'kadin.brown@example.net', '291.016.8626', 1);
INSERT INTO `Student` (`idStudent`, `name`, `lastName`, `dob`, `email`, `phone`, `fk_idClasses`) VALUES (12, 'Rachel', 'Harvey', '1985-12-15', 'cedrick.kautzer@example.org', '(615)907-5366x7714', 2);
INSERT INTO `Student` (`idStudent`, `name`, `lastName`, `dob`, `email`, `phone`, `fk_idClasses`) VALUES (13, 'Lydia', 'Oberbrunner', '1993-07-20', 'noemy.bradtke@example.com', '+92(7)4292416295', 3);
INSERT INTO `Student` (`idStudent`, `name`, `lastName`, `dob`, `email`, `phone`, `fk_idClasses`) VALUES (14, 'Martina', 'Upton', '2012-03-02', 'jalen.schaefer@example.com', '(581)015-6570x78259', 4);
INSERT INTO `Student` (`idStudent`, `name`, `lastName`, `dob`, `email`, `phone`, `fk_idClasses`) VALUES (15, 'Miles', 'Sauer', '2008-08-30', 'madilyn.bashirian@example.org', '1-565-460-2662x00507', 5);
INSERT INTO `Student` (`idStudent`, `name`, `lastName`, `dob`, `email`, `phone`, `fk_idClasses`) VALUES (16, 'Garrison', 'Eichmann', '1972-01-04', 'ellie06@example.net', '(621)996-3897x75943', 1);
INSERT INTO `Student` (`idStudent`, `name`, `lastName`, `dob`, `email`, `phone`, `fk_idClasses`) VALUES (17, 'Eudora', 'Huel', '2003-09-26', 'kayla23@example.net', '1-371-845-9054x3818', 2);
INSERT INTO `Student` (`idStudent`, `name`, `lastName`, `dob`, `email`, `phone`, `fk_idClasses`) VALUES (18, 'Gideon', 'Dietrich', '1999-12-26', 'ardella48@example.net', '1-300-949-6494', 3);
INSERT INTO `Student` (`idStudent`, `name`, `lastName`, `dob`, `email`, `phone`, `fk_idClasses`) VALUES (19, 'Kaitlyn', 'Zieme', '1992-03-24', 'mohammed90@example.com', '238.951.7679', 4);
INSERT INTO `Student` (`idStudent`, `name`, `lastName`, `dob`, `email`, `phone`, `fk_idClasses`) VALUES (20, 'Rudy', 'Wuckert', '1995-07-26', 'oreilly.rosa@example.org', '(290)485-7596', 5);


DROP TABLE IF EXISTS `Teacher`;

CREATE TABLE `Teacher` (
  `idTeacher` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `lastname` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `phone` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `degree` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`idTeacher`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `Teacher` (`idTeacher`, `name`, `lastname`, `email`, `phone`, `degree`) VALUES (1, 'Hilbert', 'Heller', 'nklocko@example.org', '(957)897-2091', 'sapiente');
INSERT INTO `Teacher` (`idTeacher`, `name`, `lastname`, `email`, `phone`, `degree`) VALUES (2, 'Chelsie', 'Rowe', 'bhayes@example.net', '1-103-904-5513x5203', 'sint');
INSERT INTO `Teacher` (`idTeacher`, `name`, `lastname`, `email`, `phone`, `degree`) VALUES (3, 'Ephraim', 'White', 'veum.rickey@example.org', '448-355-9374', 'facere');
INSERT INTO `Teacher` (`idTeacher`, `name`, `lastname`, `email`, `phone`, `degree`) VALUES (4, 'Tre', 'Mraz', 'mireya.predovic@example.com', '179-155-3805', 'maiores');
INSERT INTO `Teacher` (`idTeacher`, `name`, `lastname`, `email`, `phone`, `degree`) VALUES (5, 'Nathen', 'Borer', 'leopold90@example.net', '139.327.1681x4326', 'est');
INSERT INTO `Teacher` (`idTeacher`, `name`, `lastname`, `email`, `phone`, `degree`) VALUES (6, 'Garett', 'Effertz', 'prudence.kub@example.com', '02471966693', 'iusto');
INSERT INTO `Teacher` (`idTeacher`, `name`, `lastname`, `email`, `phone`, `degree`) VALUES (7, 'Hubert', 'Bechtelar', 'titus.osinski@example.org', '04367858751', 'dicta');
INSERT INTO `Teacher` (`idTeacher`, `name`, `lastname`, `email`, `phone`, `degree`) VALUES (8, 'Lilliana', 'Hettinger', 'april94@example.net', '(255)925-9344', 'totam');
INSERT INTO `Teacher` (`idTeacher`, `name`, `lastname`, `email`, `phone`, `degree`) VALUES (9, 'Ibrahim', 'Stokes', 'emily92@example.org', '829-162-1742', 'pariatur');
INSERT INTO `Teacher` (`idTeacher`, `name`, `lastname`, `email`, `phone`, `degree`) VALUES (10, 'Abbie', 'OReilly', 'pagac.ida@example.com', '1-820-438-4068x6145', 'autem');


