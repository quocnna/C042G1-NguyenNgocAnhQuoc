-- MySQL Workbench Synchronization
-- Generated: 2020-07-15 10:33
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: Quoc Gunner

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

ALTER TABLE `car_for_sale`.`customer` 
DROP FOREIGN KEY `customer_employee_id`;

ALTER TABLE `car_for_sale`.`order` 
DROP FOREIGN KEY `order_customer_id`;

ALTER TABLE `car_for_sale`.`payment` 
DROP FOREIGN KEY `payment_customer_id`;

CREATE TABLE IF NOT EXISTS `car_for_sale`.`product` (
  `id` INT(11) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `scale` VARCHAR(10) NOT NULL,
  `vendor` VARCHAR(45) NOT NULL,
  `description` TEXT NOT NULL,
  `quanltity_in_stock` INT(11) NOT NULL,
  `cogs` DOUBLE NOT NULL,
  `msrp` DOUBLE NOT NULL,
  `product_line_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `product_product_line_id_idx` (`product_line_id` ASC) VISIBLE,
  CONSTRAINT `product_product_line_id`
    FOREIGN KEY (`product_line_id`)
    REFERENCES `car_for_sale`.`product_line` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `car_for_sale`.`product_line` (
  `id` INT(11) NOT NULL,
  `description` TEXT NULL DEFAULT NULL,
  `image` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `car_for_sale`.`office` (
  `code` CHAR(10) NOT NULL,
  `city` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(45) NOT NULL,
  `first_address` VARCHAR(45) NOT NULL,
  `second_address` VARCHAR(45) NOT NULL,
  `state` VARCHAR(45) NOT NULL,
  `country` VARCHAR(45) NOT NULL,
  `postal_code` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `car_for_sale`.`OrderDetail` (
  `product_id` INT(11) NULL DEFAULT NULL,
  `order_id` INT(11) NULL DEFAULT NULL,
  INDEX `order_detail_product_id_idx` (`product_id` ASC) VISIBLE,
  INDEX `order_detail_order_id_idx` (`order_id` ASC) VISIBLE,
  CONSTRAINT `order_detail_product_id`
    FOREIGN KEY (`product_id`)
    REFERENCES `car_for_sale`.`product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `order_detail_order_id`
    FOREIGN KEY (`order_id`)
    REFERENCES `car_for_sale`.`order` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

ALTER TABLE `car_for_sale`.`customer` 
ADD CONSTRAINT `customer_employee_id`
  FOREIGN KEY (`employee_id`)
  REFERENCES `car_for_sale`.`employee` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `car_for_sale`.`order` 
ADD CONSTRAINT `order_customer_id`
  FOREIGN KEY (`customer_id`)
  REFERENCES `car_for_sale`.`customer` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `car_for_sale`.`payment` 
ADD CONSTRAINT `payment_customer_id`
  FOREIGN KEY (`customer_id`)
  REFERENCES `car_for_sale`.`customer` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
