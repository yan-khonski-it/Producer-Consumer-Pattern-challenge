package com.truu.interviews.fullstack.producerconsumer.app;

import com.truu.interviews.fullstack.producerconsumer.iml.SharedQueue;
import com.truu.interviews.fullstack.producerconsumer.iml.SynchronizedQueue;

public class ProducerConsumerTemplate {

  private static final int MAX_SIZE = 5;

  public static void main(String[] args) {
    SharedQueue queue = new SynchronizedQueue(MAX_SIZE);

    Thread prodThread = new Thread(new Producer(queue));
    prodThread.start();
    Thread consThread = new Thread(new Consumer(queue));
    consThread.start();
  }

  public static class Producer implements Runnable {

    private final SharedQueue queue;

    public Producer(SharedQueue queue) {
      this.queue = queue;
    }

    @Override
    public void run() {
      // TODO
      for (int i = 0; i < 10; i++) {
        queue.add(i);
      }
    }
  }

  public static class Consumer implements Runnable {

    private final SharedQueue queue;

    public Consumer(SharedQueue queue) {
      this.queue = queue;
    }

    @Override
    public void run() {
      // TODO
      for (int i = 0; i < 10; i++) {
        queue.remove();
      }
    }
  }

}
