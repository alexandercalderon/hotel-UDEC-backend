INSERT INTO usuario (cedula, ciudad, direccion, email, nombre, apellido, telefono) VALUES ('1000302','Bogota','Cr 26 # 1A','lucas@mail.com','Lucas','Rodriguez','31445434');
INSERT INTO usuario (cedula, ciudad, direccion, email, nombre, apellido, telefono) VALUES ('1999292','Medellin','Cr 50 El Poblado','Natalia@mail.com','Andrea','Lucia','212212');

INSERT INTO habitacion (numero_habitacion, tarifa) VALUES (542, 50000);
INSERT INTO habitacion (numero_habitacion, tarifa) VALUES (102, 60000);
INSERT INTO habitacion (numero_habitacion, tarifa) VALUES (402, 120000);
INSERT INTO habitacion (numero_habitacion, tarifa) VALUES (56, 80000);
INSERT INTO habitacion (numero_habitacion, tarifa) VALUES (91, 210000);

INSERT INTO usuarios_habitaciones (usuario_id, habitacion_id) VALUES (1,1);
INSERT INTO usuarios_habitaciones (usuario_id, habitacion_id) VALUES (1,2);
INSERT INTO usuarios_habitaciones (usuario_id, habitacion_id) VALUES (1,3);
INSERT INTO usuarios_habitaciones (usuario_id, habitacion_id) VALUES (2,4);
INSERT INTO usuarios_habitaciones (usuario_id, habitacion_id) VALUES (2,5);

INSERT INTO check_in (fecha_ingreso, fecha_salida, numero_dias) VALUES ('2020-10-5', '2020-10-10', 5);
INSERT INTO check_in (fecha_ingreso, fecha_salida, numero_dias) VALUES ('2019-08-10', '2019-08-20', 10);