# Java Full Stack Engineer Interview Questions

## Question 1A: DIY Producer Consumer Pattern

Using the given stub class (`ProducerConsumerTemplate.java`), implement a simple blocking
producer/consumer pattern with the following behaviors and characteristics:

- A producer thread that enqueues random integers to its shared queue
- A consumer thread that consumes and prints integers from the queue to standard out
- A fully thread-safe, blocking queue mechanism shared between the producer and consumer threads
- Absolutely no use of the `java.util.concurrent` package
- You may modify the original source as desired to improve the overall design. Be prepared to
  explain your improvements.

## Question 1B: (More) Modern Producer Consumer Pattern

- Implement a solution to Question 1A again. You are permitted to use `java.util.concurrent`.

## Prerequisites:

- JDK 11
- maven 3

## Code style

I used google code style format - `intellij-java-google-style.xml`. Settings -> Code style -> Scheme
-> Import scheme.

https://github.com/google/styleguide/blob/gh-pages/intellij-java-google-style.xml

## How to run

1) You need java 11. You need maven 3
2) Build with maven

```shell
mvn clean package
```

3) Run the app in the console

```shell
java -jar ./target/producer-consumer-pattern-challenge-jar-with-dependencies.jar
```
