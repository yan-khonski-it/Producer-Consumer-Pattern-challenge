package com.truu.producerconsumer.delay;

/**
 * It allows us to have a pause (delay) in both producer and consumer threads.
 */
public interface Delayer {

  static Delayer getInstance(boolean useRandomDelay) {
    return useRandomDelay ? new RandomDelayer() : new SkippingDelayer();
  }

  void delay();
}
