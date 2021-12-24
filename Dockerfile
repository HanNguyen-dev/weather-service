FROM openjdk:11
WORKDIR  /springboot
EXPOSE 8080
COPY . .
RUN ./gradlew build
ENTRYPOINT ["/bin/sh", "-c", "java -jar build/libs/*.jar"]