Запустить БД:
docker run -d -p 5430:5432 -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=password -e POSTGRES_DB=runnersdb --name runners_db postgres:latest