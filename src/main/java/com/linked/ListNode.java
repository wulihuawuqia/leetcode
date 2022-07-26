package com.linked;

public class ListNode<T> {
    T val;
    ListNode next;

    ListNode befor;
    ListNode() {}
    public ListNode(T val) { this.val = val; }
    public ListNode(T val, ListNode next) { this.val = val; this.next = next; }
    public ListNode(T val, ListNode next, ListNode befor) {
        this.val = val; this.next = next; this.befor = befor;
    }

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public ListNode getBefor() {
        return befor;
    }

    public void setBefor(ListNode befor) {
        this.befor = befor;
    }
}
