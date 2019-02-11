create database Y18S2B5
go
use Y17S3B5
go
create table Semester (
ID int identity(1,1) primary key,
Name nvarchar(200) not null
)
go
create table Trainer (
Code int identity(1,1) primary key,
ID int references Semester(ID),
Name nvarchar(200) not null,
Address nvarchar(200) not null,
LastUpdated date not null,
Actived bit not null
)
go
create table Subject (
Code int identity(1,1) primary key,
ID int references Semester(ID),
Name nvarchar(200) not null,
Credit int not null,
LastUpdated date not null,
Actived bit not null
)
go
insert into Semester values('Spring2017')
insert into Semester values('Spring2016')
insert into Semester values('Summer2017')
go
insert into Trainer values(1,'DungHA','Melbourne, UA','09/05/2001',0)
insert into Trainer values(1,'LamPT','Ha Noi, VN','11/03/1996',1)
insert into Trainer values(2,'DungLM','Thai Binh, VN','06/11/2008',1)
go
insert into Subject values(1,'.Net & C#',4,'09/05/2016',1)
insert into Subject values(1,'OOP with C++',3,'02/11/2001',0)
insert into Subject values(3,'Water Color',4,'12/07/2013',1)
