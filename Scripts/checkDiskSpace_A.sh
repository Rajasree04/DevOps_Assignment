#!/bin/bash
for i in {004..013} {110..119};do
echo -e "-------------------------------" >> output.txt
echo -e "Checking on...prdqvxp${i} server" >> output.txt
ssh qvxpadm@prdqvxp${i} "df -h /apps | df -h | awk '{print $4 " " $5}'" >> output.txt
echo -e "-------------------------------" >> output.txt
done

