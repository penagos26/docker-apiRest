# Usar la imagen de Eclipse Temurin con Java 23
FROM eclipse-temurin:23-jdk-alpine

# Colocar un label para la imagen de docker
LABEL author=grupo3

# Crear las variables de entorno
ENV DATABASE_URL jdbc:mysql://mysqlDB:3306/lafabrica
ENV DATABASE_USERNAME root
ENV DATABASE_PASSWORD lafabrica
ENV DATABASE_PLATFORM org.hibernate.dialect.MySQL8Dialect
ENV DATABASE_DRIVER com.mysql.cj.jdbc.Driver

# Especificar el archivo JAR que se debe añadir a la imagen
ARG JAR_FILE=build/libs/LaFabrica-0.0.1-SNAPSHOT.jar

# Añadir el archivo JAR a la imagen y nombrarlo 'app.jar'
COPY ${JAR_FILE} app.jar


# Exponer el puerto 8080
EXPOSE 8080

# Definir el comando de entrada para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app.jar"]




