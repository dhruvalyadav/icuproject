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
  CONSTRAINT `anthropometry_ibfk_1` FOREIGN KEY (`patient`) REFERENCES `patient` (`patientid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;


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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


CREATE TABLE IF NOT EXISTS `icu` (
  `icuid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `active` int(11) DEFAULT NULL,
  `createdby` int(11) NOT NULL,
  `createddate` datetime DEFAULT current_timestamp(),
  `updatedby` int(11) DEFAULT NULL,
  `updateddate` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`icuid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


CREATE TABLE IF NOT EXISTS `ivfluid` (
  `ivfluidid` int(11) NOT NULL AUTO_INCREMENT,
  `ivfluidname` int(11) NOT NULL,
  `active` int(11) DEFAULT NULL,
  `createdby` int(11) NOT NULL,
  `createddate` datetime DEFAULT current_timestamp(),
  `updatedby` int(11) DEFAULT NULL,
  `updateddate` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`ivfluidid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


CREATE TABLE IF NOT EXISTS `linestubes` (
  `linestubesid` int(11) NOT NULL AUTO_INCREMENT,
  `linestubesname` int(11) NOT NULL,
  `active` int(11) DEFAULT NULL,
  `createdby` int(11) NOT NULL,
  `createddate` datetime DEFAULT current_timestamp(),
  `updatedby` int(11) DEFAULT NULL,
  `updateddate` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`linestubesid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


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
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;

INSERT INTO `menudetails` (`menuid`, `mainname`, `subname`, `link`, `classname`, `mainsort`, `subsort`, `active`, `ionicactive`, `mainicon`, `subicon`, `ionicdashboardicon`, `createdby`, `createddate`, `updatedby`, `updateddate`) VALUES
	(1, 'Dashboard', '', '/dashboard', 'Dashboard', 1, NULL, 1, 1, 'dashboard', NULL, NULL, 1, '2025-06-01 22:33:03', 1, '2025-06-01 22:33:03'),
	(2, 'Quick Analysis', '', '/quick analysis', 'quick-analysis', 2, NULL, 1, 1, 'monitor', NULL, NULL, 1, '2025-06-01 22:36:29', 1, '2025-06-01 22:36:29'),
	(3, 'Hourly Record', 'vitals', '/vitals', 'hour-record', 3, 1, 1, 1, 'monitor_heart', 'monitor_heart', NULL, 1, '2025-06-01 22:43:20', 1, '2025-06-01 22:43:20'),
	(4, 'Hourly Record', 'CVC', '/CVC', 'hour-record', 3, 2, 1, 1, 'monitor_heart', 'favorite', NULL, 1, '2025-06-01 22:45:08', 1, '2025-06-01 22:45:08'),
	(5, 'Hourly Record', 'CNS', '/CNS', 'hour-record', 3, 3, 1, 1, 'monitor_heart', 'psychology', NULL, 1, '2025-06-01 22:45:44', 1, '2025-06-01 22:45:44'),
	(6, 'Hourly Record', 'Pupil', '/Pupil', 'hour-record', 3, 4, 1, 1, 'monitor_heart', 'visibility', NULL, 1, '2025-06-01 22:46:06', 1, '2025-06-02 13:11:04'),
	(7, 'Hourly Record', 'Intake', '/Intake', 'hour-record', 3, 5, 1, 1, 'monitor_heart', 'invert_colors', NULL, 1, '2025-06-01 22:46:27', 1, '2025-06-02 13:11:47'),
	(8, 'Hourly Record', 'Output', '/Output', 'hour-record', 3, 6, 1, 1, 'monitor_heart', 'device_thermostat', NULL, 1, '2025-06-01 22:47:03', 1, '2025-06-01 22:47:16'),
	(9, 'Patient details', 'anthropometry', '/patient/anthropometry', 'Patient-details', 4, 1, 1, 1, 'personal_injury', 'straighten', NULL, 1, '2025-06-01 23:01:19', 1, '2025-06-01 23:01:19'),
	(10, 'Patient details', 'edit', '/patient/edit', 'Patient-details', 4, 2, 1, 1, 'personal_injury', 'edit_note', NULL, 1, '2025-06-01 23:06:15', 1, '2025-06-01 23:06:15'),
	(11, 'Patient details', 'admission', '/patient/admission', 'Patient-details', 4, 3, 1, 1, 'personal_injury', 'person_add', NULL, 1, '2025-06-01 23:25:28', 1, '2025-06-01 23:25:28'),
	(12, 'Patient details', 'daysheet', '/patient/daysheet', 'Patient-details', 4, 4, 1, 1, 'personal_injury', 'today', NULL, 1, '2025-06-01 23:27:19', 1, '2025-06-01 23:27:19'),
	(13, 'Physiotheropy', '', '/physiotheropy', 'Physiotheropy', 5, NULL, 1, 1, 'directions_run', NULL, NULL, 1, '2025-06-02 00:27:36', 1, '2025-06-02 00:27:36'),
	(14, 'Dailysheet', 'Hourly Observation', '/daysheet/HourlyObservation', 'HourlyObservation', 6, 1, 1, 1, 'view_day', 'monitor_heart', NULL, 1, '2025-06-02 00:35:56', 1, '2025-06-02 00:35:56'),
	(15, 'Dailysheet', 'Patient Score', '/daysheet/PatientScore', 'Patient Score', 6, 2, 1, 1, 'view_day', 'score', NULL, 1, '2025-06-02 00:38:12', 1, '2025-06-02 00:38:12'),
	(16, 'Dailysheet', 'Patient Test', '/daysheet/PatientTest', 'PatientTest', 6, 3, 1, 1, 'view_day', 'science', NULL, 1, '2025-06-02 00:39:33', 1, '2025-06-02 00:39:45'),
	(17, 'Dailysheet', 'Embolism', '/daysheet/embolism', 'Embolism', 6, 4, 1, 1, 'view_day', 'coronavirus', NULL, 1, '2025-06-02 00:40:46', 1, '2025-06-02 00:40:46'),
	(18, 'Patient Admission Details', 'Patient Medication Chart', '/daysheet/PatientMedicationChart', 'PatientMedicationChart', 7, 1, 1, 1, 'assignment_ind', 'insert_chart', NULL, 1, '2025-06-02 00:43:01', 1, '2025-06-02 00:43:01'),
	(19, 'Patient Admission Details', 'Patient Medication log', '/daysheet/PatientMedicationLog', 'PatientMedicationLog', 7, 2, 1, 1, 'assignment_ind', 'history', NULL, 1, '2025-06-02 00:43:50', 1, '2025-06-02 00:43:50'),
	(20, 'Ventilator', 'Ventilator mode', '/daysheet/VentilatorMode', 'VentilatorMode', 8, 1, 1, 1, 'assignment_ind', 'settings_input_hdmi', NULL, 1, '2025-06-02 00:45:26', 1, '2025-06-02 00:47:15'),
	(21, 'Ventilator', 'Patient Ventilator', '/daysheet/PatientVentilator', 'PatientVentilator', 8, 2, 1, 1, 'assignment_ind', 'air', NULL, 1, '2025-06-02 00:47:27', 1, '2025-06-02 00:48:12'),
	(22, 'Patient SOS Medication', '', '/daysheet/PatientSOSMedication', 'PatientSOSMedication', 9, NULL, 1, 1, 'emergency', NULL, NULL, 1, '2025-06-02 00:50:16', 1, '2025-06-02 00:54:37'),
	(23, 'Lines and Tubes', 'Patient Lines Tubes', '/patient/Patientlinestubes', 'Patientlinestubes', 10, 1, 1, 1, 'plumbing', 'healing', NULL, 1, '2025-06-02 00:54:43', 1, '2025-06-02 00:54:43'),
	(24, 'IV Fulid', 'Patient IV Fulid', '/patient/PatientIVFulid', 'PatientIVFulid', 11, 1, 1, 1, 'IV', 'invert_colors', NULL, 1, '2025-06-02 00:56:46', 1, '2025-06-02 00:56:46'),
	(25, 'ICU', 'Shiftt RMO nurse', '/patient/ShifttRMOnurse', 'ShifttRMOnurse', 12, 1, 1, 1, 'local_hospital', 'group_work', NULL, 1, '2025-06-02 00:59:53', 1, '2025-06-02 13:09:58'),
	(26, 'Patient Infusion', '', '/patient/PatientInfusion', 'PatientInfusion', 13, NULL, 1, 1, 'IV', NULL, NULL, 1, '2025-06-02 01:01:35', 1, '2025-06-02 01:02:16'),
	(27, 'RMO Nursely', '', '/patient/RMONursely', 'RMONursely', 14, NULL, 1, 1, 'badge', NULL, NULL, 1, '2025-06-02 01:09:47', 1, '2025-06-02 01:09:47'),
	(28, 'Consultant Patient Visit', '', '/patient/ConsultantPatientVisit', 'ConsultantPatientVisit', 15, NULL, 1, 1, 'supervised_user_circle', NULL, NULL, 1, '2025-06-02 01:11:03', 1, '2025-06-02 01:11:03'),
	(29, 'Lines and Tubes', 'Edit Lines Tubes', '/patient/EditLinesTubes', 'EditLinesTubes', 10, 2, 1, 1, 'plumbing', 'edit', NULL, 1, '2025-06-02 01:15:19', 1, '2025-06-02 01:15:19'),
	(30, 'IV Fulid', 'Edit IV Fulid', '/patient/IVFluid', 'IVFluid', 11, 2, 1, 1, 'IV', 'mode_edit', NULL, 1, '2025-06-02 01:16:41', 1, '2025-06-02 01:16:41'),
	(31, 'ICU', 'ICU', '/patient/ICU', 'ICU', 12, 2, 1, 1, 'local_hospital', 'air', NULL, 1, '2025-06-02 01:18:51', 1, '2025-06-02 13:10:01');

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


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
  CONSTRAINT `patientadmission_ibfk_1` FOREIGN KEY (`patient`) REFERENCES `patient` (`patientid`) ON UPDATE CASCADE,
  CONSTRAINT `patientadmission_ibfk_2` FOREIGN KEY (`icu`) REFERENCES `icu` (`icuid`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


CREATE TABLE IF NOT EXISTS `physiothearpy` (
  `physiothearpyid` int(11) NOT NULL AUTO_INCREMENT,
  `physiothearpy` varchar(200) NOT NULL,
  `createdby` int(11) NOT NULL,
  `createddate` datetime DEFAULT current_timestamp(),
  `updatedby` int(11) DEFAULT NULL,
  `updateddate` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`physiothearpyid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;


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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;


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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;


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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
