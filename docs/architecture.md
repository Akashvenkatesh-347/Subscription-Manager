# Project Architecture

This project is currently a simple file-based subscription manager. The goal is to keep the design straightforward while establishing a structure that can grow into a more scalable application.

## Current Architecture

Subscription Manager
│
├── model
│     └── Subscription.java
│
├── service
│     └── SubscriptionManager.java
│
├── storage
│     └── File Storage (Current)
│
└── Main.java


### Overview

- model — Contains the application's data models.
- service — Implements the business logic for managing subscriptions.
- storage — Persists data using file-based storage.
- Main.java — Entry point of the application.


## Future Architecture

As the project grows, it will evolve into a layered architecture:


Client
    ↓
REST API
    ↓
Controller
    ↓
Service
    ↓
Repository
    ↓
PostgreSQL


### Vision

The future architecture separates responsibilities into dedicated layers:

- Client — Sends requests to the application.
- REST API — Exposes HTTP endpoints.
- Controller — Handles incoming requests and responses.
- Service — Contains business logic.
- Repository — Manages data access.
- PostgreSQL — Stores application data in a relational database.

This layered design improves maintainability, testability, and scalability as the application grows.