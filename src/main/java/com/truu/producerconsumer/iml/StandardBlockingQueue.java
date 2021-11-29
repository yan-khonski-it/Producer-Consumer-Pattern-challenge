package com.truu.producerconsumer.iml;

import static java.lang.String.format;

import java.util.concurrent.LinkedBlockingQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 1B Problem, were we are allowed to use {@code java.util.concurrent} package.
 * <p>
 * Simple implementation of a {@link SharedQueue} that uses {@link LinkedBlockingQueue} under the
 * hood (which, in turn, uses ReentrantLock).
 * <p>
 * Remove operation is blocked if the queue is empty. Add operation is blocked if the queue is full
 * (its size is equal to its capacity).
 */
public class StandardBlockingQueue implements SharedQueue {

  private static final Logger LOGGER = LoggerFactory.getLogger(StandardBlockingQueue.class);

  private final LinkedBlockingQueue<Integer> queue;

  public StandardBlockingQueue(int maxSize) {
    queue = new LinkedBlockingQueue<>(maxSize);
  }

  @Override
  public void add(Integer item) {
    try {
      queue.put(item);
      LOGGER.debug("The item: {} was successfully added to the queue.", item);
    } catch (InterruptedException e) {
      throw new RuntimeException(
          format("Putting an item (%s) into the queue was interrupted.", item), e);
    }
  }

  @Override
  public Integer remove() {
    try {
      var value = queue.take();
      LOGGER.debug("The item: {} was successfully removed from the queue.", value);
      return value;
    } catch (InterruptedException e) {
      throw new RuntimeException("Taking an item from the queue was interrupted.", e);
    }
  }
}
