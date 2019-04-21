package test.all;

import controller.StudentController;
import database.ConnectionSingleton;
import database.DatabaseController;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * All tests are here
 */
public class AllTest {

    private DatabaseController databaseController;
    private Connection connectionToDatabase;

    /**
     * Set up the connection with the database in "testing"
     */
    @Before
    public void setUp() {
        connectionToDatabase =  ConnectionSingleton.getTestInstance();
        databaseController = new DatabaseController(connectionToDatabase);
    }


    /**
     * Connect our application with the database
     */
    @Test
    public void connectToDatabase() {
        Connection connection = databaseController.getConnection();
        assertEquals(connection,connectionToDatabase);
    }

    /**
     * Create our data in the database;
     */
    @Test
    public void createADatabase() {
        try {
            Statement stmt = connectionToDatabase.createStatement();
            stmt.execute(getDatabaseQuery());
            assertNotEquals(stmt,null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Display all student and classes fetched in the console log
     */
    @Test
    public void displayStudentAndClasses(){

        try {
            Statement stmt = connectionToDatabase.createStatement();
            String query ="SELECT * FROM Student INNER JOIN Classes on Classes.idClasses = Student.fk_idClasses";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int idStudent = rs.getInt("idStudent");
                String name = rs.getString("name");
                String lastName = rs.getString("lastName");
                String dob = rs.getString("dob");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String idClasses = rs.getString("idClasses");
                String className = rs.getString("ClassName");

                System.out.println(idStudent+"\t"+name+"\t"+lastName+"\t"+dob+"\t"+email+"\t"+phone+"\t"+idClasses+"\t"+className+"\n");
            }
            System.out.println(rs.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    /**
     * @return a String Query
     */
    private String getDatabaseQuery(){
        String query = "DROP TABLE IF EXISTS `Classes`;\n" +
                "CREATE TABLE `Classes` (\n" +
                "  `idClasses` int(11) NOT NULL AUTO_INCREMENT,\n" +
                "  `classname` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,\n" +
                "  PRIMARY KEY (`idClasses`)\n" +
                ") ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;\n" +
                "\n" +
                "INSERT INTO `Classes` VALUES ('1','est'),\n" +

                "('2','modi'),\n" +
                "('3','occaecati'),\n" +
                "('4','et'),\n" +
                "('5','praesentium'),\n" +
                "('6','placeat'),\n" +
                "('7','vel'),\n" +
                "('8','hic'),\n" +
                "('9','aspernatur'),\n" +
                "('10','qui'); \n" +
                "\n" +
                "DROP TABLE IF EXISTS `Student`;\n" +
                "CREATE TABLE `Student` (\n" +
                "  `idStudent` int(11) NOT NULL AUTO_INCREMENT,\n" +
                "  `name` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,\n" +
                "  `lastName` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,\n" +
                "  `dob` date DEFAULT NULL,\n" +
                "  `email` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,\n" +
                "  `phone` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,\n" +
                "  `fk_idClasses` int(11) NOT NULL,\n" +
                "  PRIMARY KEY (`idStudent`),\n" +
                "  KEY `fk_Student_Classes1_idx` (`fk_idClasses`),\n" +
                "  CONSTRAINT `fk_Student_Classes1` FOREIGN KEY (`fk_idClasses`) REFERENCES `Classes` (`idClasses`) ON DELETE CASCADE\n" +
                ") ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;\n" +
                "\n" +
                "INSERT INTO `Student` VALUES ('1','Kacie','Ondricka','2004-11-26','kuphal.angeline@example.org','09794962571','1'),\n" +
                "('2','Rosalia','Harris','2002-08-11','nienow.alva@example.com','1-831-256-5602x233','2'),\n" +
                "('3','Wyman','Ankunding','2006-10-11','xbechtelar@example.com','(370)091-2851x8802','3'),\n" +
                "('4','Josie','Heathcote','2005-09-26','emie57@example.org','1-752-334-6613','4'),\n" +
                "('5','Amalia','Friesen','1974-01-11','jacobi.adaline@example.com','1-882-476-7950','5'),\n" +
                "('6','Yolanda','Douglas','1997-05-07','verna.cronin@example.org','1-714-579-0744','6'),\n" +
                "('7','Emmitt','OConnell','2013-07-28','dexter.kshlerin@example.com','1-524-422-6467','7'),\n" +
                "('8','Pearl','Robel','2001-12-11','destini48@example.com','1-658-942-7005','8'),\n" +
                "('9','Christa','Connelly','1970-02-24','wilderman.cornell@example.net','131.724.2571x2866','9'),\n" +
                "('10','Zetta','Tillman','1972-05-23','bayer.ima@example.org','01425628364','10'),\n" +
                "('11','Declan','Denesik','2006-10-03','jamel06@example.com','1-577-391-5024','1'),\n" +
                "('12','Linnie','Rogahn','2015-01-14','demario01@example.net','733-100-3882','2'),\n" +
                "('13','Isac','Hoeger','2010-01-07','deborah.anderson@example.net','594.543.9594','3'),\n" +
                "('14','Abigail','Jaskolski','2009-05-29','fabian28@example.org','1-902-675-1769x9630','4'),\n" +
                "('15','Ronny','Reilly','2010-06-11','daisy.yundt@example.org','+23(7)4732137197','5'),\n" +
                "('16','Jewel','Miller','1988-09-07','wuckert.jon@example.org','531-371-1524','6'),\n" +
                "('17','Autumn','Boehm','1974-06-19','lokuneva@example.com','+92(6)5655166164','7'),\n" +
                "('18','Carmela','Wolf','1971-04-17','camille00@example.com','1-189-694-8880','8'),\n" +
                "('19','Eriberto','Haag','1973-08-01','rrussel@example.org','1-501-948-4298x93707','9'),\n" +
                "('20','Jany','Lind','1976-09-19','katrina.halvorson@example.net','(327)314-2688x714','10'),\n" +
                "('21','Iliana','Paucek','2016-04-07','vsmith@example.net','(960)936-7735x61516','1'),\n" +
                "('22','Antonette','Goodwin','1994-10-13','stefan00@example.net','(741)096-1017x6515','2'),\n" +
                "('23','Rickey','Thiel','1994-10-13','coberbrunner@example.org','1-981-160-5394','3'),\n" +
                "('24','Rosemarie','Borer','2000-08-03','lydia.huel@example.net','1-093-374-1436x3755','4'),\n" +
                "('25','Crystel','Spinka','1990-02-21','shaun11@example.net','07734836454','5'),\n" +
                "('26','Patsy','Friesen','1970-02-21','mvandervort@example.org','02942469327','6'),\n" +
                "('27','Dalton','Murray','1981-08-19','wkrajcik@example.com','265-344-9519','7'),\n" +
                "('28','Oren','Beer','2010-06-16','geo.hane@example.net','570-859-6865x36149','8'),\n" +
                "('29','Franz','Schowalter','1972-11-13','mgorczany@example.com','1-903-549-0406x4316','9'),\n" +
                "('30','Connie','Corwin','2016-01-28','catherine.gleason@example.net','785-408-7798','10'),\n" +
                "('31','Gerald','Brekke','1975-12-31','eleazar28@example.org','510-880-2936','1'),\n" +
                "('32','Hershel','Mraz','1996-02-08','garrett36@example.com','02333637107','2'),\n" +
                "('33','Kristin','Mohr','1972-04-13','koss.lacey@example.com','928-911-3146','3'),\n" +
                "('34','Chesley','Langosh','2006-11-21','tabitha06@example.org','783.116.6354x20483','4'),\n" +
                "('35','Laney','Hilpert','2004-01-18','kamille.schimmel@example.org','1-258-102-6235x5359','5'),\n" +
                "('36','Maxine','VonRueden','1989-07-08','savanna01@example.net','1-690-349-5768','6'),\n" +
                "('37','Adolf','Bogan','2018-01-24','jaeden.schmitt@example.org','(827)547-3832x2221','7'),\n" +
                "('38','Audreanne','Morissette','1995-11-21','rachael.mayer@example.com','731.107.1411x360','8'),\n" +
                "('39','Stewart','Brekke','2002-10-04','blick.reggie@example.org','1-469-893-8027x01632','9'),\n" +
                "('40','Doyle','Jacobs','1970-04-21','ynienow@example.net','(787)809-8769','10'),\n" +
                "('41','Johnathon','Harvey','1977-05-28','wyatt25@example.net','02072868497','1'),\n" +
                "('42','Dan','Ledner','1973-07-04','carroll.mireya@example.com','1-143-958-7213x6655','2'),\n" +
                "('43','Lindsey','Brekke','1996-07-01','lschamberger@example.com','235.463.0713x64512','3'),\n" +
                "('44','Assunta','Moen','2002-07-31','evon@example.net','(241)621-8692x3589','4'),\n" +
                "('45','Salvatore','Fisher','1972-11-16','constantin.rogahn@example.net','831.036.0245x948','5'),\n" +
                "('46','Dwight','Reilly','2019-01-25','janis44@example.com','01147955339','6'),\n" +
                "('47','Dean','Dietrich','1987-08-13','jammie78@example.net','02437784898','7'),\n" +
                "('48','Hayley','Aufderhar','2007-11-21','kaelyn.glover@example.org','01042697724','8'),\n" +
                "('49','Naomie','Larson','1997-06-24','glennie33@example.org','1-210-160-9860','9'),\n" +
                "('50','Norval','Lindgren','1975-12-06','ceasar94@example.com','938.944.9041x80473','10'); \n" +
                "\n" +
                "\n" +
                "DROP TABLE IF EXISTS `Teacher`;\n" +
                "CREATE TABLE `Teacher` (\n" +
                "  `idTeacher` int(11) NOT NULL AUTO_INCREMENT,\n" +
                "  `name` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,\n" +
                "  `lastname` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,\n" +
                "  `email` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,\n" +
                "  `phone` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,\n" +
                "  `degree` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,\n" +
                "  PRIMARY KEY (`idTeacher`)\n" +
                ") ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;\n" +
                "\n" +
                "INSERT INTO `Teacher` VALUES ('1','Winston','Lind','ymurazik@example.com','(391)095-0040x7029','possimus'),\n" +
                "('2','Adriana','Hoppe','sydnie73@example.com','402-423-1208','sunt'),\n" +
                "('3','Ramona','Runolfsdottir','hkonopelski@example.org','137.080.9640','et'),\n" +
                "('4','Joany','Koss','zula68@example.net','443.131.7546x773','repellendus'),\n" +
                "('5','Kelsie','Block','ntorp@example.com','(899)599-2751x72647','cumque'),\n" +
                "('6','Terry','Senger','monty.zboncak@example.net','1-865-001-3460','excepturi'),\n" +
                "('7','Savannah','Heathcote','mandy.parker@example.com','347-248-3156x5505','dicta'),\n" +
                "('8','Imani','Donnelly','breitenberg.joesph@example.org','+99(7)4579245205','ut'),\n" +
                "('9','Lera','Gottlieb','gislason.arnulfo@example.net','1-397-439-6019','deserunt'),\n" +
                "('10','Tyrel','Fahey','izabella.schultz@example.net','034-394-9448x58649','id');\n" +
                "\n" +
                "DROP TABLE IF EXISTS `Module`;\n" +
                "CREATE TABLE `Module` (\n" +
                "  `idModule` int(11) NOT NULL AUTO_INCREMENT,\n" +
                "  `moduleName` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,\n" +
                "  `code` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,\n" +
                "  `fk_idStudent` int(11) NOT NULL,\n" +
                "  `fk_idTeacher` int(11) NOT NULL,\n" +
                "  PRIMARY KEY (`idModule`),\n" +
                "  KEY `fk_Module_Student_idx` (`fk_idStudent`),\n" +
                "  KEY `fk_Module_Teacher1_idx` (`fk_idTeacher`),\n" +
                "  CONSTRAINT `fk_Module_Student` FOREIGN KEY (`fk_idStudent`) REFERENCES `Student` (`idStudent`) ON DELETE CASCADE,\n" +
                "  CONSTRAINT `fk_Module_Teacher1` FOREIGN KEY (`fk_idTeacher`) REFERENCES `Teacher` (`idTeacher`) ON DELETE CASCADE\n" +
                ") ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;\n" +
                "\n" +
                "INSERT INTO `Module` VALUES ('1','et','3895','1','1'),\n" +
                "('2','dolores','1497','2','2'),\n" +
                "('3','quia','6839','3','3'),\n" +
                "('4','aperiam','9799','4','4'),\n" +
                "('5','animi','7237','5','5'),\n" +
                "('6','saepe','8009','6','6'),\n" +
                "('7','et','4338','7','7'),\n" +
                "('8','consequatur','2094','8','8'),\n" +
                "('9','consequatur','9790','9','9'),\n" +
                "('10','perferendis','6264','10','10'),\n" +
                "('11','cumque','2444','11','1'),\n" +
                "('12','rerum','8871','12','2'),\n" +
                "('13','atque','4445','13','3'),\n" +
                "('14','expedita','9878','14','4'),\n" +
                "('15','optio','1753','15','5'),\n" +
                "('16','culpa','6048','16','6'),\n" +
                "('17','dolor','4056','17','7'),\n" +
                "('18','veritatis','8106','18','8'),\n" +
                "('19','quia','6014','19','9'),\n" +
                "('20','facilis','3992','20','10'),\n" +
                "('21','et','6900','21','1'),\n" +
                "('22','maxime','1770','22','2'),\n" +
                "('23','illo','9583','23','3'),\n" +
                "('24','cumque','7131','24','4'),\n" +
                "('25','aliquid','1142','25','5'); \n" +
                "\n" +
                "\n" +
                "\n" +
                "DROP TABLE IF EXISTS `Grades`;\n" +
                "CREATE TABLE `Grades` (\n" +
                "  `idGrades` int(11) NOT NULL AUTO_INCREMENT,\n" +
                "  `score` int(11) NOT NULL,\n" +
                "  `fk_idStudent` int(11) NOT NULL,\n" +
                "  `fk_idModule` int(11) NOT NULL,\n" +
                "  PRIMARY KEY (`idGrades`),\n" +
                "  KEY `fk_Module_Student1_idx` (`fk_idStudent`),\n" +
                "  KEY `fk_Module_Module2_idx` (`fk_idModule`),\n" +
                "  CONSTRAINT `fk_Module_Module2` FOREIGN KEY (`fk_idModule`) REFERENCES `Module` (`idModule`) ON DELETE CASCADE,\n" +
                "  CONSTRAINT `fk_Module_Student1` FOREIGN KEY (`fk_idStudent`) REFERENCES `Student` (`idStudent`) ON DELETE CASCADE\n" +
                ") ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;\n" +
                "\n" +
                "INSERT INTO `Grades` VALUES ('1','29','1','1'),\n" +
                "('2','50','2','2'),\n" +
                "('3','42','3','3'),\n" +
                "('4','66','4','4'),\n" +
                "('5','33','5','5'),\n" +
                "('6','55','6','6'),\n" +
                "('7','34','7','7'),\n" +
                "('8','50','8','8'),\n" +
                "('9','48','9','9'),\n" +
                "('10','40','10','10'),\n" +
                "('11','56','11','11'),\n" +
                "('12','30','12','12'),\n" +
                "('13','26','13','13'),\n" +
                "('14','47','14','14'),\n" +
                "('15','63','15','15'),\n" +
                "('16','31','16','16'),\n" +
                "('17','8','17','17'),\n" +
                "('18','35','18','18'),\n" +
                "('19','23','19','19'),\n" +
                "('20','71','20','20'),\n" +
                "('21','15','21','21'),\n" +
                "('22','36','22','22'),\n" +
                "('23','6','23','23'),\n" +
                "('24','48','24','24'),\n" +
                "('25','71','25','25'),\n" +
                "('26','77','26','1'),\n" +
                "('27','75','27','2'),\n" +
                "('28','32','28','3'),\n" +
                "('29','30','29','4'),\n" +
                "('30','31','30','5'),\n" +
                "('31','55','31','6'),\n" +
                "('32','66','32','7'),\n" +
                "('33','20','33','8'),\n" +
                "('34','57','34','9'),\n" +
                "('35','83','35','10'),\n" +
                "('36','77','36','11'),\n" +
                "('37','75','37','12'),\n" +
                "('38','52','38','13'),\n" +
                "('39','80','39','14'),\n" +
                "('40','54','40','15'),\n" +
                "('41','45','41','16'),\n" +
                "('42','24','42','17'),\n" +
                "('43','90','43','18'),\n" +
                "('44','37','44','19'),\n" +
                "('45','90','45','20'),\n" +
                "('46','52','46','21'),\n" +
                "('47','96','47','22'),\n" +
                "('48','60','48','23'),\n" +
                "('49','37','49','24'),\n" +
                "('50','12','50','25'),\n" +
                "('51','78','1','1'),\n" +
                "('52','65','2','2'),\n" +
                "('53','31','3','3'),\n" +
                "('54','29','4','4'),\n" +
                "('55','69','5','5'),\n" +
                "('56','49','6','6'),\n" +
                "('57','55','7','7'),\n" +
                "('58','49','8','8'),\n" +
                "('59','42','9','9'),\n" +
                "('60','80','10','10'),\n" +
                "('61','99','11','11'),\n" +
                "('62','46','12','12'),\n" +
                "('63','75','13','13'),\n" +
                "('64','12','14','14'),\n" +
                "('65','32','15','15'),\n" +
                "('66','24','16','16'),\n" +
                "('67','24','17','17'),\n" +
                "('68','17','18','18'),\n" +
                "('69','67','19','19'),\n" +
                "('70','28','20','20'),\n" +
                "('71','89','21','21'),\n" +
                "('72','35','22','22'),\n" +
                "('73','62','23','23'),\n" +
                "('74','68','24','24'),\n" +
                "('75','60','25','25'),\n" +
                "('76','36','26','1'),\n" +
                "('77','79','27','2'),\n" +
                "('78','28','28','3'),\n" +
                "('79','83','29','4'),\n" +
                "('80','96','30','5'),\n" +
                "('81','20','31','6'),\n" +
                "('82','34','32','7'),\n" +
                "('83','28','33','8'),\n" +
                "('84','87','34','9'),\n" +
                "('85','81','35','10'),\n" +
                "('86','34','36','11'),\n" +
                "('87','92','37','12'),\n" +
                "('88','54','38','13'),\n" +
                "('89','8','39','14'),\n" +
                "('90','27','40','15'),\n" +
                "('91','55','41','16'),\n" +
                "('92','99','42','17'),\n" +
                "('93','1','43','18'),\n" +
                "('94','46','44','19'),\n" +
                "('95','33','45','20'),\n" +
                "('96','22','46','21'),\n" +
                "('97','12','47','22'),\n" +
                "('98','33','48','23'),\n" +
                "('99','88','49','24'),\n" +
                "('100','80','50','25'); \n";
        return "SELECT * FROM `Module`";
    }



}