FROM azul/zulu-openjdk-alpine:11 as zulu-openjdk
#VOLUME /tmp
ARG JAR_FILE
COPY target/tic_tac_toe-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]