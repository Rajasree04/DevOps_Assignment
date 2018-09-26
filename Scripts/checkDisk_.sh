#!/bin/bash
date >> output.txt
for i in {2..4}; do
echo "Checking on the prdtmap00${i}..." >> output.txt
ssh tmapadm@prdtmap00${i} "bash -s" < sshCheck.sh >> output.txt
done
