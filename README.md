This project is a simple demo of SpringBoot

Ref:
   http://blog.didispace.com
   http://412887952-qq-com.iteye.com/blog

1. **JUnit**: test Controller with MockMvc
2. **Logback**  
   2.1 logback-spring.xml(not logback.xml) specifies corresponding logging level for prd/test/dev profile  
   2.2 application.properties specifies log file path, it will override same configurations in logback*.xml if presented
3. **profile**  
   3.1 Specify active profile in application.properties  
   3.2 application-XXX.properties for each profile  
   3.3 seperate code logics for profiles, see details in ProfileService.java
4. **Swagger2**: auto-generate API doc and test cases, see details in BookController.java&Swagger2.java
5. **properties**: read config properties in .properties files   
   5.1 Method1: @Value, see details in MiscProperties.java   
   5.2 Method2: @ConfigurationProperties, see details in MusicProperties.java   
6. **Mybatis**   
   6.1 Druid as dataSource, see details in application-dev.properties   
   6.2 Method1: XXXMapper.java to config SQL statements, see details in UserDOMapper.java  
   6.3 Method2: traditional XXXMapper.xml+XXXDAO.java configurations, see details in CompanyDAOImpl.java  
7. **fastjson**   
   7.1 fastjson to replace default jackson for serialization/deserialization, see details in SpringBootApp.java  
   7.2 @JSONField(serialize = false) to ignore field in serialization, see details in BookDTO.java  
8. **aspect**: see details in WebLogAspect.java
9. 
