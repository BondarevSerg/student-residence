
-- пользователь с ролью ADMIN
insert into user(login, password, role) values
                                            ('admin',
                                             '$2a$12$I2y09CJuNkq/uOox85dfBOwT6iSzCJo8FomE/E8sEIuH7g1XwHFTm',
                                             'ROLE_ADMIN');
-- учебное заведение
insert into university(name) values ('University');
-- два общежития по 50 мест
insert into residence(capacity, gender, university_id) VALUES (50, 'FEMALE', 1);
insert into residence(capacity, gender, university_id) VALUES (50, 'MALE', 1);














