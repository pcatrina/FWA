
set DB_USER=fwa_user
set DB_PASS=fwa_password
set DB_NAME=fwa_db
set DB_PORT=5433



set DB_MOUNT_DIR=../docker/volumes/herbert_bot_db
set DB_CONTAINER_NAME=fwa_db
IF NOT EXIST %DB_MOUNT_DIR%   mkdir -p %DB_MOUNT_DIR%

docker container run -p%DB_PORT%:5432 -v%cd%/%DB_MOUNT_DIR%:/var/lib/postgresql/data  -e POSTGRES_DB=%DB_NAME% -e POSTGRES_USER=%DB_USER% -e POSTGRES_PASSWORD=%DB_PASS% --name %DB_CONTAINER_NAME% -d postgres
::  docker start %DB_CONTAINER_NAME%

