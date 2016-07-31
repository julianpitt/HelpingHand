DROP SCHEMA IF EXISTS helperhand;
CREATE SCHEMA helperhand;
USE helperhand;

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `helperhand`
--

-- --------------------------------------------------------

--
-- Table structure for table `GovState`
--

CREATE TABLE `GovState` (
  `ID` int(10) NOT NULL,
  `StateName` varchar(50) NOT NULL,
  `Latitude` decimal(10,6) NOT NULL,
  `Longitude` decimal(10,6) NOT NULL,
  `Zoom` int(2) DEFAULT '8'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Locality`
--

CREATE TABLE `Locality` (
  `ID` int(10) NOT NULL,
  `LocalityName` varchar(100) NOT NULL,
  `LocalityDesc` varchar(255) DEFAULT NULL,
  `Latitude` decimal(10,6) NOT NULL,
  `Longitude` decimal(10,6) NOT NULL,
  `Zoom` int(2) DEFAULT '10',
  `StateID` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `LocalityTrend`
--

CREATE TABLE `LocalityTrend` (
  `ID` int(10) NOT NULL,
  `TrendTypeID` int(10) NOT NULL,
  `VALUE` decimal(10,0) DEFAULT NULL,
  `Start_dttm` datetime NOT NULL,
  `End_dttm` datetime NOT NULL,
  `LocalityID` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `LocalityUsage`
--

CREATE TABLE `LocalityUsage` (
  `ID` int(10) NOT NULL,
  `UsageTypeID` int(10) NOT NULL,
  `VALUE` decimal(10,0) DEFAULT NULL,
  `LocalityID` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `StateTrend`
--

CREATE TABLE `StateTrend` (
  `ID` int(10) NOT NULL,
  `TrendTypeID` int(10) NOT NULL,
  `VALUE` decimal(10,0) DEFAULT NULL,
  `Start_dttm` datetime NOT NULL,
  `End_dttm` datetime NOT NULL,
  `StateID` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `StateUsage`
--

CREATE TABLE `StateUsage` (
  `ID` int(10) NOT NULL,
  `UsageTypeID` int(10) NOT NULL,
  `VALUE` decimal(10,0) DEFAULT NULL,
  `StateID` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Street`
--

CREATE TABLE `Street` (
  `ID` int(10) NOT NULL,
  `StreetName` varchar(170) NOT NULL,
  `StreetType` varchar(100) DEFAULT NULL,
  `StreetDesc` varchar(255) DEFAULT NULL,
  `Latitude` decimal(10,6) NOT NULL,
  `Longitude` decimal(10,6) NOT NULL,
  `Zoom` int(2) DEFAULT '15',
  `SuburbID` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `StreetTrend`
--

CREATE TABLE `StreetTrend` (
  `ID` int(10) NOT NULL,
  `TrendTypeID` int(10) NOT NULL,
  `VALUE` decimal(10,0) DEFAULT NULL,
  `Start_dttm` datetime NOT NULL,
  `End_dttm` datetime NOT NULL,
  `StreetID` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `StreetUsage`
--

CREATE TABLE `StreetUsage` (
  `ID` int(10) NOT NULL,
  `UsageTypeID` int(10) NOT NULL,
  `VALUE` decimal(10,0) DEFAULT NULL,
  `StreetID` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `Suburb`
--

CREATE TABLE `Suburb` (
  `ID` int(10) NOT NULL,
  `SuburbName` varchar(100) NOT NULL,
  `SuburbDesc` varchar(255) DEFAULT NULL,
  `PostCode` varchar(5) DEFAULT NULL,
  `Latitude` decimal(10,6) NOT NULL,
  `Longitude` decimal(10,6) NOT NULL,
  `Zoom` int(2) DEFAULT '12',
  `LocalityID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `SuburbTrend`
--

CREATE TABLE `SuburbTrend` (
  `ID` int(10) NOT NULL,
  `TrendTypeID` int(10) NOT NULL,
  `VALUE` decimal(10,0) DEFAULT NULL,
  `Start_dttm` datetime NOT NULL,
  `End_dttm` datetime NOT NULL,
  `SuburbID` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `SuburbUsage`
--

CREATE TABLE `SuburbUsage` (
  `ID` int(10) NOT NULL,
  `UsageTypeID` int(10) NOT NULL,
  `VALUE` decimal(10,0) DEFAULT NULL,
  `SuburbID` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `TrendType`
--

CREATE TABLE `TrendType` (
  `ID` int(10) NOT NULL,
  `TrendTypeCode` varchar(6) DEFAULT NULL,
  `TrendTypeDesc` varchar(255) DEFAULT NULL,
  `Create_dttm` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `UsageType`
--

CREATE TABLE `UsageType` (
  `ID` int(10) NOT NULL,
  `UsageTypeCode` varchar(6) NOT NULL,
  `UsageTypeDesc` varchar(255) NOT NULL,
  `Archv_flag` varchar(1) DEFAULT 'N',
  `created_dttm` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `GovState`
--
ALTER TABLE `GovState`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `Locality`
--
ALTER TABLE `Locality`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `StateID` (`StateID`);

--
-- Indexes for table `LocalityTrend`
--
ALTER TABLE `LocalityTrend`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `TrendTypeID` (`TrendTypeID`),
  ADD KEY `LocalityID` (`LocalityID`);

--
-- Indexes for table `LocalityUsage`
--
ALTER TABLE `LocalityUsage`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `UsageTypeID` (`UsageTypeID`),
  ADD KEY `LocalityID` (`LocalityID`);

--
-- Indexes for table `StateTrend`
--
ALTER TABLE `StateTrend`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `TrendTypeID` (`TrendTypeID`),
  ADD KEY `StateID` (`StateID`);

--
-- Indexes for table `StateUsage`
--
ALTER TABLE `StateUsage`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `UsageTypeID` (`UsageTypeID`),
  ADD KEY `StateID` (`StateID`);

--
-- Indexes for table `Street`
--
ALTER TABLE `Street`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `SuburbID` (`SuburbID`);

--
-- Indexes for table `StreetTrend`
--
ALTER TABLE `StreetTrend`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `TrendTypeID` (`TrendTypeID`),
  ADD KEY `StreetID` (`StreetID`);

--
-- Indexes for table `StreetUsage`
--
ALTER TABLE `StreetUsage`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `UsageTypeID` (`UsageTypeID`),
  ADD KEY `StreetID` (`StreetID`);

--
-- Indexes for table `Suburb`
--
ALTER TABLE `Suburb`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `LocalityID` (`LocalityID`);

--
-- Indexes for table `SuburbTrend`
--
ALTER TABLE `SuburbTrend`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `TrendTypeID` (`TrendTypeID`),
  ADD KEY `SuburbID` (`SuburbID`);

--
-- Indexes for table `SuburbUsage`
--
ALTER TABLE `SuburbUsage`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `UsageTypeID` (`UsageTypeID`),
  ADD KEY `SuburbID` (`SuburbID`);

--
-- Indexes for table `TrendType`
--
ALTER TABLE `TrendType`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `UsageType`
--
ALTER TABLE `UsageType`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `GovState`
--
ALTER TABLE `GovState`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `Locality`
--
ALTER TABLE `Locality`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `LocalityTrend`
--
ALTER TABLE `LocalityTrend`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `LocalityUsage`
--
ALTER TABLE `LocalityUsage`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `StateTrend`
--
ALTER TABLE `StateTrend`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `StateUsage`
--
ALTER TABLE `StateUsage`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `Street`
--
ALTER TABLE `Street`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `StreetTrend`
--
ALTER TABLE `StreetTrend`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `StreetUsage`
--
ALTER TABLE `StreetUsage`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `Suburb`
--
ALTER TABLE `Suburb`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `SuburbTrend`
--
ALTER TABLE `SuburbTrend`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `SuburbUsage`
--
ALTER TABLE `SuburbUsage`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `TrendType`
--
ALTER TABLE `TrendType`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `UsageType`
--
ALTER TABLE `UsageType`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `Locality`
--
ALTER TABLE `Locality`
  ADD CONSTRAINT `Locality_ibfk_1` FOREIGN KEY (`StateID`) REFERENCES `GovState` (`ID`);

--
-- Constraints for table `LocalityTrend`
--
ALTER TABLE `LocalityTrend`
  ADD CONSTRAINT `LocalityTrend_ibfk_1` FOREIGN KEY (`TrendTypeID`) REFERENCES `TrendType` (`ID`),
  ADD CONSTRAINT `LocalityTrend_ibfk_2` FOREIGN KEY (`LocalityID`) REFERENCES `Locality` (`ID`);

--
-- Constraints for table `LocalityUsage`
--
ALTER TABLE `LocalityUsage`
  ADD CONSTRAINT `LocalityUsage_ibfk_1` FOREIGN KEY (`UsageTypeID`) REFERENCES `UsageType` (`ID`),
  ADD CONSTRAINT `LocalityUsage_ibfk_2` FOREIGN KEY (`LocalityID`) REFERENCES `Locality` (`ID`);

--
-- Constraints for table `StateTrend`
--
ALTER TABLE `StateTrend`
  ADD CONSTRAINT `StateTrend_ibfk_1` FOREIGN KEY (`TrendTypeID`) REFERENCES `TrendType` (`ID`),
  ADD CONSTRAINT `StateTrend_ibfk_2` FOREIGN KEY (`StateID`) REFERENCES `GovState` (`ID`);

--
-- Constraints for table `StateUsage`
--
ALTER TABLE `StateUsage`
  ADD CONSTRAINT `StateUsage_ibfk_1` FOREIGN KEY (`UsageTypeID`) REFERENCES `UsageType` (`ID`),
  ADD CONSTRAINT `StateUsage_ibfk_2` FOREIGN KEY (`StateID`) REFERENCES `GovState` (`ID`);

--
-- Constraints for table `Street`
--
ALTER TABLE `Street`
  ADD CONSTRAINT `Street_ibfk_1` FOREIGN KEY (`SuburbID`) REFERENCES `Suburb` (`ID`);

--
-- Constraints for table `StreetTrend`
--
ALTER TABLE `StreetTrend`
  ADD CONSTRAINT `StreetTrend_ibfk_1` FOREIGN KEY (`TrendTypeID`) REFERENCES `TrendType` (`ID`),
  ADD CONSTRAINT `StreetTrend_ibfk_2` FOREIGN KEY (`StreetID`) REFERENCES `Street` (`ID`);

--
-- Constraints for table `StreetUsage`
--
ALTER TABLE `StreetUsage`
  ADD CONSTRAINT `StreetUsage_ibfk_1` FOREIGN KEY (`UsageTypeID`) REFERENCES `UsageType` (`ID`),
  ADD CONSTRAINT `StreetUsage_ibfk_2` FOREIGN KEY (`StreetID`) REFERENCES `Street` (`ID`);

--
-- Constraints for table `Suburb`
--
ALTER TABLE `Suburb`
  ADD CONSTRAINT `Suburb_ibfk_1` FOREIGN KEY (`LocalityID`) REFERENCES `Locality` (`ID`);

--
-- Constraints for table `SuburbTrend`
--
ALTER TABLE `SuburbTrend`
  ADD CONSTRAINT `SuburbTrend_ibfk_1` FOREIGN KEY (`TrendTypeID`) REFERENCES `TrendType` (`ID`),
  ADD CONSTRAINT `SuburbTrend_ibfk_2` FOREIGN KEY (`SuburbID`) REFERENCES `Suburb` (`ID`);

--
-- Constraints for table `SuburbUsage`
--
ALTER TABLE `SuburbUsage`
  ADD CONSTRAINT `SuburbUsage_ibfk_1` FOREIGN KEY (`UsageTypeID`) REFERENCES `UsageType` (`ID`),
  ADD CONSTRAINT `SuburbUsage_ibfk_2` FOREIGN KEY (`SuburbID`) REFERENCES `Suburb` (`ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
