CREATE TABLE Person.dbo.Persons
(
  ID int NOT NULL IDENTITY(1,1),
  FirstName varchar(50) NOT NULL,
  LastName varchar(50) NOT NULL,
  PersonCode varchar(50) NOT NULL,
  Email varchar(50) NOT NULL,
  PhoneNumber varchar(50) NOT NULL,
  PRIMARY KEY (ID)
)