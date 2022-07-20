package com.linked;

import java.util.HashSet;
import java.util.Set;

public class HasCycle {

    public static boolean hasCycle(ReverseList.ListNode head) {
        Set<ReverseList.ListNode> set = new HashSet<>();
        while(null != head) {
            if(!set.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    public static boolean hasCycle1(ReverseList.ListNode head) {
        ReverseList.ListNode f = head;
        ReverseList.ListNode s = head;
        while(null != s && null != f && null != f.next) {
            f = f.next.next;
            s = s.next;
            if (f == s) {
                return true;
            }
        }
        return false;
    }
}
