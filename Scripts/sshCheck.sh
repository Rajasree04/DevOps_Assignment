#!/bin/bash
output=`df -h /apps | grep G | awk '{print $3}'`
avilable_space="${output%?}"
echo $avilable_space