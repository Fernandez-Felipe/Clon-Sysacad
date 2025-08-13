CREATE DATABASE IF NOT EXISTS `alumnos-sysacad`;
CREATE DATABASE IF NOT EXISTS `inscripciones-materias`;

GRANT ALL PRIVILEGES ON `alumnos-sysacad`.* TO 'testuser'@'%';
GRANT ALL PRIVILEGES ON `inscripciones-materias`.* TO 'testuser'@'%';

FLUSH PRIVILEGES;