-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 20-05-2025 a las 13:15:47
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `biblioteca`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libro`
--

CREATE TABLE `libro` (
  `Titulo` varchar(50) NOT NULL,
  `Autor` varchar(40) NOT NULL,
  `ISBN` varchar(20) NOT NULL,
  `Fecha_de_publicacion` date NOT NULL,
  `Categoria` varchar(30) NOT NULL,
  `id_usuario` int(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `libro`
--

INSERT INTO `libro` (`Titulo`, `Autor`, `ISBN`, `Fecha_de_publicacion`, `Categoria`, `id_usuario`) VALUES
('El principito', 'Antoine de Saint-Exupéry', '9780156012195', '1943-04-06', 'Infantil', 1),
('Cien años de soledad', 'Gabriel García Márquez', '9780307474728', '1967-05-30', 'Drama', NULL),
('1984', 'George Orwell', '9780451524935', '1949-06-08', 'Drama', NULL),
('It', 'Stephen King', '9788401021356', '1986-09-15', 'Terror', 8),
('La sombra del viento', 'Carlos Ruiz Zafón', '9788408079545', '2001-03-01', 'Drama', NULL),
('Don Quijote de la Mancha', 'Miguel de Cervantes', '9788420412146', '1605-01-16', 'Drama', NULL),
('Los juegos del hambre', 'Suzanne Collins', '9788427202122', '2008-09-14', 'Accion', NULL),
('Harry Potter y la piedra filosofal', 'J.K. Rowling', '9788478884456', '1997-06-26', 'Infantil', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `ID` int(3) NOT NULL,
  `Nombre` varchar(40) NOT NULL,
  `Apellidos` varchar(40) NOT NULL,
  `Fecha_de_nacimiento` date NOT NULL,
  `Email` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`ID`, `Nombre`, `Apellidos`, `Fecha_de_nacimiento`, `Email`) VALUES
(1, 'María', 'González Pérez', '1985-03-15', 'maria.gonzalez@email.com'),
(2, 'Carlos', 'Martín Ruiz', '1992-07-22', 'carlos.martin@email.com'),
(3, 'Laura', 'Fernández López', '1978-11-30', 'laura.fernandez@email.com'),
(4, 'Javier', 'Sánchez Díaz', '1989-05-18', 'javier.sanchez@email.com'),
(5, 'Ana', 'Rodríguez García', '1995-09-10', 'ana.rodriguez@email.com'),
(6, 'David', 'Pérez Castro', '1982-12-05', 'david.perez@email.com'),
(7, 'Sofía', 'Jiménez Mendoza', '1990-02-28', 'sofia.jimenez@email.com'),
(8, 'Pedro', 'Torres Ortega', '1975-08-14', 'pedro.torres@email.com');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `libro`
--
ALTER TABLE `libro`
  ADD PRIMARY KEY (`ISBN`),
  ADD KEY `id_cliente` (`id_usuario`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `ID` (`ID`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `ID` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `libro`
--
ALTER TABLE `libro`
  ADD CONSTRAINT `libro_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
