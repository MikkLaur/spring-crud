# Simple Spring To-do REST API

## Setting up

Everything necessary for building should be acquired by Gradle.  
Dependencies used:
````
implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
implementation 'org.springframework.boot:spring-boot-starter-web'
implementation 'org.springdoc:springdoc-openapi-starter-webmvc-ui:2.1.0'
runtimeOnly 'com.h2database:h2'
testImplementation 'org.springframework.boot:spring-boot-starter-test'
````
Temurin-17 OpenJDK was used to develop this.

## Using the API
Possible requests:  
GET `/todos`  
GET `/todos/{todoId}`  
POST `/todos`  
DELETE `/todos`  
DELETE `/todos/{todoId}`  
PATCH `/todos/{todoId}/toggle`  
PATCH `/todos/{tdoId}/edit`

To access Swagger API http://localhost:8080/swagger-ui/index.html

![](picture-of-swagger-api.png)



