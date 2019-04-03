#!/bin/env bash

id=$(date +%s)
echo $id
echo "create customer with data"
#echo "{ \"ID\":$id,  \"name\": \"Customer$id\"}"

curl -H "Content-Type: application/json" -X POST -d "{ \"ID\":$id,  \"name\": \"Customer$id\"}"  \
http://quarkus-microprofile-rest-nmquarkus.apps.ocp1.hailstorm5.coe.muc.redhat.com/customers
