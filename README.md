This project is a simple example of SpringBoot

1. JUnit to test Controller with MockMvc
2. Logback
   2.1 logback-spring.xml(not logback.xml) specifies corresponding logging level for prd/test/dev profile
   2.2 application.properties specifies log file path, it will override same configurations in logback*.xml if presented
3. Specify active profile in application.properties