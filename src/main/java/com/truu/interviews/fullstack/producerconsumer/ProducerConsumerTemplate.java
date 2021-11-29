package com.truu.interviews.fullstack.producerconsumer;

import java.util.Queue;

public class ProducerConsumerTemplate {

  private static final int MAX_SIZE = 5;

  public static void main(String[] args) {
    // TODO
    Queue<Integer> queue = null;

    Thread prodThread = new Thread(new Producer(queue));
    prodThread.start();
    Thread consThread = new Thread(new Consumer(queue));
    consThread.start();
  }

  public static class Producer implements Runnable {
    private final Queue<Integer> queue;

    public Producer(Queue<Integer> queue) {
      this.queue = queue;
    }

    @Override
    public void run() {
      // TODO
    }
  }

  public static class Consumer implements Runnable {
    private final Queue<Integer> queue;

    public Consumer(Queue<Integer> queue) {
      this.queue = queue;
    }

    @Override
    public void run() {
      // TODO
    }
  }

}
