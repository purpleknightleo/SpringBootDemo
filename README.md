This project is a simple example of SpringBoot

Ref:
   http://blog.didispace.com


1. JUnit to test Controller with MockMvc
2. Logback
   2.1 logback-spring.xml(not logback.xml) specifies corresponding logging level for prd/test/dev profile
   2.2 application.properties specifies log file path, it will override same configurations in logback*.xml if presented
3. profile
   3.1 Specify active profile in application.properties
   3.2 application-XXX.properties for each profile
4. Swagger2 to auto-generate API doc and test cases
5. Read config properties in .properties files
6. Mybatis
   6.1 XXXMapper.java to config SQL statements

