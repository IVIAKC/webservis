CREATE TABLE mytable (
    id  	    SERIAL PRIMARY KEY,
    login           varchar(20),
    password	    varchar(20),
    first_name       varchar(20),
    last_name        varchar(20)
);

INSERT INTO mytable(login,password,first_name,last_name)
VALUES ('IVIAKC','qwe','Max','Bytorin');

INSERT INTO mytable(login,password,first_name,last_name)
VALUES ('eXerious','asd','Dmitr','Bytorin');

INSERT INTO mytable(login,password,first_name,last_name)
VALUES ('Devostator','zxc','Artem','Kicel');

INSERT INTO mytable(login,password,first_name,last_name)
VALUES ('D','zxc','Artem','Kicel');

INSERT INTO mytable(login,password,first_name,last_name)
VALUES ('Kir','wer','�������','��������');

DROP table mytable;