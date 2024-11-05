CREATE DATABASE user_db;
USE user_db;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL, -- store hashed passwords here
    phone VARCHAR(15) NOT NULL
);

DELIMITER //
CREATE TRIGGER hide_phone_digits BEFORE INSERT ON users
FOR EACH ROW
BEGIN
    SET NEW.phone = CONCAT(SUBSTRING(NEW.phone, 1, LENGTH(NEW.phone) - 3), '***');
END//
DELIMITER ;