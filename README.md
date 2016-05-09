# RMI_SistemasDistribuidos
Proyectos del ramo de sistemas distribuidos


#Script de la base de datos

insert into persona (nombre, apellidoPaterno, apellidoMaterno) values('Fabian', 'Catalan', 'Chavez');
insert into persona (nombre, apellidoPaterno, apellidoMaterno) values('Nivaldo', 'Perot', 'Quezada');

insert into usuario (nombre, contrasena, idPersona)values('fcatalan', '12345', 3);

insert into cliente (idPersona, codigoCliente)values(4, 'cli1');

insert into productos (nombre, codigo)values('computador', 'pro1');

insert into venta (idCliente, idProducto, cantidad)values(1, 1, 10);