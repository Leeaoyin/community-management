# community-management
 ## table design below
___
### ___user___
```sql
CREATE TABLE user (
	id INT NOT NULL AUTO_INCREMENT COMMENT 'user id',
	user_name VARCHAR ( 64 ) DEFAULT NULL COMMENT 'user name',
	user_password VARCHAR ( 64 ) DEFAULT NULL COMMENT 'user password',
	user_type INT DEFAULT NULL COMMENT '0:administrator，1:ordinary user',
	create_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'create time',
	update_time datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'update time',
	PRIMARY KEY ( id ),
	UNIQUE KEY user_name_unique ( user_name ) 
) ENGINE = INNODB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8mb3 COMMENT = '用户表';
```
### ___apply_active___
```sql
CREATE TABLE apply_active (
	id INT ( 10 ) NOT NULL AUTO_INCREMENT,
	user_id INT ( 10 ) NOT NULL COMMENT '用户ID',
	active_type INT DEFAULT NULL COMMENT '0:外出，1:进入',
  active_time datetime NOT NULL COMMENT '外出/进入时间',
	reason VARCHAR ( 200 ) NOT NULL COMMENT '申请原因',
	family_friend VARCHAR ( 50 ) DEFAULT NULL COMMENT '亲戚朋友姓名',
  state INT ( 2 ) NOT NULL DEFAULT '0' COMMENT '状态，0未审核/1审核通过',
	create_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'create time',
	update_time datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'update time',
	PRIMARY KEY ( id ) 
) ENGINE = INNODB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8mb3 COMMENT = '出门申请表';
```
### ___apply_material___
```sql
CREATE TABLE apply_material (
	id INT ( 11 ) NOT NULL AUTO_INCREMENT,
	material_name VARCHAR ( 50 ) NOT NULL COMMENT '物资名称',
	num INT ( 11 ) NOT NULL DEFAULT '1' COMMENT '物资数量',
	create_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP  COMMENT '创建时间',
	update_time datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	PRIMARY KEY ( id ) 
) ENGINE = INNODB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8mb3 COMMENT = '物资申请表';
```

### ___vaccine_order___
```sql
CREATE TABLE vaccine_order (
	id INT ( 10 ) NOT NULL AUTO_INCREMENT,
	user_id INT ( 10 ) NOT NULL COMMENT '预约人ID',
	phone VARCHAR ( 11 ) NOT NULL COMMENT '预约人手机号',
  vaccine_name VARCHAR ( 11 ) NOT NULL COMMENT '预约疫苗名称',
	order_time datetime NOT NULL COMMENT '预约时间',
  state INT ( 10 ) NOT NULL DEFAULT '0' COMMENT '是否过期，0未过期/1已过期',
	create_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	update_time datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	PRIMARY KEY ( id )
) ENGINE = INNODB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8mb3 COMMENT = '疫苗预约表';
```
### ___user_info___
```sql
CREATE TABLE user_info (
	id INT ( 10 ) NOT NULL AUTO_INCREMENT,
	user_id INT ( 10 ) NOT NULL COMMENT '用户ID',
  user_name VARCHAR ( 64 ) DEFAULT NULL COMMENT '住户姓名',
	email VARCHAR ( 64 ) DEFAULT NULL COMMENT 'email',
	phone VARCHAR ( 11 ) DEFAULT NULL COMMENT 'phone',
	room_number INT ( 11 ) NOT NULL COMMENT '房间编号',
	health_state INT ( 10 ) NOT NULL DEFAULT '0' COMMENT '健康状态：0康/1病',
  create_time datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	update_time datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	PRIMARY KEY (  id  )
) ENGINE = INNODB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8mb3 COMMENT = '住户信息表';
```