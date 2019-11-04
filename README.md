# WORKSHOP: KUBERNETES FOR JAVA DEVELOPERS 

## How to start locally

- Clone demo application

```bash
git clone git@github.com:banadiga/workshop-kubernetes-for-java-developers-demo.git
```

- Build maven application

```bash
mvn clean install
```

- Start database (Postgresql in docker)

```bash
docker run -d --name db -e POSTGRES_DB=db -e POSTGRES_USER=user -e POSTGRES_PASSWORD=password  -p 54320:5432 postgres
```

- Migrate database (use flyway)

```
cd bookservice
flyway -url="jdbc:postgresql://localhost:54320/db"  migrate
```

*Note:* use following command to install/update on macos

```bash
brew install flyway
```
or
```bash
brew upgrade flyway
```
or user documentation [https://flywaydb.org/documentation/commandline/](https://flywaydb.org/documentation/commandline/)

- Start application locally

```bash
SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:54320/db java -jar target/book-service-0.0.1-SNAPSHOT.jar
```


# TODO

## Preparation to K8s

- Create dockerfile
- Create multi-stage docker file for each services
- Run service locally thru docker

## Run application on k8s

- Create k8s configuration to start application on k8s
- Add readiness and liveness probes
- Add Limits (CPU & memory)
- Automatically scaling custom metrics
- Start application on k8s
- Create job to do migration
- Performance testing
