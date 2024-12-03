FROM openjdk:21

# Set the working directory in the container
WORKDIR /DevOps_AF

# Copy the JAR file into the container at /educacaoGamificada
COPY target/*.jar /DevOps_AF/DevOps_AF-0.0.1-SNAPSHOT.jar

# Expose the port that your application will run on
EXPOSE 8585

# Specify the command to run on container start
CMD ["java", "-jar", "DevOps_AF-0.0.1-SNAPSHOT.jar"]