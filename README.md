# Task

App converts not negative decimal integer number N.

### RESTful Spring Boot app which implements below algorithms:
  - return the number in binary system as a string (v1)
  - switch digits (1 to 0,  0 to 1, e.g. 1000 to 0111) and return the number in octal system as a string (v2)
  - reverse the digits (e.g. 0100 to 0010) and return the number in hexadecimal system as a string (v3)
  - move all 1s to the left, and all 0s to the right (e.g. 1010 to 1100) and return the number in decimal system as a string (v4)
  
### Available endpoints:
  - localhost:8081/algorithms/v1/{number}
  - localhost:8081/algorithms/v2/{number}
  - localhost:8081/algorithms/v3/{number}
  - localhost:8081/algorithms/v4/{number}
  - localhost:8081/algorithms/results
  
  #### Swagger documentation
  - localhost:8081/v2/api-docs
  - localhost:8081/swagger-ui.html#/
  
## Docker container accessible via docker hub: 
  - https://hub.docker.com/r/kamiljacko/task-spring-boot-application
  
  ### To run the application use commands:
      - docker pull kamiljacko/task-spring-boot-application:latest
      - docker run -p 8081:8081 kamiljacko/task-spring-boot-application:latest
  
