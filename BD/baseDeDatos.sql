create database tablemibarrio;
use tablemibarrio;

create table facturas(
	id_fac int not null,
    id_tien int not null,
    id_clien int not null,
    fecha_fac varchar(50),
    hora_fac varchar(10),
    descripcion_fac varchar(100),
    total_fac double,
    constraint pk_id_fac primary key (id_fac)
);

create table productos(
	codigo_prod int not null,
    nombre_prod varchar (100),
    marca_prod varchar(50),
    descripcion_prod varchar(150),
    url_imagen varchar (150),
    precio_prod double,
    cantidad_prod int,
    constraint pk_codigo_prod primary key (codigo_prod)
);

select * from facturas;
select * from productos;
INSERT INTO `tablemibarrio`.`facturas` (`id_fac`, `id_tien`, `id_clien`, `fecha_fac`, `hora_fac`, `descripcion_fac`, `total_fac`) VALUES ('1', '143', '1', '12/09/22', '12:00', 'factura andrés', '12000');
INSERT INTO `tablemibarrio`.`facturas` (`id_fac`, `id_tien`, `id_clien`, `fecha_fac`, `hora_fac`, `descripcion_fac`, `total_fac`) VALUES ('2', '987', '2', '12/10/22', '10:00', 'factura Sara', '20000');
INSERT INTO `tablemibarrio`.`productos` (`codigo_prod`, `nombre_prod`, `marca_prod`, `descripcion_prod`, `url_imagen`, `precio_prod`, `cantidad_prod`) VALUES ('1', 'jabón', 'dove', 'jabon en barra', 'jabon.png', '3000', '100');
INSERT INTO `tablemibarrio`.`productos` (`codigo_prod`, `nombre_prod`, `marca_prod`, `descripcion_prod`, `url_imagen`, `precio_prod`, `cantidad_prod`) VALUES ('2', 'cereal', 'kelogs', 'cereal en caja azucarado', 'cereal.png', '11000', '120');
