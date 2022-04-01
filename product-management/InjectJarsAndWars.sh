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
