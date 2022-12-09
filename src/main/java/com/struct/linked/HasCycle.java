package com.struct.linked;

import java.util.HashSet;
import java.util.Set;

public class HasCycle {

    /**
     * 使用Hash 在遍历过程中判定是否有重复
     * @param head
     * @return
     */
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

    /**
     * 快慢指针，如果慢指针在某个节点赶上了快指针就代表存在环结构
     *
     * @param head 头
     * @return boolean
     */
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
