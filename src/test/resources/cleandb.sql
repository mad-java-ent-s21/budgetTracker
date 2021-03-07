DELETE FROM `entry` WHERE id > 0;
DELETE FROM `category` WHERE id > 0;
DELETE FROM `role` WHERE id > 0;
DELETE FROM `user` WHERE id > 0;
INSERT INTO `user` VALUES (1,'mikeyjones123','yoyojojo123', 'Mike', 'Jones', 'kingjones999@gmail.com', '1987-03-21'),(2,'miraclet0909','p098', 'Miracle', 'Tianna', 'miracletiti@gmail.com', '1995-02-13');
INSERT INTO `role` VALUES (1, 'admin', 'mikeyjones123', 1),(2, 'general', 'miraclet0909', 2);
INSERT INTO `category` VALUES (1,'Food - Dine Out','Dining out', '#FFFFFF', 1),(2,'Hobby','Anything that involves hobbies', '#FF8080', 1),(3,'Bills - House','House bills, utilities, internet, etc.','#CCFF99', 1),(4,'Work-Income','Paychecks, Bonuses, etc.','#00A63D', 1);
INSERT INTO `entry` VALUES (1, '2021-02-23', 'Walmart - Pizzas', 'Expense', 10.50, 1, 1),(2, '2021-02-22', 'Target - Board Games', 'Expense', 25.55, 2, 1),(3, '2021-02-01', 'Apartment Rent', 'Expense', 999.99, 3, 1),(4, '2021-02-01', 'Paycheck', 'Income', 1500.00, 4, 1);

