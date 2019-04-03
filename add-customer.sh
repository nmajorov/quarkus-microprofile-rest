#!/bin/env bash

id=$(date +%s)
echo $id

curl -H "Content-Type: application/json" -X POST -d '{ "id":"$id",  "name": "Customer$id"}' \
    http://quarkus-microprofile-rest-nmquarkus.apps.ocp1.hailstorm5.coe.muc.redhat.com/customers
