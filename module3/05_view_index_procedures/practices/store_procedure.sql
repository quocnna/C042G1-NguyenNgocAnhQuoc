use classicmodels;
DROP PROCEDURE IF EXISTS `findAllCustomers`;
DELIMITER //
CREATE PROCEDURE findAllCustomers()
BEGIN
  SELECT * FROM customers;
END
// DELIMITER ;

call findAllCustomers();

/*
DELIMITER // dùng để phân cách bộ nhớ lưu trữ thủ tục Cache và mở ra một ô lưu trữ mới.
CREATE PROCEDURE findAllCustomers() dùng để khai báo tạo một Procedure mới, trong đó findAllCustomers chính là tên thủ tục còn hai từ đầu là từ khóa.
**BEGIN và END; // ** dùng để khai báo bắt đầu của Procedure và kết thúc Procedure
**DELIMITER ; ** đóng lại ô lưu trữ
Sau đó chạy câu SQL này và nó báo thành công tức là bạn đã tạo mới một thủ tục với tên findAllCustomers.

Cách gọi procedure

call findAllCustomers();

Sửa procedure

Trong Mysql không cung cấp lệnh sửa Stored nên thông thường chúng ta sẽ chạy lệnh tạo mới.

Lệnh Drop để xóa đi Procedure đó và tạo lại:

DELIMITER //

DROP PROCEDURE IF EXISTS `findAllCustomers`//

CREATE PROCEDURE findAllCustomers()

BEGIN

   SELECT *  FROM customers where customerNumber = 175;

END; //

DELIMITER
*/