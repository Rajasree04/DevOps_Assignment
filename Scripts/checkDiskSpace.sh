#!/bin/bash
echo 
date
for i in {004..013}; do
echo "Checking on local machine"
df -h /cygdrive/d | awk '{print $4}' 
done;