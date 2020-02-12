FROM zally_server

COPY build/libs/zally-ruleset-example-1.0.0-SNAPSHOT.jar BOOT-INF/lib/
RUN jar uvf0 zally.jar BOOT-INF/lib/zally-ruleset-example-1.0.0-SNAPSHOT.jar

ENV MANAGEMENT_PORT=9090
ENV TOKEN_INFO_URI=https://auth.example.com/oauth2/tokeninfo

# Switch on the dev profile so that we don't need auth and a database
ENV SPRING_PROFILES_ACTIVE=dev
