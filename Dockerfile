# Start with a base image containing Java runtime
FROM openjdk:11-jre-slim

ENV APP_HOME=/usr/app/

WORKDIR $APP_HOME

COPY build/libs/*.jar application.jar

# Make port 8080 available to the world outside this container
EXPOSE 8080

CMD ["java", "-jar", "application.jar"]


# docker image build -t image_name .
# docker image build -t livestudyapp .