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

To stop all services and clear docker call:

```
./stop-containers.sh
```

###Additionally listing of metriks from Jmeter test execution:

1,000 REQUESTS (100 threads created in 1 sec. with 10 loop):
```
summary =   1000 in 00:00:05 =  182.3/s Avg:   425 Min:     6 Max:  1297 Err:     0 (0.00%)
```

100,000 REQUESTS (1000 threads created in 10 sec. with 100 loop):
```
summary = 100000 in 00:06:34 =  253.8/s Avg:  3632 Min:     5 Max: 75736 Err:     0 (0.00%)
```

1 million REQUESTS (1000 threads created in 10 sec. with 1000 loop):
```
summary = 1000000 in 00:35:50 =  465.2/s Avg:  2053 Min:     4 Max: 79353 Err:     0 (0.00%)
```
