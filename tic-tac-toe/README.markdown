#Tic-Tac-Toe application

#Instructions to run

A) Docker
1. Go to main folder of project and execute command to build docker image: 
	docker build -t tic-tac-toe/tic-tac-toe . 
2. To start docker container:  docker run -p 8080:8080 tic-tac-toe/tic-tac-toe

B) Command line. You must have maven and java installed on machine
1. Go to main folder and execute: mvn clean install
2. java -jar target/tic_tac_toe-0.0.1-SNAPSHOT.jar app.jar