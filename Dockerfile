FROM openjdk:11.0.9.1-jdk as build
WORKDIR /usr/app

COPY mvnw mvnw
COPY .mvn .mvn
COPY pom.xml .

RUN ./mvnw dependency:go-offline -B

COPY src src

RUN ./mvnw package -Dmaven.test.skip=true

RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

FROM openjdk:11.0.9.1-jre

ARG DEPENDENCY=/usr/app/target/dependency

COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app

EXPOSE 8080
ENTRYPOINT ["java", "-cp", "app:app/lib/*", "br.com.lkt.authenticator.AuthenticatorApplication"]
