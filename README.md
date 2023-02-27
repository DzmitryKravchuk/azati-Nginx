azati-Nginx
===

Application contains 3 `producers` (simple REST app for saving a number to Apache Kafka topic) 1 `consumer` (reads the message from Kafka topic and saves the number to DB)
 
Nginx is used as load balancer (redirecting requests to `producers`) on fixed round-robin criteria (configuration stored in ./nginx/nginx.conf file)

From the root project to run all services (including Zookeeper, Kafka, DB and nginx) simply call:

```
./exec-start.sh
```
Do not call `docker-compose up` directly. For all producers we use one image `producer`, which should be created first (though we don't create a separate container for it).

###For manual testing you can use this end-point:

- POST to URL:  http://localhost:8080/message/publish

set any number to `intValue` parameter in request body
```
{ "intValue": 10 }
```
To stop all services and clear docker call:

```
./stop-containers.sh
```