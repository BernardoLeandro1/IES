In exercise 1:

    - a) I followed the guide available at https://www.baeldung.com/spring-boot-crud-thymeleaf.

    - b)    The “UserController” class gets an instance of “userRepository” through its constructor; how is this new repository instantiated?

                Through @Autowired. @Autowired puts an instance of "userRepository" in "userController"
            
            List the methods invoked in the “userRepository” object by the “UserController”. Where are these methods defined?

                save(), findAll(), findById() e delete().All these methods are defined in CrudRepository which userRepository extends.

            Where is the data being saved?

                Data is being saved in a database, using h2database, that was added to the project dependencies.
            
            Where is the rule for the “not empty” email address defined?

                It's defined in User.java through @NotBlank.
    
    - c) In c, I added, as suggested a Phone Number to the user class. Changed the html files to have inputs and to show the phone number for each user. Used @NotNull with the same intent of @NotBlank because Integer is not a valid type for the second one to check.

In exercise 2:

    - a) Used this command: docker run --name mysql6 -e MYSQL_ROOT_PASSWORD=secret1 -e MYSQL_DATABASE=demo -e MYSQL_USER=demo -e MYSQL_PASSWORD=secret2 -p 33060:3306 -d mysql/mysql-server:5.7

    - For the remainder of the exercise I followed the guide present in https://www.javaguides.net/2018/09/spring-boot-2-jpa-mysql-crud-example.html. After completing the guide and adding the application.properties present in the pdf, I also added spring.jpa.open-in-view=true to remove a warning that was appearing when running the application (spring.jpa.open-in-view is enabled by default. Therefore, database queries may be performed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning). In g) I followed https://spring.io/guides/gs/accessing-data-jpa/#_create_simple_queries and https://www.baeldung.com/spring-request-param in onrder add a search by email method. The result of the testing is in the lab3_2/ImagesFromTesting folder.

