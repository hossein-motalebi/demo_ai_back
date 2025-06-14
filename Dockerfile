# Use an official OpenJDK runtime as a parent image
FROM maven As build

# Set the working directory in the container
WORKDIR /app

COPY . .

RUN mvn clean install



FROM eclipse-temurin:21-jre-alpine AS deploy

ARG JAR_FILE="/app/target/BackDemo-0.0.1-SNAPSHOT.jar"
ARG AZURE_DB_URL
ARG AZURE_DB_USERNAME
ARG AZURE_DB_PASSWORD

# Définir les variables d'environnement pour l'exécution

ENV SPRING_PROFILES_ACTIVE=azure


COPY --from=build ${JAR_FILE} /opt/app/app.jar

RUN chmod u+x /opt/app/app.jar

WORKDIR /opt/app

RUN echo SPRING_DATASOURCE_URL=${AZURE_DB_URL} > .env && \
    echo SPRING_DATASOURCE_USERNAME=${AZURE_DB_USERNAME} >> .env && \
    echo SPRING_DATASOURCE_PASSWORD=${AZURE_DB_PASSWORD} >> .env


EXPOSE 8080

CMD ["java", "-jar", "/opt/app/app.jar"]