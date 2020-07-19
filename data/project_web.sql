-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 05, 2020 lúc 03:04 AM
-- Phiên bản máy phục vụ: 10.4.11-MariaDB
-- Phiên bản PHP: 7.2.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `project_web`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `account`
--

CREATE TABLE `account` (
  `id_acc` int(10) NOT NULL,
  `user` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `pass` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `phone` int(10) NOT NULL,
  `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `area` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `bill`
--

CREATE TABLE `bill` (
  `id_bill` int(10) NOT NULL,
  `id_order` int(10) NOT NULL,
  `tatal_price` int(10) NOT NULL,
  `discount` double NOT NULL,
  `time_pay` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `category`
--

CREATE TABLE `category` (
  `id_category` int(10) NOT NULL,
  `category` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `category`
--

INSERT INTO `category` (`id_category`, `category`) VALUES
(1, 'Food'),
(2, 'Drink'),
(3, 'Vege'),
(4, 'Cakes'),
(5, 'Homemade'),
(6, 'Streetfood'),
(7, 'Pizza/Burger'),
(8, 'Chicken'),
(9, 'Hotpot'),
(10, 'Sushi'),
(11, 'Noodle'),
(12, 'Rice Box');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `comment`
--

CREATE TABLE `comment` (
  `id_comment` int(10) NOT NULL,
  `id_acc` int(10) NOT NULL,
  `id_product` int(10) NOT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `content_cmt` varchar(10000) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `time_cmt` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `cuisine`
--

CREATE TABLE `cuisine` (
  `id_cuisine` int(10) NOT NULL,
  `cuisine` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `cuisine`
--

INSERT INTO `cuisine` (`id_cuisine`, `cuisine`) VALUES
(1, 'Món Miền Bắc'),
(2, 'Mốn Miền Trung'),
(3, 'Món Miền Nam'),
(4, 'Món Trung Hoa'),
(5, 'Món Thái'),
(6, 'Món Việt'),
(7, 'Bánh Pizza'),
(8, 'Đặc sản vùng');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `places`
--

CREATE TABLE `places` (
  `id_place` int(10) NOT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `area` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `contact` int(10) NOT NULL,
  `id_category` int(10) NOT NULL,
  `id_tag` int(10) NOT NULL,
  `id_cuisine` int(10) NOT NULL,
  `book` tinyint(1) NOT NULL,
  `delivery` tinyint(1) NOT NULL,
  `open` time NOT NULL,
  `close` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `places`
--

INSERT INTO `places` (`id_place`, `name`, `address`, `area`, `contact`, `id_category`, `id_tag`, `id_cuisine`, `book`, `delivery`, `open`, `close`) VALUES
(1, 'Quán nhậu', '436 Tây Sơn,  Quận Đống Đa, Hà Nội', 'Hà Nội', 967544253, 1, 8, 6, 1, 1, '08:00:00', '22:00:00');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `product`
--

CREATE TABLE `product` (
  `id_product` int(10) NOT NULL,
  `name_product` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `id_category` int(10) NOT NULL,
  `id_tag` int(10) NOT NULL,
  `id_cuisine` int(10) NOT NULL,
  `id_place` int(10) NOT NULL,
  `price` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tag`
--

CREATE TABLE `tag` (
  `id_tag` int(10) NOT NULL,
  `tag` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `tag`
--

INSERT INTO `tag` (`id_tag`, `tag`) VALUES
(1, 'Sang trọng'),
(2, 'Buffet'),
(3, 'Nhà Hàng'),
(4, 'Ăn vặt/Vỉa hè'),
(5, 'Cafe/Dessert'),
(6, 'Quán ăn'),
(7, 'Bar/Pub'),
(8, 'Quán nhậu'),
(9, 'Beer Club'),
(10, 'Tiệm bánh'),
(11, 'Khu ẩm thực');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `the_order`
--

CREATE TABLE `the_order` (
  `id_order` int(10) NOT NULL,
  `id_acc` int(10) NOT NULL,
  `id_product` int(10) NOT NULL,
  `amount` int(10) NOT NULL,
  `into_price` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`id_acc`);

--
-- Chỉ mục cho bảng `bill`
--
ALTER TABLE `bill`
  ADD PRIMARY KEY (`id_bill`),
  ADD KEY `id_order` (`id_order`);

--
-- Chỉ mục cho bảng `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id_category`);

--
-- Chỉ mục cho bảng `comment`
--
ALTER TABLE `comment`
  ADD PRIMARY KEY (`id_comment`),
  ADD KEY `id_product` (`id_product`),
  ADD KEY `id_acc` (`id_acc`);

--
-- Chỉ mục cho bảng `cuisine`
--
ALTER TABLE `cuisine`
  ADD PRIMARY KEY (`id_cuisine`);

--
-- Chỉ mục cho bảng `places`
--
ALTER TABLE `places`
  ADD PRIMARY KEY (`id_place`),
  ADD KEY `id_category` (`id_category`),
  ADD KEY `id_tag` (`id_tag`),
  ADD KEY `id_cuisine` (`id_cuisine`),
  ADD KEY `id_category_2` (`id_category`),
  ADD KEY `id_tag_2` (`id_tag`),
  ADD KEY `id_cuisine_2` (`id_cuisine`);

--
-- Chỉ mục cho bảng `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id_product`),
  ADD KEY `id_tag` (`id_tag`),
  ADD KEY `id_cuisine` (`id_cuisine`),
  ADD KEY `id_place` (`id_place`),
  ADD KEY `id_category` (`id_category`);

--
-- Chỉ mục cho bảng `tag`
--
ALTER TABLE `tag`
  ADD PRIMARY KEY (`id_tag`);

--
-- Chỉ mục cho bảng `the_order`
--
ALTER TABLE `the_order`
  ADD PRIMARY KEY (`id_order`),
  ADD KEY `id_product` (`id_product`),
  ADD KEY `id_acc` (`id_acc`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `account`
--
ALTER TABLE `account`
  MODIFY `id_acc` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `bill`
--
ALTER TABLE `bill`
  MODIFY `id_bill` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `category`
--
ALTER TABLE `category`
  MODIFY `id_category` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT cho bảng `comment`
--
ALTER TABLE `comment`
  MODIFY `id_comment` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `cuisine`
--
ALTER TABLE `cuisine`
  MODIFY `id_cuisine` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT cho bảng `places`
--
ALTER TABLE `places`
  MODIFY `id_place` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT cho bảng `product`
--
ALTER TABLE `product`
  MODIFY `id_product` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `tag`
--
ALTER TABLE `tag`
  MODIFY `id_tag` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT cho bảng `the_order`
--
ALTER TABLE `the_order`
  MODIFY `id_order` int(10) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
