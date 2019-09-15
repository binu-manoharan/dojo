#!/bin/bash

../../../gradlew build
cp ../../../build/libs/*.jar .
docker build -t my-greeter-app .
docker run -p 8081:8080 my-greeter-app