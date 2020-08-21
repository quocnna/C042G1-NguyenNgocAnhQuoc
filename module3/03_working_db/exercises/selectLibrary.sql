select * from student;

select * from student s
inner join address a
on s.id= a.student_id;

select * from student s
inner join borrow_order bo
inner join book b
on s.id = bo.student_id and bo.book_id= b.id;