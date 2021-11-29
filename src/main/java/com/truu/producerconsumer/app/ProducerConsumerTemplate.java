package com.truu.producerconsumer.app;

import static com.truu.producerconsumer.app.ProgramProperties.MAX_QUEUE_SIZE;
import static com.truu.producerconsumer.app.ProgramProperties.USE_SYNCHRONIZED_QUEUE;

import com.truu.producerconsumer.core.Consumer;
import com.truu.producerconsumer.core.Producer;
import com.truu.producerconsumer.iml.SharedQueue;

/**
 * Main program that demonstrates usages of producer and consumer pattern.
 */
public class ProducerConsumerTemplate {

  public static void main(String[] args) {
    SharedQueue queue = SharedQueue.getInstance(USE_SYNCHRONIZED_QUEUE, MAX_QUEUE_SIZE);
    buildProducersThreads(1, queue);
    buildConsumerThreads(1, queue);
  }

  private static void buildProducersThreads(int producersCount, SharedQueue queue) {
    for (int i = 0; i < producersCount; i++) {
      startProducerThread(i, queue);
    }
  }

  private static void buildConsumerThreads(int consumersCount, SharedQueue queue) {
    for (int i = 0; i < consumersCount; i++) {
      startConsumerThread(i, queue);
    }
  }

  private static void startProducerThread(int suffix, SharedQueue queue) {
    Thread producerThread = new Thread(new Producer(queue));
    producerThread.setName("Producer-thread-" + suffix);
    producerThread.start();
  }

  private static void startConsumerThread(int suffix, SharedQueue queue) {
    Thread consumerThread = new Thread(new Consumer(queue));
    consumerThread.setName("Consumer-thread-" + suffix);
    consumerThread.start();
  }
}

