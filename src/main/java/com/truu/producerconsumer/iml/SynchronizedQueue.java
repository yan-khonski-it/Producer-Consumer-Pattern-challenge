package com.truu.producerconsumer.iml;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1A: DIY blocking queue. Add and remove operations are synchronized on the queue.
 * <p>
 * A fully thread-safe, blocking queue mechanism shared between the producer and consumer threads
 * via the internal {@code queue} object.
 * <p>
 * It does not use of the `java.util.concurrent` package.
 */
public class SynchronizedQueue implements SharedQueue {

  private final LinkedList<Integer> queue;
  private final int maxSize;

  /**
   * We cannot check {@link Queue#size()} because the field is non-volatile in some implementations
   * (may not see the most recently written value).
   */
  private volatile int currentSize = 0;

  public SynchronizedQueue(int maxSize) {
    this.maxSize = maxSize;
    this.queue = new LinkedList<>();
  }

  @Override
  public void add(Integer item) {
    synchronized (queue) {
      while (currentSize >= maxSize) {
        waitOnQueue();
      }

      queue.add(item);
      currentSize++;

      queue.notify();
    }
  }

  @Override
  public Integer remove() {
    Integer result;
    synchronized (queue) {
      while (currentSize == 0) {
        waitOnQueue();
      }

      result = queue.remove();
      currentSize--;

      queue.notify();
    }

    return result;
  }

  private void waitOnQueue() {
    try {
      queue.wait();
    } catch (InterruptedException e) {
      throw new RuntimeException("Failed to wait. It was interrupted.", e);
    }
  }
}
