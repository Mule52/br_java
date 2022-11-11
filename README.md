<a name="readme-top"></a>

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

#### Instructions

The purpose of this exercise is to further get to know each other. Provide you with a chance to experience the type of work you will be doing as well as gauge your coding style. We do not expect this assessment to take any longer than 1-2 hours; if it takes much longer please stop and send what you have completed.

A recently signed customer wants to integrate some data from Github into their client application. We have discussed their needs and
essentially what they want is an endpoint they can call with a username that will return the data in JSON format as specified below (that also
serves as an example):

```
{
  user_name: "octocat",
  display_name: "The Octocat",
  avatar: "https://avatars3.githubusercontent.com/u/583231?v=4 ",
  geo_location: "San Francisco",
  email: null,
  url: "https://github.com/octocat ",
  created_at: "2011-01-25 18:44:36",
  repos: [
    {
      name: "boysenberry-repo-1",
      url: "https://github.com/octocat/boysenberry-repo-1 "
    },
    ...
  ]
}
```

```
DATA FROM
https://api.github.com/users/octocat
https://api.github.com/users/octocat/repos
```

The example response above is returned when calling the api sending the username “octocat”. Data to form the response comes from the
two APIs noted. Be sure to take note of the difference(s) in parameter names as well as formatting for the created_at value when
compared to what is returned from the API.

No token or signup is necessary to use these Github APIs (https://docs.github.com/en/rest/guides/getting-started-with-the-rest-api), however,
you can be rate limited. Perhaps implementing a caching mechanism might help? Or of course you could get an access token that can
maybe be set at runtime (we do not expect this).

In summary

- Stand up a server.
- Have an endpoint that takes a username.
- Fetch or retrieve the data matching to that username using the API noted above.
- Return the JSON object defined above with the data you pulled.
  - What if no user exists?
- Should also include some unit tests.

Make sure final code is in a public repo (github, bitbucket, gitlab). Provide a readMe explaining your decisions, architecture, and how to
install/run and utilize your service. We look forward to seeing your code!

#### FAQ

##### What language/tools do I use? Can I use a framework or library?

You can choose any language/tools and use any framework or library. We are interested in knowing what you feel will be the best choice in
implementing the above. Whatever choices you make explain those in the readMe and be prepared to discuss further. Some suggestions for
languages (and frameworks): Java (Spring Boot), Node (Express), Go (Gin).

##### What am I being evaluated on exactly?

We want to see production-ready code. Primary criteria is as follows:

- Organization Is the code well organized where it can be easily extended? Not one big function or lack of modularity.
- Readability Can the code be easily read and followed for a new developer or when you come back to it months later?
- Language/Libraries/Framework Are these good choices? Is the reasoning sound?
- Documentation Can we run and use the code based on the readMe? Is the code itself well documented in some way?
- Depth of Knowledge Are the right data structures being used? Are the strengths of the language chosen being utilized? Does the
  API follow industry standards?
- Stability/Security Can the code handle bad input? Is the code programmed defensively?

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

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.company.homework.HomeworkApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

Alternatively, you can use java -jar to run the project from a terminal.

```shell
java -jar target/company-homework-0.0.1-SNAPSHOT.jar
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
