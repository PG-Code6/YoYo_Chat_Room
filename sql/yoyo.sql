drop table if exists user;
create table user(
                     user_id int primary key auto_increment comment '�û�id',
                     user_name varchar(20) not null comment '�û���',
                     user_password varchar(20) not null comment '�û�����'
)comment '�û���';

insert into user(user_name,user_password) values('admin','123456');

drop table if exists information;
create table information(
                            inf_id int primary key auto_increment comment '��Ϣid',
                            inf_send_id int not null comment '������id',
                            inf_receive_id int not null default 0 comment '������id(0,��ʾ������1��ʾ�����ˣ��û�id���ڵ���10)',
                            inf_content varchar(1000) not null comment '��Ϣ����',
                            inf_time datetime not null comment '��Ϣʱ��'
)comment '��Ϣ��';



