In exercise 1:
    
    - After downloading apache tomcat and running startup.sh present in /bin directory, I opened localhost:8080 and got a page with documentation and other stuff from tomcat.

    - The superclass found was HttpServlet
    
    - To finish the exercise I followed step #6 from (https://examples.javacodegeeks.com/enterprise-java/servlet/java-servlet-container-example/) and  https://howtodoinjava.com/java/servlets/complete-java-servlets-tutorial/#webservlet_annotation
   
In exercise 2:

    - I followed a guide on embedded jetty servers (https://examples.javacodegeeks.com/enterprise-java/jetty/embedded-jetty-server-example/). With this I learned that Jetty can be embedded, therefore we don't need a .war file to launch Jetty. 

In exercise 3:

    - I generated a Spring Boot Web Application and ran it, using ./mvnw spring-boot:run. Oppened localhost/8080, to see the page.

    - In b), I followed this guide (https://spring.io/guides/gs/serving-web-content/), having to change the server port to 9000 on application.properties.
    
    You can easily identify the controller by the @Controller annotation. 
    
    The @GetMapping annotation ensures that HTTP GET requests to /greeting are mapped to the greeting() method.
    
    @RequestParam binds the value of the query string parameter name into the name parameter of the greeting() method. This query string parameter is not required. If it is absent in the request, the defaultValue is used (in this exercise it's defined by World).
    
    @SpringBootApplication is a convenience annotation that adds all of the following:

        @Configuration: Tags the class as a source of bean definitions for the application context.

        @EnableAutoConfiguration: Tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings. For example, if spring-webmvc is on the classpath, this annotation flags the application as a web application and activates key behaviors, such as setting up a DispatcherServlet.

        @ComponentScan: Tells Spring to look for other components, configurations, and services in the com/example package, letting it find the controllers.



    - In c), I followed this guide (https://spring.io/guides/gs/rest-service/), doing it in the previous files, comentating the resolution and adding what I needed for this exercise. Added Greeting also.

    In Spring’s approach to building RESTful web services, HTTP requests are handled by a controller. These components are identified by the @RestController annotation.

    This code uses Spring @RestController annotation, which marks the class as a controller where every method returns a domain object instead of a view. It is shorthand for including both @Controller and @ResponseBody.

        The result from $ curl -v http://localhost:9000/greeting:

            *   Trying 127.0.0.1:9000...
            * TCP_NODELAY set
            * Connected to localhost (127.0.0.1) port 9000 (#0)
            > GET /greeting HTTP/1.1
            > Host: localhost:9000
            > User-Agent: curl/7.68.0
            > Accept: */*
            > 
            * Mark bundle as not supporting multiuse
            < HTTP/1.1 200 
            < Content-Type: application/json
            < Transfer-Encoding: chunked
            < Date: Thu, 13 Oct 2022 16:20:17 GMT
            < 
            * Connection #0 to host localhost left intact
            {"id":3,"content":"Hello, World!"}
        
        The result from $ curl -v http://localhost:9000/greeting?name=Bernardo:

            *   Trying 127.0.0.1:9000...
            * TCP_NODELAY set
            * Connected to localhost (127.0.0.1) port 9000 (#0)
            > GET /greeting?name=Bernardo HTTP/1.1
            > Host: localhost:9000
            > User-Agent: curl/7.68.0
            > Accept: */*
            > 
            * Mark bundle as not supporting multiuse
            < HTTP/1.1 200 
            < Content-Type: application/json
            < Transfer-Encoding: chunked
            < Date: Thu, 13 Oct 2022 16:25:55 GMT
            < 
            * Connection #0 to host localhost left intact
            {"id":5,"content":"Hello, Bernardo!"}


In exercise 4:

    - I used the same logic as exercise 3. Created Quotes.java and QuotesController.java, where, in the second, I defined an HashMap with the names from tv shows/movies and an ArrayList with their quotes.

Questions:

    A. What are the responsibilities/services of a “servlet container”?

        -  The servlet container provides the servlet easy access to properties of the HTTP request, such as its headers and parameters. When a servlet is called (such as when a servlet is specified by URL), the Web server passes the HTTP request to the servlet container. The container, in turn, passes the request to the servlet. In the course of managing a servlet, a servlet container performs the following tasks:

            It creates an instance of the servlet and calls its init() method to initialize it.

            It constructs a request object to pass to the servlet. The request includes, among other things, any HTTP headers from the client, parameters and values passed from the client (for example, names and values of query strings in the URL), the complete URI of the servlet request.

            It constructs a response object for the servlet.

            It invokes the servlet service() method. Note that for HTTP servlets, the generic service method is usually overridden in the HttpServlet class. The service method dispatches requests to the servlet doGet() or doPost() methods, depending on the HTTP header in the request (GET or POST).

            It calls the destroy() method of the servlet to discard it when appropriate, so that it can be garbage collected. (For performance reasons, it is typical for a servlet container to keep a servlet instance in memory for reuse, rather than destroying it each time it has finished its task. It would be destroyed only for infrequent events, such as Web server shutdown).

    
    B. Explain, in brief, the “dynamics” of Model-View-Controller approach used in Spring Boot to serve web content. (You may exemplify with the context of the previous exercises.)

    - The Model component corresponds to all the data-related logic that the user works with. This can represent either the data that is being transferred between the View and Controller components or any other business logic-related data. For example, the Quotes object retrieves the quote information from the quotesList, manipulates it and updates data back to the database or uses it to render data.

    - The View component is used for all the UI logic of the application. It is what the user sees.

    - Controllers act as an interface between Model and View components to process all the business logic and incoming requests, manipulate data using the Model component and interact with the Views to render the final output. For example, the Quotes controller handles all the interactions and inputs from the View and updates the database using the Model. The same controller will be used to view the data.
    
    
    C. Inspect the POM.xml for the previous Spring Boot projects. What is the role of the “starters” dependencies?

    - The "starters" dependencies are there to ensure a pattern is being used for the specifications of the project, making it easier for it to be constructed.


    D. Which annotations are transitively included in the @SpringBootApplication?

    - @Configuration: Tags the class as a source of bean definitions for the application context.

    - @EnableAutoConfiguration: Tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings. For example, if spring-webmvc is on the classpath, this annotation flags the application as a web application and activates key behaviors, such as setting up a DispatcherServlet.

    - @ComponentScan: Tells Spring to look for other components, configurations, and services in the com/example package, letting it find the controllers.


    E. Search online for the topic “Best practices for REST API design”. From what you could learn, select your “top 5” practices, and briefly explain them in you own words

    - REST API Must Accept and Respond with JSON -> JSON is an open and standardized format for data transfer and server-side technologies have libraries that can decode JSON without any hassle, making it easy to use.

    - Don’t Use Verbs in URLs -> HTTP verbs should be sufficient to describe the action being performed on the resource, therefore there's no need to use verbs in the URLs

    - Use Plural Nouns to Name a Collection -> Makes it easier for human comprehension

    - Well compiled documentation -> Well compiled documentation is always important. The documentation is the first point in the hands of customers to understand the product and a critical deciding factor whether to use it or not. One good documentation is neatly presented, in a proper flow to make an API development process quicker.

    - Handle errors gracefully and return standard error codes -> To eliminate confusion for API users when an error occurs, we should handle errors gracefully and return HTTP response codes that indicate what kind of error occurred. This gives maintainers of the API enough information to understand the problem that’s occurred. Common error status codes:

        400 Bad Request – This means that client-side input fails validation.
        
        401 Unauthorized – This means the user isn’t not authorized to access a resource. It usually returns when the user isn’t authenticated.
        
        403 Forbidden – This means the user is authenticated, but it’s not allowed to access a resource.
        
        404 Not Found – This indicates that a resource is not found.
        
        500 Internal server error – This is a generic server error. It probably shouldn’t be thrown explicitly.
        
        502 Bad Gateway – This indicates an invalid response from an upstream server.
        
        503 Service Unavailable – This indicates that something unexpected happened on server side (It can be anything like server overload, some parts of the system failed, etc.).