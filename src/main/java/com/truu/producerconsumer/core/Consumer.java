package com.truu.producerconsumer.core;

import com.truu.producerconsumer.app.ProgramProperties;
import com.truu.producerconsumer.delay.Delayer;
import com.truu.producerconsumer.iml.SharedQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Consumer implements Runnable {

  private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

  private final SharedQueue queue;
  private final Delayer delayer;

  public Consumer(SharedQueue queue) {
    this.queue = queue;
    this.delayer = Delayer.getInstance(ProgramProperties.USE_RANDOM_DELAY);
  }

  @Override
  public void run() {
    for (int i = 0; i < ProgramProperties.CONSUMED_ITEMS_COUNT; i++) {
      delayer.delay();
      var value = queue.remove();
      LOGGER.info("The item: {} was removed.", value);
    }
  }
}
