#!/bin/bash

# build base image for producer-app's
docker build -t producer producer

docker-compose build && docker-compose up -d
