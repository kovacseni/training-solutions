CREATE TABLE postal_codes (irsz INT(4) UNSIGNED NOT NULL, telepules VARCHAR(50) NOT NULL, telepulesresz VARCHAR(50));

CREATE TABLE citizens (citizen_id BIGINT NOT NULL AUTO_INCREMENT, citizen_name VARCHAR(200) NOT NULL, zip CHAR(4) NOT NULL, age BIGINT NOT NULL, email VARCHAR(200), taj VARCHAR(10) UNIQUE NOT NULL, number_of_vaccination INT, last_vaccination DATE, vaccine_type VARCHAR(20), comments VARCHAR(250), PRIMARY KEY (citizen_id));

CREATE TABLE vaccinations (vaccination_id BIGINT NOT NULL AUTO_INCREMENT, citizen_id BIGINT NOT NULL, taj VARCHAR(9) NOT NULL, vaccination_date DATE NOT NULL, number_of_vaccination INT, vaccine_type VARCHAR(20), comments VARCHAR(250), PRIMARY KEY (vaccination_id), FOREIGN KEY (citizen_id) REFERENCES citizens(citizen_id));