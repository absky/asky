create database shopping;

use shopping;

create table adminuser(
	uid int not null AUTO_INCREMENT,
	username varchar(255) not null,
	password varchar(255) not null,
	minventory int not null,
	primary key(uid)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table category(
	cid int not null AUTO_INCREMENT,
	cname varchar(255) not null,
	discount float default 0 not null,  ---折扣率
	privilegeTime datetime null COMMENT '优惠时间',
	primary key(cid)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


create table categorysecond(
	csid int not null AUTO_INCREMENT,
	csname varchar(255) not null,
	cid int not null,
	primary key(csid),
	key(cid)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table orderitem(
	itemid int not null AUTO_INCREMENT,
	count int default 0 not null,
	subtotal float default 0 not null,
	oid int not null,
	pid int not null,
	primary key(itemid),
	key(oid, pid)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


create table orders(
	oid int not null AUTO_INCREMENT,
	addr varchar(255) null,
	name varchar(255) null,
	ordertime datetime null,
	phone varchar(16) null,
	state int default 0 not null,
	total float default 0 not null,
	uid int not null,
	primary key(oid),
	CONSTRAINT fk_orders_user FOREIGN KEY (uid) REFERENCES `user` (uid)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table packet(
	pacid int NOT NULL AUTO_INCREMENT COMMENT '卡包编号',
    uid int NOT NULL COMMENT '客户编号',
    primary key(pacid),
    unique key(uid)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table product(
	pid int not null AUTO_INCREMENT,
	pname varchar(255) null,
	market_price float default 0 not null,
	shop_price float default 0 not null,
	inventory int not null,
	image varchar(255) null,
	pdesc varchar(255) null,
	is_hot int default 0 not null,
	pdate datetime null,
	csid int not null,
	primary key(pid),
	key(csid)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


/**
 * 优惠券表
 */
create table ticket(
	tid int not null AUTO_INCREMENT COMMENT '优惠券编号',
	privilege double not null COMMENT '优惠券金额',
	consume double not null COMMENT '满减金额',
    useTime datetime not null COMMENT '使用期限',
    cid int not null COMMENT '类别编号',
    pacid int not null COMMENT '卡包编号',
    primary key(tid),
    unique key(cid),
    key(cid, pacid)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table user(
	uid int not null AUTO_INCREMENT,
	username varchar(255) null,
	password varchar(255) null,
	name varchar(255) null,
	email varchar(255) null,
	phone varchar(16) null,
	age int default 0 not null,
	addr varchar(255) null,
	state int default 0 not null,
	code varchar(64) null,
	primary key(uid)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


create table wallet(
	wid int not null AUTO_INCREMENT,
	money float default 0 not null,
	uid int not null,
	primary key(wid),
	unique key(uid)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

DELIMITER $$
CREATE TRIGGER u_afterinsert AFTER INSERT ON `user` FOR EACH ROW insert into wallet(uid) values (new.uid)
$$
DELIMITER ;


