package com.truu.producerconsumer.utils;

public final class ThreadUtils {

  private ThreadUtils() {
    throw new AssertionError("Instance is not allowed.");
  }

  public static void sleep(int ms) {
    try {
      Thread.sleep(ms);
    } catch (InterruptedException e) {
      throw new RuntimeException("Sleep was interrupted.", e);
    }
  }
}
