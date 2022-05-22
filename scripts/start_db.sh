#!/bin/bash

DB_USER='fwa_user'
DB_PASS='fwa_password'
DB_NAME='fwa_db'
DB_PORT=5433



DB_MOUNT_DIR='../docker/volumes/herbert_bot_db'
DB_CONTAINER_NAME='fwa_db'
[ ! -d $DB_MOUNT_DIR ] && mkdir -p $DB_MOUNT_DIR

if [ ! "$(docker ps -a | grep $DB_CONTAINER_NAME)" ]; then
  docker container run -p$DB_PORT:5432 -v$(pwd)/$DB_MOUNT_DIR:/var/lib/postgresql/data  -e POSTGRES_DB=$DB_NAME -e POSTGRES_USER=$DB_USER -e POSTGRES_PASSWORD=$DB_PASS --name $DB_CONTAINER_NAME -d postgres
else
  docker start $DB_CONTAINER_NAME
fi

