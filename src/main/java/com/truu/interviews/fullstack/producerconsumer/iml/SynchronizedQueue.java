package com.truu.interviews.fullstack.producerconsumer.iml;

import static java.lang.String.format;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Simple implementation of a {@link SharedQueue} that uses {@link LinkedBlockingQueue} under the
 * hood. Read operation is blocked if the queue is empty. Write operation is blocked if the queue is
 * full (its size is equal to its capacity).
 */
public class SynchronizedQueue implements SharedQueue {

  private final LinkedBlockingQueue<Integer> queue;

  public SynchronizedQueue(int maxSize) {
    queue = new LinkedBlockingQueue<>(maxSize);
  }

  public void add(Integer item) {
    try {
      queue.put(item);
    } catch (InterruptedException e) {
      throw new RuntimeException(
          format("Putting an item (%s) into the queue was interrupted.", item), e);
    }
  }

  public Integer remove() {
    try {
      return queue.take();
    } catch (InterruptedException e) {
      throw new RuntimeException("Taking an item from the queue was interrupted.", e);
    }
  }
}
