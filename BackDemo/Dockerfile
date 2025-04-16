# Use an official OpenJDK runtime as a parent image
FROM maven As build

# Set the working directory in the container
WORKDIR /app

COPY . .

RUN mvn clean install



FROM eclipse-temurin:21-jre-alpine AS deploy

ARG JAR_FILE="/app/target/BackDemo-0.0.1-SNAPSHOT.jar"


ENV spring_profiles_active="prod"

COPY --from=build ${JAR_FILE} /opt/app/app.jar

RUN chmod u+x /opt/app/app.jar

WORKDIR /opt/app


EXPOSE 8080

CMD ["java", "-jar", "/opt/app/app.jar"]