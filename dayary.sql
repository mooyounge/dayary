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

insert into diary values(seq_diary_id.nextval, 'mooyounge','ù ��° �ϱ�','�����ɽð��̴�..',sysdate);
insert into diary values(seq_diary_id.nextval, 'mooyounge','�� ��° �ϱ�','�޽Ľð��� ������..',sysdate);
commit;

select * from diary;