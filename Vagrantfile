# -*- mode: ruby -*-
# vi: set ft=ruby :

# All Vagrant configuration is done below. The "2" in Vagrant.configure
# configures the configuration version (we support older styles for
# backwards compatibility). Please don't change it unless you know what
# you're doing.

$installDocker = <<-SCRIPT
sudo apt-get install unzip
sudo curl -fsSL https://get.docker.com -o get-docker.sh
sh get-docker.sh
sudo usermod -aG docker vagrant
sudo curl -L "https://github.com/docker/compose/releases/download/1.24.0/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
sudo chmod +x /usr/local/bin/docker-compose

SCRIPT


Vagrant.configure("2") do |config|
  # The most common configuration options are documented and commented below.
  # For a complete reference, please see the online documentation at
  # https://docs.vagrantup.com.


  # Every Vagrant development environment requires a box. You can search for
  # boxes at https://vagrantcloud.com/search.
  config.vm.box = "ubuntu/xenial64"
  config.vm.box_check_update = false
  config.vm.provision "shell", inline: $installDocker


  config.vm.define "server-1" do |server1|
    server1.vm.hostname = "server-1"
    server1.vm.network "private_network", ip: "10.0.1.1"
    server1.vm.network "forwarded_port", guest_ip: "127", guest: 8500, host_ip: "10.0.1.1", host: 8500, protocol: "tcp"
    server1.vm.network "forwarded_port", guest_ip: "10.0.1.1", guest: 8300, host_ip: "10.0.1.1", host: 8300, protocol: "tcp"
    server1.vm.network "forwarded_port", guest_ip: "10.0.1.1", guest: 8301, host_ip: "10.0.1.1", host: 8301, protocol: "tcp"
    server1.vm.network "forwarded_port", guest_ip: "10.0.1.1", guest: 8301, host_ip: "10.0.1.1", host: 8301, protocol: "udp"
    server1.vm.network "forwarded_port", guest_ip: "10.0.1.1", guest: 8302, host_ip: "10.0.1.1", host: 8302, protocol: "tcp"
    server1.vm.network "forwarded_port", guest_ip: "10.0.1.1", guest: 8302, host_ip: "10.0.1.1", host: 8302, protocol: "udp"
    server1.vm.provision "file", source: "consul/start1.sh", destination: "$HOME/start.sh", run: "always"
    server1.vm.provision "shell", inline: "./start.sh", run: "always"
    # server1.vm.provision "shell", inline: "docker-compose -f /vagrant/docker-compose.yml up consul1", run: "always"
   end

  config.vm.define "server-2" do |server2|
    server2.vm.hostname = "server-2"
    server2.vm.network "private_network", ip: "10.0.1.2"
    server2.vm.network "forwarded_port", guest_ip: "127.0.0.1", guest: 8500, host_ip: "10.0.1.2", host: 8500, protocol: "tcp"
    server2.vm.network "forwarded_port", guest_ip: "10.0.1.2", guest: 8300, host_ip: "10.0.1.2", host: 8300, protocol: "tcp"
    server2.vm.network "forwarded_port", guest_ip: "10.0.1.2", guest: 8301, host_ip: "10.0.1.2", host: 8301, protocol: "tcp"
    server2.vm.network "forwarded_port", guest_ip: "10.0.1.2", guest: 8302, host_ip: "10.0.1.2", host: 8301, protocol: "udp"
    server2.vm.network "forwarded_port", guest_ip: "10.0.1.2", guest: 8302, host_ip: "10.0.1.2", host: 8302, protocol: "tcp"
    server2.vm.network "forwarded_port", guest_ip: "10.0.1.2", guest: 8302, host_ip: "10.0.1.2", host: 8302, protocol: "udp"
    # server2.vm.network "forwarded_port", guest_ip: "localhost", guest: 8500, host_ip: "10.0.0.2", host: 8500, protocol: "tcp"
    server2.vm.provision "file", source: "consul/start2.sh", destination: "$HOME/start.sh", run: "always"
    # server2.vm.provision "shell", inline: "SERVER_NAME=$(hostname) docker-compose -f /vagrant/docker-compose.yml up consul", run: "always"
  end

  # Disable automatic box update checking. If you disable this, thenls
  # boxes will only be checked for updates when the user runs
  # `vagrant box outdated`. This is not recommended.
  # config.vm.box_check_update = false

  # Create a forwarded port mapping which allows access to a specific port
  # within the machine from a port on the host machine. In the example below,
  # accessing "localhost:8080" will access port 80 on the guest machine.
  # NOTE: This will enable public access to the opened port
  # config.vm.network "forwarded_port", guest: 80, host: 8080

  # Create a forwarded port mapping which allows access to a specific port
  # within the machine from a port on the host machine and only allow access
  # via 127.0.0.1 to disable public access
  # config.vm.network "forwarded_port", guest: 80, host: 8080, host_ip: "127.0.0.1"

  # Create a private network, which allows host-only access to the machine
  # using a specific IP.
  # config.vm.network "private_network", ip: "192.168.33.10"

  # Create a public network, which generally matched to bridged network.
  # Bridged networks make the machine appear as another physical device on
  # your network.
  # config.vm.network "public_network"

  # Share an additional folder to the guest VM. The first argument is
  # the path on the host to the actual folder. The second argument is
  # the path on the guest to mount the folder. And the optional third
  # argument is a set of non-required options.
  # config.vm.synced_folder "../data", "/vagrant_data"

  # Provider-specific configuration so you can fine-tune various
  # backing providers for Vagrant. These expose provider-specific options.
  # Example for VirtualBox:
  #
  # config.vm.provider "virtualbox" do |vb|
  #   # Display the VirtualBox GUI when booting the machine
  #   vb.gui = true
  #
  #   # Customize the amount of memory on the VM:
  #   vb.memory = "1024"
  # end
  #
  # View the documentation for the provider you are using for more
  # information on available options.

  # Enable provisioning with a shell script. Additional provisioners such as
  # Puppet, Chef, Ansible, Salt, and Docker are also available. Please see the
  # documentation for more information about their specific syntax and use.
  # config.vm.provision "shell", inline: <<-SHELL
  #   apt-get update
  #   apt-get install -y apache2
  # SHELL
end
