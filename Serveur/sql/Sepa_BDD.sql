 
 CREATE DATABASE sepadb;
 
 USE sepadb;
 
 CREATE TABLE `transaction` (
  `transaction_id` int(11) NOT NULL AUTO_INCREMENT,
  `num` varchar(6) NOT NULL,
  `PmtId` varchar(35) NOT NULL,
  `InstdAmt` DOUBLE NOT NULL,
  `MndtId` varchar(35) NOT NULL,
  `DtOfSgntr` varchar(10) NOT NULL,
  `BIC` varchar(11) NOT NULL,
  `Nm` varchar(35) NOT NULL,
  `IBAN` varchar(34) NOT NULL,
  `RmtInf` varchar(50) NOT NULL,
  PRIMARY KEY (`transaction_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ;

INSERT INTO `transaction` (`transaction_id`, `num`, `PmtId`, `InstdAmt`, `MndtId`, `DtOfSgntr`, `BIC`, `Nm`, `IBAN`, `RmtInf`) VALUES
(1, 'AS0001', 'REF OPE AAAA', 1100.07, 'MANDAT NO 55555', '2009-09-01', 'NOTPROVIDED', 'Mr Debiteur N1', 'FR763004136210001234567811', 'Facture N1'),
(2, 'AS0002', 'REF OPE BBBB', 2150.08, 'MANDAT NO 666666', '1989-07-03', 'BANKGBUL', 'Mr Debiteur N2', 'GB29NWBK60161331926819', 'Facture reference ISO 654321');