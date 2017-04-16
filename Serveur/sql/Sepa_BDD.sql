 
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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ;

INSERT INTO `transaction` (`transaction_id`, `num`, `PmtId`, `InstdAmt`, `MndtId`, `DtOfSgntr`, `BIC`, `Nm`, `IBAN`, `RmtInf`) VALUES
(1, 'AM0001', 'REF OPE AAAA', 1100.07, 'MANDAT NO 111111', '2010-01-01', 'ABNAFRPP', 'Mr Debiteur N1', 'FR7630001007941234567890185', 'Facture N1'),
(2, 'AM0002', 'REF OPE BBBB', 2150.08, 'MANDAT NO 111112', '2011-02-03', 'AECFFR21', 'Mr Debiteur N2', 'FR7630004000031234567890143', 'Facture N2'),
(3, 'AM0003', 'REF OPE CCCC', 500.25, 'MANDAT NO 111113', '2011-05-21', 'AFRIFRPP', 'Mr Debiteur N3', 'FR7630006000011234567890189', 'Facture N3'),
(4, 'AM0004', 'REF OPE DDDD', 1255.03, 'MANDAT NO 111114', '2011-06-11', 'AGFBFRCC', 'Mr Debiteur N4', 'FR7610107001011234567890129', 'Facture N4'),
(5, 'AM0005', 'REF OPE EEEE', 3042.98, 'MANDAT NO 111115', '2011-08-16', 'AGRIFRPI', 'Mr Debiteur N5', 'FR7611315000011234567890138', 'Facture N5'),
(6, 'AM0006', 'REF OPE FFFF', 568.58, 'MANDAT NO 111116', '2012-01-18', 'AGRIFRPP', 'Mr Debiteur N6', 'FR7630002032531234567890168', 'Facture N6'),
(7, 'AM0007', 'REF OPE GGGG', 243.37, 'MANDAT NO 111117', '2012-04-22', 'AGRIMQMX', 'Mr Debiteur N7', 'FR7630056009271234567890182', 'Facture N7'),
(8, 'AM0008', 'REF OPE HHHH', 987.74, 'MANDAT NO 111118', '2012-10-26', 'AGRIRERX', 'Mr Debiteur N8', 'FR7611808009101234567890147', 'Facture N8'),
(9, 'AM0009', 'REF OPE IIII', 1684.54, 'MANDAT NO 111119', '2013-03-14', 'ARCEFRP1', 'Mr Debiteur N9', 'FR7610011000201234567890188', 'Facture N9'),
(10, 'AM0010', 'REF OPE JJJJ', 256.39, 'MANDAT NO 111120', '2013-07-25', 'AUDIFRPP', 'Mr Debiteur N10', 'FR7630076020821234567890186', 'Facture N10'),
(11, 'AM0011', 'REF OPE KKKK', 694.48, 'MANDAT NO 111121', '2014-02-15', 'AXABFRPP', 'Mr Debiteur N11', 'FR7614410000011234567890163', 'Facture N11'),
(12, 'AM0012', 'REF OPE LLLL', 2657.87, 'MANDAT NO 111122', '2014-06-29', 'BAMYFR22', 'Mr Debiteur N12', 'FR7612548029981234567890161', 'Facture N12');