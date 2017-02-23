#!/bin/bash

####################################################################
# Setup file that contains commands to run an initial setup on a VPC
####################################################################

# Add a new administrator user with sudo privileges
adduser administrator
usermod -aG sudo administrator

# Change root user's password
sudo passwd

####################################################################

# Install NGINX
sudo apt-get update
sudo apt-get install nginx
sudo ufw allow 'Nginx HTTP'

####################################################################

# Install MySQL
sudo apt-get install mysql-server
sudo mysql_secure_installation
# Ignore VALIDATE PASSWORD PLUGIN, Yes for everything else

####################################################################

# Install php
sudo apt-get install php-fpm php-mysql
sudo vim /etc/php/7.0/fpm/php.ini
# Uncomment and change cgi.fix_pathinfo=1 to cgi.fix_pathinfo=0
sudo systemctl restart php7.0-fpm

# Change '80' server block to '443 ssl' server block in NGINX configuration
# Add '80' server block and make it default_server

####################################################################

# LETSENCRYPT setup
sudo apt-get install letsencrypt

# Edit NGINX conf to add ./well-known to the conf

sudo letsencrypt certonly -a webroot --webroot-path=/var/www/html -d example.com -d www.example.com

# Your certificate and chain have been saved at
#   /etc/letsencrypt/live/dhavalpowar.com/fullchain.pem. Your cert will
#   expire on 2017-05-23
#  To obtain a new version of the certificate in
#   the future, simply run Let's Encrypt again.

# Generate a Diffie-Hellman group
sudo openssl dhparam -out /etc/ssl/certs/dhparam.pem 2048

# Create ssl-params.conf and ssl-dhavalpowar.com.conf
# Include them in /etc/nginx/sites-available/default

# Restart NGINX
sudo systemctl nginx restart

# Add a chronjob to renew SSL certificate every week
sudo crontab -e
# 30 2 * * 1 /usr/bin/letsencrypt renew >> /var/log/le-renew.log
# 35 2 * * 1 /bin/systemctl reload nginx


#### FOLLOW REST OF THE INSTRUCTIONS FROM THE DIGITALOCEAN LINK (2) BELOW ####
###########################################

# Resources
# 1. MEMP stack setup https://www.digitalocean.com/community/tutorials/how-to-install-linux-nginx-mysql-php-lemp-stack-in-ubuntu-16-04
# 2. Wordpress setup  https://www.digitalocean.com/community/tutorials/how-to-install-wordpress-with-lemp-on-ubuntu-16-04