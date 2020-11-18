-- Parece ser para los tipos de usuario (entre Productor y Comprador) (?)
insert into usuarioTipo (usTiId, usTiNombre) values (1, 'PRODUCTOR');

-- Tipos de identificacion
insert into usuarioTipoIdentificacion (usTiIdAbrev, ustiIdNombre) values ('C', 'Cedula de Ciudadania');

-- Moneda
insert into moneda (monId, monNombre) values (1, 'Pesos Colombianos');

-- Usuarios Productores (La tercera columna creo que es el Tipo de usuario Productor/Comprador) (?)
-- Hash MD5 Simple para la clave

-- Clave: L4sUp3rCl4v3
-- La funcion SHA2 esta disponible en MariaDB pero no en H2 Database, para este ultimo se usa HASH('SHA256', STRINGTOUTF8('THE_PWD'))
insert into usuario (usrLogin, usrCorreo, usrUsTiId, usrPassHash, usrUsTiIdAbrev, usrIdentificacion, usrMonid, usrPrimerNombre, usrPrimerApellido)
values ('julian_arango', 'julian_arango@tucorreo.com', 1, HASH('SHA256', STRINGTOUTF8('L4sUp3rCl4v3')), 'C', '123456789', 1, 'Julián', 'Arango');

-- Clave: 1122334455
-- La funcion SHA2 esta disponible en MariaDB pero no en H2 Database, para este ultimo se usa HASH('SHA256', STRINGTOUTF8('THE_PWD'))
insert into usuario (usrLogin, usrCorreo, usrUsTiId, usrPassHash, usrUsTiIdAbrev, usrIdentificacion, usrMonid, usrPrimerNombre, usrPrimerApellido, usrSegundoApellido)
values ('robinson_diaz', 'robinson_diaz@tucorreo.com', 1, HASH('SHA256', STRINGTOUTF8('1122334455')), 'C', '987654321', 1, 'Robinson', 'Díaz', 'Uribe');
