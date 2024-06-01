drop table if exists user;
create table user(
    user_id int primary key auto_increment comment '用户id',
    user_name varchar(20) not null comment '用户名',
    user_password varchar(20) not null comment '用户密码'
)comment '用户表';

insert into user(user_name,user_password) values('admin','123456');

drop table if exists information;
create table information(
    inf_id int primary key auto_increment comment 'id',
                            inf_send_id int not null comment'发送者id',
                            inf_receive_id int not null default 0 comment'接收者id',
                            inf_content varchar(4000)not null comment'消息内容',
                            inf_time datetime not null comment'消息时间'
)comment'消息表';


SELECT * FROM information
    WHERE inf_send_id = 456 OR inf_receive_id = 456