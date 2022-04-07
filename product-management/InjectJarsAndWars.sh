#!/bin/bash



cd services/
mvn clean install
cd ..
cd packaging/
mvn clean install
cd ..
cd webapps/
mvn clean install
cd ..
mvn clean install

echo -en "\007"

echo -en "\007"
echo -en "\007"
echo -en "\007"
echo -en "\007"

echo -en "\007"
echo -en "\007"
echo -en "\007"



printf "Can I tell you something Med Amine Arfaoui, I think you're a genius let's get compiled together one day and run some scripts ! I insist .\n"
