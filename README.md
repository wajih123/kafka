# kafka
this is a spring boot project how to use kafka messaging from producer to consumer
after installing kafka go to the kafka folder and search this file server.properties and add this 2 lines


port=9092
advertised.host.name=localhost


and start zookeper by typing 

*****mac******


bin/zookeeper-server-start.sh config/zookeeper.properties


******windows******

bin\windows\zookeeper-server-start.bat config/zookeeper.properties


then start kafka by typing 

******mac******

bin/kafka-server-start.sh config/server.properties

*******windows*******

bin\windows\kafka-server-start.bat config/server.properties

for more details visit kafka page

=> https://kafka.apache.org/
