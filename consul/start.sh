#!/usr/bin/env bash

if [ ! -f ./consul ]
then
    wget https://releases.hashicorp.com/consul/1.4.4/consul_1.4.4_linux_amd64.zip
    unzip consul_1.4.4_linux_amd64.zip
    rm unzip consul_1.4.4_linux_amd64.zip
fi
./consul agent -config-dir=consul-config.json