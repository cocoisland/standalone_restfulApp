# standalone_restfulApp
> This application represents the barebone minimum running standalone application built with dropwizard framework and maven-shade-plugin fat jar packaging.

> Dropwizard is an open-source Java framework used for the fast development of high-performance RESTful web services. It gathers some popular libraries to create the light-weight package. The main libraries that it uses are Jetty, Jersey, Jackson, JUnit, and Guava. Furthermore, it uses its own library called Metrics.

[Description of the project](https://https://www.baeldung.com/java-dropwizard)

> This project was built with java maven-archtype-quickstart and maven-shade-plugin.
- A maven-archetype-quickstart = generate a sample Maven project.
- A maven-archetype-webapp = create a webapp that will generated a WAR file to running inside webserver (i.e. Tomcat)

> There are 3 main plugins that we can use when packaging our application into a jar file and those plugins follow different concepts when packaging our application with dependencies.
1. maven jar plugin
  - This plugin provides the capability to build and sign jars. But it just compiles the java files under src/main/java and /src/main/resources/. It doesn't include the dependencies JAR files.
  
2. maven assembly plugin
  - This plugin extracts all dependency jars into raw classes, and group it together. It can also be used to build an executable jar by specifying the main class. It works in project with less dependencies only, for large project with many dependencies, it will cause Java class name conflict issue.
  
3. maven shade plugin
  - It packages all dependencies into one uber-jar. It can also be used to build an executable jar by specifying the main class. This plugin is particularly useful as it merges content of specific files instead of overwriting them by Relocating Classes. This is needed when there are resource files that are have the same name across the jars and the plugin tries to package all the resource files.


### Compile and Package
Eclipse -> Run configuration -> Maven Build -> Goals: package

### To run
java -jar target/dropwizard-0.0.1-SNAPSHOT.jar

### Application listens on port 8080
http://localhost:8080/brands

### HealthCheck on port 8081
http://localhost:8081/healthcheck
