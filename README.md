# RMI_SistemasDistribuidos
Proyectos del ramo de sistemas distribuidos


#Script de la base de datos


/*==============================================================*/
/* Table: CLIENTE                                               */
/*==============================================================*/
create table CLIENTE (
   IDCLIENTE            SERIAL not null,
   IDPERSONA            INT4                 null,
   CODIGOCLIENTE        VARCHAR(100)         null,
   constraint PK_CLIENTE primary key (IDCLIENTE)
);

/*==============================================================*/
/* Table: PERSONA                                               */
/*==============================================================*/
create table PERSONA (
   IDPERSONA            SERIAL not null,
   NOMBRE               VARCHAR(100)         null,
   APELLIDOPATERNO      VARCHAR(100)         null,
   APELLIDOMATERNO      VARCHAR(100)         null,
   constraint PK_PERSONA primary key (IDPERSONA)
);

/*==============================================================*/
/* Table: PRODUCTOS                                             */
/*==============================================================*/
create table PRODUCTOS (
   IDPRODUCTO           SERIAL not null,
   NOMBRE               VARCHAR(100)         null,
   CODIGO               VARCHAR(100)         null,
   constraint PK_PRODUCTOS primary key (IDPRODUCTO)
);

/*==============================================================*/
/* Table: USUARIO                                               */
/*==============================================================*/
create table USUARIO (
   IDUSUARIO            SERIAL not null,
   IDPERSONA            INT4                 null,
   NOMBRE               VARCHAR(100)         null,
   CONTRASENA           VARCHAR(100)         null,
   constraint PK_USUARIO primary key (IDUSUARIO)
);

/*==============================================================*/
/* Table: VENTA                                                 */
/*==============================================================*/
create table VENTA (
   IDVENTA              SERIAL not null,
   IDCLIENTE            INT4                 null,
   IDPRODUCTO           INT4                 null,
   CANTIDAD             INT4                 null,
   constraint PK_VENTA primary key (IDVENTA)
);

alter table CLIENTE
   add constraint FK_CLIENTE_REFERENCE_PERSONA foreign key (IDPERSONA)
      references PERSONA (IDPERSONA)
      on delete restrict on update restrict;

alter table USUARIO
   add constraint FK_USUARIO_REFERENCE_PERSONA foreign key (IDPERSONA)
      references PERSONA (IDPERSONA)
      on delete restrict on update restrict;

alter table VENTA
   add constraint FK_VENTA_REFERENCE_CLIENTE foreign key (IDCLIENTE)
      references CLIENTE (IDCLIENTE)
      on delete restrict on update restrict;

alter table VENTA
   add constraint FK_VENTA_REFERENCE_PRODUCTO foreign key (IDPRODUCTO)
      references PRODUCTOS (IDPRODUCTO)
      on delete restrict on update restrict;

	  
	  
# Primer inser

insert into persona (nombre, apellidoPaterno, apellidoMaterno) values('Fabian', 'Catalan', 'Chavez');
insert into persona (nombre, apellidoPaterno, apellidoMaterno) values('Nivaldo', 'Perot', 'Quezada');
insert into persona (nombre, apellidoPaterno, apellidoMaterno) values('Santiago', 'Catalan', 'Herrera');

insert into usuario (nombre, contrasena, idPersona)values('fcatalan', '12345', 1);

insert into cliente (idPersona, codigoCliente)values(2, 'cli1');
insert into cliente (idPersona, codigoCliente)values(3, 'cli2');

insert into productos (nombre, codigo)values('computador', 'pro1');

insert into venta (idCliente, idProducto, cantidad)values(1, 1, 10);