create sequence hibernate_sequence start with 1 increment by 1
create table author (id bigint not null, first_name varchar(255), last_name varchar(255), primary key (id))
create table author_book (book_id bigint not null, author_id bigint not null, primary key (book_id, author_id))
create table book (id bigint not null, isbn varchar(255), title varchar(255), publisher_id bigint, primary key (id))
create table publisher (id bigint not null, name varchar(255), primary key (id))
create table result_word_group (month bigint not null, id_number bigint not null, hash_code varchar(255) not null, word varchar(255), primary key (month, id_number, hash_code))
create table result_definition (id bigint not null, description varchar(255), name varchar(255), primary key (id))
create table result_definition_word_group (result_definition_id bigint not null, word_group_month bigint not null, word_group_id_number bigint not null, word_group_hash_code varchar(255) not null)
alter table result_definition_word_group add constraint UK_dp73nk6sq6l13ui1dii2fiw19 unique (word_group_month, word_group_id_number, word_group_hash_code)
alter table author_book add constraint FKg7j6ud9d32ll232o9mgo90s57 foreign key (author_id) references author
alter table author_book add constraint FKn8665s8lv781v4eojs8jo3jao foreign key (book_id) references book
alter table book add constraint FKgtvt7p649s4x80y6f4842pnfq foreign key (publisher_id) references publisher
alter table result_definition_word_group add constraint FKdr795m9swcrem4hejhltrr07a foreign key (word_group_month, word_group_id_number, word_group_hash_code) references result_word_group
alter table result_definition_word_group add constraint FKog8ewg92jdo4n68qt8o8ymtmn foreign key (result_definition_id) references result_definition
