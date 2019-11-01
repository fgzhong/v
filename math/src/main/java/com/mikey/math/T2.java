package com.mikey.math;

public class T2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        int tmp = 0;
        ListNode cur = node;
        while (l1 != null || l2 != null) {
            int add = 0;
            if (l1 != null && l2 != null) {
                add = l1.val+l2.val+tmp;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 != null && l2 == null) {
                add = l1.val+tmp;
                l1 = l1.next;
            } else if (l2 != null && l1 == null) {
                add = l2.val+tmp;
                l2 = l2.next;
            }
            if (add >= 10) {
                tmp = 1;
                cur.next = new ListNode(add - 10);
            } else {
                tmp = 0;
                cur.next = new ListNode(add);
            }
            cur = cur.next;
        }

        if (tmp == 1) {
            cur.next = new ListNode(1);
        }

        return node.next;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
