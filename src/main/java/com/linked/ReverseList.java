package com.linked;

/**
 * program leetcode
 * <p>
 * description
 *
 * @author wuqia
 * @date 2022-07-12 09:38
 **/
public class ReverseList {



    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseList(ListNode head) {
        if (null == head.next) {
            return head;
        }
        ListNode kuai;
        ListNode cur = head;
        while (null != head.next) {
            head = cur.next;
            kuai = head.next.next;
            if (null == kuai) {
                return head;
            }
            head.next = cur;
            cur = head;
            head = kuai;
        }
        return head;
    }

    public static void main(String[] args) {
        ReverseList reverseList = new ReverseList();
        ListNode head = new ListNode(1, null);
        for (int i : new int[]{1,2,3,4,5}) {
            head.next = new ListNode(1, null);
            head = head.next;
        }

    }


}
