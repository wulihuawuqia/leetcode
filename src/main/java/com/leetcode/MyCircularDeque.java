package com.leetcode;

/**
 * @Description : TODO
 * @Author : wuqia
 * @Date : 2022/12/20 18:31
 * @Version : 1.0
 **/
public class MyCircularDeque {

    int size;

    int curSize = 0;

    Node head;

    Node last;

    public static class Node {
        public Node(int val) {
            this.val = val;
        }

        int val;
        Node front;
        Node rear;
    }

    public MyCircularDeque(int k) {
        this.size = k;
    }

    public boolean insertFront(int value) {
        if (curSize + 1 > size) {
            return false;
        }
        Node cur = new Node(value);
        cur.rear = head;
        if (null != head) {
            head.front = cur;
        }
        head = cur;
        if (null == last) {
            last = head;
        }
        curSize ++;
        return true;
    }

    public boolean insertLast(int value) {
        if (curSize + 1 > size) {
            return false;
        }
        if (null == last) {
            last = new Node(value);
        } else {
            last.rear = new Node(value);
            last.rear.front = last;
            last = last.rear;
        }
        if (null == head) {
            head = last;
        }
        curSize ++;
        return true;
    }

    public boolean deleteFront() {
        if (curSize == 0) {
            return false;
        }
        head = head.rear;
        curSize --;
        if (curSize == 0) {
            head = null;
            last = null;
        }
        return true;
    }

    public boolean deleteLast() {
        if (curSize == 0) {
            return false;
        }
        last = last.front;
        curSize --;
        if (curSize == 0) {
            head = null;
            last = null;
        }
        return true;
    }

    public int getFront() {
        if(null == head) {
            return -1;
        }
        return head.val;
    }

    public int getRear() {
        if(null == last) {
            return -1;
        }
        return last.val;
    }

    public boolean isEmpty() {
        return curSize == 0;
    }

    public boolean isFull() {
        return curSize == size;
    }

    public static void main(String[] args) {
        MyCircularDeque myCircularDeque = new MyCircularDeque(3);
        myCircularDeque.insertLast(1);
        myCircularDeque.insertLast(2);
        myCircularDeque.insertFront(3);
        myCircularDeque.insertFront(4);
        System.out.println(myCircularDeque.getRear());
        System.out.println(myCircularDeque.isFull());
        System.out.println(myCircularDeque.deleteLast());
        System.out.println(myCircularDeque.insertFront(4));
        System.out.println(myCircularDeque.getFront());
    }
}

