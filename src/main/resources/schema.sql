drop table if exists DEVICES;
create table DEVICES (
	ID int auto_increment primary key,
	SERIAL_NUMBER int unique,
	PIN_CODE varchar2(7) unique,
	STATUS_ID int not null default 1,
	TEMPERATURE int not null default (-1)
);

drop table if exists STATUS;
create table STATUS (
	ID int auto_increment primary key,
	STATUS varchar2(10) not null
);

alter table devices
add foreign key (STATUS_ID)
references STATUS(ID);