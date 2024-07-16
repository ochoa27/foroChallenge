create table IF NOT EXISTS usuarios(

                          id bigint not null auto_increment,
                          name varchar(100) not null,
                          lastname varchar(100) not null,
                          email varchar(100) not null unique,
                          tel varchar(15),


                          primary key(id)

);