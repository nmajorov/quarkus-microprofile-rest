#!/bin/sh

curl -X GET  http://quarkus-microprofile-rest-nmquarkus.apps.ocp1.hailstorm5.coe.muc.redhat.com/customers | python -m json.tool

