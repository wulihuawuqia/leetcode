package com.struct.linked;

import java.util.HashSet;
import java.util.Set;

public class HasCycle {

    public static boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while(null != head) {
            if(!set.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    public static boolean hasCycle1(ListNode head) {
        ListNode f = head;
        ListNode s = head;
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
