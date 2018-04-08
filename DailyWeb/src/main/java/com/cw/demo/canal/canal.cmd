--------------------------------------------------------------canal配置
//要监控的数据库服务器的 ip：端口 用户名 密码  
canal.instance.master.address = 127.0.0.1:3306
canal.instance.dbUsername = canal
canal.instance.dbPassword = canal
canal.instance.defaultDatabaseName =test

//监控的库/表
canal.instance.filter.regex = .*\\..* 
//伪装成slave的id，不可与数据库master相同
canal.id= 1



---------------------------------------------------------------mysql配置
 [mysqld]  
log-bin=E:/mysql5.5/bin_log/mysql-bin.log  #配置开启binlog功能
server-id=123 #配置mysql同步需要定义的id，不能和canal的slaveId重复  
//新建canal的用户，分配权限
CREATE USER canal IDENTIFIED BY 'canal';    
GRANT SELECT, REPLICATION SLAVE, REPLICATION CLIENT ON *.* TO 'canal'@'%';  
-- GRANT ALL PRIVILEGES ON *.* TO 'canal'@'%' ;  
FLUSH PRIVILEGES; 
