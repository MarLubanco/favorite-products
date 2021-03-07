## Favorite Product Service

Application for stores, where the customer can view products registered and mark their favorite products.

#### Tecnolgies

```aidl
 Java 8
 Spring Boot
 Spring Security
 Spring Cloud OpenFeign
 Hibernate
 JPA
 Docker
 PostgreSQL
 Lombok
 MockMVC
 JUnit
```

### Documentation Swagger

Project Running

http://localhost:8080/swagger-ui.html#/

### Requirements

```aidl
PostgreSQL installed
Java 8 installed
Docker installed
```

### Clone project
```
git clone https://github.com/MarLubanco/favorite-products.git
cd favorite-products
```


### Run project

```dockerfile
docker pull marthome/favorite-product:1.2

docker run --name favorite-product -e USER_DATABASE=<user> -e PASSWORD_DATABASE=<password> -p 8080:8080 marthome/favorite-product:1.2
```
