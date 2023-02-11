-- phpMyAdmin SQL Dump
-- version 4.9.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Mar 26, 2021 at 01:19 PM
-- Server version: 10.3.27-MariaDB-log-cll-lve
-- PHP Version: 7.3.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `anikncnm_superpos`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `admin_id` int(11) NOT NULL,
  `admin_name` varchar(255) NOT NULL,
  `admin_email` varchar(255) NOT NULL,
  `admin_cell` varchar(20) NOT NULL,
  `admin_password` varchar(255) NOT NULL,
  `admin_type` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`admin_id`, `admin_name`, `admin_email`, `admin_cell`, `admin_password`, `admin_type`) VALUES
(1, 'Admin', 'admin@gmail.com', '123456', '1234', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE `customers` (
  `customer_id` int(11) NOT NULL,
  `customer_name` varchar(255) NOT NULL,
  `customer_cell` varchar(255) NOT NULL,
  `customer_email` varchar(255) NOT NULL,
  `customer_address` varchar(255) NOT NULL,
  `shop_id` int(255) NOT NULL,
  `owner_id` int(255) NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`customer_id`, `customer_name`, `customer_cell`, `customer_email`, `customer_address`, `shop_id`, `owner_id`, `timestamp`) VALUES
(21, 'Jhonson', '8801954796214', 'jhonson@gmail.com', 'Australia', 0, 0, '2020-09-18 06:16:51'),
(13, 'Rakib Uddin', '+8888558888', 'rakib@gmail.com', 'Agrabad, Ctg', 0, 0, '2020-09-18 06:16:51'),
(25, 'Jhon Due', '882552999', 'jhon@gmail.com', 'USA', 2, 0, '2020-09-18 06:20:30'),
(26, 'Anik', '+8801672902634', 'noormohammedanik@gmail.com', 'Agrabad', 1, 1, '2020-10-13 14:06:42'),
(27, 'Customer', '01778001401', 'demo@gmail.com', 'ctg', 2, 1, '2020-10-13 13:51:27'),
(28, 'Jisan', '123456', 'jisan@gmail.com', 'ctg', 1, 1, '2020-10-13 14:07:02'),
(29, 'Shop 6 customer', '123456', 'customershop6@gmail.com', 'Delhi, India', 8, 7, '2020-10-17 07:18:07'),
(30, 'WALK-IN CUSTOMER', '0558871268', 'sanpkn@gmail.com', 'B701 HQ BUILDING', 6, 6, '2020-10-20 10:17:05'),
(31, 'new customer', '452366889', 'test@test.com', 'test', 6, 6, '2020-10-20 10:29:09'),
(32, 'Walk-in', '000000000000', 'walkin@walkin.com', 'Not a regular customer', 9, 8, '2020-11-02 10:54:55'),
(33, 'shanoj', '9746613451', 'shanoj.kizhakkepath@atmbharath.com', 'test\nKUN', 9, 8, '2020-11-03 04:52:13');

-- --------------------------------------------------------

--
-- Table structure for table `expense`
--

CREATE TABLE `expense` (
  `expense_id` int(255) NOT NULL,
  `expense_name` varchar(255) NOT NULL,
  `expense_note` varchar(255) NOT NULL,
  `expense_amount` varchar(255) NOT NULL,
  `expense_date` varchar(255) NOT NULL,
  `expense_time` varchar(255) NOT NULL,
  `shop_id` int(255) NOT NULL,
  `owner_id` int(255) NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `expense`
--

INSERT INTO `expense` (`expense_id`, `expense_name`, `expense_note`, `expense_amount`, `expense_date`, `expense_time`, `shop_id`, `owner_id`, `timestamp`) VALUES
(4, 'Snacks Bil', 'Snacks Bill', '50', '2020-05-12', '11:01 AM', 1, 1, '2020-09-20 15:40:54'),
(5, 'Employee Salary', 'Employee Salary', '2000', '2020-05-12', '12:41 AM', 2, 1, '2020-09-20 15:42:44'),
(28, 'Employment Cost', 'cost for employee ', '5000', '2020-06-07', '09:42 PM ', 0, 0, '2020-08-08 16:42:08'),
(47, 'asas', 'asas', '33', '2020-09-21', '10:25 PM ', 2, 1, '2020-09-21 16:25:23'),
(48, 'asasa', 'sasas', '111', '2020-09-21', '10:34 PM ', 8, 7, '2020-10-25 13:01:12'),
(49, 'Lunch Cost', 'lunch', '500', '2020-10-17', '01:35 PM', 8, 7, '2020-10-17 08:05:38'),
(50, 'Lunch Cost', 'Lunch', '300', '2021-03-26', '07:21 PM ', 1, 1, '2021-03-26 13:23:11'),
(51, 'BreakFast', 'BF', '200', '2021-02-11', '07:22 PM ', 1, 1, '2021-03-26 13:24:05');

-- --------------------------------------------------------

--
-- Table structure for table `order_details`
--

CREATE TABLE `order_details` (
  `order_details_id` int(255) NOT NULL,
  `invoice_id` varchar(255) NOT NULL,
  `product_name` text NOT NULL,
  `product_quantity` varchar(255) NOT NULL,
  `product_weight` varchar(255) NOT NULL,
  `product_price` varchar(255) NOT NULL,
  `product_order_date` varchar(255) NOT NULL,
  `product_id` varchar(255) NOT NULL,
  `product_image` varchar(255) NOT NULL,
  `shop_id` int(255) NOT NULL,
  `owner_id` int(255) NOT NULL,
  `tax` varchar(255) NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `order_details`
--

INSERT INTO `order_details` (`order_details_id`, `invoice_id`, `product_name`, `product_quantity`, `product_weight`, `product_price`, `product_order_date`, `product_id`, `product_image`, `shop_id`, `owner_id`, `tax`, `timestamp`) VALUES
(9, 'INV1420201604456584', 'Gold Loan', '1', '1 g', '100', '2020-11-04', '46', 'image_placeholder.png', 9, 8, '0.0', '2020-11-03 10:28:22'),
(8, 'INV1420201604455696', 'Gold Loan', '1', '1 g', '100', '2020-11-04', '46', 'image_placeholder.png', 9, 8, '0.0', '2020-11-03 10:13:35'),
(7, 'INV1420201604393359', 'Gold Loan', '1', '1 g', '100', '2020-11-03', '46', 'image_placeholder.png', 9, 8, '0.0', '2020-11-03 08:49:18'),
(6, 'INV1020201604263474', 'Ramen', '1', '200 g', '200', '2020-11-02', '38', '1602919320.png', 8, 7, '2.0', '2020-11-01 20:44:37'),
(10, 'INV1420201604456604', 'Gold Loan', '1', '1 g', '100', '2020-11-04', '46', 'image_placeholder.png', 9, 8, '0.0', '2020-11-03 10:28:42'),
(11, 'INV1420201604463184', 'Gold Loan', '1', '1 g', '100', '2020-11-04', '46', 'image_placeholder.png', 9, 8, '0.0', '2020-11-03 12:18:23'),
(12, 'INV1420201604538902', 'Gold Loan', '1', '1 g', '100', '2020-11-05', '46', '1604468353.png', 9, 8, '0.0', '2020-11-04 09:20:22'),
(13, 'INV1420201604610339', 'Gold Loan', '1', '1 g', '100', '2020-11-06', '46', '1604480956.png', 9, 8, '0.0', '2020-11-05 05:10:59'),
(14, 'INV1420201604610443', 'Gold Loan', '1', '1 g', '100', '2020-11-06', '46', '1604480956.png', 9, 8, '0.0', '2020-11-05 05:12:44'),
(15, 'INV1420201604610550', 'Gold Loan', '1', '1 g', '100', '2020-11-06', '46', '1604480956.png', 9, 8, '0.0', '2020-11-05 05:14:30'),
(16, 'INV1420201604613799', 'Gold Loan', '1', '1 g', '100', '2020-11-06', '46', '1604480956.png', 9, 8, '0.0', '2020-11-05 06:08:38'),
(17, 'INV1520201605511074', 'eraser', '4', '1 g', '15', '2020-11-16', '47', '1605507909.png', 9, 8, '2.7', '2020-11-16 07:17:56'),
(18, 'INV1520201605511137', 'eraser', '1', '1 g', '15', '2020-11-16', '47', '1605507909.png', 9, 8, '2.7', '2020-11-16 07:18:58'),
(19, 'INV1420201606295745', 'eraser', '1', '1 g', '15', '2020-11-25', '47', '1605507909.png', 9, 8, '2.7', '2020-11-25 09:16:26'),
(20, 'INV1420201606295745', 'Gold Loan', '1', '1 g', '100', '2020-11-25', '46', '1604480956.png', 9, 8, '0.0', '2020-11-25 09:16:26'),
(21, 'INV1420201607583572', 'eraser', '1', '1 g', '15', '2020-12-10', '47', '1605507909.png', 9, 8, '2.7', '2020-12-10 06:59:33'),
(22, 'INV1520211614912417', 'eraser', '1', '1 g', '15', '2021-03-05', '47', '1605507909.png', 9, 8, '2.7', '2021-03-05 02:46:59'),
(23, 'INV1520211614912417', 'Jovees', '1', '100 ml', '60', '2021-03-05', '48', '1614911409.png', 9, 8, '4.8', '2021-03-05 02:46:59'),
(24, 'INV1520211615446735', 'Jovees', '2', '100 ml', '60', '2021-03-11', '48', '1614911409.png', 9, 8, '4.8', '2021-03-11 07:12:16'),
(25, 'INV1520211615866376', 'eraser', '1', '1 g', '15', '2021-03-16', '47', '1605507909.png', 9, 8, '2.7', '2021-03-16 03:46:17'),
(26, 'INV1520211615867860', 'eraser', '1', '1 g', '15', '2021-03-16', '47', '1605507909.png', 9, 8, '2.7', '2021-03-16 04:11:02'),
(27, 'INV1520211615868090', 'eraser', '1', '1 g', '15', '2021-03-16', '47', '1605507909.png', 9, 8, '2.7', '2021-03-16 04:14:50'),
(28, 'INV820211616696074', 'Chicken Pasta', '1', '1 Kg', '11', '2021-03-26', '36', 'image_placeholder.png', 1, 1, '0.11', '2021-03-25 18:14:31'),
(29, 'INV820211616696074', 'test product', '1', '23 g', '25', '2021-03-26', '37', '1602650768.png', 1, 1, '1.25', '2021-03-25 18:14:31'),
(30, 'INV820211616776017', 'Chicken Eggs', '1', '2 g', '222', '2021-03-26', '14', '1593670631.jpg', 1, 1, '0.0', '2021-03-26 16:26:55'),
(31, 'INV820211616776350', 'test product', '1', '23 g', '25', '2021-03-26', '37', '1602650768.png', 1, 1, '1.25', '2021-03-26 16:32:28'),
(32, 'INV820211616777124', 'Fish', '1', '2 g', '222', '2021-03-26', '7', '1593671208.png', 1, 1, '0.0', '2021-03-26 16:45:22'),
(33, 'INV820211616777124', 'Banana', '1', '2 Kg', '222', '2021-03-26', '12', '1593668653.png', 1, 1, '0.0', '2021-03-26 16:45:22'),
(34, 'INV820211616777147', 'Fish', '1', '2 g', '222', '2021-03-26', '7', '1593671208.png', 1, 1, '0.0', '2021-03-26 16:45:44');

-- --------------------------------------------------------

--
-- Table structure for table `order_list`
--

CREATE TABLE `order_list` (
  `order_id` int(255) NOT NULL,
  `invoice_id` varchar(255) NOT NULL,
  `order_date` varchar(255) NOT NULL,
  `order_time` varchar(255) NOT NULL,
  `order_type` varchar(255) NOT NULL,
  `order_payment_method` varchar(255) NOT NULL,
  `order_price` varchar(255) NOT NULL,
  `discount` varchar(255) NOT NULL,
  `tax` varchar(255) NOT NULL,
  `customer_name` varchar(255) NOT NULL,
  `served_by` varchar(255) NOT NULL,
  `shop_id` int(255) NOT NULL,
  `owner_id` int(255) NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `order_list`
--

INSERT INTO `order_list` (`order_id`, `invoice_id`, `order_date`, `order_time`, `order_type`, `order_payment_method`, `order_price`, `discount`, `tax`, `customer_name`, `served_by`, `shop_id`, `owner_id`, `timestamp`) VALUES
(2, 'INV1020201604263474', '2020-11-02', '02:44 AM', 'PERCEL', 'CASH', '200.0', '2', '12.0', 'Shop 6 customer', 'Admin', 8, 7, '2020-11-01 20:44:37'),
(3, 'INV1420201604393359', '2020-11-03', '02:19 PM', 'PICK UP', 'CASH', '100.0', '0.00', '0.0', 'Walk In Customer', 'TESTUSER', 9, 8, '2020-11-03 08:49:18'),
(4, 'INV1420201604455696', '2020-11-04', '06:08 AM', 'PICK UP', 'CASH', '100.0', '0.00', '0.0', 'Walk In Customer', 'TESTUSER', 9, 8, '2020-11-03 10:13:35'),
(5, 'INV1420201604456584', '2020-11-04', '06:23 AM', 'PICK UP', 'CASH', '100.0', '0.00', '0.0', 'Walk In Customer', 'TESTUSER', 9, 8, '2020-11-03 10:28:22'),
(6, 'INV1420201604456604', '2020-11-04', '06:23 AM', 'PICK UP', 'CASH', '100.0', '0.00', '0.0', 'Walk In Customer', 'TESTUSER', 9, 8, '2020-11-03 10:28:42'),
(7, 'INV1420201604463184', '2020-11-04', '08:13 AM', 'PICK UP', 'CASH', '100.0', '0.00', '0.0', 'Walk In Customer', 'TESTUSER', 9, 8, '2020-11-03 12:18:23'),
(8, 'INV1420201604538902', '2020-11-05', '05:15 AM', 'PICK UP', 'CASH', '100.0', '0.00', '0.0', 'Walk In Customer', 'TESTUSER', 9, 8, '2020-11-04 09:20:22'),
(9, 'INV1420201604610339', '2020-11-06', '01:05 AM', 'PICK UP', 'CASH', '100.0', '0.00', '0.0', 'Walk In Customer', 'TESTUSER', 9, 8, '2020-11-05 05:10:59'),
(10, 'INV1420201604610443', '2020-11-06', '01:07 AM', 'PICK UP', 'CASH', '100.0', '0.00', '0.0', 'Walk In Customer', 'TESTUSER', 9, 8, '2020-11-05 05:12:44'),
(11, 'INV1420201604610550', '2020-11-06', '01:09 AM', 'PICK UP', 'CASH', '100.0', '0.00', '0.0', 'Walk In Customer', 'TESTUSER', 9, 8, '2020-11-05 05:14:30'),
(12, 'INV1420201604613799', '2020-11-06', '02:03 AM', 'PICK UP', 'CASH', '100.0', '0.00', '0.0', 'Walk In Customer', 'TESTUSER', 9, 8, '2020-11-05 06:08:38'),
(13, 'INV1520201605511074', '2020-11-16', '12:47 PM', 'PICK UP', 'CARD', '60.0', '0.00', '32.400000000000006', 'Walk-in', 'TESTADMIN', 9, 8, '2020-11-16 07:17:56'),
(14, 'INV1520201605511137', '2020-11-16', '12:48 PM', 'PICK UP', 'CARD', '15.0', '0.00', '8.100000000000001', 'Walk In Customer', 'TESTADMIN', 9, 8, '2020-11-16 07:18:58'),
(15, 'INV1420201606295745', '2020-11-25', '02:45 PM', 'PICK UP', 'CASH', '115.0', '0.00', '8.100000000000001', 'Walk In Customer', 'TESTUSER', 9, 8, '2020-11-25 09:16:26'),
(16, 'INV1420201607583572', '2020-12-10', '10:59 AM', 'PICK UP', 'CASH', '15.0', '0.00', '8.100000000000001', 'Walk In Customer', 'TESTUSER', 9, 8, '2020-12-10 06:59:33'),
(17, 'INV1520211614912417', '2021-03-05', '08:16 AM', 'Table Booking', 'CASH', '75.0', '10', '17.1', 'Walk In Customer', 'TESTADMIN', 9, 8, '2021-03-05 02:46:59'),
(18, 'INV1520211615446735', '2021-03-11', '12:42 PM', 'PICK UP', 'CASH', '120.0', '10', '18.0', 'shanoj', 'TESTADMIN', 9, 8, '2021-03-11 07:12:16'),
(19, 'INV1520211615866376', '2021-03-16', '09:16 AM', 'PICK UP', 'CASH', '15.0', '0.00', '8.100000000000001', 'Walk In Customer', 'TESTADMIN', 9, 8, '2021-03-16 03:46:17'),
(20, 'INV1520211615867860', '2021-03-16', '09:41 AM', 'PICK UP', 'CASH', '15.0', '1', '8.100000000000001', 'Walk In Customer', 'TESTADMIN', 9, 8, '2021-03-16 04:11:02'),
(21, 'INV1520211615868090', '2021-03-16', '09:44 AM', 'PICK UP', 'CASH', '15.0', '1', '8.100000000000001', 'Walk In Customer', 'TESTADMIN', 9, 8, '2021-03-16 04:14:50'),
(23, 'INV820211616696074', '2021-03-26', '12:14 AM', 'PICK UP', 'CASH', '36.0', '6.36', '1.36', 'Walk In Customer', 'Admin', 1, 1, '2021-03-25 18:14:31'),
(24, 'INV820211616776017', '2021-03-26', '10:26 PM', 'PICK UP', 'CASH', '222.0', '0.00', '0.0', 'Walk In Customer', 'Admin', 1, 1, '2021-03-26 16:26:55'),
(25, 'INV820211616776350', '2021-03-26', '10:32 PM', 'PICK UP', 'CASH', '25.0', '0.00', '1.25', 'Walk In Customer', 'Admin', 1, 1, '2021-03-26 16:32:28'),
(26, 'INV820211616777124', '2021-03-26', '10:45 PM', 'PICK UP', 'CASH', '444.0', '0.00', '0.0', 'Walk In Customer', 'Admin', 1, 1, '2021-03-26 16:45:22'),
(27, 'INV820211616777147', '2021-03-26', '10:45 PM', 'PICK UP', 'CASH', '222.0', '22', '0.0', 'Walk In Customer', 'Admin', 1, 1, '2021-03-26 16:45:44');

-- --------------------------------------------------------

--
-- Table structure for table `owner`
--

CREATE TABLE `owner` (
  `owner_id` int(255) NOT NULL,
  `owner_name` varchar(255) NOT NULL,
  `owner_email` varchar(255) NOT NULL,
  `owner_cell` varchar(255) NOT NULL,
  `owner_password` varchar(255) NOT NULL,
  `owner_address` text NOT NULL,
  `owner_status` int(5) NOT NULL,
  `owner_type` varchar(255) NOT NULL DEFAULT 'admin'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `owner`
--

INSERT INTO `owner` (`owner_id`, `owner_name`, `owner_email`, `owner_cell`, `owner_password`, `owner_address`, `owner_status`, `owner_type`) VALUES
(1, 'Shop Owner 1', 'owner@gmail.com', '123456789', '1234', 'USA', 1, 'admin'),
(2, 'Shop Owner 2', 'owner2@gmail.com', '2223333', '1234', 'Brundi', 1, 'admin'),
(3, 'Shop Owner 3', 'owner3@gmail.com', '12121342121', '1234', 'USA', 0, 'admin'),
(4, 'Shop Owner 4', 'owner4@gmail.com', '88121342121', '1234', 'Australia', 0, 'admin'),
(5, 'Shop Owner 5', 'owner5@gmail.com', '800121342121', '1234', 'Brundi', 1, 'admin'),
(6, 'Santo Puthoor', 'sanpkn@gmail.com', '7356630756', 'hotcom9632', 'Australia', 1, 'admin'),
(7, 'Shop Owner 6', 'owner6@gmail.com', '6677865322', '1234', 'Australia', 1, 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `product_id` int(11) NOT NULL,
  `product_name` varchar(255) NOT NULL,
  `product_code` text NOT NULL,
  `product_category_id` int(5) NOT NULL,
  `product_description` text NOT NULL,
  `product_sell_price` float NOT NULL,
  `product_weight` varchar(255) NOT NULL,
  `product_weight_unit_id` int(11) NOT NULL,
  `product_supplier_id` int(11) NOT NULL,
  `product_image` text NOT NULL,
  `product_stock` int(255) NOT NULL,
  `shop_id` int(255) NOT NULL,
  `owner_id` int(255) NOT NULL,
  `tax` float NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`product_id`, `product_name`, `product_code`, `product_category_id`, `product_description`, `product_sell_price`, `product_weight`, `product_weight_unit_id`, `product_supplier_id`, `product_image`, `product_stock`, `shop_id`, `owner_id`, `tax`, `timestamp`) VALUES
(1, 'Baby Foods', 'RRS', 26, 'sensitive and well', 222, '2', 4, 20, '1593671266.png', 10, 1, 1, 3, '2021-03-26 16:18:05'),
(5, 'poultry Farm', 'farm', 3, 'wqwq', 222, '2', 1, 9, '1593670775.jpg', 20, 0, 0, 0, '2020-09-03 20:41:41'),
(7, 'Fish', 'kochu', 26, 'wqwq', 222, '2', 1, 1, '1593671208.png', 19, 1, 1, 0, '2021-03-26 16:45:44'),
(12, 'Banana', 'wqwqw', 26, 'nice &looking fresh', 222, '2', 2, 5, '1593668653.png', 18, 1, 1, 0, '2021-03-26 16:45:22'),
(14, 'Chicken Eggs', 'eggs', 26, 'well & fresh', 222, '2', 1, 1, '1593670631.jpg', 497, 1, 1, 0, '2021-03-26 16:26:55'),
(27, 'juice', 'sst', 3, 'well and healthy', 120, '1', 4, 3, '1594012986.png', 16, 2, 1, 0, '2020-09-22 15:08:58'),
(28, 'chicken', '001', 4, 'fresh & good', 5, '1.5', 2, 9, '1594012951.png', 0, 0, 0, 0, '2020-09-03 20:42:13'),
(35, 'sqsqsq', 'qsqsq', 22, 'sqsq', 22, '2', 2, 19, 'image_placeholder.png', 12, 2, 0, 11, '2020-09-18 06:50:20'),
(37, 'test product', 'vvf', 1, 'ffg', 25, '23', 1, 20, '1602650768.png', 15, 1, 1, 5, '2021-03-26 16:32:28'),
(38, 'Ramen', 'ramen101', 27, 'Testy foods', 200, '200', 1, 22, '1602919320.png', 5, 8, 7, 1, '2020-11-01 20:44:37'),
(39, 'Biryani', 'biryani', 27, 'Testy foods', 20, '200', 1, 22, '1602927949.png', 19, 8, 7, 2, '2020-10-24 05:54:35'),
(40, 'Poco F1', 'pocof1', 29, 'Pocof1', 19000, '192', 1, 22, '1602928067.png', 16, 8, 7, 2, '2020-10-24 05:54:35'),
(41, 'Pepsi 500 ML Bottle', 'PEP500B', 31, 'Pepsi 500 ML Bottle', 50, '500', 5, 0, 'image_placeholder.png', 99, 6, 6, 2, '2020-10-23 16:11:48'),
(42, 'Pepsi 300 ML Can', 'PEP300CAN', 31, 'Pepsi 300 ML Can', 30, '300', 5, 0, 'image_placeholder.png', 100, 6, 6, 5, '2020-10-20 10:20:40'),
(43, 'Pepsi 500 ML Can', 'PEP500CAN', 31, 'Pepsi 500 ML Can', 100, '500', 5, 0, 'image_placeholder.png', 17, 6, 6, 5, '2020-10-23 16:11:48'),
(44, 'Coca Cola 300 ML Can', 'CC300C', 32, 'Coca Cola 300 Ml', 50, '300', 5, 23, 'image_placeholder.png', 20, 6, 6, 5, '2020-10-20 10:48:38'),
(45, 'Test', 'ccvgg', 27, 'desc', 200, '20', 1, 0, '1603473426.png', 16, 8, 7, 1, '2020-10-24 05:54:35'),
(46, 'Gold Loan', 'GLN', 34, 'Gold Loan', 100, '1', 1, 26, '1604480956.png', -1, 9, 8, 0, '2020-11-25 09:16:26'),
(47, 'eraser', '8901324010664', 34, 'eraser', 15, '1', 1, 26, '1605507909.png', -1, 9, 8, 18, '2021-03-16 04:14:50'),
(48, 'Jovees', '946421677592', 34, 'Sanitizer', 60, '100', 5, 26, '1614911409.png', 0, 9, 8, 8, '2021-03-11 07:12:16');

-- --------------------------------------------------------

--
-- Table structure for table `product_category`
--

CREATE TABLE `product_category` (
  `product_category_id` int(11) NOT NULL,
  `product_category_name` varchar(255) NOT NULL,
  `shop_id` int(255) NOT NULL,
  `owner_id` int(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product_category`
--

INSERT INTO `product_category` (`product_category_id`, `product_category_name`, `shop_id`, `owner_id`) VALUES
(1, 'Mobile', 1, 1),
(2, 'Remote desktop', 0, 0),
(3, 'Food & Drink', 0, 0),
(4, 'Medicine', 0, 0),
(5, 'vegetable', 0, 0),
(11, 'Macbook', 1, 1),
(9, 'Fish ', 0, 0),
(12, 'House & Home', 1, 1),
(19, 'Baby food', 0, 0),
(20, 'Grocery', 0, 0),
(21, 'Food', 0, 0),
(22, 'Headphone', 0, 0),
(23, 'Bike', 0, 0),
(25, 'Test', 2, 1),
(26, 'Foods', 1, 1),
(27, 'Foods', 8, 7),
(28, 'Drinks', 8, 7),
(29, 'Electrocnics', 8, 7),
(30, 'Toys', 8, 7),
(31, 'PEPSI', 6, 6),
(32, 'COCA COLA', 6, 6),
(33, 'NESTLE', 6, 6),
(34, 'Banking Solution', 9, 8);

-- --------------------------------------------------------

--
-- Table structure for table `shop`
--

CREATE TABLE `shop` (
  `shop_id` int(11) NOT NULL,
  `shop_name` varchar(255) NOT NULL,
  `shop_contact` varchar(255) NOT NULL,
  `shop_email` varchar(255) NOT NULL,
  `shop_address` varchar(255) NOT NULL,
  `currency_symbol` varchar(20) NOT NULL,
  `shop_status` varchar(255) NOT NULL,
  `shop_owner_id` int(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `shop`
--

INSERT INTO `shop` (`shop_id`, `shop_name`, `shop_contact`, `shop_email`, `shop_address`, `currency_symbol`, `shop_status`, `shop_owner_id`) VALUES
(1, 'Shop 1', '+812345678900', 'shop1@gmail.com', 'India', '$', 'OPEN', 1),
(2, 'Shop 2', '423232322', 'shop2@gmail.com', 'Delhi', 'Rp.', 'OPEN', 1),
(3, 'Shop 3', '423232322', 'shop3@gmail.com', 'Delhi', 'Rp.', 'OPEN', 2),
(4, 'Shop 3', '4443333', 'shop3@gmail.com', 'Delhi, India', '$', 'OPEN', 1),
(5, 'Shop 5', '42553232322', 'shop5@gmail.com', 'Delhi', 'Rp.', 'OPEN', 2),
(6, 'shop 9', '7356630756', 'shop9@gmail.com', 'Kozhikode', '$', 'OPEN', 6),
(7, 'Shop 8', '12121212', 'shop8@gmail.com', 'safa', 'sf', 'OPEN', 6),
(8, 'Shop 6', '13133133', 'shop6@gmail.com', 'India', 'Rp', 'OPEN', 7),
(9, 'Shop 7', '9746613451', 'shop7@atmbharath.com', 'USA', '$', 'OPEN', 8);

-- --------------------------------------------------------

--
-- Table structure for table `suppliers`
--

CREATE TABLE `suppliers` (
  `suppliers_id` int(255) NOT NULL,
  `suppliers_name` varchar(255) NOT NULL,
  `suppliers_contact_person` varchar(255) NOT NULL,
  `suppliers_cell` varchar(255) NOT NULL,
  `suppliers_email` varchar(255) NOT NULL,
  `suppliers_address` varchar(255) NOT NULL,
  `shop_id` int(255) NOT NULL,
  `owner_id` int(255) NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `suppliers`
--

INSERT INTO `suppliers` (`suppliers_id`, `suppliers_name`, `suppliers_contact_person`, `suppliers_cell`, `suppliers_email`, `suppliers_address`, `shop_id`, `owner_id`, `timestamp`) VALUES
(5, 'jon', 'Jamal', '01831758798', 'jamul@gmail.com', 'Iiuc', 0, 0, '2020-07-06 16:16:59'),
(19, 'Pepsi', 'Jhon', '88800891994', 'pepsi9@gmail.com', 'USA', 0, 0, '2020-07-30 06:31:14'),
(18, 'Addidas', 'Jhon due', '88085585588', 'addidas@gmail.com', 'USA', 0, 0, '2020-07-30 06:31:53'),
(15, 'Evaly', 'Jamil', '01831758799', 'evaly@gmail.com', 'Dhaka', 0, 0, '2020-07-25 15:36:22'),
(20, 'My Suppliers', 'Supplier', '01831758799', 'supplier34@gmail.com', 'Dhaka', 1, 1, '2020-10-13 14:28:11'),
(21, 'Pepsi', 'Jasim 2', '85255455', 'pepsi@gmail.com', 'India', 1, 1, '2020-10-13 14:47:02'),
(22, 'Supplier Shop 6', 'Supplier', '123456', 'shop6supplier@gmail.com', 'india', 8, 7, '2020-10-17 07:19:04'),
(23, 'Beverage Corporation', 'Helen', '89700000000', 'helen@gmail.com', 'Silicon Oasis', 6, 6, '2020-10-20 10:25:25'),
(24, 'Supplier From Device', 'Myself', '856998559996', 'test@test.com', 'new supplier', 6, 6, '2020-10-20 10:30:07'),
(25, 'Supplier Mobile Data', 'Mobile Data', '8998885999', 'offline@gmaul.con', 'Mobile Data', 6, 6, '2020-10-20 10:31:48'),
(26, 'ABC', 'test', '9', 'a@a.com', 'test', 9, 8, '2020-11-03 04:53:41');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `cell` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `user_type` varchar(255) NOT NULL,
  `shop_id` int(255) NOT NULL,
  `owner_id` int(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `cell`, `email`, `password`, `user_type`, `shop_id`, `owner_id`) VALUES
(8, 'Admin', '123456789', 'admin@gmail.com', '123456', 'admin', 1, 1),
(3, 'Manager', '777888', 'manager@gmail.com', '1234', 'admin', 2, 1),
(4, 'Staff', '76543211', 'staff@gmail.com', '1234', 'staff', 1, 0),
(5, 'Manager', '01778001401', 'noor.bd92@gmail.com', '12345', 'manager', 0, 0),
(9, 'aasas', '1212134445', 'asas@gmail.com', '1234', 'manager', 2, 1),
(10, 'Admin', '1234321', 'adminshop6@gmail.com', '1234', 'admin', 8, 7),
(11, 'Manager', '2121231212', 'managershop6@gmail.com', '1234', 'manager', 8, 7),
(12, 'Staff Shop6', '99878999', 'staffshop6@gmail.com', '1234', 'staff', 8, 7),
(13, 'SANTO', '0558871268', 'sanpkn@gmail.com', '6789', 'staff', 6, 6),
(14, 'TESTUSER', '234567890', 'TESTUSER@GMAIL.COM', '3456', 'staff', 9, 8),
(15, 'TESTADMIN', '12345678', 'testadmin@gmail.com', '3456', 'admin', 9, 8);

-- --------------------------------------------------------

--
-- Table structure for table `weight_unit`
--

CREATE TABLE `weight_unit` (
  `weight_unit_id` int(11) NOT NULL,
  `weight_unit_name` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `weight_unit`
--

INSERT INTO `weight_unit` (`weight_unit_id`, `weight_unit_name`) VALUES
(1, 'g'),
(2, 'Kg'),
(3, 'L'),
(4, 'pcs'),
(5, 'ml');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`admin_id`),
  ADD UNIQUE KEY `admin_email` (`admin_email`);

--
-- Indexes for table `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`customer_id`);

--
-- Indexes for table `expense`
--
ALTER TABLE `expense`
  ADD PRIMARY KEY (`expense_id`);

--
-- Indexes for table `order_details`
--
ALTER TABLE `order_details`
  ADD PRIMARY KEY (`order_details_id`);

--
-- Indexes for table `order_list`
--
ALTER TABLE `order_list`
  ADD PRIMARY KEY (`order_id`),
  ADD UNIQUE KEY `invoice_id` (`invoice_id`);

--
-- Indexes for table `owner`
--
ALTER TABLE `owner`
  ADD PRIMARY KEY (`owner_id`),
  ADD UNIQUE KEY `owner_email` (`owner_email`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`product_id`);

--
-- Indexes for table `product_category`
--
ALTER TABLE `product_category`
  ADD PRIMARY KEY (`product_category_id`);

--
-- Indexes for table `shop`
--
ALTER TABLE `shop`
  ADD PRIMARY KEY (`shop_id`);

--
-- Indexes for table `suppliers`
--
ALTER TABLE `suppliers`
  ADD PRIMARY KEY (`suppliers_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `weight_unit`
--
ALTER TABLE `weight_unit`
  ADD PRIMARY KEY (`weight_unit_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `admin_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `customers`
--
ALTER TABLE `customers`
  MODIFY `customer_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT for table `expense`
--
ALTER TABLE `expense`
  MODIFY `expense_id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=52;

--
-- AUTO_INCREMENT for table `order_details`
--
ALTER TABLE `order_details`
  MODIFY `order_details_id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT for table `order_list`
--
ALTER TABLE `order_list`
  MODIFY `order_id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT for table `owner`
--
ALTER TABLE `owner`
  MODIFY `owner_id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `product_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;

--
-- AUTO_INCREMENT for table `product_category`
--
ALTER TABLE `product_category`
  MODIFY `product_category_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT for table `shop`
--
ALTER TABLE `shop`
  MODIFY `shop_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `suppliers`
--
ALTER TABLE `suppliers`
  MODIFY `suppliers_id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `weight_unit`
--
ALTER TABLE `weight_unit`
  MODIFY `weight_unit_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
