#!/bin/sh
#aaaa

echo $1
sed -i 's/$version/'$1'/g' deploymentservice.yml
