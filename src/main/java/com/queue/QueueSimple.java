package com.queue;

/**
 * @Description : 队列定义
 * @Author : wuqia
 * @Date : 2022/7/26 09:40
 * @Version : 1.0
 **/
public interface QueueSimple {

    boolean enqueue(String item);

    String dequeue();
}
