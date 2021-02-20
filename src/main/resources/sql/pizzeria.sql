SELECT * FROM `customers` ORDER BY `customer_name` DESC;

SELECT `customer_name` FROM `customers` ORDER BY `customer_name` DESC;

SELECT * FROM `pizza` ORDER BY `pizza_price` ASC;

SELECT `pizza_id`, `pizza_name`, MAX(`pizza_price`) AS `Legdrágább pizza ára:` FROM `pizza`;

SELECT AVG(`pizza_price`) AS `Átlagos rendelési érték` FROM `pizza` INNER JOIN `order` ON pizza.pizza_id = order.pizza_id;

SELECT COUNT(`customer_name`) AS `a-betűt tartalmazó nevek:` FROM `customers` WHERE `customer_name` LIKE '%a%';

SELECT * FROM `pizza` WHERE `pizza_price` > 1000 OR `pizza_name` LIKE '%a%';

SELECT customers.customer_name, order.order_date FROM customers INNER JOIN `order` ON customers.customer_id = order.customer_id;

SELECT order.order_date, pizza.pizza_name FROM `order` INNER JOIN `pizza` ON order.pizza_id = pizza.pizza_id;