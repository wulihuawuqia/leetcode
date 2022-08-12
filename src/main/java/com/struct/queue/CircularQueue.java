package com.struct.queue;

import cn.hutool.log.StaticLog;

/**
 * @Description : 循环队列，入队时不用频繁移动
 * 队列满时  （tail+1）%n=head
 * @Author : wuqia
 * @Date : 2022/7/26 22:27
 * @Version : 1.0
 **/
public class CircularQueue implements QueueSimple {

    int tail;
    int head;
    int size;
    String[] items;

    public CircularQueue(int size) {
        this.size = size;
        this.tail = 0;
        this.head = 0;
        items = new String[size];
    }

    @Override
    public boolean enqueue(String item) {
        if (((tail + 1) % size == head)) {
            return false;
        } else {
            items[tail] = item;
            tail = (tail + 1) % size;
        }
        return true;
    }

    @Override
    public String dequeue() {
        if(tail == head) {
            return null;
        }
        String ret = items[head];
        head = (head + 1) % size;
        return ret;
    }

    public static void main(String[] args) {
        CircularQueue circularQueue = new CircularQueue(3);
        circularQueue.enqueue("1");
        circularQueue.enqueue("2");
        circularQueue.enqueue("3");
        StaticLog.error("超限写入 {}", circularQueue.enqueue("3"));
        StaticLog.error(circularQueue.dequeue());
        StaticLog.error(circularQueue.dequeue());
        StaticLog.error(circularQueue.dequeue());
        StaticLog.error("超限写入 {}", circularQueue.enqueue("3"));
        StaticLog.error(circularQueue.dequeue());
        StaticLog.error(circularQueue.dequeue());
        StaticLog.error(circularQueue.dequeue());
        StaticLog.error(circularQueue.dequeue());
    }
}
