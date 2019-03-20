/*Rules*/
insert  into solar_system.role(role_id, role) values(1, 'ADMIN');
insert into solar_system.role(role_id, role) values (2, 'USER');

/*
Users
 */

 insert into solar_system.user (id, active, name, password)
 values (1, 1,'ADMIN','$2a$10$T2je4KQ9B1kC/RcFJBkiGerYQ/zXwiRvUVk49vSCSrc4PflwRO1tO');

insert into solar_system.user (id, active, name, password)
values (2, 1,'USER','$2a$10$TOQNQfOiwqqm6EwO//YkvuLTFFAmuLSUTl/4/WSv62orD9d71Ag.C');

/*ADD ROLE TO USER*/

insert into solar_system.user_role (user_id, role_id)
values (1, 1);
insert into solar_system.user_role (user_id, role_id)
values (1, 2);

insert into solar_system.user_role (user_id, role_id)
values (2, 2);