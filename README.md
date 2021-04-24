# EcommercialWS
to make this project working in your computer 


1-make pull requset
git pull origin master

<br/>
2-you have to add **Ecommercial** database to your MySQL server
<br/><br/>
3-you have to update your Ecommercial\src\mine\resources\application.properties to<br/>

spring.jpa.hibernate.ddl-auto=update<br/>
spring.datasource.url=jdbc:mysql://localhost/Ecommercial?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Moscow&createDatabaseIfNotExist=true
<br/>spring.datasource.username=root<br/>
spring.datasource.password=Sabry1998<br/>
<br/>
as _**spring.datasource.username**_ is your database user<br/>
as _**spring.datasource.password**_ is your database user password

