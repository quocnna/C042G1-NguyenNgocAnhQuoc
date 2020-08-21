DROP FUNCTION IF EXISTS lipsum;

DELIMITER //
CREATE FUNCTION lipsum(p_max_words SMALLINT
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
        DECLARE v_text_lipsum VARCHAR(1500) DEFAULT 'a ac accumsan ad adipiscing aenean aliquam aliquet amet ante aptent arcu at auctor augue bibendum blandit class commodo condimentum congue consectetuer consequat conubia convallis cras cubilia cum curabitur curae; cursus dapibus diam dictum dignissim dis dolor donec dui duis egestas eget eleifend elementum elit enim erat eros est et etiam eu euismod facilisi facilisis fames faucibus felis fermentum feugiat fringilla fusce gravida habitant hendrerit hymenaeos iaculis id imperdiet in inceptos integer interdum ipsum justo lacinia lacus laoreet lectus leo libero ligula litora lobortis lorem luctus maecenas magna magnis malesuada massa mattis mauris metus mi molestie mollis montes morbi mus nam nascetur natoque nec neque netus nibh nisi nisl non nonummy nostra nulla nullam nunc odio orci ornare parturient pede pellentesque penatibus per pharetra phasellus placerat porta porttitor posuere praesent pretium primis proin pulvinar purus quam quis quisque rhoncus ridiculus risus rutrum sagittis sapien scelerisque sed sem semper senectus sit sociis sociosqu sodales sollicitudin suscipit suspendisse taciti tellus tempor tempus tincidunt torquent tortor tristique turpis ullamcorper ultrices ultricies urna ut varius vehicula vel velit venenatis vestibulum vitae vivamus viverra volutpat vulputate';
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

        RETURN TRIM(CONCAT(v_result,'.'));
END;
//
DELIMITER ;


select lipsum(3,1,0);

SELECT * FROM `movies` WHERE `title` REGEXP 'ack[[:>:]]';

SELECT SUBSTRING_INDEX('www.mytestpage.info','.',3);
SELECT SUBSTRING_INDEX('www mytestpage info',' ',3);

select regexp_substr('my sql function', '[a-z]+[\s]',1, 1);  


select * from actor;
SELECT
LENGTH(first_name) - LENGTH(REPLACE(first_name, ' ', '')) as 'number',
trim(replace(first_name,SUBSTRING_INDEX(first_name, ' ', LENGTH(first_name)- LENGTH(REPLACE(first_name,' ',''))),'')) AS first_name,
    TRIM( SUBSTR(first_name, LOCATE(' ', first_name)) ) AS last_name
FROM actor
where trim(replace(first_name,SUBSTRING_INDEX(first_name, ' ', LENGTH(first_name)- LENGTH(REPLACE(first_name,' ',''))),'')) like 'q%';



--qg



-- set @ids= 'select id from(
-- select distinct(cus.id) from customer cus
-- join contract con on cus.id= con.customer_id
-- where year(con.start_day) <2015) as tmp';
-- set @queryToDeleteOnContract :=  concat_ws(@ids,'delete from contract where customer_id in ( ',')');
-- prepare executeQuery from @queryToDeleteOnContract;
-- execute executeQuery;
-- set @queryToDeleteOnCustomer :=  concat_ws(@ids,'delete from customer where id in ( ',')');
-- prepare executeQuery from @queryToDeleteOnCustomer;
-- execute executeQuery;
-- //ok but have many other constraint diff

USE information_schema;
set @fk := (SELECT constraint_name FROM referential_constraints
WHERE constraint_schema = 'furama_v1'
        AND referenced_table_name = 'customer');

use furama_v1;
set @queryDropFK := concat('alter table contract drop foreign key ',@fk);
prepare executeQuery from @queryDropFK;
execute executeQuery;

set @queryAddFK := concat_ws(@fk,'alter table contract add constraint ',' foreign key (customer_id) references customer(id) on delete cascade');
prepare executeQuery from @queryAddFK;
execute executeQuery;

delete from customer where id not in(
select id from(
select distinct(cus.id) from customer cus
join contract con on cus.id= con.customer_id
where year(con.start_day) <2018) as tmp );


-- set @query := (select count(*) from customer);
-- select fullname from customer where (@query := @query-1)=0;

-- set @tableName = 'customer';
-- set @queryToSelectCustomer := concat('select fullname from ',@tableName);
-- prepare executeQuery from @queryToSelectCustomer;
-- execute executeQuery;

-- SET FOREIGN_KEY_CHECKS=0; -- to disable them
-- SET FOREIGN_KEY_CHECKS=1; -- to re-enable them

-- show columns from contract;
-- show index from contract;

-- SELECT COLUMN_NAME, DATA_TYPE, IS_NULLABLE, COLUMN_DEFAULT
--   FROM INFORMATION_SCHEMA.COLUMNS
--   WHERE table_name = 'customer';
--   
-- SELECT TABLE_NAME, COLUMN_NAME, CONSTRAINT_NAME, REFERENCED_TABLE_NAME,REFERENCED_COLUMN_NAME
-- FROM INFORMATION_SCHEMA.KEY_COLUMN_USAGE
-- WHERE REFERENCED_TABLE_SCHEMA = 'furama_v1' AND REFERENCED_TABLE_NAME = 'customer';
---qg

insert into DemoTable1945(StudentName,StudentAge) select tbl1.Name,tbl2.Age from DemoTable1943 tbl1,DemoTable1944 tbl2;
insert into DemoTable1
   -> select Name,89 from DemoTable2
   -> union all
   -> select Name,98 from DemoTable2;