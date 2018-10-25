# JVApp
Java漏洞练习程序，开发工具Eclipse，运行环境Java 1.7以上版本，Tocmat7以上。

安装方法：
1.首先安装jdk1.7以上版本，下载Tomcat7以上版本，将war包程序部署到Tomcat webapps目录
2.安装mysql5.7，如果是其他5.x版本或导入SQL报错，修改JVAPP.sql中的utf8mb4为utf8，然后新建数据库apptest使用navicat导入sql文件。
3.启动tomcat,待程序解压后，修改JVApp中WEB-INF/classes/config.properties中的数据库连接信息（ip、数据库、账号、密码）等信息，修改完成后重启tomcat即可。
4.访问程序：http://127.0.0.1/JVApp/
