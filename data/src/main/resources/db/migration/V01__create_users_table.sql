CREATE TABLE IF NOT EXISTS `user_hub_db`.`users` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `mail` VARCHAR(50) NOT NULL,
  `first_name` VARCHAR(20) NOT NULL,
  `last_name` VARCHAR(40) NOT NULL,
  `surname` VARCHAR(40) NOT NULL,
  `role` VARCHAR(40) NOT NULL,
  PRIMARY KEY (`id`))