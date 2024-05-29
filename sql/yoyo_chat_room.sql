
drop table if exists user;
create table user(
    user_id int primary key auto_increment comment '用户id',
    user_name varchar(20) not null comment '用户名',
    user_password varchar(20) not null comment '用户密码'
)comment '用户表';

insert into user(user_name,user_password) values('admin','123456');