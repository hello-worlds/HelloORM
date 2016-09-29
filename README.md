# HelloORM
eclipse sample java code for ORM (Object-relational Mapping)

## Tools and Method
* Maven
* JDBC
* JPA
* Eclipselink

## MySQL Connection
Connection File Location
```java
Persistence.xml
```

Sample Connection Configuration
```xml
<property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/hellojava" />
			<property name="javax.persistence.jdbc.user" value="root" />
			<property name="javax.persistence.jdbc.password" value="" />
			<property name="javax.persistence.jdbc.driver" value="com.mysql.jdbc.Driver" />
			<property name="eclipselink.logging.level" value="FINE" />
			<property name="eclipselink.ddl-generation" value="create-tables"/>
```