package com.struct.queue;

import cn.hutool.log.StaticLog;
import com.struct.linked.ListNode;

/**
 * @Description : 链式队列
 * @Author : wuqia
 * @Date : 2022/7/26 22:14
 * @Version : 1.0
 **/
public class LinkedQueue implements QueueSimple {

    ListNode<String> head;

    ListNode<String> end;

    @Override
    public boolean enqueue(String item) {
        if (null == end) {
            head = new ListNode<>(item, null);
            end = head;
        } else {
            end.setNext(new ListNode<>(item, null));
            end = end.getNext();
        }
        return true;
    }

    @Override
    public String dequeue() {
        if (null != head) {
            String val = head.getVal();
            head = head.getNext();
            return val;
        }
        return null;
    }

    public static void main(String[] args) {
        LinkedQueue linkedQueue = new LinkedQueue();
        linkedQueue.enqueue("1");
        linkedQueue.enqueue("2");
        linkedQueue.enqueue("3");
        StaticLog.error("超限 {}",linkedQueue.enqueue("3"));
        StaticLog.error(linkedQueue.dequeue());
        StaticLog.error(linkedQueue.dequeue());
        StaticLog.error(linkedQueue.dequeue());
        StaticLog.error("超限 {}",linkedQueue.enqueue("3"));
        StaticLog.error(linkedQueue.dequeue());
        StaticLog.error(linkedQueue.dequeue());
        StaticLog.error(linkedQueue.dequeue());
        StaticLog.error(linkedQueue.dequeue());
    }
}
