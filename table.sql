CREATE TABLE IF NOT EXISTS `t_user`(
    `id` INT UNSIGNED AUTO_INCREMENT,
    `username` VARCHAR(20),
    `password` VARCHAR(20),
    `age` INT,
    `gender` CHAR(1),
    `email` VARCHAR(20),
    PRIMARY KEY ( `id` )
    )ENGINE=InnoDB DEFAULT CHARSET=utf8;