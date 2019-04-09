#!/usr/bin/env bash

if [ ! -f ./consul ]
then
    apt-get update
    apt-get install unzip

    echo "Downloading consul ..."
    wget https://releases.hashicorp.com/consul/1.4.4/consul_1.4.4_linux_amd64.zip
    unzip consul_1.4.4_linux_amd64.zip
    rm consul_1.4.4_linux_amd64.zip
    echo "Consul installed sucesfully"
fi
 echo "Starting consul ..."
./consul agent -config-dir=consul-config.json

sleep 2s

echo "Importing properties ... "
./consul kv import @init-data.json


