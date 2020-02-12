FROM zally_server

COPY build/libs/zally-ruleset-example-1.0.0-SNAPSHOT.jar /extras/

ENV MANAGEMENT_PORT=9090
ENV TOKEN_INFO_URI=https://auth.example.com/oauth2/tokeninfo

CMD java $(java-dynamic-memory-opts) $(appdynamics-agent) -Dloader.path=/extras/ -Dspring.profiles.active=dev -jar /zally.jar
