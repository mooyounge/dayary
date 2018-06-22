create user mooyounge identified by 1111;
grant dba to mooyounge;

create table diary(
    id number primary key,
    u_id varchar2(15),
    title varchar2(50),
    content clob not null,
    regdate date not null
);

create sequence seq_diary_id;

insert into diary values(seq_diary_id.nextval, 'mooyounge','첫 번째 일기','곧점심시간이다..',sysdate);
insert into diary values(seq_diary_id.nextval, 'mooyounge','두 번째 일기','휴식시간이 끝났다..',sysdate);
commit;

select * from diary;
delete diary;

--member
create table member(
    id varchar2(10) primary key,
    password varchar2(10) not null,
    name varchar2(30) not null,
    email varchar2(30) not null unique,
    gender char(1) check(gender in('m','f'))
);

insert into member values('admin','admin','어드민','admin','m');
