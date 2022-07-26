package com.queue;

/**
 * @Description : 基于数组实现
 * @Author : wuqia
 * @Date : 2022/7/26 09:41
 * @Version : 1.0
 **/
public class ArrayQueue implements QueueSimple {

    int tail;
    int head;
    int size;
    String items[];

    public ArrayQueue(int size) {
        this.size = size;
        this.head = 0;
        this.tail = 0;
        items = new String[size];
    }

    @Override
    public boolean enqueue(String item) {
        if (tail == size) {
            // 数组已占满 需要扩容
            if (head == 0) {
               return false;
            }
            //如果当前实际元素数小于数组大小，则触发数组元素左移
            for(int i = head; i < tail; i++) {
                items[i - head] = items[i];
            }
            // 重置head fail
            tail = tail - head;
            head = 0;
        }
        items[tail] = item;
        tail ++;
        return true;
    }

    @Override
    public String dequeue() {
        if(tail == 0 || head == tail) {
            return null;
        }
        return items[head++];
    }

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        arrayQueue.enqueue("1");
        arrayQueue.enqueue("2");
        arrayQueue.enqueue("3");
        System.out.println(arrayQueue.enqueue("3"));
        System.out.println(arrayQueue.dequeue());
        System.out.println(arrayQueue.dequeue());
        System.out.println(arrayQueue.dequeue());
        System.out.println(arrayQueue.enqueue("3"));
        System.out.println(arrayQueue.dequeue());
        System.out.println(arrayQueue.dequeue());
        System.out.println(arrayQueue.dequeue());
    }
}
