For correct work need start in the tomcat 7 or later
also need add jstl & mysql library to tomcat lib
(for me jstl-1.2.jar,mysql-connector-java-8.0.13.jar
from .m2 repo to tomcatX/lib directory)

mysql:
CREATE DATABASE nicofog;
USE nicofog;
CREATE TABLE user
(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(23),
    role VARCHAR(20),
    sigaretPrice INT,
    dateRegistration VARCHAR(23)
);

ALTER TABLE user ADD password VARCHAR(32) DEFAULT 0 NOT NULL;
ALTER TABLE user CONVERT TO CHARACTER SET utf8 COLLATE utf8_unicode_ci;
