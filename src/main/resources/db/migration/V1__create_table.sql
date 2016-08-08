CREATE TABLE urlinfo (
   id bigint(20) NOT NULL,
   created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
   modified_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
   urlname varchar(255) DEFAULT NULL,
   urllink varchar(500) DEFAULT NULL,
   platform VARCHAR (255) DEFAULT NULL,
   opt_lock int(11) unsigned
)ENGINE=InnoDB;