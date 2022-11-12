**Dans Java Springboot Test**

**Java Test**
Please create below REST API using Java - SpringBoot framework:

**1.Login API**
- The API should validate username and password
- List of valid username and password should be stored on a DBMS
- Any DBMS is allowed
- It is recommended to use JPA as ORM to manage relational data in Java
application
- It is recommended to use JPA as ORM to manage relational data in Java application

**2.Get job list API**
- The API should be secured with JWT token
- The API should make http request
```
http://dev3.dansmultipro.co.id/api/recruitment/positions.json
```
and return jobs data as response payload.

**3.Get job detail API**
- The API should be secured with JWT token
- The API should make http request 
```
http://dev3.dansmultipro.co.id/api/recruitment/positions/{ID}
```
and return job detail data as response payload.
