use classicmodels;

/*
IN: Đây là chế độ mặc định (nghĩa là nếu bạn không định nghĩa loại nào thì nó sẽ hiểu là IN).
OUT: Chế độ này nếu như trong Procedure có tác động thay đổi thì nó sẽ thay đổi theo. Nhưng có điều đặc biệt là dù trước khi truyền vào mà bạn gán giá trị cho biến đó thì vẫn sẽ không nhận được vì mặc định nó luôn hiểu giá trị truyền vào là NULL.
INOUT: Đây là sự kết hợp giữa IN và OUT. Nghĩa là có thể gán giá trị trước và có thể bị thay đổi nếu trong Procedure có tác động.
*/

DELIMITER //
CREATE PROCEDURE getCusById(IN cusNum INT(11))
BEGIN
  SELECT * FROM customers WHERE customerNumber = cusNum;
END //
DELIMITER ;

call getCusById(175);

drop procedure if exists getCusById;

DELIMITER //
CREATE PROCEDURE GetCustomersCountByCity(
    IN  in_city VARCHAR(50),
    OUT total INT
)
BEGIN
    SELECT COUNT(customerNumber)
    INTO total
    FROM customers
    WHERE city = in_city;
END//
DELIMITER ;

CALL GetCustomersCountByCity('Lyon',@total);
SELECT @total;


drop procedure if exists GetCustomersCountByCity;

DELIMITER //
CREATE PROCEDURE SetCounter(
    INOUT counter INT,
    IN inc INT
)
BEGIN
    SET counter = counter + inc;
END//
DELIMITER ;

SET @counter = 10;
CALL SetCounter(@counter,1); -- 2
CALL SetCounter(@counter,1); -- 3
CALL SetCounter(@counter,5); -- 8
SELECT @counter; -- 8