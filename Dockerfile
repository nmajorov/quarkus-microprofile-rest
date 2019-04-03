####
# Before building the docker image run:
#
# mvn package -Pnative -Dnative-image.docker-build=true
#
# Then, build the image with:
#
# docker build -f src/main/docker/Dockerfile -t quarkus/microprofile-health .
#
# Then run the container using:
#
# docker run -i --rm -p 8080:8080 quarkus/microprofile-health
#
###
#FROM registry.fedoraproject.org/fedora-minimal
#FROM redhat-openjdk-18/openjdk18-openshift
FROM registry.access.redhat.com/redhat-openjdk-18/openjdk18-openshift

ENV QUARKUS_DATASOURCE_URL jdbc:mysql://mysql.nmquarkus.svc.cluster.local/berlin
ENV QUARKUS_DATASOURCE_USERNAME niko
ENV QUARKUS_DATASOURCE_PASSWORD niko

USER jboss

WORKDIR /target/
COPY target/*-runner /target/application


EXPOSE 8080

CMD ["./application", "-Dquarkus.http.host=0.0.0.0 -Dquarkus.datasource.url=jdbc:mysql://mysql.nmquarkus.svc.cluster.local/berlin -Dquarkus.datasource.username=niko -Dquarkus.datasource.password=niko" ]
