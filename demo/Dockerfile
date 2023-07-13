# First stage: complete build environment
FROM adoptopenjdk/openjdk11:x86_64-alpine-jdk-11.0.4_11

# add pom.xml and source code
ADD ./pom.xml pom.xml
ADD ./src src/

# package jar
RUN mvn clean package

# Second stage: minimal runtime environment
From openjdk:8-jre-alpine

# copy jar from the first stage
COPY --from=builder target/demo-1.0-SNAPSHOT.jar demo-1.0-SNAPSHOT.jar

EXPOSE 8080

CMD ["java", "-jar", "test-app-1.0-SNAPSHOT.jar"]