#!/bin/bash
echo 
date
for i in {004..013}; do
sshpass -p '4o-Tx_B72f+RzL5*E6$qe!F3{K9tb8}J2%Sm/' ssh -qT -o StrictHostKeyChecking=no qvxpadm@prdqvxp${i} "df -h /apps | df -h | awk '{print $4 " " $5}'
echo "Checking on...prdqvxp${i} server"
done;

