drop procedure if exists delete_cascade;
drop procedure if exists set_cascade;

delimiter //
create procedure set_cascade(re_tbl varchar(50), d_is_cascade tinyint(1), out c_tbl varchar(30))
begin
	declare is_cascade tinyint default 0;
	declare db_name varchar(30);
    declare tbl varchar(30);
    declare txt_cascade varchar(20);
    -- SET max_sp_recursion_depth = 255; st  execute a recursive stored procedure
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
    -- set @val = 'tmp';
--    call set_cascade("contract",is_cascade);
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

call delete_cascade("delete from customer where id not in(
select id from(
select distinct(cus.id) from customer cus
join contract con on cus.id= con.customer_id
where year(con.start_day) <2018) as tmp );")