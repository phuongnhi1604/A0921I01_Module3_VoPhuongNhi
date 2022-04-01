use demo1;

DELIMITER $$
CREATE PROCEDURE get_all_users()
BEGIN
    SELECT users.id, users.name, users.email, users.country
    FROM users;
END$$
DELIMITER ;
call get_all_users();

DELIMITER $$
CREATE PROCEDURE update_user(IN id int, name varchar(120), email varchar(120), country varchar(120))
BEGIN
    update users set users.name=name, users.email=email, users.country=country 
    where users.id=id;
END$$
DELIMITER ;
call update_user(14,'Nhi','nhi@gmail.com','Singapore');


DELIMITER $$
CREATE PROCEDURE delete_user(IN id int)
BEGIN
    delete from users
    where users.id=id;
END$$
DELIMITER ;
call delete_user(14);
  