create database inotes;
use inotes;

create table note_type(
id int primary key auto_increment,
name varchar(50),
description varchar(200)
);

create table note(
id int primary key auto_increment,
title varchar(100),
content varchar(500),
note_type_id int,
foreign key (note_type_id) references note_type(id) 
);

insert into note_type (name,description) values ('code','note for code'),('game','note for game'), ('film','note for film');
insert into note (title,content,note_type_id) values ('java','jdbc jsp servlet',1),('fast and furios','good film',3),('mario','good game',2);

select * from note_type;
select * from note;
select n.id, n.title, n.content, nt.id, nt.name from note n join note_type nt on n.note_type_id= nt.id; 
select n.id, n.title, n.content, nt.id, nt.name from note n join note_type nt on n.note_type_id= nt.id where n.title regexp binary 'a'; 

-- create procedure insert 2 table or use java insert parent after inserr child
drop procedure if exists insert_notetype_note;
delimiter //
create procedure insert_notetype_note(ptitle varchar(100), pcontent varchar(200), pname varchar(50))
begin
declare last_note_type_id int;
insert into note_type (name) values (pname);
select id into last_note_type_id from note_type order by id desc limit 1;
insert into note (title,content,note_type_id) values (ptitle,pcontent,last_note_type_id);
end;
// delimiter ;
call insert_notetype_note('note title','note content','note type name');



drop procedure if exists delete_cascade;
drop procedure if exists set_cascade;

delimiter //
create procedure set_cascade(re_tbl varchar(50), d_is_cascade tinyint(1), out c_tbl varchar(30))
begin
	declare is_cascade tinyint default 0;
	declare db_name varchar(30);
    declare tbl varchar(30);
    declare txt_cascade varchar(20);
    set is_cascade := ifnull(d_is_cascade,0);
    if is_cascade =1 then
    set txt_cascade= 'on delete cascade';
    else
     set txt_cascade= '';
    end if;
    
    set db_name= concat("'",database(),"'");
    set tbl = concat("'",re_tbl,"'");
    -- select database() into db_name;
	set @res= concat("SELECT concat_ws(',',TABLE_NAME, COLUMN_NAME, CONSTRAINT_NAME, REFERENCED_COLUMN_NAME) into @val FROM INFORMATION_SCHEMA.KEY_COLUMN_USAGE WHERE REFERENCED_TABLE_SCHEMA =",db_name," AND REFERENCED_TABLE_NAME = ",tbl);
	PREPARE st FROM @res;
      EXECUTE st;
      DEALLOCATE PREPARE st;
    
    if @val is not null and @val <> 'tmp'  then
	set @tbl_name = substring_index(@val,',',1);
    set c_tbl= @tbl_name; 
	set @column_fk = replace(substring_index(@val,',',2),concat(@tbl_name,',') ,'') ;
	set @column_pk = substring_index(@val,',',-1);
	set @ctraint_name = replace(substring_index(@val,',',-2),concat(',',@column_pk),'') ;
    
    set @queryDropFK := concat('alter table ', @tbl_name, ' drop foreign key ',@ctraint_name);
	prepare executeQuery from @queryDropFK;
	execute executeQuery;
    
    set @queryAddFK := concat('alter table ',@tbl_name,' add constraint ',@ctraint_name,' foreign key(',@column_fk,') references ',re_tbl,'(',@column_pk,') ',txt_cascade);
	prepare executeQuery from @queryAddFK;
	execute executeQuery;
    set @val = 'tmp';
    end if;

end;
// delimiter ;


delimiter //
create procedure delete_cascade(d_query varchar(1000))
begin
	declare tbl_name varchar(50);
	set tbl_name= substring_index(trim(replace(replace(d_query,SUBSTRING_INDEX(d_query,'from',1),''),'from','')),' ',1);
	call set_cascade(tbl_name,1,@c_tbl); 
    if @c_tbl is not null then
		call set_cascade(@c_tbl,1,@c_tbl);
    end if;
    
    set @res= d_query;
    prepare executeQuery from @res;
	execute executeQuery;
    
    call set_cascade(tbl_name,0,@c_tbl);
    if @c_tbl is not null then 
    call set_cascade(@c_tbl,0,@c_tbl);
    end if;
    
end;
// delimiter ;

delete from note_type where id in (3);

call delete_cascade("delete from note_type where id =1;");
