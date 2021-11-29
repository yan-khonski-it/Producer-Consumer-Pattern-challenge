package com.truu.producerconsumer.delay;

import static com.truu.producerconsumer.utils.ThreadUtils.sleep;

import com.truu.producerconsumer.app.ProgramProperties;
import java.util.Random;

/**
 * Before taking an action, sleeps the current thread for a random ms delay.
 */
public class RandomDelayer implements Delayer {

  private final Random random = new Random();

  @Override
  public void delay() {
    var delayMs = random.nextInt(ProgramProperties.MAX_RANDOM_DELAY_MS);
    sleep(delayMs);
  }
}
