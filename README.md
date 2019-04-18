Topics to cover:

* Spring Core (i.e. dependency injection)
  * What's the problem?
  	 * instantiating instances needed by the application.
  	    * Traditionally solved with Factory pattern
	  	* client shouldn't care what producer needs. Just do your job!
	  	* figuring out the order of instantiation
	  	* make testing easy 
	  	* lazy loading vs eager loading of instances 
  * How to use Spring?
    * XML-only config
    * xml + `@Component` + `@Autowired`
        * `@Named` + `@Inject`
    * java config
  * How to test? 
  	 * `@RunWith(SpringJUnit4ClassRunner.class)`
  	 * `@ContextConfiguration`
  	 * autowire ApplicationContext 
  	 * `@Autowired` 
* Spring MVC
    * REST endpoints
    * JSON serialization/de-serialization
    * XML serialization/de-serialization (nice to have)
* Spring with MyBatis 
    * Transaction mgmt 


### Running 

#### spring-core-demo
```
cd spring-core-demo 
./mvnw clean install 

./mvnw exec:java -Dexec.mainClass="com.sourceallies.demos.library.LibraryApplication"  

```

#### spring-mvc-demo
```
cd spring-mvc-demo 
./mvnw clean install 

./mvnw jetty:run  

```

# You want to start from scratch? 
To start a console app from scratch
```bash
mvn archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4
```

To create a web application from scratch:
```bash
mvn archetype:generate -DarchetypeArtifactId=maven-archetype-webapp
```
