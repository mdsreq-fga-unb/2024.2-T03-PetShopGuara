# Etapa de build - Usar imagem oficial do Maven com OpenJDK 21
FROM maven:latest AS build

# Definir o diretório de trabalho dentro do container
WORKDIR /app

# Copiar o arquivo pom.xml e baixar dependências
COPY pom.xml . 
RUN mvn dependency:go-offline

# Copiar o código-fonte e construir o projeto
COPY src /app/src
RUN mvn clean package -DskipTests

# Etapa de runtime - Usar uma imagem base mais recente com OpenJDK 17 ou 21
FROM openjdk:21-jdk-slim

# Definir o diretório de trabalho para a aplicação
WORKDIR /app

# Copiar o arquivo JAR gerado para a imagem
COPY --from=build /app/target/backend-0.0.1-SNAPSHOT.jar /app/backend.jar

# Expor a porta 8080 (porta padrão do Spring Boot)
EXPOSE 8080

# Comando para iniciar a aplicação
ENTRYPOINT ["java", "-jar", "/app/backend.jar"]
