INSERT INTO personas (identificacion, pri_nombre, seg_nombre, pri_apellido, seg_apellido, correo, direccion, genero, telefono) VALUES (123, 'Jose','Antonio','Rodriguez','Cubillos','jose@mail.com','Cr 26 #1A','M','3148828393');
INSERT INTO personas (identificacion, pri_nombre, seg_nombre, pri_apellido, seg_apellido, correo, direccion, genero, telefono) VALUES (12345, 'Luz','Maria','Rodriguez','Orejuela','luz@mail.com','Cr 50 87-1','F','3154332');
INSERT INTO personas (identificacion, pri_nombre, seg_nombre, pri_apellido, seg_apellido, correo, direccion, genero, telefono) VALUES (123456, 'Miguel','Josue','Gomez','Olga','miguel@mail.com','Av 2 Cr-24','M','316839933');
INSERT INTO personas (identificacion, pri_nombre, seg_nombre, pri_apellido, seg_apellido, correo, direccion, genero, telefono) VALUES (12, 'Cristian','Camilo','Rodriguez','Mattew','cristian@mail.com','Cr 145 #21','M','3179493');
INSERT INTO personas (identificacion, pri_nombre, seg_nombre, pri_apellido, seg_apellido, correo, direccion, genero, telefono) VALUES (1, 'Maria','Jose','Velez','Caceres','maria@mail.com','Dg 71 23-1','F','31899393');

INSERT INTO check_in (fecha_ingreso, fecha_salida, numero_dias, id_persona) VALUES ('2020-10-5', '2020-10-10', 5, 4);
INSERT INTO check_in (fecha_ingreso, fecha_salida, numero_dias, id_persona) VALUES ('2019-08-10', '2019-08-20', 10, 5);

INSERT INTO tipo_habitacion (desc_tipo_habitacion, nom_tipo_habitacion, precio_habitacion) VALUES ('Para 2 personas','Suite de Lujo',340000);
INSERT INTO tipo_habitacion (desc_tipo_habitacion, nom_tipo_habitacion, precio_habitacion) VALUES ('Para 4 personas','Suite Economica',400000);
INSERT INTO tipo_habitacion (desc_tipo_habitacion, nom_tipo_habitacion, precio_habitacion) VALUES ('Para 2 personas','Suite Sencilla',150000);
INSERT INTO tipo_habitacion (desc_tipo_habitacion, nom_tipo_habitacion, precio_habitacion) VALUES ('Para 2 personas','Suite VIP',560000);

INSERT INTO habitaciones (estado, num_habitacion, id_tipo_habitacion) VALUES ('D',450, 2);
INSERT INTO habitaciones (estado, num_habitacion, id_tipo_habitacion) VALUES ('L',120, 2);
INSERT INTO habitaciones (estado, num_habitacion, id_tipo_habitacion) VALUES ('O',51, 1);
INSERT INTO habitaciones (estado, num_habitacion, id_tipo_habitacion) VALUES ('R',45, 4);
INSERT INTO habitaciones (estado, num_habitacion, id_tipo_habitacion) VALUES ('D',96, 4);

INSERT INTO checkin_habitaciones (id_checkin, id_habitacion) VALUES (1,1);
INSERT INTO checkin_habitaciones (id_checkin, id_habitacion) VALUES (1,2);
INSERT INTO checkin_habitaciones (id_checkin, id_habitacion) VALUES (1,3);
INSERT INTO checkin_habitaciones (id_checkin, id_habitacion) VALUES (2,4);
INSERT INTO checkin_habitaciones (id_checkin, id_habitacion) VALUES (2,5);