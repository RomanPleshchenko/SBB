-- phpMyAdmin SQL Dump
-- version 4.4.15.7
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1:3306
-- Время создания: Апр 24 2017 г., 18:40
-- Версия сервера: 5.5.50
-- Версия PHP: 5.3.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `sbb`
--

-- --------------------------------------------------------

--
-- Структура таблицы `car`
--

CREATE TABLE IF NOT EXISTS `car` (
  `id` int(11) NOT NULL,
  `carPrototypeId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Структура таблицы `carPrototype`
--

CREATE TABLE IF NOT EXISTS `carPrototype` (
  `id` int(11) NOT NULL,
  `name` varchar(30) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `carPrototype`
--

INSERT INTO `carPrototype` (`id`, `name`) VALUES
(1, 'standart');

-- --------------------------------------------------------

--
-- Структура таблицы `carPrototypeComposition`
--

CREATE TABLE IF NOT EXISTS `carPrototypeComposition` (
  `id` int(11) NOT NULL,
  `carPrototypeId` int(11) NOT NULL,
  `siteId` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `carPrototypeComposition`
--

INSERT INTO `carPrototypeComposition` (`id`, `carPrototypeId`, `siteId`) VALUES
(1, 1, 1),
(2, 1, 2),
(3, 1, 3),
(4, 1, 4),
(5, 1, 5),
(6, 1, 6),
(7, 1, 7),
(8, 1, 8),
(9, 1, 9),
(10, 1, 10),
(11, 1, 11),
(12, 1, 12),
(13, 1, 13),
(14, 1, 14),
(15, 1, 15),
(16, 1, 16),
(17, 1, 17),
(18, 1, 18),
(19, 1, 19),
(20, 1, 20),
(21, 1, 21),
(22, 1, 22),
(23, 1, 23),
(24, 1, 24),
(25, 1, 25),
(26, 1, 26),
(27, 1, 27),
(28, 1, 28),
(29, 1, 29),
(30, 1, 30),
(31, 1, 31),
(32, 1, 32),
(33, 1, 33),
(34, 1, 34),
(35, 1, 35),
(36, 1, 36),
(37, 1, 37),
(38, 1, 38),
(39, 1, 39),
(40, 1, 40),
(41, 1, 41),
(42, 1, 42),
(43, 1, 43),
(44, 1, 44),
(45, 1, 45),
(46, 1, 46),
(47, 1, 47),
(48, 1, 48),
(49, 1, 49),
(50, 1, 50),
(51, 1, 51);

-- --------------------------------------------------------

--
-- Структура таблицы `passenger`
--

CREATE TABLE IF NOT EXISTS `passenger` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `surname` varchar(45) NOT NULL,
  `birthDate` date NOT NULL,
  `idUser` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `passenger`
--

INSERT INTO `passenger` (`id`, `name`, `surname`, `birthDate`, `idUser`) VALUES
(1, 'Roman', 'Pleshchenko', '1989-04-04', 1),
(2, 'Vasya', 'Pupkin', '2017-04-01', 2);

-- --------------------------------------------------------

--
-- Структура таблицы `role`
--

CREATE TABLE IF NOT EXISTS `role` (
  `id` bigint(20) NOT NULL,
  `type` varchar(30) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `role`
--

INSERT INTO `role` (`id`, `type`) VALUES
(2, 'ADMIN'),
(3, 'DBA'),
(1, 'USER');

-- --------------------------------------------------------

--
-- Структура таблицы `schedule`
--

CREATE TABLE IF NOT EXISTS `schedule` (
  `id` int(11) NOT NULL,
  `trainId` int(11) NOT NULL,
  `departureTime` timestamp NULL DEFAULT '0000-00-00 00:00:00',
  `destinationTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `segmentId` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `schedule`
--

INSERT INTO `schedule` (`id`, `trainId`, `departureTime`, `destinationTime`, `segmentId`) VALUES
(3, 4, '2017-04-01 00:21:22', '2017-04-02 02:31:48', 7),
(4, 10, '2017-04-05 23:14:33', '2017-04-09 02:33:50', 8),
(5, 4, '2017-04-09 03:26:00', '2017-04-09 21:08:32', 7),
(11, 10, '2017-04-12 21:00:00', '2017-05-12 21:00:00', 7),
(20, 10, '2017-05-12 21:00:00', '2017-04-13 21:00:00', 23),
(21, 4, '2017-04-13 21:00:00', '2017-04-13 21:00:00', 7);

-- --------------------------------------------------------

--
-- Структура таблицы `schedule`
--

CREATE TABLE IF NOT EXISTS `segment` (
  `id` int(11) NOT NULL,
  `departureStationId` int(11) NOT NULL,
  `destinationStationId` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `schedule`
--

INSERT INTO `segment` (`id`, `departureStationId`, `destinationStationId`) VALUES
(7, 1, 2),
(8, 1, 3),
(9, 1, 4),
(13, 4, 1),
(22, 4, 2),
(23, 4, 3),
(24, 3, 1),
(25, 3, 2),
(26, 3, 4),
(27, 2, 1),
(28, 2, 3),
(29, 2, 4);

-- --------------------------------------------------------

--
-- Структура таблицы `site`
--

CREATE TABLE IF NOT EXISTS `site` (
  `id` int(11) NOT NULL,
  `number` int(3) NOT NULL,
  `type` varchar(30) NOT NULL,
  `level` varchar(30) NOT NULL,
  `note` varchar(30) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `site`
--

INSERT INTO `site` (`id`, `number`, `type`, `level`, `note`) VALUES
(1, 1, 'inner', 'bottom', 'standart'),
(2, 2, 'inner', 'top', 'standart'),
(3, 3, 'inner', 'bottom', 'standart'),
(4, 4, 'inner', 'top', 'standart'),
(5, 5, 'inner', 'bottom', 'standart'),
(6, 6, 'inner', 'top', 'standart'),
(7, 7, 'inner', 'bottom', 'standart'),
(8, 8, 'inner', 'top', 'standart'),
(9, 9, 'inner', 'bottom', 'standart'),
(10, 10, 'inner', 'top', 'standart'),
(11, 11, 'inner', 'bottom', 'standart'),
(12, 12, 'inner', 'top', 'standart'),
(13, 13, 'inner', 'bottom', 'standart'),
(14, 14, 'inner', 'top', 'standart'),
(15, 15, 'inner', 'bottom', 'standart'),
(16, 16, 'inner', 'top', 'standart'),
(17, 17, 'inner', 'bottom', 'standart'),
(18, 18, 'inner', 'top', 'standart'),
(19, 19, 'inner', 'bottom', 'standart'),
(20, 20, 'inner', 'top', 'standart'),
(21, 21, 'inner', 'bottom', 'standart'),
(22, 22, 'inner', 'top', 'standart'),
(23, 23, 'inner', 'bottom', 'standart'),
(24, 24, 'inner', 'top', 'standart'),
(25, 25, 'inner', 'bottom', 'standart'),
(26, 26, 'inner', 'top', 'standart'),
(27, 27, 'inner', 'bottom', 'standart'),
(28, 28, 'inner', 'top', 'standart'),
(29, 29, 'inner', 'bottom', 'standart'),
(30, 30, 'inner', 'top', 'standart'),
(31, 31, 'inner', 'bottom', 'standart'),
(32, 32, 'inner', 'top', 'standart'),
(33, 33, 'inner', 'bottom', 'standart'),
(34, 34, 'inner', 'top', 'standart'),
(35, 35, 'inner', 'bottom', 'standart'),
(36, 36, 'inner', 'top', 'standart'),
(37, 37, 'side', 'bottom', 'standart'),
(38, 38, 'side', 'top', 'standart'),
(39, 39, 'side', 'bottom', 'standart'),
(40, 40, 'side', 'top', 'standart'),
(41, 41, 'side', 'bottom', 'standart'),
(42, 42, 'side', 'top', 'standart'),
(43, 43, 'side', 'bottom', 'standart'),
(44, 44, 'side', 'top', 'standart'),
(45, 45, 'side', 'bottom', 'standart'),
(46, 46, 'side', 'top', 'standart'),
(47, 47, 'side', 'bottom', 'standart'),
(48, 48, 'side', 'top', 'standart'),
(49, 49, 'side', 'bottom', 'standart'),
(50, 50, 'side', 'top', 'standart'),
(51, 51, 'side', 'bottom', 'standart'),
(52, 52, 'side', 'top', 'standart'),
(53, 53, 'side', 'bottom', 'standart'),
(54, 54, 'side', 'top', 'standart');

-- --------------------------------------------------------

--
-- Структура таблицы `station`
--

CREATE TABLE IF NOT EXISTS `station` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `station`
--

INSERT INTO `station` (`id`, `name`) VALUES
(1, 'Moscow'),
(2, 'Berlin'),
(3, 'Paris'),
(4, 'London');

-- --------------------------------------------------------

--
-- Структура таблицы `ticket`
--

CREATE TABLE IF NOT EXISTS `ticket` (
  `id` int(11) NOT NULL,
  `idPassenger` int(11) NOT NULL,
  `scheduleId` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `ticket`
--

INSERT INTO `ticket` (`id`, `idPassenger`, `scheduleId`) VALUES
(13, 1, 3),
(14, 1, 5),
(15, 1, 11),
(16, 2, 11);

-- --------------------------------------------------------

--
-- Структура таблицы `train`
--

CREATE TABLE IF NOT EXISTS `train` (
  `id` int(11) NOT NULL,
  `number` varchar(45) NOT NULL,
  `capacity` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `train`
--

INSERT INTO `train` (`id`, `number`, `capacity`) VALUES
(4, 's55', 55),
(6, 'sd80', 800),
(10, 'Sapsan100', 100);

-- --------------------------------------------------------

--
-- Структура таблицы `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint(20) NOT NULL,
  `sso_id` varchar(30) NOT NULL,
  `password` varchar(100) NOT NULL,
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `state` varchar(30) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `user`
--

INSERT INTO `user` (`id`, `sso_id`, `password`, `first_name`, `last_name`, `email`, `state`) VALUES
(4, 'Roman', '$2a$10$3vNtuUINPjyoPoQTK9/YZOvYtE3RLvnAMGsby5sMd4yMgQabjmDGe', 'Roman', 'Roman', 'Roman', NULL),
(5, 'sam', '$2a$10$1FSFzdph5d6NP2mcP98EyecpJ94TfpLG0ZEyyfNNujIEUg39tfmAq', 'Sam', 'sam', 'sam', NULL);

-- --------------------------------------------------------

--
-- Структура таблицы `userRole`
--

CREATE TABLE IF NOT EXISTS `userRole` (
  `user_id` bigint(20) NOT NULL,
  `user_role_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `userRole`
--

INSERT INTO `userRole` (`user_id`, `user_role_id`) VALUES
(5, 1),
(4, 2),
(5, 2),
(4, 3),
(5, 3);

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `car`
--
ALTER TABLE `car`
  ADD PRIMARY KEY (`carPrototypeId`);

--
-- Индексы таблицы `carPrototype`
--
ALTER TABLE `carPrototype`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `carPrototypeComposition`
--
ALTER TABLE `carPrototypeComposition`
  ADD PRIMARY KEY (`id`),
  ADD KEY `carPrototypeId` (`carPrototypeId`),
  ADD KEY `siteId` (`siteId`);

--
-- Индексы таблицы `passenger`
--
ALTER TABLE `passenger`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idUser_idx` (`idUser`);

--
-- Индексы таблицы `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `type` (`type`);

--
-- Индексы таблицы `schedule`
--
ALTER TABLE `schedule`
  ADD PRIMARY KEY (`id`),
  ADD KEY `trainId_idx` (`trainId`),
  ADD KEY `routeId_idx` (`segmentId`);

--
-- Индексы таблицы `schedule`
--
ALTER TABLE `segment`
  ADD PRIMARY KEY (`id`),
  ADD KEY `departureStationId_idx` (`departureStationId`),
  ADD KEY `destinationStationId_idx` (`destinationStationId`);

--
-- Индексы таблицы `site`
--
ALTER TABLE `site`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `station`
--
ALTER TABLE `station`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `ticket`
--
ALTER TABLE `ticket`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idPassenger_idx` (`idPassenger`),
  ADD KEY `sheduleId_idx` (`scheduleId`);

--
-- Индексы таблицы `train`
--
ALTER TABLE `train`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `sso_id` (`sso_id`);

--
-- Индексы таблицы `userRole`
--
ALTER TABLE `userRole`
  ADD PRIMARY KEY (`user_id`,`user_role_id`),
  ADD KEY `FK_USER_PROFILE` (`user_role_id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `car`
--
ALTER TABLE `car`
  MODIFY `carPrototypeId` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT для таблицы `carPrototype`
--
ALTER TABLE `carPrototype`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT для таблицы `carPrototypeComposition`
--
ALTER TABLE `carPrototypeComposition`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=52;
--
-- AUTO_INCREMENT для таблицы `passenger`
--
ALTER TABLE `passenger`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT для таблицы `role`
--
ALTER TABLE `role`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT для таблицы `schedule`
--
ALTER TABLE `schedule`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=22;
--
-- AUTO_INCREMENT для таблицы `schedule`
--
ALTER TABLE `segment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=30;
--
-- AUTO_INCREMENT для таблицы `site`
--
ALTER TABLE `site`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=55;
--
-- AUTO_INCREMENT для таблицы `station`
--
ALTER TABLE `station`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT для таблицы `ticket`
--
ALTER TABLE `ticket`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT для таблицы `train`
--
ALTER TABLE `train`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT для таблицы `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `car`
--
ALTER TABLE `car`
  ADD CONSTRAINT `carPrototypeId` FOREIGN KEY (`carPrototypeId`) REFERENCES `carPrototype` (`id`);

--
-- Ограничения внешнего ключа таблицы `carPrototypeComposition`
--
ALTER TABLE `carPrototypeComposition`
  ADD CONSTRAINT `carPrototId` FOREIGN KEY (`carPrototypeId`) REFERENCES `carPrototype` (`id`),
  ADD CONSTRAINT `siteId` FOREIGN KEY (`siteId`) REFERENCES `site` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ограничения внешнего ключа таблицы `schedule`
--
ALTER TABLE `schedule`
  ADD CONSTRAINT `segmentId` FOREIGN KEY (`segmentId`) REFERENCES `segment` (`id`),
  ADD CONSTRAINT `trainId` FOREIGN KEY (`trainId`) REFERENCES `train` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Ограничения внешнего ключа таблицы `schedule`
--
ALTER TABLE `segment`
  ADD CONSTRAINT `departureStationId` FOREIGN KEY (`departureStationId`) REFERENCES `station` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `destinationStationId` FOREIGN KEY (`destinationStationId`) REFERENCES `station` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ограничения внешнего ключа таблицы `ticket`
--
ALTER TABLE `ticket`
  ADD CONSTRAINT `idPassenger` FOREIGN KEY (`idPassenger`) REFERENCES `passenger` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `scheduleId` FOREIGN KEY (`scheduleId`) REFERENCES `schedule` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Ограничения внешнего ключа таблицы `userRole`
--
ALTER TABLE `userRole`
  ADD CONSTRAINT `roleId` FOREIGN KEY (`user_role_id`) REFERENCES `role` (`id`),
  ADD CONSTRAINT `userId` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
