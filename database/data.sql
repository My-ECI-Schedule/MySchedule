INSERT INTO ASSIGNATURES (id,Name) VALUES (1,'ARSW');
INSERT INTO ASSIGNATURES (id,Name) VALUES (2,'AREP');
INSERT INTO ASSIGNATURES (id,Name) VALUES (3,'SPTI');
INSERT INTO ASSIGNATURES (id,Name) VALUES (4,'FDGP');
INSERT INTO ASSIGNATURES (id,Name) VALUES (5,'EGR1');

INSERT INTO DATE (id,hora_inicio,hora_final,dia,id_assignature) VALUES (1,'07:00','10:00','L',1);
INSERT INTO DATE (id,hora_inicio,hora_final,dia,id_assignature) VALUES (2,'08:30','10:00','J',2);
INSERT INTO DATE (id,hora_inicio,hora_final,dia,id_assignature) VALUES (3,'11:30','13:00','V',3);
INSERT INTO DATE (id,hora_inicio,hora_final,dia,id_assignature) VALUES (4,'07:00','08:30','M',1);
INSERT INTO DATE (id,hora_inicio,hora_final,dia,id_assignature) VALUES (5,'16:00','19:00','X',3);

INSERT INTO CUSTOMERS (id,name) VALUES (0,'Diego');
INSERT INTO CUSTOMERS (id,name) VALUES (1,'baez');
INSERT INTO CUSTOMERS (id,name) VALUES (2,'Majo');
INSERT INTO CUSTOMERS (id,name) VALUES (3,'Kristhian');
INSERT INTO CUSTOMERS (id,name) VALUES (24,'Sebastian');

INSERT INTO schedules(id, creation_date, owner)VALUES (0,current_timestamp,0);

INSERT INTO AssignatureXSchedule (schedule_id,assignature_Id) VALUES (0,1);
INSERT INTO AssignatureXSchedule (schedule_id,assignature_Id) VALUES (0,2);
INSERT INTO AssignatureXSchedule (schedule_id,assignature_Id) VALUES (0,3);
INSERT INTO AssignatureXSchedule (schedule_id,assignature_Id) VALUES (0,4);
INSERT INTO AssignatureXSchedule (schedule_id,assignature_Id) VALUES (0,5);


INSERT INTO KANBAN (id,assignature_Id,creation_date) VALUES (1,1,current_timestamp);
INSERT INTO KANBAN (id,assignature_Id,creation_date) VALUES (2,2,current_timestamp);
INSERT INTO KANBAN (id,assignature_Id,creation_date) VALUES (3,3,current_timestamp);
INSERT INTO KANBAN (id,assignature_Id,creation_date) VALUES (4,4,current_timestamp);
INSERT INTO KANBAN (id,assignature_Id,creation_date) VALUES (5,5,current_timestamp);

insert into kanban_columns (id,id_kanban,"name") values (3,1,'TO_DO');
insert into kanban_columns (id,id_kanban,"name") values (2,1,'DOING');
insert into kanban_columns (id,id_kanban,"name") values (1,1,'DONE');
insert into kanban_columns (id,id_kanban,"name") values (6,2,'TO_DO');
insert into kanban_columns (id,id_kanban,"name") values (5,2,'DOING');
insert into kanban_columns (id,id_kanban,"name") values (4,2,'DONE');
insert into kanban_columns (id,id_kanban,"name") values (9,3,'TO_DO');
insert into kanban_columns (id,id_kanban,"name") values (8,3,'DOING');
insert into kanban_columns (id,id_kanban,"name") values (7,3,'DONE');



DELETE FROM public.tasks;
insert into tasks (id ,description,is_public,id_customer,id_kanban_column) values (1,'Realizar tarea 1',true,0,1);
insert into tasks (id ,description,is_public,id_customer,id_kanban_column) values (2,'Realizar tarea 2',true,0,2);
insert into tasks (id, description,is_public,id_customer,id_kanban_column) values (3,'Realizar tarea 3',true,0,3);
