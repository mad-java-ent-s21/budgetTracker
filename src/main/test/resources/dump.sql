-- Drop All Tables --
DROP TABLE IF EXISTS `category`;
DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS `entry`;


-- Category Table --
CREATE TABLE `category` (
        `id` int(11) NOT NULL AUTO_INCREMENT,
        `category_name` varchar(50) NOT NULL,
        `category_description` varchar(255),
        `color` varchar(10) NOT NULL,
        PRIMARY KEY (`id`),
        UNIQUE KEY `category_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- delete only data --

INSERT INTO `category` VALUES (1,'Food - Dine Out','Dining out', '#FFFFFF'),(2,'Hobby','Anything that involves hobbies', '#FF8080'),(3,'Bills - House','House bills, utilities, internet, etc.','#CCFF99'),(4,'Work-Income','Paychecks, Bonuses, etc.','#00A63D');


-- User Table --
CREATE TABLE `user` (
        `id` int(11) NOT NULL AUTO_INCREMENT,
        `username` varchar(25) NOT NULL,
        `password` varchar(255) NOT NULL,
        `first_name` varchar(25) NOT NULL,
        `last_name` varchar(25) NOT NULL,
        `birthdate` DATE NOT NULL,
        PRIMARY KEY (`id`),
        UNIQUE KEY `user_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- delete only data --

INSERT INTO `user` VALUES (1,'mikeyjones123','yoyojojo123', 'Mike', 'Jones', '1987-03-21');


-- Entry Table --
CREATE TABLE `entry` (
        `id` int(11) NOT NULL AUTO_INCREMENT,
        `date` DATE NOT NULL,
        `entry_name` varchar(100) NOT NULL,
        `entry_type` varchar(7) NOT NULL,
        `value` decimal(6,2) NOT NULL,
        `category_id` int(11) NOT NULL,
        `user_id` int(11) NOT NULL,
        PRIMARY KEY (`id`),
        UNIQUE KEY `entry_id_uindex` (`id`),

        KEY `entry_category_id_fk` (`category_id`),
        KEY `entry_user_id_fk` (`user_id`),
        CONSTRAINT `entry_category_id_fk` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
        CONSTRAINT `entry_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- delete only data --

INSERT INTO `entry` VALUES (1, '2021-02-23', 'Walmart - Pizzas', 'Expense', 10.50, 1, 1),(2, '2021-02-22', 'Target - Board Games', 'Expense', 25.55, 2, 1),(3, '2021-02-01', 'Apartment Rent', 'Expense', 999.99, 3, 1),(4, '2021-02-01', 'Paycheck', 'Income', 1500.00, 4, 1);

