#!/bin/bash

# deploy application to openshift
#
# get full path to project dir
SCRIPT_DIR=$(cd -P -- "$(dirname -- "$0")" && pwd -P)


echo $SCRIPT_DIR
oc new-app java \
   --code=$SCRIPT_DIR \
   --env=AB_JOLOKIA_OFF=true \
   --env=MAVEN_CLEAR_REPO=true \
   --name='quarkus-microprofile-rest'

#oc process  -f eap/eap64-basic-s2i.json -p APPLICATION_NAME=helloworld -p SOURCE_REPOSITORY_URL=https://github.com/jboss-developer/jboss-eap-quickstarts -p SOURCE_REPOSITORY_REF=6.4.x -p CONTEXT_DIR=helloworld | oc create -n yourproject -f -



oc start-build quarkus-microprofile-rest --from-repo=$SCRIPT_DIR

sleep 10

oc expose svc quarkus-microprofile-rest
