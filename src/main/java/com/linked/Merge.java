package com.linked;


public class Merge {


    /**
     * 合并
     *
     * @param list1
     * @param list2
     * @return {@link ListNode}
     */
    public static ListNode merge(ListNode<Integer> list1, ListNode<Integer> list2) {
        ListNode<Integer> newlist1;
        if (null == list1) {
            return list2;
        }
        if (null == list2) {
            return list1;
        }
        if (list1.val < list2.val) {
            newlist1 = new ListNode(list1.val, null);
            list1 = list1.next;
        } else {
            newlist1 = new ListNode(list2.val, null);
            list2 = list2.next;
        }
        while(true) {
            // 如果其中一个遍历完则只需要遍历一个即可
            if (null == list2) {
                while (null != list1) {
                    newlist1.next = new ListNode(list1.val, null);
                    list1 = list1.next;
                    newlist1 = newlist1.next;
                }
                break;
            } else if (null == list1) {
                while (null != list2) {
                    newlist1.next = new ListNode(list2.val, null);
                    list2 = list2.next;
                    newlist1 = newlist1.next;
                }
                break;
            } else {
                if (list1.val < list2.val) {
                    newlist1.next = new ListNode(list1.val, null);
                    list1 = list1.next;
                } else {
                    newlist1.next = new ListNode(list2.val, null);
                    list2 = list2.next;
                }
                newlist1 = newlist1.next;
            }
        }
        return newlist1;
    }
}
