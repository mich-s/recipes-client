# Recipes REST Client app
This is a Spring Boot app that consumes Recipes REST API. It makes use of Spring's RestTemplate and Thymeleaf template engine.
[About Recipes REST API](https://github.com/mich-s/recipes-rest-api)
## How to run
1. Clone the repo
	```
	git clone https://github.com/mich-s/recipes-client.git
	```
2.  Make sure you are using JDK 1.8 and Gradle 4.x
3.  You can use Gradle plugin to run this app
	```
	cd recipes-client
	gradlew bootRun
	```
4.  Start your browser and go to:
	```
	http://localhost:8081/recipes
	```
Remember that both REST service and REST consumer should run simultaneously.
## Screenshots
![Alt](https://github.com/mich-s/recipes-client/blob/master/src/main/resources/static/images/rc1.PNG)
![Alt](https://github.com/mich-s/recipes-client/blob/master/src/main/resources/static/images/rc2.PNG)