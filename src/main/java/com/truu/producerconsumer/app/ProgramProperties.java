package com.truu.producerconsumer.app;

import com.truu.producerconsumer.iml.SynchronizedQueue;

/**
 * Defines properties how this application will run.
 */
public final class ProgramProperties {

  /**
   * Defines how long the maximum delay can take place if {@link #USE_RANDOM_DELAY} is enabled.
   */
  public static final int MAX_RANDOM_DELAY_MS = 400;

  public static final int MAX_QUEUE_SIZE = 5;

  public static final int PRODUCER_MAX_VALUE = 100;

  /**
   * Defines how many items we want our producer to produce into the queue.
   */
  public static final int PRODUCED_ITEMS_COUNT = 10;

  /**
   * Defines how many items we want our consumer to consume from the queue.
   */
  public static final int CONSUMED_ITEMS_COUNT = 10;

  /**
   * Allows to have a random delay when producing or consuming items.
   */
  public static final boolean USE_RANDOM_DELAY = true;

  /**
   * Defines if we want to use {@link SynchronizedQueue} (our custom implementation). Otherwise, we
   * will use the default blocking queue.
   */
  public static final boolean USE_SYNCHRONIZED_QUEUE = true;
}
