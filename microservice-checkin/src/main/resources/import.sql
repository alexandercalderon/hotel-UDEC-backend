INSERT INTO usuario (cedula, ciudad, direccion, email, nombre, pais, telefono) VALUES ('1000302','Bogota','Cr 26 # 1A','lucas@mail.com','Lucas Jose','Colombia','31445434');
INSERT INTO usuario (cedula, ciudad, direccion, email, nombre, pais, telefono) VALUES ('1999292','Medellin','Cr 50 El Poblado','Natalia@mail.com','Natalia Andrea','Colombia','212212');

INSERT INTO habitacion (estado, numero_habitacion, tarifa) VALUES ('O', 542, 50000);
INSERT INTO habitacion (estado, numero_habitacion, tarifa) VALUES ('L', 102, 60000);
INSERT INTO habitacion (estado, numero_habitacion, tarifa) VALUES ('D', 402, 120000);
INSERT INTO habitacion (estado, numero_habitacion, tarifa) VALUES ('O', 56, 80000);
INSERT INTO habitacion (estado, numero_habitacion, tarifa) VALUES ('D', 91, 210000);

INSERT INTO usuarios_habitaciones (usuario_id, habitacion_id) VALUES (1,1);
INSERT INTO usuarios_habitaciones (usuario_id, habitacion_id) VALUES (1,2);
INSERT INTO usuarios_habitaciones (usuario_id, habitacion_id) VALUES (1,3);
INSERT INTO usuarios_habitaciones (usuario_id, habitacion_id) VALUES (2,4);
INSERT INTO usuarios_habitaciones (usuario_id, habitacion_id) VALUES (2,5);