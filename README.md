# Distributed Digital Wallet Engine

A backend-focused digital wallet transaction engine built using Spring Boot that simulates secure money transfers between users with transaction consistency, pessimistic locking, and asynchronous event-driven processing using RabbitMQ.

---

## Features

* Secure wallet-to-wallet money transfer
* Transaction history tracking
* Sender and receiver relationship mapping
* Balance validation before transfer
* Pessimistic locking to prevent double-spending
* Asynchronous audit logging using RabbitMQ
* Dockerized infrastructure setup
* RESTful APIs using Spring Boot

---

## Tech Stack

* Java 21
* Spring Boot
* Spring Data JPA
* MySQL
* RabbitMQ
* Docker & Docker Compose
* Maven

---

## Architecture

Client
->
Spring Boot REST API
->
Transaction Service
->
MySQL Database

Successful Transaction
->
RabbitMQ Queue
->
Audit Consumer

---

## Transaction Flow

1. Sender initiates transfer
2. Sender row locked using pessimistic locking
3. Balance validated
4. Sender balance deducted
5. Receiver balance credited
6. Transaction stored in database
7. RabbitMQ audit event published

---

## Pessimistic Locking

Implemented database-level pessimistic locking using:

```sql
SELECT ... FOR UPDATE
```

This prevents:

* Race conditions
* Concurrent balance corruption
* Double-spending vulnerabilities

---

## RabbitMQ Integration

RabbitMQ is used for asynchronous processing.

After successful transaction:

* Audit events are pushed into queue
* Consumer processes logs independently
* Core API latency remains fast

---

## API Endpoints

### Create User

POST `/user`

### Get User

GET `/user/{id}`

### Transfer Money

PUT `/trans/sender_id/reciver_id`

---

## Example Transaction Request

```json
{
  "amount": 200,
  "sender_id": {
    "id": 1
  },
  "reciver_id": {
    "id": 2
  }
}
```

---

## Docker Setup

### Start Services

```bash
docker compose up
```

Services:

* MySQL
* RabbitMQ

---

## RabbitMQ Dashboard

```text
http://localhost:15672
```

Username:

```text
myuser
```

Password:

```text
secret
```

---

## Run Spring Boot

```bash
mvn spring-boot:run
```

---

## Future Improvements

* Redis caching
* JWT authentication
* Notification service
* Transaction status tracking
* Distributed microservice architecture

---

## Learning Outcomes

This project demonstrates:

* Backend transaction processing
* ACID transaction handling
* Concurrency control
* Event-driven architecture
* Dockerized backend systems
* REST API engineering
