# Receipt Processor Challenge
#### by [carolusquintus](https://github.com/carolusquintus)

This is `receipt-proccess` challenge developed by Carlos Rosas for Fetch Backend Engginer position.

Challenge was developed using:
- Java 17
- Gradle
- Micronaut
- Redis
- Docker

And designed with Hexagonal Architecture and Domain Driven Design.

## Setup local environment

The only assume is that the reviewer has UNIX like OS workstation and Docker.

Open your Terminal and follow next steps.

1. Download SDKMan.
```
curl -s "https://get.sdkman.io" | bash
```
![SDKMan install](screenshots/14-ago-2023_21-49-13.png)

2. Install java jdk 17.
```
sdk install java 17.0.8-zulu
```
![jdk install](screenshots/14-ago-2023_21-51-27.png)

3. Install Gradle.
```
sdk install gradle 7.6.1
```
![jdk install](screenshots/14-ago-2023_21-52-44.png)

Previous steps are not strictly necessary, because this project uses gradle wrapper.

But there's no reason to take risks :smiley:

4. Clone or paste project in your preferred location.
```
git clone https://github.com/carolusquintus/receipt-processor.git
```
![clone repo](screenshots/14-ago-2023_22-24-46.png)

5. Move to project.
```
cd receipt-processor
```
![move to project](screenshots/14-ago-2023_22-25-13.png)


## Build

Now that your located in the project, there are some small tweaks in order to build it properly.

1. Print your current working directory and copy it.
```
pwd
```
![print](screenshots/14-ago-2023_22-41-11.png)

2. Open `.env` file located at root project, with your favorite text editor.
![.env file](screenshots/14-ago-2023_22-49-53.png)

3. Replace `PROJECT_DIR` var env with path copied from Build -> Step 1.
![PROJECT_DIR](screenshots/14-ago-2023_22-56-18.png)

4. Replace `DOCKER_USER`var env with your personal or business Docker Hub user.
![DOCKER_USER](screenshots/14-ago-2023_23-00-21.png)

5. Build `receipt-processor` project.
```
gradle build
```
Or
```
./gradlew build
```
![gradle](screenshots/14-ago-2023_23-06-25.png)
![gradlew](screenshots/14-ago-2023_23-07-11.png)

6. Build and run `docker-compose.yml`
```
docker-compose up -d
```
![docker-compose](screenshots/14-ago-2023_23-13-37.png)

7. Validate that services are up & running.
```
docker-compose top
```
![docker-compose](screenshots/14-ago-2023_23-15-13.png)

## Test
