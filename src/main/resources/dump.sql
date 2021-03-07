-- Drop All Tables --
DROP TABLE IF EXISTS `entry`;
DROP TABLE IF EXISTS `category`;
DROP TABLE IF EXISTS `role`;
DROP TABLE IF EXISTS `user`;

-- User Table --
CREATE TABLE `user` (
                        `id` int(11) NOT NULL AUTO_INCREMENT,
                        `username` varchar(25) NOT NULL,
                        `password` varchar(255) NOT NULL,
                        `first_name` varchar(25) NOT NULL,
                        `last_name` varchar(25) NOT NULL,
                        `email` varchar(100) NOT NULL,
                        `birthdate` DATE NOT NULL,
                        PRIMARY KEY (`id`),
                        UNIQUE KEY `user_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- Insert user --
INSERT INTO `user` VALUES (1,'mikeyjones123','yoyojojo123', 'Mike', 'Jones', 'kingjones999@gmail.com', '1987-03-21'),(2,'miraclet0909','p098', 'Miracle', 'Tianna', 'miracletiti@gmail.com', '1995-02-13');


-- Category Table --
CREATE TABLE `category` (
                            `id` int(11) NOT NULL AUTO_INCREMENT,
                            `category_name` varchar(50) NOT NULL,
                            `category_description` varchar(255),
                            `color` varchar(10) NOT NULL,
                            `user_id` int(11) NOT NULL,
                            PRIMARY KEY (`id`),
                            UNIQUE KEY `category_id_uindex` (`id`),

                            KEY `category_user_id_fk` (`user_id`),
                            CONSTRAINT `category_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- Insert category --
INSERT INTO `category` VALUES (1,'Food - Dine Out','Dining out', '#FFFFFF',1),(2,'Hobby','Anything that involves hobbies', '#FF8080',1),(3,'Bills - House','House bills, utilities, internet, etc.','#CCFF99',1),(4,'Work-Income','Paychecks, Bonuses, etc.','#00A63D',1);


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

-- Insert entry --
INSERT INTO `entry` VALUES (1, '2021-02-23', 'Walmart - Pizzas', 'Expense', 10.50, 1, 1),(2, '2021-02-22', 'Target - Board Games', 'Expense', 25.55, 2, 1),(3, '2021-02-01', 'Apartment Rent', 'Expense', 999.99, 3, 1),(4, '2021-02-01', 'Paycheck', 'Income', 1500.00, 4, 1);


-- Role Table --
CREATE TABLE role
(
    id        INT AUTO_INCREMENT
        PRIMARY KEY,
    role_name VARCHAR(25) NOT NULL,
    user_name VARCHAR(15) NOT NULL,
    user_id   INT         NOT NULL,
    CONSTRAINT role_id_uindex
        UNIQUE (id),
    CONSTRAINT role_user_user_id_fk
        FOREIGN KEY (user_id) REFERENCES user (id)
            ON UPDATE CASCADE
            ON DELETE CASCADE
)
    ENGINE = InnoDB;

CREATE INDEX role_user_user_id_fk
   ON role (user_id);

-- Insert Role --
INSERT INTO `role` VALUES (1, 'admin', 'mikeyjones123', 1),(2, 'general', 'miraclet0909', 2);

