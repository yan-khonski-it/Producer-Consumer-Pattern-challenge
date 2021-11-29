package com.truu.producerconsumer.core;

import static com.truu.producerconsumer.app.ProgramProperties.PRODUCED_ITEMS_COUNT;
import static com.truu.producerconsumer.app.ProgramProperties.PRODUCER_MAX_VALUE;
import static com.truu.producerconsumer.app.ProgramProperties.USE_RANDOM_DELAY;

import com.truu.producerconsumer.delay.Delayer;
import com.truu.producerconsumer.iml.SharedQueue;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Producer implements Runnable {

  private static final Logger LOGGER = LoggerFactory.getLogger(Producer.class);

  private final Random random;
  private final SharedQueue queue;
  private final Delayer delayer;

  public Producer(SharedQueue queue) {
    this.queue = queue;
    this.delayer = Delayer.getInstance(USE_RANDOM_DELAY);
    this.random = new Random();
  }

  @Override
  public void run() {
    for (int i = 0; i < PRODUCED_ITEMS_COUNT; i++) {
      var randomItem = random.nextInt(PRODUCER_MAX_VALUE);
      delayer.delay();
      LOGGER.info("Producing item: {}.", randomItem);
      queue.add(randomItem);
    }
  }
}
