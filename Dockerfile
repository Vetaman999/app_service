FROM openjdk:18.0.1.1-oraclelinux7
EXPOSE 8080
ADD target/app_service-0.0.1-SNAPSHOT.jar app_service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","app_service-0.0.1-SNAPSHOT.jar"]