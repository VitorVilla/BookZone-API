# Usando a imagem do OpenJDK
FROM openjdk:17-jdk-slim

# Copia o arquivo .jar para dentro do container
COPY target/bookzone-0.0.1-SNAPSHOT.jar app.jar

# Comando para rodar o .jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
