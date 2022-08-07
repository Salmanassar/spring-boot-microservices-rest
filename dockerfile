docker run --name mysql -p 3307:3307 -e MYSQL_ROOT_PASSWORD=root -d mysql:8.0.30
docker run --name some-mysql -e MYSQL_ROOT_PASSWORD=my-secret-pw -d mysql:5
MYSQL_USER=root -e