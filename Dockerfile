FROM eclipse-temurin:17-jre-alpine
COPY /target/Lotto-web.jar /Lotto-web.jar
ENTRYPOINT ["java","-jar","/Lotto-web.jar"]