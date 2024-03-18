use miniproject;
create table question1(questionid int not null UNIQUE auto_increment, question varchar (255), option1 varchar(255),option2 varchar(255),
 option3 varchar(255),option4 varchar(255),correctAns varchar(255), primary key(questionid));

 insert into question1( question,option1,option2,option3,option4,correctAns) values('How many primitive data types are in java?','6','7','8','9','C');
 insert into question1( question,option1,option2,option3,option4,correctAns) values('Array in java are...','object reference','objects','primitive data type','none','A');
 insert into question1( question,option1,option2,option3,option4,correctAns) values('compareTo() returns...','true','false','an int value','none','C');
 insert into question1( question,option1,option2,option3,option4,correctAns) values('How many constructors are in string class?','3','7','13','20','C');
 insert into question1( question,option1,option2,option3,option4,correctAns) values('What is runnable?','abstract class','interface','class','method','B');
 insert into question1( question,option1,option2,option3,option4,correctAns) values('Who invented JAVA?','dennis ritchie','james gosling','bjarne stroustrap','none of these','B');
 insert into question1( question,option1,option2,option3,option4,correctAns) values('What is the extension of JAVA file?','.js','.txt','.class','.java','D');
 insert into question1( question,option1,option2,option3,option4,correctAns) values('Which of the following is not an oops concept in java?','polymorphism','inheritance','compilation','encapsulation','C');
 insert into question1( question,option1,option2,option3,option4,correctAns) values('Which of these keyword is used to define interface in java?','intf','Intf','interface','Interface','C');
 insert into question1( question,option1,option2,option3,option4,correctAns) values('Which of the following is a superclass of every class in java?','array list','abstract class','object class','string','C');
