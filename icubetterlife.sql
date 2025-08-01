/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

CREATE DATABASE IF NOT EXISTS `ibliv` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;
USE `ibliv`;

CREATE TABLE IF NOT EXISTS `anthropometry` (
  `anthropometryid` int(11) NOT NULL AUTO_INCREMENT,
  `patient` int(11) NOT NULL,
  `weight` decimal(20,6) DEFAULT NULL,
  `height` decimal(20,6) DEFAULT NULL,
  `bmi` decimal(20,6) DEFAULT NULL,
  `bsaboyd` decimal(20,6) DEFAULT NULL,
  `createdby` int(11) NOT NULL,
  `createddate` datetime DEFAULT current_timestamp(),
  `updatedby` int(11) DEFAULT NULL,
  `updateddate` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`anthropometryid`) USING BTREE,
  KEY `patient` (`patient`),
  CONSTRAINT `anthropometry_ibfk_1` FOREIGN KEY (`patient`) REFERENCES `patient` (`patientid`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `anthropometry` (`anthropometryid`, `patient`, `weight`, `height`, `bmi`, `bsaboyd`, `createdby`, `createddate`, `updatedby`, `updateddate`) VALUES
	(16, 41, 40.000000, 0.230000, 756.143667, 20.000000, 1, '2025-06-14 22:13:57', 1, '2025-06-14 22:13:57'),
	(17, 41, 50.000000, 0.340000, 432.525952, 21.000000, 1, '2025-06-14 22:14:56', 1, '2025-06-14 22:14:56'),
	(18, 41, 40.000000, 0.670000, 89.106705, 22.300000, 0, '0034-03-12 05:30:00', 0, NULL);

CREATE TABLE IF NOT EXISTS `applicationversion` (
  `versionid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `versionnumber` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `active` int(11) DEFAULT NULL,
  `createdby` int(11) NOT NULL,
  `createddate` datetime DEFAULT current_timestamp(),
  `updatedby` int(11) DEFAULT NULL,
  `updateddate` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`versionid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;


CREATE TABLE IF NOT EXISTS `consultantpatientvisit` (
  `consultantpatientvisitid` int(11) NOT NULL AUTO_INCREMENT,
  `patientdaysheet` int(11) NOT NULL,
  `datetime` datetime DEFAULT NULL,
  `doctor` int(11) DEFAULT NULL,
  `createdby` int(11) NOT NULL,
  `createddate` datetime DEFAULT current_timestamp(),
  `updatedby` int(11) DEFAULT NULL,
  `updateddate` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`consultantpatientvisitid`) USING BTREE,
  KEY `patientdaysheet` (`patientdaysheet`),
  KEY `doctor` (`doctor`),
  CONSTRAINT `consultantpatientvisit_ibfk_1` FOREIGN KEY (`patientdaysheet`) REFERENCES `patientdaysheet` (`patientdaysheetid`) ON UPDATE CASCADE,
  CONSTRAINT `consultantpatientvisit_ibfk_2` FOREIGN KEY (`doctor`) REFERENCES `user` (`userid`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `consultantpatientvisit` (`consultantpatientvisitid`, `patientdaysheet`, `datetime`, `doctor`, `createdby`, `createddate`, `updatedby`, `updateddate`) VALUES
	(1, 1, '2025-06-20 13:51:13', 4, 0, '2025-06-20 13:51:13', 0, NULL);

CREATE TABLE IF NOT EXISTS `division` (
  `divisionid` int(11) NOT NULL AUTO_INCREMENT,
  `divisionname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `divisioncode` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `date` datetime DEFAULT current_timestamp(),
  `active` int(1) NOT NULL,
  `createdby` int(11) NOT NULL,
  `createddate` datetime DEFAULT current_timestamp(),
  `updatedby` int(11) DEFAULT NULL,
  `updateddate` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`divisionid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;

INSERT INTO `division` (`divisionid`, `divisionname`, `divisioncode`, `date`, `active`, `createdby`, `createddate`, `updatedby`, `updateddate`) VALUES
	(1, 'Medical ICU', 'MICU', '2025-06-08 17:30:27', 1, 1, '2025-06-08 17:30:27', 1, '2025-06-08 17:30:27'),
	(2, 'Surgical ICU', 'SICU', '2025-06-08 17:30:27', 1, 1, '2025-06-08 17:30:27', 1, '2025-06-08 17:30:27'),
	(3, 'Cardiac ICU', 'CICU', '2025-06-08 17:30:27', 1, 1, '2025-06-08 17:30:27', 1, '2025-06-08 17:30:27'),
	(4, 'Neonatal ICU', 'NICU', '2025-06-08 17:30:27', 1, 1, '2025-06-08 17:30:27', 1, '2025-06-08 17:30:27'),
	(5, 'Pediatric ICU', 'PICU', '2025-06-08 17:30:27', 1, 1, '2025-06-08 17:30:27', 1, '2025-06-08 17:30:27'),
	(6, 'Neurological ICU', 'NeuroICU', '2025-06-08 17:30:27', 1, 1, '2025-06-08 17:30:27', 1, '2025-06-08 17:30:27'),
	(7, 'Trauma ICU', 'TICU', '2025-06-08 17:30:27', 1, 1, '2025-06-08 17:30:27', 1, '2025-06-08 17:30:27'),
	(8, 'Burn ICU', 'BICU', '2025-06-08 17:30:27', 1, 1, '2025-06-08 17:30:27', 1, '2025-06-08 17:30:27'),
	(9, 'Coronary Care Unit', 'CCU', '2025-06-08 17:30:27', 1, 1, '2025-06-08 17:30:27', 1, '2025-06-08 17:30:27'),
	(10, 'Respiratory ICU', 'RICU', '2025-06-08 17:30:27', 1, 1, '2025-06-08 17:30:27', 1, '2025-06-08 17:30:27'),
	(11, 'Post-Anesthesia Care Unit', 'PACU', '2025-06-08 17:30:27', 1, 1, '2025-06-08 17:30:27', 1, '2025-06-08 17:30:27'),
	(12, 'High Dependency Unit', 'HDU', '2025-06-08 17:30:27', 1, 1, '2025-06-08 17:30:27', 1, '2025-06-08 17:30:27'),
	(13, 'Cardiothoracic ICU', 'CTICU', '2025-06-08 17:30:27', 1, 1, '2025-06-08 17:30:27', 1, '2025-06-08 17:30:27'),
	(14, 'Transplant ICU', 'TICU', '2025-06-08 17:30:27', 1, 1, '2025-06-08 17:30:27', 1, '2025-06-08 17:30:27'),
	(15, 'Emergency ICU', 'EICU', '2025-06-08 17:30:27', 1, 1, '2025-06-08 17:30:27', 1, '2025-06-08 17:30:27');

CREATE TABLE IF NOT EXISTS `embolism` (
  `embolismid` int(11) NOT NULL AUTO_INCREMENT,
  `patientdaysheet` int(11) NOT NULL,
  `dvtrisk` varchar(50) DEFAULT NULL,
  `anticoagulation` varchar(50) DEFAULT NULL,
  `compression` varchar(200) DEFAULT NULL,
  `createdby` int(11) NOT NULL,
  `createddate` datetime DEFAULT current_timestamp(),
  `updatedby` int(11) DEFAULT NULL,
  `updateddate` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`embolismid`) USING BTREE,
  KEY `patientdaysheet` (`patientdaysheet`),
  CONSTRAINT `embolism_ibfk_1` FOREIGN KEY (`patientdaysheet`) REFERENCES `patientdaysheet` (`patientdaysheetid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `embolism` (`embolismid`, `patientdaysheet`, `dvtrisk`, `anticoagulation`, `compression`, `createdby`, `createddate`, `updatedby`, `updateddate`) VALUES
	(1, 1, 'jnsd', 'nsns', 'ajjaaj', 0, '2025-06-15 23:27:07', 0, NULL);

CREATE TABLE IF NOT EXISTS `hourlyobservation` (
  `hourlyobservationid` int(11) NOT NULL AUTO_INCREMENT,
  `patientdaysheet` int(11) NOT NULL,
  `timeslot` int(11) NOT NULL,
  `vital` int(11) NOT NULL,
  `value` int(11) DEFAULT NULL,
  `createdby` int(11) NOT NULL,
  `createddate` datetime DEFAULT current_timestamp(),
  `updatedby` int(11) DEFAULT NULL,
  `updateddate` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`hourlyobservationid`) USING BTREE,
  KEY `patientdaysheet` (`patientdaysheet`),
  KEY `vital` (`vital`),
  CONSTRAINT `hourlyobservation_ibfk_1` FOREIGN KEY (`patientdaysheet`) REFERENCES `patientdaysheet` (`patientdaysheetid`) ON UPDATE CASCADE,
  CONSTRAINT `hourlyobservation_ibfk_2` FOREIGN KEY (`vital`) REFERENCES `vital` (`vitalid`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `hourlyobservation` (`hourlyobservationid`, `patientdaysheet`, `timeslot`, `vital`, `value`, `createdby`, `createddate`, `updatedby`, `updateddate`) VALUES
	(1, 1, 12, 1, 40, 0, '2025-06-15 18:20:37', 0, NULL),
	(2, 1, 13, 1, 50, 0, '2025-06-15 18:22:44', 0, NULL),
	(3, 1, 16, 1, 40, 0, '2025-06-15 18:25:48', 0, NULL),
	(4, 1, 12, 1, 30, 0, '2025-06-15 19:58:59', 0, NULL),
	(5, 1, 23, 1, 50, 0, '2025-06-15 20:01:33', 0, NULL),
	(6, 1, 23, 6, 67, 0, '2025-06-15 21:54:19', 0, NULL);

CREATE TABLE IF NOT EXISTS `icu` (
  `icuid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `active` int(11) DEFAULT NULL,
  `createdby` int(11) NOT NULL,
  `createddate` datetime DEFAULT current_timestamp(),
  `updatedby` int(11) DEFAULT NULL,
  `updateddate` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`icuid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `icu` (`icuid`, `name`, `active`, `createdby`, `createddate`, `updatedby`, `updateddate`) VALUES
	(1, 'jdhd sjjs', 1, 1, '2025-06-06 20:15:02', 0, '2025-06-06 22:16:39'),
	(2, 'wjsj sbsbbsbsbs ddd', 1, 1, '2025-06-06 22:01:04', 0, '2025-06-06 22:16:27'),
	(3, 'hdhhdhdhd', 1, 1, '2025-06-06 22:02:01', 1, '2025-06-06 22:11:29'),
	(4, 'wjsj sbsbbsbsbs ddd', 1, 1, '2025-06-15 14:12:27', 0, '2025-06-15 14:12:27');

CREATE TABLE IF NOT EXISTS `ivfluid` (
  `ivfluidid` int(11) NOT NULL AUTO_INCREMENT,
  `ivfluidname` int(11) NOT NULL,
  `active` int(11) DEFAULT NULL,
  `createdby` int(11) NOT NULL,
  `createddate` datetime DEFAULT current_timestamp(),
  `updatedby` int(11) DEFAULT NULL,
  `updateddate` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`ivfluidid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `ivfluid` (`ivfluidid`, `ivfluidname`, `active`, `createdby`, `createddate`, `updatedby`, `updateddate`) VALUES
	(1, 3838, 0, 0, '2025-06-19 13:33:11', 0, NULL);

CREATE TABLE IF NOT EXISTS `linestubes` (
  `linestubesid` int(11) NOT NULL AUTO_INCREMENT,
  `linestubesname` int(11) NOT NULL,
  `active` int(11) DEFAULT NULL,
  `createdby` int(11) NOT NULL,
  `createddate` datetime DEFAULT current_timestamp(),
  `updatedby` int(11) DEFAULT NULL,
  `updateddate` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`linestubesid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `linestubes` (`linestubesid`, `linestubesname`, `active`, `createdby`, `createddate`, `updatedby`, `updateddate`) VALUES
	(2, 12, 1, 0, '2025-06-15 14:36:27', 0, NULL);

CREATE TABLE IF NOT EXISTS `menudetails` (
  `menuid` int(11) NOT NULL AUTO_INCREMENT,
  `mainname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `subname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `link` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `classname` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `mainsort` int(11) DEFAULT NULL,
  `subsort` int(11) DEFAULT NULL,
  `active` int(1) NOT NULL,
  `ionicactive` int(1) NOT NULL,
  `mainicon` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `subicon` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ionicdashboardicon` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `createdby` int(11) NOT NULL,
  `createddate` datetime DEFAULT current_timestamp(),
  `updatedby` int(11) DEFAULT NULL,
  `updateddate` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`menuid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;

INSERT INTO `menudetails` (`menuid`, `mainname`, `subname`, `link`, `classname`, `mainsort`, `subsort`, `active`, `ionicactive`, `mainicon`, `subicon`, `ionicdashboardicon`, `createdby`, `createddate`, `updatedby`, `updateddate`) VALUES
	(1, 'Dashboard', '', 'dashboard', 'DashboardComponent', 1, NULL, 1, 1, 'dashboard', NULL, NULL, 1, '2025-06-01 22:33:03', 1, '2025-06-02 22:40:22'),
	(3, 'Admin', 'vitals', 'admin', 'VitalComponent', 4, 1, 1, 1, 'monitor_heart', 'monitor_heart', NULL, 1, '2025-06-01 22:43:20', 1, '2025-06-14 14:06:59'),
	(9, 'Patient', 'anthropometry', 'patient', 'AnthropometryComponent', 3, 1, 1, 1, 'personal_injury', 'straighten', NULL, 1, '2025-06-01 23:01:19', 1, '2025-06-12 18:29:49'),
	(12, 'Patient', 'daysheet', 'patient/daysheet', 'PatientdaysheetComponent', 3, 2, 1, 1, 'personal_injury', 'today', NULL, 1, '2025-06-01 23:27:19', 1, '2025-06-09 22:39:13'),
	(13, 'Admin', 'physiotheropy', 'physiotheropy', 'PhysiothearpyComponent', 4, 6, 1, 1, 'directions_run', 'person_add', NULL, 1, '2025-06-02 00:27:36', 1, '2025-06-14 23:28:55'),
	(14, 'Patient', 'Hourly Observation', 'daysheet/HourlyObservation', 'HourlyobservationComponent', 3, 4, 1, 1, 'view_day', 'monitor_heart', NULL, 1, '2025-06-02 00:35:56', 1, '2025-06-09 22:39:19'),
	(15, 'Patient', 'Patient Score', 'daysheet/PatientScore', 'PatientadditionalscoresComponent', 3, 5, 1, 1, 'view_day', 'score', NULL, 1, '2025-06-02 00:38:12', 1, '2025-06-09 22:39:22'),
	(16, 'Patient', 'Patient Test', 'daysheet/PatientTest', 'PatientadditionaltestsComponent', 3, 6, 1, 1, 'view_day', 'science', NULL, 1, '2025-06-02 00:39:33', 1, '2025-06-09 22:39:25'),
	(17, 'Patient', 'Embolism', 'daysheet/embolism', 'EmbolismComponent', 3, 7, 1, 1, 'view_day', 'coronavirus', NULL, 1, '2025-06-02 00:40:46', 1, '2025-06-09 22:39:28'),
	(18, 'Patient', 'Patient Medication Chart', 'daysheet/PatientMedicationChart', 'PatientMedicationChartComponent', 3, 8, 1, 1, 'assignment_ind', 'insert_chart', NULL, 1, '2025-06-02 00:43:01', 1, '2025-06-09 22:39:31'),
	(19, 'Patient', 'Patient Medication log', 'daysheet/PatientMedicationLog', 'PatientMedicationLogComponent', 3, 9, 1, 1, 'assignment_ind', 'history', NULL, 1, '2025-06-02 00:43:50', 1, '2025-06-09 22:39:36'),
	(20, 'Admin', 'Ventilator mode', 'daysheet/VentilatorMode', 'VentilatorModeComponent', 4, 5, 1, 1, 'assignment_ind', 'settings_input_hdmi', NULL, 1, '2025-06-02 00:45:26', 1, '2025-06-14 12:43:30'),
	(21, 'Patient', 'Patient Ventilator', 'daysheet/PatientVentilator', 'PatientVentilatorComponent', 3, 11, 1, 1, 'assignment_ind', 'air', NULL, 1, '2025-06-02 00:47:27', 1, '2025-06-09 22:39:45'),
	(22, 'Patient', 'Patient SOS Medication', 'daysheet/PatientSOSMedication', 'PatientSosMedicationComponent', 3, 12, 1, 1, 'emergency', 'personal_injury', NULL, 1, '2025-06-02 00:50:16', 1, '2025-06-09 22:39:47'),
	(23, 'Patient', 'Patient Lines Tubes', 'patient/Patientlinestubes', 'PatientlinestubesComponent', 3, 13, 1, 1, 'plumbing', 'healing', NULL, 1, '2025-06-02 00:54:43', 1, '2025-06-09 22:39:50'),
	(24, 'Patient', 'Patient IV Fulid', 'patient/PatientIVFulid', 'PatientivfluidComponent', 3, 14, 1, 1, 'IV', 'invert_colors', NULL, 1, '2025-06-02 00:56:46', 1, '2025-06-09 22:39:53'),
	(25, 'Patient', 'Shiftt RMO nurse', 'patient/ShifttRMOnurse', 'ShiftrmonurseComponent', 3, 15, 1, 1, 'local_hospital', 'group_work', NULL, 1, '2025-06-02 00:59:53', 1, '2025-06-09 22:39:56'),
	(26, 'Patient', 'Patient Infusion', 'patient/PatientInfusion', 'PatientinfusionComponent', 3, 16, 1, 1, 'IV', 'person_add', NULL, 1, '2025-06-02 01:01:35', 1, '2025-06-09 22:39:59'),
	(27, 'Patient', 'RMO Nursely', 'patient/RMONursely', 'RmonurselogComponent', 3, 17, 1, 1, 'badge', 'man', NULL, 1, '2025-06-02 01:09:47', 1, '2025-06-09 22:40:50'),
	(28, 'Patient', 'Consultant Patient Visit', 'patient/ConsultantPatientVisit', 'ConsultantPatientVisitComponent', 3, 18, 1, 1, 'supervised_user_circle', 'edit_note', NULL, 1, '2025-06-02 01:11:03', 1, '2025-06-09 22:40:20'),
	(29, 'Admin', 'Edit Lines Tubes', 'patient/EditLinesTubes', 'EditlinesTubesComponent', 4, 2, 1, 1, 'plumbing', 'edit', NULL, 1, '2025-06-02 01:15:19', 1, '2025-06-09 22:38:22'),
	(30, 'Admin', 'Edit IV Fulid', 'patient/IVFluid', 'EditIVfuildComponent', 4, 3, 1, 1, 'IV', 'mode_edit', NULL, 1, '2025-06-02 01:16:41', 1, '2025-06-09 22:40:24'),
	(31, 'Admin', 'ICU', 'patient/ICU', 'IcuComponent', 4, 4, 1, 1, 'local_hospital', 'air', NULL, 1, '2025-06-02 01:18:51', 1, '2025-06-09 22:40:27'),
	(32, 'Reports', '', 'reports', 'Report', 5, NULL, 1, 1, 'report', NULL, NULL, 1, '2025-06-09 22:33:49', 1, '2025-06-14 14:00:25');

CREATE TABLE IF NOT EXISTS `patient` (
  `patientid` int(11) NOT NULL AUTO_INCREMENT,
  `patientname` varchar(50) DEFAULT NULL,
  `dob` datetime DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `sex` varchar(50) DEFAULT NULL,
  `address` varchar(2000) DEFAULT NULL,
  `contact` varchar(50) DEFAULT NULL,
  `active` int(11) DEFAULT NULL,
  `createdby` int(11) NOT NULL,
  `createddate` datetime DEFAULT current_timestamp(),
  `updatedby` int(11) DEFAULT NULL,
  `updateddate` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`patientid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `patient` (`patientid`, `patientname`, `dob`, `age`, `sex`, `address`, `contact`, `active`, `createdby`, `createddate`, `updatedby`, `updateddate`) VALUES
	(41, 'jdjd sosos nns', '6789-05-31 05:30:00', 91, 'Male', 'snns shsh sytrwoohohn caxasa', '1234567889', 1, 1, '2025-06-14 21:00:50', 0, '2025-06-14 21:00:50'),
	(43, 'qwqwwqw oosoos ataatra', '4667-03-12 05:30:00', 97, 'Male', 'ffhhr rruruur owwowow zm zmzmz ncn', '9175772990', 1, 1, '2025-06-14 23:47:13', 0, '2025-06-14 23:47:13');

CREATE TABLE IF NOT EXISTS `patientadditionalscores` (
  `patientadditionalscoresid` int(11) NOT NULL AUTO_INCREMENT,
  `patientdaysheet` int(11) NOT NULL,
  `qsofa` decimal(20,6) DEFAULT NULL,
  `mews` decimal(20,6) DEFAULT NULL,
  `apacheiv` decimal(20,6) DEFAULT NULL,
  `createdby` int(11) NOT NULL,
  `createddate` datetime DEFAULT current_timestamp(),
  `updatedby` int(11) DEFAULT NULL,
  `updateddate` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`patientadditionalscoresid`) USING BTREE,
  KEY `patientdaysheet` (`patientdaysheet`),
  CONSTRAINT `patientadditionalscores_ibfk_1` FOREIGN KEY (`patientdaysheet`) REFERENCES `patientdaysheet` (`patientdaysheetid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `patientadditionalscores` (`patientadditionalscoresid`, `patientdaysheet`, `qsofa`, `mews`, `apacheiv`, `createdby`, `createddate`, `updatedby`, `updateddate`) VALUES
	(1, 1, 34.000000, 55.000000, 22.000000, 0, '2025-06-15 22:34:02', 0, NULL);

CREATE TABLE IF NOT EXISTS `patientadditionaltests` (
  `patientadditionaltestsid` int(11) NOT NULL AUTO_INCREMENT,
  `patientdaysheet` int(11) NOT NULL,
  `physiothearpy` int(11) NOT NULL,
  `ambulation` varchar(50) DEFAULT NULL,
  `incentivespirometry` varchar(50) DEFAULT NULL,
  `belt` varchar(50) DEFAULT NULL,
  `dressing` varchar(50) DEFAULT NULL,
  `trachettsectretion` varchar(50) DEFAULT NULL,
  `createdby` int(11) NOT NULL,
  `createddate` datetime DEFAULT current_timestamp(),
  `updatedby` int(11) DEFAULT NULL,
  `updateddate` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`patientadditionaltestsid`) USING BTREE,
  KEY `patientdaysheet` (`patientdaysheet`),
  KEY `physiothearpy` (`physiothearpy`),
  CONSTRAINT `patientadditionaltests_ibfk_1` FOREIGN KEY (`patientdaysheet`) REFERENCES `patientdaysheet` (`patientdaysheetid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `patientadditionaltests_ibfk_2` FOREIGN KEY (`physiothearpy`) REFERENCES `physiothearpy` (`physiothearpyid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `patientadditionaltests` (`patientadditionaltestsid`, `patientdaysheet`, `physiothearpy`, `ambulation`, `incentivespirometry`, `belt`, `dressing`, `trachettsectretion`, `createdby`, `createddate`, `updatedby`, `updateddate`) VALUES
	(1, 1, 2, 'ksskjs siis', 'jsjjs', 'shsh sus', 'snsn', 'sbs', 0, '2025-06-18 20:08:33', 0, NULL);

CREATE TABLE IF NOT EXISTS `patientadmission` (
  `patientadmissionid` int(11) NOT NULL AUTO_INCREMENT,
  `patient` int(11) NOT NULL,
  `admissiondate` datetime DEFAULT NULL,
  `icu` int(11) NOT NULL,
  `icuadmissiondate` datetime DEFAULT NULL,
  `createdby` int(11) NOT NULL,
  `createddate` datetime DEFAULT current_timestamp(),
  `updatedby` int(11) DEFAULT NULL,
  `updateddate` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`patientadmissionid`) USING BTREE,
  KEY `patient` (`patient`),
  KEY `icu` (`icu`),
  CONSTRAINT `patientadmission_ibfk_1` FOREIGN KEY (`patient`) REFERENCES `patient` (`patientid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `patientadmission_ibfk_2` FOREIGN KEY (`icu`) REFERENCES `icu` (`icuid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `patientadmission` (`patientadmissionid`, `patient`, `admissiondate`, `icu`, `icuadmissiondate`, `createdby`, `createddate`, `updatedby`, `updateddate`) VALUES
	(11, 41, '6773-05-12 05:30:00', 1, '0754-05-08 05:30:00', 1, '2025-06-14 21:00:50', 1, '2025-06-14 21:00:50'),
	(12, 43, '5613-05-23 05:30:00', 3, '4568-04-23 05:30:00', 1, '2025-06-14 23:47:13', 1, '2025-06-14 23:47:13');

CREATE TABLE IF NOT EXISTS `patientdaysheet` (
  `patientdaysheetid` int(11) NOT NULL AUTO_INCREMENT,
  `patientadmission` int(11) NOT NULL,
  `date` date DEFAULT NULL,
  `consultant1` int(11) DEFAULT NULL,
  `consultant2` int(11) DEFAULT NULL,
  `consultant3` int(11) DEFAULT NULL,
  `intensivist` int(11) NOT NULL,
  `createdby` int(11) NOT NULL,
  `createddate` datetime DEFAULT current_timestamp(),
  `updatedby` int(11) DEFAULT NULL,
  `updateddate` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`patientdaysheetid`) USING BTREE,
  KEY `patientadmission` (`patientadmission`),
  KEY `consultant1` (`consultant1`),
  KEY `consultant2` (`consultant2`),
  KEY `consultant3` (`consultant3`),
  KEY `intensivist` (`intensivist`),
  CONSTRAINT `patientdaysheet_ibfk_1` FOREIGN KEY (`patientadmission`) REFERENCES `patientadmission` (`patientadmissionid`) ON UPDATE CASCADE,
  CONSTRAINT `patientdaysheet_ibfk_2` FOREIGN KEY (`consultant1`) REFERENCES `user` (`userid`) ON UPDATE CASCADE,
  CONSTRAINT `patientdaysheet_ibfk_3` FOREIGN KEY (`consultant2`) REFERENCES `user` (`userid`) ON UPDATE CASCADE,
  CONSTRAINT `patientdaysheet_ibfk_4` FOREIGN KEY (`consultant3`) REFERENCES `user` (`userid`) ON UPDATE CASCADE,
  CONSTRAINT `patientdaysheet_ibfk_5` FOREIGN KEY (`intensivist`) REFERENCES `user` (`userid`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `patientdaysheet` (`patientdaysheetid`, `patientadmission`, `date`, `consultant1`, `consultant2`, `consultant3`, `intensivist`, `createdby`, `createddate`, `updatedby`, `updateddate`) VALUES
	(1, 11, '4566-03-12', 2, 1, 3, 2, 0, '2025-06-14 23:00:12', 0, '2025-06-14 23:00:12');

CREATE TABLE IF NOT EXISTS `patientinfusion` (
  `patientinfusionid` int(11) NOT NULL AUTO_INCREMENT,
  `patient` int(11) NOT NULL,
  `time` datetime DEFAULT current_timestamp(),
  `fluidname` varchar(200) DEFAULT NULL,
  `fluidvolume` varchar(200) DEFAULT NULL,
  `ivmedication` varchar(200) DEFAULT NULL,
  `dose` varchar(200) DEFAULT NULL,
  `rate` varchar(200) DEFAULT NULL,
  `preparedby` int(11) NOT NULL,
  `starttime` datetime DEFAULT current_timestamp(),
  `endtime` datetime DEFAULT current_timestamp(),
  `createdby` int(11) NOT NULL,
  `createddate` datetime DEFAULT current_timestamp(),
  `updatedby` int(11) DEFAULT NULL,
  `updateddate` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`patientinfusionid`) USING BTREE,
  KEY `patient` (`patient`),
  KEY `preparedby` (`preparedby`),
  CONSTRAINT `patientinfusion_ibfk_1` FOREIGN KEY (`patient`) REFERENCES `patient` (`patientid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `patientinfusion_ibfk_2` FOREIGN KEY (`preparedby`) REFERENCES `user` (`userid`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


CREATE TABLE IF NOT EXISTS `patientivfluid` (
  `patientivfluidid` int(11) NOT NULL AUTO_INCREMENT,
  `patient` int(11) NOT NULL,
  `ivfluid` int(11) NOT NULL,
  `rate` varchar(50) DEFAULT NULL,
  `additionaldrugs` varchar(2000) DEFAULT NULL,
  `createdby` int(11) NOT NULL,
  `createddate` datetime DEFAULT current_timestamp(),
  `updatedby` int(11) DEFAULT NULL,
  `updateddate` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`patientivfluidid`) USING BTREE,
  KEY `patient` (`patient`),
  KEY `ivfluid` (`ivfluid`),
  CONSTRAINT `patientivfluid_ibfk_1` FOREIGN KEY (`patient`) REFERENCES `patient` (`patientid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `patientivfluid_ibfk_2` FOREIGN KEY (`ivfluid`) REFERENCES `ivfluid` (`ivfluidid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `patientivfluid` (`patientivfluidid`, `patient`, `ivfluid`, `rate`, `additionaldrugs`, `createdby`, `createddate`, `updatedby`, `updateddate`) VALUES
	(1, 41, 1, 'dhdh', 'hsh', 0, '2025-06-19 13:53:10', 0, NULL);

CREATE TABLE IF NOT EXISTS `patientlinestubes` (
  `patientlinestubesid` int(11) NOT NULL AUTO_INCREMENT,
  `patientdaysheet` int(11) NOT NULL,
  `linestubes` int(11) NOT NULL,
  `dateofinsertion` datetime DEFAULT NULL,
  `site` varchar(50) DEFAULT NULL,
  `createdby` int(11) NOT NULL,
  `createddate` datetime DEFAULT current_timestamp(),
  `updatedby` int(11) DEFAULT NULL,
  `updateddate` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`patientlinestubesid`) USING BTREE,
  KEY `patientdaysheet` (`patientdaysheet`),
  KEY `linestubes` (`linestubes`),
  CONSTRAINT `patientlinestubes_ibfk_1` FOREIGN KEY (`patientdaysheet`) REFERENCES `patientdaysheet` (`patientdaysheetid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `patientlinestubes_ibfk_2` FOREIGN KEY (`linestubes`) REFERENCES `linestubes` (`linestubesid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `patientlinestubes` (`patientlinestubesid`, `patientdaysheet`, `linestubes`, `dateofinsertion`, `site`, `createdby`, `createddate`, `updatedby`, `updateddate`) VALUES
	(1, 1, 2, '3478-03-12 05:30:00', 'sddjd', 0, '2025-06-18 14:54:51', 0, NULL);

CREATE TABLE IF NOT EXISTS `patientmedicationchart` (
  `patientmedicationchartid` int(11) NOT NULL AUTO_INCREMENT,
  `patientadmission` int(11) NOT NULL,
  `drug` varchar(50) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `dose` varchar(200) DEFAULT NULL,
  `route` varchar(200) DEFAULT NULL,
  `frequency` varchar(200) DEFAULT NULL,
  `createdby` int(11) NOT NULL,
  `createddate` datetime DEFAULT current_timestamp(),
  `updatedby` int(11) DEFAULT NULL,
  `updateddate` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`patientmedicationchartid`) USING BTREE,
  KEY `patientadmission` (`patientadmission`),
  CONSTRAINT `patientmedicationchart_ibfk_1` FOREIGN KEY (`patientadmission`) REFERENCES `patientadmission` (`patientadmissionid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `patientmedicationchart` (`patientmedicationchartid`, `patientadmission`, `drug`, `date`, `dose`, `route`, `frequency`, `createdby`, `createddate`, `updatedby`, `updateddate`) VALUES
	(1, 11, '', '4566-03-12', '', '', '', 0, '2025-06-16 00:03:40', 0, NULL),
	(2, 11, '', '4566-03-12', '', '', '', 0, '2025-06-17 19:41:23', 0, NULL);

CREATE TABLE IF NOT EXISTS `patientmedicationlog` (
  `patientmedicationlogid` int(11) NOT NULL AUTO_INCREMENT,
  `patientmedicationchart` int(11) NOT NULL,
  `drug` varchar(50) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `dose` varchar(200) DEFAULT NULL,
  `route` varchar(200) DEFAULT NULL,
  `administeredby` int(11) NOT NULL,
  `Administrationtime` datetime DEFAULT current_timestamp(),
  `createdby` int(11) NOT NULL,
  `createddate` datetime DEFAULT current_timestamp(),
  `updatedby` int(11) DEFAULT NULL,
  `updateddate` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`patientmedicationlogid`) USING BTREE,
  KEY `patientmedicationchart` (`patientmedicationchart`),
  KEY `administeredby` (`administeredby`),
  CONSTRAINT `patientmedicationlog_ibfk_1` FOREIGN KEY (`patientmedicationchart`) REFERENCES `patientmedicationchart` (`patientmedicationchartid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `patientmedicationlog_ibfk_2` FOREIGN KEY (`administeredby`) REFERENCES `user` (`userid`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `patientmedicationlog` (`patientmedicationlogid`, `patientmedicationchart`, `drug`, `date`, `dose`, `route`, `administeredby`, `Administrationtime`, `createdby`, `createddate`, `updatedby`, `updateddate`) VALUES
	(1, 2, 'jjdj', '4566-03-12', 'jaak', 'aj', 1, NULL, 1, '2025-06-18 13:27:56', 0, NULL),
	(2, 1, 'hdhd', '4566-03-12', 'ss', 'sjs', 1, NULL, 1, '2025-06-18 13:33:24', 0, NULL),
	(3, 1, 'djdj', '4566-03-12', 'jaa', 'jaja', 1, NULL, 1, '2025-06-18 13:34:05', 0, NULL),
	(4, 2, 'jsjs', '4566-03-12', 'ajaj', 'akk', 1, NULL, 1, '2025-06-18 13:39:55', 0, NULL),
	(5, 2, 'djd', '4566-03-12', 'ajak', 'akao', 1, NULL, 1, '2025-06-18 13:41:55', 0, NULL),
	(6, 1, ' ddnn', '4566-03-12', 'amam', 'ssj', 1, '2025-06-18 23:00:00', 1, '2025-06-18 13:43:30', 0, NULL);

CREATE TABLE IF NOT EXISTS `patientsosmedication` (
  `patientsosmedicationid` int(11) NOT NULL AUTO_INCREMENT,
  `patient` int(11) NOT NULL,
  `indication` varchar(200) DEFAULT NULL,
  `drug` varchar(50) DEFAULT NULL,
  `dose` varchar(2000) DEFAULT NULL,
  `route` varchar(2000) DEFAULT NULL,
  `time` datetime DEFAULT current_timestamp(),
  `administeredby` int(11) NOT NULL,
  `orderedbydoctor` int(11) NOT NULL,
  `telephoneverbal` varchar(200) DEFAULT NULL,
  `createdby` int(11) NOT NULL,
  `createddate` datetime DEFAULT current_timestamp(),
  `updatedby` int(11) DEFAULT NULL,
  `updateddate` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`patientsosmedicationid`) USING BTREE,
  KEY `patient` (`patient`),
  KEY `administeredby` (`administeredby`),
  KEY `orderedbydoctor` (`orderedbydoctor`),
  CONSTRAINT `patientsosmedication_ibfk_1` FOREIGN KEY (`patient`) REFERENCES `patient` (`patientid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `patientsosmedication_ibfk_2` FOREIGN KEY (`administeredby`) REFERENCES `user` (`userid`) ON UPDATE CASCADE,
  CONSTRAINT `patientsosmedication_ibfk_3` FOREIGN KEY (`orderedbydoctor`) REFERENCES `user` (`userid`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


CREATE TABLE IF NOT EXISTS `patientventilator` (
  `patientventilatorid` int(11) NOT NULL AUTO_INCREMENT,
  `patientdaysheet` int(11) NOT NULL,
  `ventilatormode` int(11) NOT NULL,
  `fio2` decimal(20,6) DEFAULT NULL,
  `peepcpap` decimal(20,6) DEFAULT NULL,
  `rate` decimal(20,6) DEFAULT NULL,
  `tv` decimal(20,6) DEFAULT NULL,
  `ppeak` decimal(20,6) DEFAULT NULL,
  `mv` decimal(20,6) DEFAULT NULL,
  `spo2` decimal(20,6) DEFAULT NULL,
  `cuffpressure` decimal(20,6) DEFAULT NULL,
  `epap` decimal(20,6) DEFAULT NULL,
  `peakinsppressure` decimal(20,6) DEFAULT NULL,
  `plateaupressure` decimal(20,6) DEFAULT NULL,
  `createdby` int(11) NOT NULL,
  `createddate` datetime DEFAULT current_timestamp(),
  `updatedby` int(11) DEFAULT NULL,
  `updateddate` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`patientventilatorid`) USING BTREE,
  KEY `patientdaysheet` (`patientdaysheet`),
  KEY `ventilatormode` (`ventilatormode`),
  CONSTRAINT `patientventilator_ibfk_1` FOREIGN KEY (`patientdaysheet`) REFERENCES `patientdaysheet` (`patientdaysheetid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `patientventilator_ibfk_2` FOREIGN KEY (`ventilatormode`) REFERENCES `ventilatormode` (`ventilatormodeid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `patientventilator` (`patientventilatorid`, `patientdaysheet`, `ventilatormode`, `fio2`, `peepcpap`, `rate`, `tv`, `ppeak`, `mv`, `spo2`, `cuffpressure`, `epap`, `peakinsppressure`, `plateaupressure`, `createdby`, `createddate`, `updatedby`, `updateddate`) VALUES
	(1, 1, 1, 22.000000, 22.000000, 44.000000, 44.000000, 44.000000, 55.000000, 33.000000, 22.000000, 33.000000, 44.000000, 55.000000, 0, '2025-06-18 23:29:20', 0, NULL);

CREATE TABLE IF NOT EXISTS `physiothearpy` (
  `physiothearpyid` int(11) NOT NULL AUTO_INCREMENT,
  `physiothearpy` varchar(200) NOT NULL,
  `createdby` int(11) NOT NULL,
  `createddate` datetime DEFAULT current_timestamp(),
  `updatedby` int(11) DEFAULT NULL,
  `updateddate` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`physiothearpyid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `physiothearpy` (`physiothearpyid`, `physiothearpy`, `createdby`, `createddate`, `updatedby`, `updateddate`) VALUES
	(1, 'dhdjdjd', 0, '2025-06-18 19:01:00', 0, NULL),
	(2, 'kdkd', 0, '2025-06-18 19:01:24', 0, NULL);

CREATE TABLE IF NOT EXISTS `resettoken` (
  `resettokenid` int(11) NOT NULL AUTO_INCREMENT,
  `user` int(11) DEFAULT NULL,
  `token` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  PRIMARY KEY (`resettokenid`) USING BTREE,
  KEY `user` (`user`) USING BTREE,
  CONSTRAINT `FK_resettoken_users` FOREIGN KEY (`user`) REFERENCES `user` (`userid`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;


CREATE TABLE IF NOT EXISTS `rmonurselog` (
  `rmonurselogid` int(11) NOT NULL AUTO_INCREMENT,
  `patientdaysheet` int(11) NOT NULL,
  `datetime` datetime DEFAULT NULL,
  `rmonurse` int(11) DEFAULT NULL,
  `createdby` int(11) NOT NULL,
  `createddate` datetime DEFAULT current_timestamp(),
  `updatedby` int(11) DEFAULT NULL,
  `updateddate` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`rmonurselogid`) USING BTREE,
  KEY `patientdaysheet` (`patientdaysheet`),
  KEY `rmonurse` (`rmonurse`),
  CONSTRAINT `rmonurselog_ibfk_1` FOREIGN KEY (`patientdaysheet`) REFERENCES `patientdaysheet` (`patientdaysheetid`) ON UPDATE CASCADE,
  CONSTRAINT `rmonurselog_ibfk_2` FOREIGN KEY (`rmonurse`) REFERENCES `user` (`userid`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


CREATE TABLE IF NOT EXISTS `role` (
  `roleid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `rolecode` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `division` int(11) DEFAULT NULL,
  `active` int(1) DEFAULT NULL,
  `createdby` int(11) NOT NULL,
  `createddate` datetime DEFAULT current_timestamp(),
  `updatedby` int(11) DEFAULT NULL,
  `updateddate` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`roleid`) USING BTREE,
  KEY `FK_role_division` (`division`) USING BTREE,
  CONSTRAINT `FK_role_division` FOREIGN KEY (`division`) REFERENCES `division` (`divisionid`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;

INSERT INTO `role` (`roleid`, `name`, `rolecode`, `description`, `division`, `active`, `createdby`, `createddate`, `updatedby`, `updateddate`) VALUES
	(1, 'ICU Director', 'ICU_DIR', 'Head of ICU department', 1, 1, 1, '2025-06-08 17:34:02', 1, '2025-06-08 17:34:02'),
	(2, 'Consultant', 'ICU_ATT', 'Consultant of ICU', 1, 1, 1, '2025-06-08 17:34:02', 1, '2025-06-17 22:19:57'),
	(3, 'ICU Resident', 'ICU_RES', 'Junior doctor in ICU', 1, 1, 1, '2025-06-08 17:34:02', 1, '2025-06-08 17:34:02'),
	(4, 'ICU Nurse Manager', 'ICU_NM', 'Head ICU nurse', 1, 1, 1, '2025-06-08 17:34:02', 1, '2025-06-08 17:34:02'),
	(5, 'ICU Staff Nurse', 'ICU_SN', 'Regular ICU nurse', 1, 1, 1, '2025-06-08 17:34:02', 1, '2025-06-08 17:34:02'),
	(6, 'ICU Respiratory Therapist', 'ICU_RT', 'Specialist for ventilator management', 1, 1, 1, '2025-06-08 17:34:02', 1, '2025-06-08 17:34:02'),
	(7, 'Cardiac Intensivist', 'CICU_DR', 'Specialist cardiac ICU doctor', 3, 1, 1, '2025-06-08 17:34:02', 1, '2025-06-08 17:34:02'),
	(8, 'Cardiac ICU Nurse', 'CICU_NUR', 'Nurse specialized in cardiac care', 3, 1, 1, '2025-06-08 17:34:02', 1, '2025-06-08 17:34:02'),
	(9, 'ECMO Specialist', 'ECMO_SP', 'Specialist for ECMO machines', 3, 1, 1, '2025-06-08 17:34:02', 1, '2025-06-08 17:34:02'),
	(10, 'Neonatologist', 'NICU_DR', 'Specialist for newborn care', 4, 1, 1, '2025-06-08 17:34:02', 1, '2025-06-08 17:34:02'),
	(11, 'NICU Nurse', 'NICU_NUR', 'Nurse specialized in neonatal care', 4, 1, 1, '2025-06-08 17:34:02', 1, '2025-06-08 17:34:02'),
	(12, 'Developmental Specialist', 'NICU_DEV', 'Specialist for infant development', 4, 1, 1, '2025-06-08 17:34:02', 1, '2025-06-08 17:34:02'),
	(16, 'Adminstrative', 'ICU_ADM', 'admin', 3, 1, 1, '2025-06-17 19:48:42', NULL, '2025-06-17 19:48:42'),
	(17, 'doctor', 'ICU_DOC', 'Doctor of ICU department', 1, 1, 1, '2025-06-20 13:50:17', 1, '2025-06-20 13:50:17');

CREATE TABLE IF NOT EXISTS `roleaccess` (
  `roleaccessid` int(11) NOT NULL AUTO_INCREMENT,
  `role` int(11) NOT NULL,
  `menu` int(11) DEFAULT NULL,
  `ionicmenu` int(11) DEFAULT NULL,
  `createdby` int(11) NOT NULL,
  `createddate` datetime DEFAULT current_timestamp(),
  `updatedby` int(11) DEFAULT NULL,
  `updateddate` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`roleaccessid`) USING BTREE,
  KEY `FK_role_access_role` (`role`) USING BTREE,
  KEY `FK_role_access_menu_details` (`menu`) USING BTREE,
  CONSTRAINT `FK_roleaccess_menudetails` FOREIGN KEY (`menu`) REFERENCES `menudetails` (`menuid`) ON UPDATE CASCADE,
  CONSTRAINT `FK_roleaccess_role` FOREIGN KEY (`role`) REFERENCES `role` (`roleid`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;


CREATE TABLE IF NOT EXISTS `shiftrmonurse` (
  `shiftrmonurseid` int(11) NOT NULL AUTO_INCREMENT,
  `icu` int(11) NOT NULL,
  `date` date DEFAULT NULL,
  `shift` int(11) NOT NULL,
  `rmo` int(11) NOT NULL,
  `nurse` int(11) NOT NULL,
  `createdby` int(11) NOT NULL,
  `createddate` datetime DEFAULT current_timestamp(),
  `updatedby` int(11) DEFAULT NULL,
  `updateddate` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`shiftrmonurseid`) USING BTREE,
  KEY `icu` (`icu`),
  KEY `rmo` (`rmo`),
  KEY `nurse` (`nurse`),
  CONSTRAINT `shiftrmonurse_ibfk_1` FOREIGN KEY (`icu`) REFERENCES `icu` (`icuid`) ON UPDATE CASCADE,
  CONSTRAINT `shiftrmonurse_ibfk_2` FOREIGN KEY (`rmo`) REFERENCES `user` (`userid`) ON UPDATE CASCADE,
  CONSTRAINT `shiftrmonurse_ibfk_3` FOREIGN KEY (`nurse`) REFERENCES `user` (`userid`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


CREATE TABLE IF NOT EXISTS `user` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `mobileno` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `active` int(1) DEFAULT NULL,
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `createdby` int(11) NOT NULL,
  `createddate` datetime DEFAULT current_timestamp(),
  `updatedby` int(11) DEFAULT NULL,
  `updateddate` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`userid`) USING BTREE,
  KEY `FK_users_users` (`createdby`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;

INSERT INTO `user` (`userid`, `name`, `id`, `mobileno`, `email`, `active`, `username`, `password`, `createdby`, `createddate`, `updatedby`, `updateddate`) VALUES
	(1, 'Jayraj Kiran Malge', '1', '9175772990', 'jayrajmalge@gmail.com', 1, 'jayrajmalge', '#', 1, '2025-06-08 17:24:21', 1, '2025-06-08 17:24:21'),
	(2, 'Alice Carter', '2', '2340987654', 'alice@gmail.com', 1, 'alice', '#', 1, '2025-06-08 19:54:33', 1, '2025-06-08 19:54:33'),
	(3, 'John Wingerson', '3', '2334987654', 'johnwingerson@gmail.com', 1, 'johnwing', '#', 1, '2025-06-08 19:56:48', 1, '2025-06-08 19:56:48'),
	(4, 'rehen domstekchin', '1', '9175772990', 'rehendomstekchi@gmail.com', 1, 'rehendomstekchi', '#', 1, '2025-06-08 17:24:21', 1, '2025-06-08 17:24:21');

CREATE TABLE IF NOT EXISTS `userrole` (
  `userroleid` int(11) NOT NULL AUTO_INCREMENT,
  `user` int(11) NOT NULL,
  `role` int(11) NOT NULL,
  `active` int(1) NOT NULL,
  `createdby` int(11) NOT NULL,
  `createddate` datetime DEFAULT current_timestamp(),
  `updatedby` int(11) DEFAULT NULL,
  `updateddate` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`userroleid`) USING BTREE,
  KEY `FK_userrole_role` (`role`) USING BTREE,
  KEY `FK_userrole_users` (`user`) USING BTREE,
  CONSTRAINT `FK_userrole_role` FOREIGN KEY (`role`) REFERENCES `role` (`roleid`) ON UPDATE CASCADE,
  CONSTRAINT `FK_userrole_users` FOREIGN KEY (`user`) REFERENCES `user` (`userid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;

INSERT INTO `userrole` (`userroleid`, `user`, `role`, `active`, `createdby`, `createddate`, `updatedby`, `updateddate`) VALUES
	(1, 1, 2, 1, 1, '2025-06-08 17:40:33', 1, '2025-06-08 17:40:33'),
	(2, 1, 3, 1, 1, '2025-06-08 17:40:43', 1, '2025-06-08 17:40:43'),
	(3, 2, 2, 1, 1, '2025-06-08 19:59:14', 1, '2025-06-08 19:59:14'),
	(4, 3, 2, 1, 1, '2025-06-08 19:59:24', 1, '2025-06-08 19:59:24'),
	(5, 1, 16, 1, 1, '2025-06-18 10:24:06', NULL, '2025-06-18 10:24:06'),
	(6, 4, 17, 1, 1, '2025-06-20 13:47:00', NULL, '2025-06-20 13:50:46');

CREATE TABLE IF NOT EXISTS `usertoken` (
  `usertokenid` int(11) NOT NULL AUTO_INCREMENT,
  `user` int(11) DEFAULT NULL,
  `token` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `fcmtoken` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `datetime` datetime DEFAULT NULL,
  PRIMARY KEY (`usertokenid`) USING BTREE,
  KEY `logindetails` (`user`) USING BTREE,
  CONSTRAINT `FK_usertoken_users` FOREIGN KEY (`user`) REFERENCES `user` (`userid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;


CREATE TABLE IF NOT EXISTS `ventilatormode` (
  `ventilatormodeid` int(11) NOT NULL AUTO_INCREMENT,
  `ventilatormode` varchar(50) DEFAULT NULL,
  `active` int(11) DEFAULT NULL,
  `createdby` int(11) NOT NULL,
  `createddate` datetime DEFAULT current_timestamp(),
  `updatedby` int(11) DEFAULT NULL,
  `updateddate` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`ventilatormodeid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `ventilatormode` (`ventilatormodeid`, `ventilatormode`, `active`, `createdby`, `createddate`, `updatedby`, `updateddate`) VALUES
	(1, 'dhdhdj', 1, 0, '2025-06-18 23:01:59', 0, NULL);

CREATE TABLE IF NOT EXISTS `vital` (
  `vitalid` int(11) NOT NULL AUTO_INCREMENT,
  `vitalname` varchar(50) DEFAULT NULL,
  `vitalcategory` varchar(50) DEFAULT NULL,
  `active` int(11) DEFAULT NULL,
  `categorysortorder` int(11) DEFAULT NULL,
  `sortorder` int(11) DEFAULT NULL,
  `createdby` int(11) NOT NULL,
  `createddate` datetime DEFAULT current_timestamp(),
  `updatedby` int(11) DEFAULT NULL,
  `updateddate` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`vitalid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO `vital` (`vitalid`, `vitalname`, `vitalcategory`, `active`, `categorysortorder`, `sortorder`, `createdby`, `createddate`, `updatedby`, `updateddate`) VALUES
	(1, 'Temperture', 'vital', 0, 100, 100, 0, '2025-06-15 14:07:30', 0, NULL),
	(2, 'Pulse', 'vital', 0, 100, 100, 0, '2025-06-15 20:00:43', 0, NULL),
	(3, 'Pulse Volume', 'vital', 0, 100, 100, 0, '2025-06-15 20:01:01', 0, NULL),
	(4, 'Heart Rate', 'CVC', 0, 100, 100, 0, '2025-06-15 20:01:58', 0, NULL),
	(5, 'MAP', 'CVC', 0, 100, 100, 0, '2025-06-15 20:02:17', 0, NULL),
	(6, 'Systolic BP (mmHg)', 'vital', 0, 100, 100, 0, '2025-06-15 21:53:56', 0, NULL);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
