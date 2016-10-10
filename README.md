# HelloORM
eclipse sample java code for ORM (Object-relational Mapping)

## Tools and Method
* Maven
* JDBC
* JPA
* JPA Implementation with Eclipselink
* Hibernate

## JPA Eclipselink MySQL Configuration
Configuration File Location
```java
src/main/resources/Persistence.xml
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

## Hibernate Configuration
Configuration File Location
```java
src/main/resources/hibernate.cfg.xml
```
or
```java
src/main/resources/hibernate.properties
```

Sample XML Configuration
```xml
<property name="hibernate.bytecode.use_reflection_optimizer">false</property>
<property name="hibernate.dialect">org.hibernate.dialect.MySQLDialect</property>
<property name="hibernate.connection.driver_class">com.mysql.jdbc.Driver</property>
<property name="hibernate.connection.url">jdbc:mysql://localhost:3306/hellojava</property>
<property name="hibernate.connection.username">root</property>
<property name="hibernate.connection.password"></property>
<property name="show_sql">true</property>
<mapping class="com.richasdy.HelloORM.model.Stock"></mapping>
```

## JPA Implementation with Eclipselink
* JPA CRUD
* JPA Criteria aka Query Builder
* JPA Entity Relational Mapping
* JPQL (Query Language)
* JPA Inheritance Startegies

## Hibernate
* Hibernate CRUD
* Hibernate Entity Relational Mapping
* Hibernate Costum Logging
* Hibernate c3p0 connection pool
* Hibernate Transaction
* Hibernate QL
* Hibernate Native Query
* Hibernate Criteria
* Hibernate Parameter Binding
