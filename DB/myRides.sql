-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema ridedb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `ridedb` ;

-- -----------------------------------------------------
-- Schema ridedb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ridedb` DEFAULT CHARACTER SET utf8 ;
USE `ridedb` ;

-- -----------------------------------------------------
-- Table `rides`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `rides` ;

CREATE TABLE IF NOT EXISTS `rides` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(450) NULL,
  `date` DATE NULL,
  `location` VARCHAR(45) NULL,
  `length` VARCHAR(45) NULL,
  `details` VARCHAR(4500) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS rideuser@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'rideuser'@'localhost' IDENTIFIED BY 'ride';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'rideuser'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `rides`
-- -----------------------------------------------------
START TRANSACTION;
USE `ridedb`;
INSERT INTO `rides` (`id`, `name`, `date`, `location`, `length`, `details`) VALUES (1, 'Copper Triangle', '2019-08-03', 'Copper Mountain', '79', 'Based at Copper Mountain in the heart of the Rockies, the famous Copper Triangle is a Colorado classic. This road sportive is graced with breathtaking scenery, gorgeous roads and three climbs over 10,000 feet, each with a timed segment.  Includes Colorado mountain passes – Fremont Pass (elevation 11,318’), Tennessee Pass (10,424’) and Vail Pass (10,662’) for a total elevation gain of 6,500 feet.');
INSERT INTO `rides` (`id`, `name`, `date`, `location`, `length`, `details`) VALUES (2, 'The Broadmoor Pikes Peak Hill Climb', '2019-08-10', 'Colorado Springs', '12', 'The final race of the Colorado Summit Series.  Includes competitive race and gran fondo divisions. Ride to the summit of Pikes Peak at 14,115 ft.  Closed road course which is fully supported');
INSERT INTO `rides` (`id`, `name`, `date`, `location`, `length`, `details`) VALUES (3, 'Big Mountain Enduro Finals', '2019-08-17', 'Aspen', '36', 'Aspen Snowmass will host the BME Finals for 2019. The two-day event will blend high altitude riding adventures mixed with some of the biggest descents and best riding in the area. Expect a heavy pro field and some new trail integrations. The combination of the Aspen Mountain and Snowmass Bike Park terrain and the surrounding trails within the valley, offer some of the most diverse mountain biking in the country.');
INSERT INTO `rides` (`id`, `name`, `date`, `location`, `length`, `details`) VALUES (4, 'Colorado Classic', '2019-08-22', 'Steamboat Springs', '54', 'The 2019 Colorado Classic will become the only women’s stand-alone stage race in the Western Hemisphere on the Union Cycliste Internationale (UCI) calendar and USA Cycling’s Pro Road Tour, organizers of the race announced today, while raising the bar for pro women’s cycling around the world.');
INSERT INTO `rides` (`id`, `name`, `date`, `location`, `length`, `details`) VALUES (5, 'VIDA MTB Series', '2019-08-17', 'Snowmass', '26', 'Saturdays in 2019 just got that much better! VIDA has returned to showcases epic Colorado towns. Visit the website for all event details. Saturday, April 27: Grand Junction Saturday, May 11: Boulder Saturday, June 1: Lakewood Saturday, August 17: Snowmass');
INSERT INTO `rides` (`id`, `name`, `date`, `location`, `length`, `details`) VALUES (6, 'The West Elk Bike Classic', '2019-09-01', 'Gunnison', '34', 'The West Elk Bicycle Classic covers country that should be felt up close, like on a bicycle. There are several options for most any rider. Do you want a shorter ride on the most beautiful road you’ll be on in some time? Try our 34 on the north rim of the Black Canyon of the Gunnison. This route can be shortened or lengthened as it is a supported out-and-back rid accessible to all ages and abilities!');
INSERT INTO `rides` (`id`, `name`, `date`, `location`, `length`, `details`) VALUES (7, 'Bicycle Colorado Summit', '2019-09-07', 'Steamboat Springs', '46', 'Save the date for October 7th for this year’s Bicycle Colorado Summit! Organizers are hosting back in Denver after an exciting 2018 event in Steamboat. The Summit with bring in influential cycling speakers and focus on key issues facing our community.');
INSERT INTO `rides` (`id`, `name`, `date`, `location`, `length`, `details`) VALUES (8, 'Fort Collins Ramble', '2019-09-12', 'Fort Collins', '50', 'Are you ready for some amazing Fall foliage, golden Aspens, and cooler riding weather? The Fort Collins Ramble travels through the Routt and Roosevelt National Forests, starting in Steamboat Springs and ending in Fort Collins CO. Now a 4-day adventure, we’ll travel through stunning landscapes, grand vistas, and desolate backdrops\n\nThe ride starts in Steamboat Springs and ends in Fort Collins CO. 208 miles, 17,306 ft of climbing.');
INSERT INTO `rides` (`id`, `name`, `date`, `location`, `length`, `details`) VALUES (9, 'Pedal The Plains', '2019-09-13', 'Denver', '50', 'Pedal The Plains (PTP) is a bicycle tour of Colorado, a signature event of The Denver Post Community Foundation and an initiative of The Denver Post and the State of Colorado. This Tour strives to strengthen community ties by fostering individual connections and fueling economic development by bringing tourism to the eastern plains, and giving locals the opportunity to educate others on their town and businesses.');
INSERT INTO `rides` (`id`, `name`, `date`, `location`, `length`, `details`) VALUES (10, 'Annual High Plains Gravel Grinder  ', '2019-09-21', 'Elbert', '70', 'Enjoy the challenging roads of Elbert County featuring a variety of great terrain. Pedal along stretches of the panoramic views of Pikes Peak, alongside beautiful local ranches and ponderosa pine next to rock outcrops. On the northeast side of the Palmer Divide the elevation is right around 7000′ where you can test your bike skills over Colorado cobbles, race up and down long rollers, and maybe redline your engine cranking up a few short steep climbs.');

COMMIT;

