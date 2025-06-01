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
ENV AZURE_DB_URL=${AZURE_DB_URL}
ENV AZURE_DB_USERNAME=${AZURE_DB_USERNAME}
ENV AZURE_DB_PASSWORD=${AZURE_DB_PASSWORD}
ENV spring_profiles_active="azure"


COPY --from=build ${JAR_FILE} /opt/app/app.jar

RUN chmod u+x /opt/app/app.jar

WORKDIR /opt/app


EXPOSE 8080

CMD ["java", "-jar", "/opt/app/app.jar"]
