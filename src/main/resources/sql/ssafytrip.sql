drop table if exists `user`;

create table user (
   id int primary key auto_increment,
    user_id varchar(50) unique not null,
    user_password varchar(1000),
    user_name varchar(10),
    user_phone varchar(20),
    birthday date,
    message varchar(100),
    img varchar(1000)
);

drop table if exists `group`;

create table `group` (
   group_id int primary key auto_increment,
    group_name varchar(50) not null,
    group_title varchar(50),
    group_img varchar(1000),
    group_music varchar(100),
    start_date date,
    end_date date,
    total_cnt int default 0,
    today_cnt int default 0
);

drop table if exists groupuser;

create table groupuser (
   groupuser_id int primary key auto_increment,
    user_id int,
    group_id int,
    notice_check boolean default false,
    constraint foreign key(user_id) references user(id) on delete cascade on update cascade,
    constraint foreign key(group_id) references `group`(group_id) on delete cascade on update cascade
);



drop table if exists `chat`;

create table `chat` (
   chat_id int primary key auto_increment,
    content varchar(1000),
    chat_datetime datetime default current_timestamp,
    group_id int,
    user_id int,
    constraint foreign key(group_id) references `group`(group_id) on delete cascade on update cascade,
    constraint foreign key(user_id) references `user`(id) on delete cascade on update cascade
);
alter table `chat` rename column chat_content to content;

drop table if exists `notice`;

create table `notice` (
   notice_id int primary key auto_increment,
    content varchar(300),
    group_id int,
    constraint foreign key(group_id) references `group`(group_id) on delete cascade on update cascade
);

drop table if exists `todo`;
create table `todo` (
   todo_id int primary key auto_increment,
    content varchar(300),
    checked boolean default false,
    group_id int,
    constraint foreign key(group_id) references `group`(group_id) on delete cascade on update cascade
);



drop table if exists `memory`;
create table `memory` (
   memory_id int primary key auto_increment,
    img varchar(1000),
    content varchar(2000),
    write_time datetime default current_timestamp,
    group_id int,
    user_id int,
    constraint foreign key(group_id) references `group`(group_id) on delete cascade on update cascade,
    constraint foreign key(user_id) references `user`(id) on delete cascade on update cascade
);

drop table if exists plan;

create table `plan` (
	plan_id int primary key auto_increment,
    date date,
    content_id int,
    group_id int,
    constraint foreign key(group_id) references `group`(group_id) on delete cascade on update cascade,
    constraint foreign key(content_id) references `attraction_info`(content_id) on delete cascade on update cascade
);