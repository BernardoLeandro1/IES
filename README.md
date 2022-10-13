# IES

Repository for IES classes


Useful commands:
 - For Maven:
 	
	mvn package -> get dependencies, compiles the project and creates the jar
	
	mvn exec:java -Dexec.mainClass="package.ClassName" -> Executes the file, adapt to match your own package and class name

	mvn install -DskipTests && java -jar target\webapp1-0.0.1-SNAPSHOT.jar or ./mvnw spring-boot:run -> build the Spring Boot application
 
 - For Git:
 	
	git clone -> to clone your existing repository
	
	git add -> to stage a change to the repository
	
	git commit -> sets up the project to be pushed
	
	git push -> sends the changes that were made to the repository

 - For Docker:
 
 	To use docker as a non-user root:
 		
		Create the docker group.

 			sudo groupadd docker

		Add your user to the docker group.

 			sudo usermod -aG docker $USER

		Log out and log back in

		On Linux, you can also run the following command to activate the changes to groups:

 			newgrp docker 

		Verify that you can run docker commands without sudo.

 			docker run hello-world

	
	
	docker compose up -> build and run an app
	
	docker compose down -> stop the app that's running (use the command on another terminal or just use ctrl+c on the current terminal)
	
	docker compose ps -> check what's running
	
	docker compose stop -> stops all services, if started by docker compose up -d
	
	docker pull postgres -> pull latest postgres image
	
	
