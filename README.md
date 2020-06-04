# Cinemix

### Technology stack for backend

- Java 11
- Maven 
- Spring 2.2.5
- SpringBoot 2.2.5
- Heroku for production environment with PostgreSQL database
- JWT for authorization
- H2 Database for local development
- Lombok
- Spock (with Groovy) for testing
- MapStruct
- JUnit
- 

### Local development
Run command in project dir:
- For Windows:
```bash
mvnw.cmd spring-boot:run
```
- For Linux:
```bash
./mvnw spring-boot:run
```

### Sonarcloud

Sonarcloud link: [https://sonarcloud.io/dashboard?id=cinemix_cinemix-backend](https://sonarcloud.io/dashboard?id=cinemix_cinemix-backend)
App is analysed by Sonar on every pull request to develop. This was achieved using Github Actions.

### Live App

Live app with Frontend: [https://cinemix.ga](https://cinemix.ga)

REST EndPoints on internet:

- GET:
    - [https://cinemix.herokuapp.com/api/test/all](https://cinemix.herokuapp.com/api/test/all)
    - [https://cinemix.herokuapp.com/api/movies/all](https://cinemix.herokuapp.com/api/movies/all)
    - [https://cinemix.herokuapp.com/api/movies/id](https://cinemix.herokuapp.com/api/movies/1)
    - [https://cinemix.herokuapp.com/api/test/user](https://cinemix.herokuapp.com/api/test/user)
    - [https://cinemix.herokuapp.com/api/test/mod](https://cinemix.herokuapp.com/api/test/mod)
    - [https://cinemix.herokuapp.com/api/test/admin](https://cinemix.herokuapp.com/api/test/admin)
- POST:
    - [https://cinemix.herokuapp.com/api/auth/signin](https://cinemix.herokuapp.com/api/auth/signin)
    - [https://cinemix.herokuapp.com/api/auth/signup](https://cinemix.herokuapp.com/api/auth/signup)
    - [https://cinemix.herokuapp.com/api/movies/add](https://cinemix.herokuapp.com/api/movies/add)
