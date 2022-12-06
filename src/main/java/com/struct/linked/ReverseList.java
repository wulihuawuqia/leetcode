package com.struct.linked;

/**
 * program leetcode
 * <p>
 * description
 *
 * @author wuqia
 * @date 2022-07-12 09:38
 **/
public class ReverseList {

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
        ListNode head = new ListNode(1, null);
        ListNode cur = head;
        for (int i : new int[]{2,3,4,6}) {
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
