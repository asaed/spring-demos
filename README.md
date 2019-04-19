spring-demos
====

This project is a step-by-step demo of how to use Spring. Each step is in its own git branch.

### Spring Core (IoC Container)
The git branches for using spring IOC container are (in chronological order):
- demo-1-0-without-spring
- demo-1-1-spring-xml
- demo-1-2-spring-annotations
- demo-1-3-spring-java-config

To use the any of those branches: 
```bash 
git checkout ${branchName}

cd spring-core-demo 

./mvnw clean install 

./mvnw exec:java -Dexec.mainClass="com.sourceallies.demos.library.LibraryApplication"  
# The console application will run and print some output to the console 
```

### Testing Spring IoC Container
The git branches are: 
- demo-2-1-spring-xml-with-tests
- demo-2-2-spring-annotations-with-tests
- demo-2-3-spring-java-config-with-tests

To use the any of those branches: 
```bash 
git checkout ${branchName}

cd spring-core-demo 

./mvnw clean test 
# Tests will run agains the spring IOC container 
```

### Spring MVC 
The git branches are: 
- demo-3-0-bare-java-web-app
- demo-3-1-bare-spring-mvc
- demo-3-2-mvc-request-mapping
- demo-3-3-more-request-mapping
- demo-3-4-handling-responses

To use the any of those branches: 
```bash 
git checkout ${branchName}

cd spring-mvc-demo 

./mvnw clean install 

./mvnw jetty:run

# Point your browser to http://localhost:8080/
```

### You want to start from scratch?
To start a console app from scratch
```bash 
mvn archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4
```

To create a web application from scratch:
```bash
mvn archetype:generate -DarchetypeArtifactId=maven-archetype-webapp
```