Use Java 18 as the project SDK or there will be an error with java.sql.rowset


SQL files are added in the SQL folder, use the Dump Folder Data Import in MySQL Workbench CE on the SQL folder. In DBUtil, you will need to create your own JDBC connection url from your MySQL Workbench server instance and use your password.

JDBC connection url is as is: jdbc:mysql://username:password@[localhost:port]

username is your server username (root is default), can be found on MySQL Connections on home page after software start.
password is your password for your server instance.
port is the port that it runs on, which can be found on the MySQL Connections on the home page after software start.


![image](https://user-images.githubusercontent.com/19367729/203153018-a3d9c30b-5465-465e-a706-4cb1d4bccac8.png)
