#!/bin/bash

USER=consul
DAEMON=consul
EXEC=$(which $DAEMON)

START_COMMAND="${EXEC} agent -config-dir /opt/bitnami/consul/conf | tee /opt/bitnami/consul/logs/consul.log"
exec bash -c "${START_COMMAND}"

sleep 5
echo "importing properties!!!!!!!!!!!!!!!!!!!!!!!!!!!"
INIT_DATA="${EXEC} kv import /init-data.json"
exec bash -c "${INIT_DATA}"
