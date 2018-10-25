# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine

# Add Maintainer Info
LABEL maintainer="houdayec"

# Make port 9393 available to the world outside this container
EXPOSE 9393

# The application's jar file
ARG JAR_FILE=target/nomadaccomodationfinder-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} nomadaccomodationfinder.jar

# Run the jar file
ENTRYPOINT ["java","-jar","/nomadaccomodationfinder.jar"]
