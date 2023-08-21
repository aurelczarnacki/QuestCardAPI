# QuestCard API - Backend

QuestCard API is part of a system designed for creating and sharing quizzes and games. The backend API provides authentication, user registration, and quiz management functionalities.

## Table of Contents

- [Introduction](#introduction)
- [Technologies](#technologies)
- [Getting Started](#getting-started)
- [Configuration](#configuration)

## Introduction

QuestCard API is the server component of the QuestCard system, which enables users to create, browse, and manage quizzes. The API provides authentication, authorization, and operations related to user accounts and quizzes.

## Technologies

The backend API is built using the following technologies and tools:

- Java 11
- Spring Boot 2.x
- Spring Security
- Hibernate ORM
- MySQL
- JWT (JSON Web Tokens)

## Getting Started

To run the QuestCard API, follow these steps:

1. Clone the repository to your computer.
2. Configure the MySQL database connection in the `application.properties` file.
3. Build and run the project using your preferred build tool (e.g., Maven) or development environment.

## Configuration

Database configuration and other parameters can be customized through the `application.properties` file located in the `src/main/resources` directory. In this file, you can adjust settings related to the database connection, server port, JWT keys, etc.
