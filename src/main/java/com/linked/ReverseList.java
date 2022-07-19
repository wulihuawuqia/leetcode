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

    public static ListNode reverseList(ListNode head) {
        // 首先处理空
        if (null == head || null == head.next) {
            return head;
        }
        // 三个引用
        // 当前
        ListNode cur = head;
        // 头
        head = cur.next;
        cur.next = null;
        // 快
        ListNode kuai;
        while (true) {
            kuai = head.next;
            head.next = cur;
            if (null == kuai) {
                return head;
            }
            cur = head;
            head = kuai;
        }
    }

    public static void main(String[] args) {
        ReverseList reverseList = new ReverseList();
        ListNode head = new ListNode(1, null);
        ListNode cur = head;
        for (int i : new int[]{2}) {
            cur.next = new ListNode(i, null);
            cur = cur.next;
        }
        head = reverseList(head);
        while(null != head) {
            System.out.print(head.val+",");
            head = head.next;
        }
    }


}
