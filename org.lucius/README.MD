启动consul：<br>
./consul agent -server -bootstrap-expect=1  -data-dir=/tmp/consul -node=server-01 -bind=192.168.26.131 -dc=data-center-01 -client 0.0.0.0 -ui & 

在Consul的配置key/value中增加如下节点和配置:<br>
节点：config/org.lucius.microservice.user.service,test/configuration

节点：config/org.lucius.microservice.order.service,test/configuration

配置：

lucius:
  email: lucius.lv.test@qq.com
