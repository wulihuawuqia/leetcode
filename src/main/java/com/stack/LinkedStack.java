package com.stack;

import com.linked.ListNode;

/**
 * @Description : 链式栈
 * @Author : wuqia
 * @Date : 2022/7/26 09:15
 * @Version : 1.0
 **/
public class LinkedStack implements StackSimple {
    ListNode<String> end;
    int size;

    public LinkedStack() {

    }

    @Override
    public boolean push(String item) {
        if (null == end) {
            end = new ListNode(item);
        } else {
            end.setNext(new ListNode(item, null, end));
        }
        return true;
    }

    @Override
    public String pop() {
        if (null == end) {
            return null;
        }
        String val = end.getVal();
        end = end.getBefor();
        return val;
    }

    public static void main(String[] args) {
        LinkedStack linkedStack = new LinkedStack();
        linkedStack.push("1");
        linkedStack.push("2");
        System.out.println(linkedStack.push("3"));
        System.out.println(linkedStack.pop());
        System.out.println(linkedStack.push("3"));
    }
}
