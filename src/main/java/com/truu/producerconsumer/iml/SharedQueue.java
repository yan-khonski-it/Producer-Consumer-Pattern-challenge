package com.truu.producerconsumer.iml;

/**
 * A queue that is shared between the producer and consumer.
 */
public interface SharedQueue {

  static SharedQueue getInstance(boolean useSynchronizedQueue, int maxQueueSize) {
    return useSynchronizedQueue ? new SynchronizedQueue(maxQueueSize)
        : new StandardBlockingQueue(maxQueueSize);
  }

  void add(Integer item);

  Integer remove();
}
