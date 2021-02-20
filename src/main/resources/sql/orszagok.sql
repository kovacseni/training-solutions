SELECT `fovaros` AS `Madagaszkár fővárosa` FROM `orszagok` WHERE `orszag` = 'MADAGASZKÁR';

SELECT `orszag` AS `Ennek az országnak a fővárosa Ouagadougou:` FROM `orszagok` WHERE `fovaros` = 'OUAGADOUGOU';

SELECT `orszag` AS `Ország:` FROM `orszagok` WHERE `autojel` = 'TT';

SELECT `orszag` AS `Ország:` FROM `orszagok` WHERE `penzjel` = 'SGD';

SELECT `orszag` AS `Ország:` FROM `orszagok` WHERE `telefon` = 61;

SELECT `terulet` AS `Monaco területe (km2) :` FROM `orszagok` WHERE `orszag` = 'MONACO';

SELECT `nepesseg` AS `Málta népessége (1000 fő) :` FROM `orszagok` WHERE `orszag` = 'MÁLTA';

SELECT `nepesseg` * 1000 / `terulet` AS `Japán népsűrűsége (fő/km2) :` FROM `orszagok` WHERE `orszag` = 'JAPÁN';

SELECT `orszag` AS `500 fő/km2-nél nagyobb népsűrűségű országok:` FROM `orszagok` WHERE (`nepesseg` * 1000 / `terulet`) > 500;

SELECT `orszag` AS `Szigetországok:` FROM `orszagok` WHERE `foldr_hely` LIKE '%szigetország%';

SELECT `orszag` AS `A legnagyobb területű országok:` FROM `orszagok` ORDER BY `terulet` DESC LIMIT 6;

SELECT `orszag` AS `A legkisebb területű országok:` FROM `orszagok` ORDER BY `terulet` ASC LIMIT 3;

SELECT SUM(`nepesseg` * 1000) AS 'A Föld Lakossága:' FROM `orszagok`;

SELECT SUM(`nepesseg` * 1000) / SUM(`terulet`) AS 'A Föld népsűrűsége' FROM `orszagok`;

SELECT COUNT(*) AS '1 000 000 km2-nél nagyobb területű országok száma:' FROM `orszagok` WHERE `terulet` > 1000000;

SELECT COUNT(*) AS '50 000 és 150 000 km2 közötti területű országok száma:' FROM `orszagok` WHERE `terulet` BETWEEN 50000 AND 150000;
SELECT COUNT(*) AS '50 000 és 150 000 km2 közötti területű országok száma:' FROM `orszagok` WHERE `terulet` > 50000 AND `terulet` < 150000;

SELECT COUNT(*) AS '1 000 000-nál kevesebb lakosú országok száma:' FROM `orszagok` WHERE (`nepesseg` * 1000) < 1000000;

SELECT COUNT(*) AS '10 000 km2-nél kisebb területű és/vagy 1 000 000 főnél kisebb lakosságú országok száma:' FROM `orszagok` WHERE `terulet` < 10000 OR (`nepesseg` * 1000) < 1000000;

SELECT COUNT(*) AS 'A kelet-karib dollár pénznemet használó országok száma:' FROM `orszagok` WHERE `penznem` = 'kelet-karib dollár';

SELECT COUNT(*) AS '***ország nevű országok száma:' FROM `orszagok` WHERE `orszag` LIKE '%ország%';

SELECT COUNT(*) AS 'Az afrikai országok száma:' FROM `orszagok` WHERE `foldr_hely` LIKE '%Afrika%';

SELECT SUM(`nepesseg` * 1000) AS 'Afrika lakossága:' FROM `orszagok` WHERE `foldr_hely` LIKE '%Afrika%';

SELECT SUM(`terulet`) AS 'Európa területe:' FROM `orszagok` WHERE `foldr_hely` LIKE '%Európa%';

SELECT SUM(`nepesseg` * 1000) / (`terulet`) AS 'Európa népsűrűsége:' FROM  `orszagok` WHERE `foldr_hely` LIKE '%Európa%';

SELECT COUNT(*) AS 'Ennyi országnak nincs autójelzése:' FROM `orszagok` WHERE `autojel` = '';

SELECT COUNT(*) AS 'Ennyi országban nem 100 az aprópénz váltószáma:' FROM `orszagok` WHERE `valtopenz` NOT LIKE '100 %';

SELECT COUNT(*) AS 'Ennyi országnak nagyobb a népessége, mint Romániának:' FROM `orszagok` WHERE `nepesseg` > (SELECT `nepesseg` FROM `orszagok` WHERE `orszag` = 'ROMÁNIA');

SELECT SUM(`nepesseg` * 1000) AS 'Európa népessége:', COUNT(*) AS 'Európa országainak száma:' FROM `orszagok` WHERE `foldr_hely` LIKE '%Európa%';

SELECT COUNT(*) AS 'Ennyi országnak kisebb a területe, mint Törökországé:' FROM `orszagok` WHERE `terulet` < (SELECT `terulet` FROM `orszagok` WHERE `orszag` = 'TÖRÖKORSZÁG');

SELECT COUNT(*) AS 'Ennyi ország területe kisebb Magyarországénál:' FROM `orszagok` WHERE `terulet` < (SELECT `terulet` FROM `orszagok` WHERE `orszag` = 'MAGYARORSZÁG');

SELECT `orszag` AS 'A legnagyobb területű ország:', `terulet` AS 'Területe:' FROM `orszagok` WHERE `terulet` = (SELECT MAX(`terulet`) FROM `orszagok`);

SELECT `orszag` AS 'A legkisebb területű ország:', `terulet` AS 'Területe:' FROM `orszagok` WHERE `terulet` = (SELECT MIN(`terulet`) FROM `orszagok`);

SELECT `orszag` AS 'A legnépesebb ország:', `nepesseg` * 1000 AS 'Népessége:' FROM `orszagok` WHERE `nepesseg` = (SELECT MAX(`nepesseg`) FROM `orszagok`);

SELECT `orszag` AS 'A legkisebb népességű ország:', `nepesseg` * 1000 AS 'Népessége:' FROM `orszagok` WHERE `nepesseg` = (SELECT MIN(`nepesseg`) FROM `orszagok`);

SELECT `orszag` AS 'A legsűrűbben lakott ország:', (`nepesseg` * 1000 / `terulet`) AS 'Népsűrűsége:' FROM `orszagok` WHERE (`nepesseg` * 1000 / `terulet`) = (SELECT MAX(`nepesseg` * 1000 / `terulet`) FROM `orszagok`);

SELECT `orszag` AS 'A legritkábban lakott ország:', (`nepesseg` * 1000 / `terulet`) AS 'Népsűrűsége:' FROM `orszagok` WHERE (`nepesseg` * 1000 / `terulet`) = (SELECT MIN(`nepesseg` * 1000 / `terulet`) FROM `orszagok`);

SELECT `orszag` AS 'A legritkábban lakott európai ország:', (`nepesseg` * 1000 / `terulet`) AS 'Népsűrűsége:' FROM `orszagok` WHERE (`nepesseg` * 1000 / `terulet`) = (SELECT MIN(`nepesseg` * 1000 / `terulet`) FROM `orszagok` WHERE `foldr_hely` LIKE '%Európa%');

SELECT `orszag` AS 'A legnagyobb területű afrikai ország:', `terulet` AS 'Területe:' FROM `orszagok` WHERE `terulet` = (SELECT MAX(`terulet`) FROM `orszagok` WHERE `foldr_hely` LIKE '%Afrika%');