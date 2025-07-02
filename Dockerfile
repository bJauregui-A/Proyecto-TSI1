# Imagen base con Java 24
FROM eclipse-temurin:24-jdk

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo JAR generado
COPY target/test-0.0.1-SNAPSHOT.jar app.jar

# Expón el puerto (por defecto Spring Boot usa 8080)
EXPOSE 8080

# Ejecuta la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
