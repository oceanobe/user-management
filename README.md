# EFK log centralizer with Kibana, Fluentd and SpringBoot

### TLDR
Create fluentd local image
```
docker build -t fluentd fluentd/
```
Then build user-management app
```
gradle clean build
```
Then create user-management local image
```
docker build -t user-management .
```
Then start all containers
```
docker-compose up
```
Then call user-management API
```
curl -i http://localhost:5000/v1/api/user
```
Then navigate to ElasticSearch at http://localhost:5601/app/home#/ . Open the hamburger menu from the top left side, and select Discover -> Create data view

Complete as per

![img.png](img.png)

And click on `Save data view to Kibana`

Et voila! Now you should be able to see user-management logs flowing in.

### Collecting and displaying SpringBoot app metrics in a human friendly format using Prometheus and Grafana
WIP

### Long version
WIP
