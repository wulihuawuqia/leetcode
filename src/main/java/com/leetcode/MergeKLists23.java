package com.leetcode;

/**
 * @Description : 合并K个升序链表
 * https://leetcode.cn/problems/merge-k-sorted-lists/
 * @Author : wuqia
 * @Date : 2022/12/8 09:32
 * @Version : 1.0
 **/
public class MergeKLists23 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (null == lists || lists.length == 0) {
            return null;
        }
        ListNode head = null;
        for (ListNode listNode : lists) {
            if (null == listNode) {
                continue;
            }
            // 头节点为空，直接加入当前即可
            if (null == head) {
                head = new ListNode(listNode.val);
                listNode = listNode.next;
            }
            ListNode cur = head;
            // 开始遍历
            while (null != listNode) {
                // 汇总链表中的值小于 待添加链表的值
                if (cur.val <= listNode.val) {
                    // 如果下级节点为null，则直接加入
                    if (null == cur.next) {
                        cur.next = new ListNode(listNode.val);
                        listNode = listNode.next;
                    } else if (cur.next.val >= listNode.val) {
                        // 如果下级节点不为空，且下级节点大于等于 待添加值，则在当前节点后，插入值
                        ListNode temp = cur.next;
                        cur.next = new ListNode(listNode.val);
                        cur.next.next = temp;
                        listNode = listNode.next;
                    }
                    cur = cur.next;
                } else {
                    // 当前值 > 待添加值，则需要把值插入前面
                    head = new ListNode(listNode.val);
                    head.next = cur;
                    cur = head;
                    listNode = listNode.next;
                }
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        int [][] arr = new int[3][];
        arr[0] = new int[]{1,4,5};
        arr[1] = new int[]{1,3,4};
        arr[2] = new int[]{2,6};
        for (int i = 0; i < arr.length; i++) {
            int []temp = arr[i];
            ListNode head = new ListNode(temp[0]);
            ListNode cur = head;
            for (int j = 1; j < temp.length; j++) {
                cur.next = new ListNode(temp[j]);
                cur = cur.next;
            }
            lists[i] = head;
        }
        ListNode result = mergeKLists(lists);
        while(null != result) {
            System.out.print(result.val+",");
            result = result.next;
        }
    }

}
