package com.truu.producerconsumer.delay;

/**
 * Does not delay the current thread.
 */
public class SkippingDelayer implements Delayer {

  @Override
  public void delay() {
  }
}
