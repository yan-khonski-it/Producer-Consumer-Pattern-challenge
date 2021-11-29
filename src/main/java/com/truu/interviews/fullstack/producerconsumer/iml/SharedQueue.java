package com.truu.interviews.fullstack.producerconsumer.iml;

/**
 * A queue that is shared between the producer and consumer.
 */
public interface SharedQueue {

  void add(Integer item);

  Integer remove();
}
