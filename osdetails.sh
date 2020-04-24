#!/bin/bash

HOSTS=$1

echo "HOSTS: ${HOSTS}"

for i in ${!HOSTS[*]} ; do 

echo ${HOSTS[i]}

IPAddress=${HOSTS[i]}

ssh -t $2@${HOSTS[i]} '(

    

echo ""

echo "======== Host:`hostname`, checked on `date` ========"

echo ""

echo "Host Details:-"

echo "=============="

echo "Host Name :- `uname -a | cut -d " " -f 2`"

echo "FQDN :- `hostname --all-fqdns`"

echo "Version details :- `uname -a | cut -d " " -f 3`"

echo "Release :- `cat /etc/redhat-release`"

IPAddress=$(hostname -I)

echo "IP Address:- `hostname --all-ip-addresses || hostname -I`"

echo ""

echo "Service Status of DS Agent :-"

echo "============================="

echo "DS Agent service :- `systemctl status ds_agent | head -3`"

echo ""

echo "File System details :-"

echo "======================"

df -h

echo ""

    

  )'



echo "Ping Status :-"

echo "=============="

echo "Ping from $IPAddress to ${HOSTS[i]}= :- " 

ping -c 5 ${HOSTS[i]} | head -9 | tail -1

echo ""



echo "Telnet Status :-"

echo "================"

echo "Telnet connected to ${HOSTS[i]} Port 22 :- `(echo >/dev/tcp/${HOSTS[i]}/22) &>/dev/null && echo "Port Open" || echo "Port Closed"`"

echo "Telnet connected to ${HOSTS[i]} Port 4122 :- `(echo >/dev/tcp/${HOSTS[i]}/4122) &>/dev/null && echo "Port Open" || echo "Port Closed"`"

echo "======================================================================"



done
