create table cos_tbl(
	re_code number(5) primary key,
	cos_code varchar2(10),
	cos_1 varchar2(40),
	cos_2 varchar2(40),
	cos_3 varchar2(40),
	cos_4 varchar2(40),
	cos_5 varchar2(40)
);

drop table re_tbl;
drop table cos_tbl;


insert into cos_tbl
values(10001,'lunch-A','계란말이','완자구이','스시','라멘','아이스크림');
insert into cos_tbl
values(10002,'lunch-A','계란말이','완자구이','모둠회','우동','아이스크림');
insert into cos_tbl
values(10003,'lunch-B','미소된장국','완자구이','모둠회','모밀','아이스크림');


select * from cos_tbl;

create table re_tbl(
	re_code number(5) primary key,
	re_phone varchar2(13),
	re_date date,
	re_time varchar2(10),
	re_person number(2),
	cos_code varchar2(10),
	cos_price varchar2(20)
);

insert into re_tbl(re_code, re_phone, re_date, re_time, re_person, cos_code, cos_price) 
values(10001,'010-1234-1234','20240410','1230',1,'lunch-A','160000원');
insert into re_tbl(re_code, re_phone, re_date, re_time, re_person, cos_code, cos_price) 
values(10002,'010-6789-4325','20240410','1730',2,'dinner-A','160000원');
insert into re_tbl(re_code, re_phone, re_date, re_time, re_person, cos_code, cos_price)  
values(10003,'010-4357-2353','20240410','1030',1,'dinner-B','180000원');

select * from re_tbl;


select re_code,re_phone,
re_date , re_time , re_person
from re_tbl;

substr(re_date,1,4) ||'년'||substr(re_date,5,2)||'월'|| substr(re_date,7,2)||'일' as

select max(re_code)+1 re_code from re_tbl;