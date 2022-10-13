<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>

<!-- ABOUT THE PROJECT -->

## Homework Assignment - Github Users

This project is a Spring Boot sample app. It will expose a REST endpoint that when called, will make two external calls to the Github API to return user and user repository information, in the form of JSON.

I am not providing further details because it is a homework assignment and it should remain confidential.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

## Built With

This section should list any major frameworks/libraries used to bootstrap your project. Leave any add-ons/plugins for the acknowledgements section. Here are a few examples.

- <a href="https://spring.io">Spring Boot</a>

<p align="right">(<a href="#readme-top">back to top</a>)</p>

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

<p align="right">(<a href="#readme-top">back to top</a>)</p>

## Getting Started

This application is packaged as a jar and includes a Tomcat server by default. You run it using the `java -jar` command.

- Clone this repository
- Make sure you are using JDK 1.8 and Maven 3.x

<p align="right">(<a href="#readme-top">back to top</a>)</p>

## How to Build

This application can be built in your IDE or via Maven. If Maven is not installed, instructions can be found here, [Installing Apache Maven](https://maven.apache.org/install.html).

To build the project via Maven, run the following commands from a terminal. This will clean, compile, package, and run all tests.

```shell
mvn clean package
```

<p align="right">(<a href="#readme-top">back to top</a>)</p>

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.branch.branchhomework.BranchHomeworkApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

Alternatively, you can use java -jar to run the project from a terminal.

```shell
java -jar target/branch-homework-0.0.1-SNAPSHOT.jar
```

<p align="right">(<a href="#readme-top">back to top</a>)</p>

## Usage

The application provides a REST endpoint to call. The easiest way to use this application is to start the application, then open a browser and provide the following URL.

```
http://localhost:8080/api/v1/users/octocat
```

Octocat is a username to query from Github. Change this value to query other usernames.

```
http://localhost:8080/api/v1/users/<change this username>
```

<p align="right">(<a href="#readme-top">back to top</a>)</p>

## Roadmap

This project has a time limit of 1-2 hours. These are my considerations what is next.

- More tests, for all classes.
- Swagger documentation.
- Dockerfile to containerize the app.
- Terraform to deploy the container to a Cloud Run service or similar.
- Improve the README.md.
- Add changelog.

<p align="right">(<a href="#readme-top">back to top</a>)</p>
