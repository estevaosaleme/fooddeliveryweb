# HeidiSQL Dump 
#
# --------------------------------------------------------
# Host:                         127.0.0.1
# Database:                     fdw
# Server version:               5.1.35-community
# Server OS:                    Win32
# Target compatibility:         ANSI SQL
# HeidiSQL version:             4.0
# Date/time:                    2009-11-30 19:42:03
# --------------------------------------------------------

/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ANSI,NO_BACKSLASH_ESCAPES';*/
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;*/


#
# Database structure for database 'fdw'
#

CREATE DATABASE /*!32312 IF NOT EXISTS*/ "fdw" /*!40100 DEFAULT CHARACTER SET utf8 */;

USE "fdw";


#
# Table structure for table 'cardapio'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ "cardapio" (
  "CARD_CD_CARDAPIO" int(11) NOT NULL AUTO_INCREMENT,
  "CARD_NM_CARDAPIO" varchar(50) NOT NULL,
  "ESTA_CD_ESTABELECIMENTO" int(11) NOT NULL COMMENT 'Chave estrangeira (estabelecimento)',
  PRIMARY KEY ("CARD_CD_CARDAPIO"),
  KEY "FK_CARD_ESTA" ("ESTA_CD_ESTABELECIMENTO"),
  CONSTRAINT "FK_CARD_ESTA" FOREIGN KEY ("ESTA_CD_ESTABELECIMENTO") REFERENCES "estabelecimento" ("ESTA_CD_ESTABELECIMENTO") ON DELETE CASCADE
);



#
# Dumping data for table 'cardapio'
#

# No data found.



#
# Table structure for table 'cep'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ "cep" (
  "CEP_CD_CEP" int(11) NOT NULL AUTO_INCREMENT,
  "CEP_NR_CEP" varchar(9) NOT NULL,
  "CEP_NM_LOGRADOURO" varchar(100) NOT NULL,
  "CEP_NM_BAIRRO" tinyint(4) NOT NULL,
  "CEP_NM_CIDADE" varchar(50) NOT NULL,
  "CEP_SG_ESTADO" char(2) NOT NULL,
  PRIMARY KEY ("CEP_CD_CEP")
);



#
# Dumping data for table 'cep'
#

# No data found.



#
# Table structure for table 'cliente'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ "cliente" (
  "CLIE_CD_CLIENTE" int(11) NOT NULL AUTO_INCREMENT,
  "CLIE_NM_CLIENTE" varchar(100) NOT NULL,
  "CLIE_NR_CPF" varchar(14) NOT NULL,
  "CLIE_IN_SEXO" char(1) NOT NULL COMMENT '''M'' ou ''F''',
  "CLIE_DT_NASCIMENTO" date NOT NULL,
  "CLIE_NR_CELULAR" varchar(15) DEFAULT NULL,
  "CLIE_NR_TELEFONE_FIXO" varchar(14) DEFAULT NULL,
  "CLIE_TX_EMAIL" varchar(100) NOT NULL,
  "CLIE_TX_SENHA" varchar(255) NOT NULL,
  "CLIE_TX_ENDERECO" varchar(100) NOT NULL,
  "CLIE_TX_PONTO_REFERENCIA" varchar(100) DEFAULT NULL,
  "CLIE_IN_STATUS" char(1) NOT NULL COMMENT 'Ativo, bloqueado ou inativo',
  "CEP_CD_CEP" int(11) NOT NULL,
  PRIMARY KEY ("CLIE_CD_CLIENTE"),
  KEY "FK_CLIE_CEP" ("CEP_CD_CEP"),
  CONSTRAINT "FK_CLIE_CEP" FOREIGN KEY ("CEP_CD_CEP") REFERENCES "cep" ("CEP_CD_CEP")
);



#
# Dumping data for table 'cliente'
#

# No data found.



#
# Table structure for table 'estabelecimento'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ "estabelecimento" (
  "ESTA_CD_ESTABELECIMENTO" int(11) NOT NULL AUTO_INCREMENT,
  "ESTA_NM_FANTASIA" varchar(100) NOT NULL,
  "ESTA_NM_RAZAO_SOCIAL" varchar(100) NOT NULL,
  "ESTA_NR_CNPJ" varchar(18) NOT NULL,
  "ESTA_TX_SLOGAN" varchar(500) DEFAULT NULL,
  "ESTA_TX_ENDERECO" varchar(100) NOT NULL,
  "ESTA_TX_EMAIL" varchar(100) NOT NULL,
  "ESTA_NR_TELEFONE_FIXO" varchar(14) NOT NULL,
  "ESTA_NM_RESPONSAVEL" varchar(50) NOT NULL,
  "ESTA_NR_CELULAR_RESPONSAVEL" varchar(14) DEFAULT NULL,
  "ESTA_IN_STATUS" char(1) NOT NULL COMMENT 'Ativo, bloqueado ou inativo',
  "CEP_CD_CEP" int(11) NOT NULL,
  PRIMARY KEY ("ESTA_CD_ESTABELECIMENTO"),
  KEY "FK_ESTA_CEP" ("CEP_CD_CEP"),
  CONSTRAINT "FK_ESTA_CEP" FOREIGN KEY ("CEP_CD_CEP") REFERENCES "cep" ("CEP_CD_CEP")
);



#
# Dumping data for table 'estabelecimento'
#

# No data found.



#
# Table structure for table 'estabelecimento_cep'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ "estabelecimento_cep" (
  "ESCE_CD_ESTA_CEP" int(11) NOT NULL AUTO_INCREMENT,
  "ESTA_CD_ESTABELECIMENTO" int(11) NOT NULL,
  "CEP_CD_CEP" int(11) NOT NULL,
  PRIMARY KEY ("ESCE_CD_ESTA_CEP"),
  KEY "FK_ESCE_CEP" ("CEP_CD_CEP"),
  KEY "FK_ESCE_ESTA" ("ESTA_CD_ESTABELECIMENTO"),
  CONSTRAINT "FK_ESCE_CEP" FOREIGN KEY ("CEP_CD_CEP") REFERENCES "cep" ("CEP_CD_CEP"),
  CONSTRAINT "FK_ESCE_ESTA" FOREIGN KEY ("ESTA_CD_ESTABELECIMENTO") REFERENCES "estabelecimento" ("ESTA_CD_ESTABELECIMENTO")
);



#
# Dumping data for table 'estabelecimento_cep'
#

# No data found.



#
# Table structure for table 'estabelecimento_forma_pagamento'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ "estabelecimento_forma_pagamento" (
  "ESFO_CD_ESTA_FOPA" int(11) NOT NULL AUTO_INCREMENT,
  "ESTA_CD_ESTABELECIMENTO" int(11) NOT NULL,
  "FOPA_CD_FORMA_PAGAMENTO" int(11) NOT NULL,
  PRIMARY KEY ("ESFO_CD_ESTA_FOPA"),
  KEY "FK_ESFO_ESTA" ("ESTA_CD_ESTABELECIMENTO"),
  KEY "FK_ESFO_FOPA" ("FOPA_CD_FORMA_PAGAMENTO"),
  CONSTRAINT "FK_ESFO_ESTA" FOREIGN KEY ("ESTA_CD_ESTABELECIMENTO") REFERENCES "estabelecimento" ("ESTA_CD_ESTABELECIMENTO"),
  CONSTRAINT "FK_ESFO_FOPA" FOREIGN KEY ("FOPA_CD_FORMA_PAGAMENTO") REFERENCES "forma_pagamento" ("FOPA_CD_FORMA_PAGAMENTO")
);



#
# Dumping data for table 'estabelecimento_forma_pagamento'
#

# No data found.



#
# Table structure for table 'forma_pagamento'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ "forma_pagamento" (
  "FOPA_CD_FORMA_PAGAMENTO" int(11) NOT NULL AUTO_INCREMENT,
  "FOPA_NM_TIPO_PAGAMENTO" varchar(50) NOT NULL,
  "FOPA_MM_ICONE" blob,
  PRIMARY KEY ("FOPA_CD_FORMA_PAGAMENTO")
);



#
# Dumping data for table 'forma_pagamento'
#

# No data found.



#
# Table structure for table 'funcionamento'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ "funcionamento" (
  "FUNC_CD_FUNCIONAMENTO" int(11) NOT NULL AUTO_INCREMENT,
  "FUNC_IN_DIA_SEMANA" char(1) NOT NULL,
  "FUNC_HR_ABERTURA" time NOT NULL,
  "FUNC_HR_FECHAMENTO" time NOT NULL,
  "FUNC_VL_CUSTA_ENTREGA" double NOT NULL,
  "FUNC_MD_TEMPO_ENTREGA" time NOT NULL,
  "ESTA_CD_ESTABELECIMENTO" int(11) NOT NULL,
  PRIMARY KEY ("FUNC_CD_FUNCIONAMENTO"),
  KEY "FK_FUNC_ESTA" ("ESTA_CD_ESTABELECIMENTO"),
  CONSTRAINT "FK_FUNC_ESTA" FOREIGN KEY ("ESTA_CD_ESTABELECIMENTO") REFERENCES "estabelecimento" ("ESTA_CD_ESTABELECIMENTO") ON DELETE CASCADE
);



#
# Dumping data for table 'funcionamento'
#

# No data found.



#
# Table structure for table 'pedido'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ "pedido" (
  "PEDI_CD_PEDIDO" int(11) NOT NULL AUTO_INCREMENT,
  "PEDI_DT_HORA_PEDIDO" datetime NOT NULL,
  "PEDI_DT_HORA_SAIDA" datetime DEFAULT NULL,
  "PEDI_DT_HORA_ENTREGA_AGENDADA" datetime DEFAULT NULL,
  "PEDI_DT_HORA_ENTREGA_REAL" datetime DEFAULT NULL,
  "PEDI_DT_HORA_FECHAMENTO_PEDIDO" datetime DEFAULT NULL,
  "PEDI_IN_SITUACAO" char(1) NOT NULL,
  "PEDI_TX_OBSERVACAO_CLIENTE" varchar(500) DEFAULT NULL,
  "PEDI_TX_OBSERVACAO_ESTABELECIMENTO" varchar(500) DEFAULT NULL,
  "CLIE_CD_CLIENTE" int(11) NOT NULL,
  "ESTA_CD_ESTABELECIMENTO" int(11) NOT NULL,
  "FOPA_CD_FORMA_PAGAMENTO" int(11) NOT NULL,
  PRIMARY KEY ("PEDI_CD_PEDIDO"),
  KEY "FK_PEDI_CLIE" ("CLIE_CD_CLIENTE"),
  KEY "FK_PEDI_ESTA" ("ESTA_CD_ESTABELECIMENTO"),
  KEY "FK_PEDI_FOPA" ("FOPA_CD_FORMA_PAGAMENTO"),
  CONSTRAINT "FK_PEDI_FOPA" FOREIGN KEY ("FOPA_CD_FORMA_PAGAMENTO") REFERENCES "forma_pagamento" ("FOPA_CD_FORMA_PAGAMENTO"),
  CONSTRAINT "FK_PEDI_CLIE" FOREIGN KEY ("CLIE_CD_CLIENTE") REFERENCES "cliente" ("CLIE_CD_CLIENTE"),
  CONSTRAINT "FK_PEDI_ESTA" FOREIGN KEY ("ESTA_CD_ESTABELECIMENTO") REFERENCES "estabelecimento" ("ESTA_CD_ESTABELECIMENTO")
);



#
# Dumping data for table 'pedido'
#

# No data found.



#
# Table structure for table 'pedido_item'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ "pedido_item" (
  "PEIT_CD_PEDIDO_ITEM" int(11) NOT NULL AUTO_INCREMENT,
  "PEIT_VL_COBRADO" double NOT NULL COMMENT 'Valor unitário atual do produto',
  "PEIT_QN_QUANTIDADE" int(11) NOT NULL,
  "PRAT_CD_PRATO" int(11) NOT NULL,
  "PEDI_CD_PEDIDO" int(11) NOT NULL,
  PRIMARY KEY ("PEIT_CD_PEDIDO_ITEM"),
  KEY "FK_PEIT_PRAT" ("PRAT_CD_PRATO"),
  KEY "FK_PEIT_PEDI" ("PEDI_CD_PEDIDO"),
  CONSTRAINT "FK_PEIT_PEDI" FOREIGN KEY ("PEDI_CD_PEDIDO") REFERENCES "pedido" ("PEDI_CD_PEDIDO") ON DELETE CASCADE,
  CONSTRAINT "FK_PEIT_PRAT" FOREIGN KEY ("PRAT_CD_PRATO") REFERENCES "prato" ("PRAT_CD_PRATO")
);



#
# Dumping data for table 'pedido_item'
#

# No data found.



#
# Table structure for table 'prato'
#

CREATE TABLE /*!32312 IF NOT EXISTS*/ "prato" (
  "PRAT_CD_PRATO" int(11) NOT NULL AUTO_INCREMENT,
  "PRAT_NM_PRATO" varchar(100) NOT NULL,
  "PRAT_DS_PRATO" text NOT NULL COMMENT 'Descrição do prato',
  "PRAT_MM_FOTO" blob,
  "PRAT_MD_TAMANHO" varchar(50) NOT NULL,
  "PRAT_VL_UNITARIO" double unsigned NOT NULL,
  "CARD_CD_CARDAPIO" int(11) NOT NULL COMMENT 'Chave estrangeira (Cardápio)',
  PRIMARY KEY ("PRAT_CD_PRATO"),
  KEY "FK_PRAT_CARD" ("CARD_CD_CARDAPIO"),
  CONSTRAINT "FK_PRAT_CARD" FOREIGN KEY ("CARD_CD_CARDAPIO") REFERENCES "cardapio" ("CARD_CD_CARDAPIO") ON DELETE CASCADE
);



#
# Dumping data for table 'prato'
#

# No data found.

/*!40101 SET SQL_MODE=@OLD_SQL_MODE;*/
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;*/
