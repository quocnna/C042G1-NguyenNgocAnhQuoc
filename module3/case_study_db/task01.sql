use furama_v1;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES';
DROP FUNCTION IF EXISTS random_name;
DELIMITER //
CREATE FUNCTION random_name(p_max_words SMALLINT
                       ,p_min_words SMALLINT
                       ,p_start_with_lipsum TINYINT(1)
                       )
    RETURNS VARCHAR(10000)
    NO SQL
    BEGIN
    DECLARE v_max_words SMALLINT DEFAULT 50;
        DECLARE v_random_item SMALLINT DEFAULT 0;
        DECLARE v_random_word VARCHAR(25) DEFAULT '';
        DECLARE v_start_with_lipsum TINYINT DEFAULT 0;
        DECLARE v_result VARCHAR(10000) DEFAULT '';
        DECLARE v_iter INT DEFAULT 1;
		DECLARE v_text_lipsum VARCHAR(1500) DEFAULT 'Nguyen Ho Le Truong Tuan Phong Dung Ly Tran Linh Quang Anh Hoat Thinh Vu Chuong Dang Van Long Phuong My Hoa Dang Lam Doan Trung Minh Quoc Toan Ngan Tuong Binh Hai Ha Nhung Loan Cuong Duy Xuan Lan Tien Tung Thao Son Thanh Thuong Nguyen Ho Le Truong Tuan Phong Dung Ly Tran Linh Quang Anh Hoat Thinh Vu Chuong Dang Van Long Phuong My Hoa Dang Lam Doan Trung Minh Quoc Toan Ngan Tuong Binh Hai Ha Nhung Loan Cuong Duy Xuan Lan Tien Tung Thao Son Thanh Thuong Hao Huong Chi Tri Thao Thinh Tinh Tin Tuy Thao Hung Duc Anh Dung Quoc My Xuan Tien Tan Ta Ton Tien Vu Van Theo Nguyen Ho Le Truong Tuan Phong Dung Ly Tran Linh Quang Anh Hoat Thinh Vu Chuong Dang Van Long Phuong My Hoa Dang Lam Doan Trung Minh Quoc Toan Ngan Tuong Binh Hai Ha Nhung Loan Cuong Duy Xuan Lan Tien Tung Thao Son Thanh Thuong Nguyen Ho Le Truong Tuan Phong Dung Ly Tran Linh Quang Anh Hoat Thinh Vu Chuong Dang Van Long Phuong My Hoa Dang Lam Doan Trung Minh Quoc Toan Ngan Tuong Binh Hai Ha Nhung Loan Cuong Duy Xuan Lan Tien Tung Thao Son Thanh Thuong Hao Huong Chi Tri Thao Thinh Tinh Tin Tuy Thao Hung Duc Anh Dung Quoc My Xuan Tien Tan Ta Ton Tien Vu Van Theorandom_name';
        DECLARE v_text_lipsum_wordcount INT DEFAULT 180;
        DECLARE v_sentence_wordcount INT DEFAULT 0;
        DECLARE v_sentence_start BOOLEAN DEFAULT 1;
        DECLARE v_sentence_end BOOLEAN DEFAULT 0;
        DECLARE v_sentence_lenght TINYINT DEFAULT 9;

        SET v_max_words := COALESCE(p_max_words, v_max_words);
        SET v_start_with_lipsum := COALESCE(p_start_with_lipsum , v_start_with_lipsum);

        IF p_min_words IS NOT NULL THEN
            SET v_max_words := FLOOR(p_min_words + (RAND() * (v_max_words - p_min_words)));
        END IF;

        IF v_max_words < v_sentence_lenght THEN
            SET v_sentence_lenght := v_max_words;
        END IF;

        IF p_start_with_lipsum = 1 THEN
            SET v_result := CONCAT(v_result,'Lorem ipsum dolor sit amet.');
            SET v_max_words := v_max_words - 5;
        END IF;

        WHILE v_iter <= v_max_words DO
            SET v_random_item := FLOOR(1 + (RAND() * v_text_lipsum_wordcount));
            SET v_random_word := REPLACE(SUBSTRING(SUBSTRING_INDEX(v_text_lipsum, ' ' ,v_random_item),
                                           CHAR_LENGTH(SUBSTRING_INDEX(v_text_lipsum,' ', v_random_item -1)) + 1),
                                           ' ', '');

            SET v_sentence_wordcount := v_sentence_wordcount + 1;
            IF v_sentence_wordcount = v_sentence_lenght THEN
                SET v_sentence_end := 1 ;
            END IF;

            IF v_sentence_start = 1 THEN
                SET v_random_word := CONCAT(UPPER(SUBSTRING(v_random_word, 1, 1))
                                            ,LOWER(SUBSTRING(v_random_word FROM 2)));
                SET v_sentence_start := 0 ;
            END IF;

            IF v_sentence_end = 1 THEN
                IF v_iter <> v_max_words THEN
                    SET v_random_word := CONCAT(v_random_word, '.');
                END IF;
                SET v_sentence_lenght := FLOOR(9 + (RAND() * 7));
                SET v_sentence_end := 0 ;
                SET v_sentence_start := 1 ;
                SET v_sentence_wordcount := 0 ;
            END IF;

            SET v_result := CONCAT(v_result,' ', v_random_word);
            SET v_iter := v_iter + 1;
        END WHILE;

        RETURN TRIM(v_result);
END;
// DELIMITER ;
SET SQL_MODE=@OLD_SQL_MODE;


DROP procedure IF EXISTS general_employee;
DELIMITER //
create procedure general_employee()
begin
 DECLARE i INT DEFAULT 50;
  WHILE i < 100 DO
    INSERT INTO employee (fullname,birthday,identify_number,salary,phone,email,address,position_id,department_id,degree_id)
    VALUES (random_name(6,3,0),'2020-05-05','2015181835',i,'0708230984','email','address',1,2,3);
    SET i = i + 1;
  END WHILE;
end
// DELIMITER ;
call general_employee;