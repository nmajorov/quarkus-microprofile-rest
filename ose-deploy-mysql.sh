#!/bin/sh
echo "deploy database"
oc new-app mysql -e MYSQL_USER=niko -e MYSQL_PASSWORD=niko -e MYSQL_DATABASE=berlin
