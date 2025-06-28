# Spring Boot Kafka Producer-Consumer Example

This project is a simple **Spring Boot** application demonstrating how to use **Apache Kafka** to send and receive messages.

It acts as:

✅ A **Kafka Producer**: Exposes a REST endpoint that sends messages to a Kafka topic.  
✅ A **Kafka Consumer**: Listens to the same topic and logs any received message.

---

## 🏗️ Features

- REST API to publish messages
- Kafka producer configuration
- Kafka consumer configuration
- Configurable topic name and broker
- Easy to run on local Kafka

## ⚙️ Architecture

[Client] ---> [Spring Boot REST Controller] ---> [Kafka Topic] ---> [Spring Boot Consumer Service]


## 🗂️ Project Structure

src/main/java/com/example/kafkaapp
├── KafkaProducerService.java
├── KafkaConsumerService.java
├── MessageController.java
└── KafkaAppApplication.java

## 🧩 Code Explanation

### 1️⃣ KafkaProducerService

- Uses **KafkaTemplate** to send messages.
- Reads topic name from `application.properties`.

  kafkaTemplate.send(topicName, message);
2️⃣ KafkaConsumerService
  Uses @KafkaListener to listen on the topic.

  Logs any message received.

@KafkaListener(topics = "${app.kafka.topic}")
3️⃣ MessageController
  REST endpoint /api/messages

  Accepts POST requests with raw text body.

  Calls ProducerService to send to Kafka.

Example request:

POST /api/messages
Body: Hello from client!


4️⃣ application.properties
Configure Kafka broker, topic, group id, serializers:

spring.kafka.bootstrap-servers=localhost:9092
spring.kafka.consumer.group-id=my-group
app.kafka.topic=my-topic
🚀 How to Run
1️⃣ Start Kafka and ZooKeeper
✅ For example (Windows):

.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
.\bin\windows\kafka-server-start.bat .\config\server.properties
✅ Create topic:
.\bin\windows\kafka-topics.bat --create --topic my-topic --bootstrap-server localhost:9092
2️⃣ Run Spring Boot App
mvn spring-boot:run
✅ The app will start on: http://localhost:8282
