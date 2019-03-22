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


Domain to use: 

init 
```
 mvn archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4
```

```
Libraries (3x Libraries: SAI Internal Library, Des Moines )
Members

public class Author {
    private long id;
    private String name;
}

public class Book {
    private long id;
    private String title;
    private long authorId;
    private long genreId;
    private long publicationYear;
}

public class Genre {
    private long id;
    private String name;
}

public class Library {
    private long id;
    private String name;
}

public class Member {
    private long id;
    private String name;
    private MembershipType membershipType;
}

public enum MembershipType {
    BASIC, SUPER, VIP;
}


    support multiple libraries with different list of books
    implement countBooksByGenre(), countBooksByAuthor(), etc. 
    
```
testing data https://github.com/asaed/poc-nancy-at-iadnug/tree/master/Poc.Nancy.Modules/Data/Repositories

Running 

```
cd spring-core-demo 
./mvnw clean install 

./mvnw exec:java -Dexec.mainClass="com.sourceallies.demos.library.LibraryApplication"  

```
