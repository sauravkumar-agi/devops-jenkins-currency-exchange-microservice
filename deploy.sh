#!/bin/sh


echo $1
sed 's/$version/'$1'/g' deploymentservice.yml > deploymentservice.yml
