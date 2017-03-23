package oj;

/**
 * date: 2017/02/10 14:45.
 * author: Yueqi Shi
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 */
public class MergeTwoSortedLists_21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode res;
//        if (l1.val < l2.val) {
//            res = l1;
//        } else {
//            res = l2;
//        }

        List<ListNode> list = new ArrayList<>();

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                list.add(l1);
                l1 = l1.next;
            } else {
                list.add(l2);
                l2 = l2.next;
            }
        }

        if (l1 != null) {
            while (l1 != null) {
                list.add(l1);
                l1 = l1.next;
            }
        }

        if (l2 != null) {
            while (l2 != null) {
                list.add(l2);
                l2 = l2.next;
            }
        }


        res = list.get(0);
        for (int i = 0; i < list.size()-1; i++) {
            list.get(i).next = list.get(i+1);
        }

        return res;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode res;
        if (l1.val < l2.val) {
            res = l1;
        } else {
            res = l2;
        }




        return res;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);
        ListNode l8 = new ListNode(8);
        ListNode l9 = new ListNode(9);
        ListNode l10 = new ListNode(10);
        l1.next = l3;
        l3.next = l5;
        l5.next = l7;
        l7.next = l9;
        l2.next = l4;
        l4.next = l6;
        l6.next = l8;
        l8.next = l10;

        ListNode head = new MergeTwoSortedLists_21().mergeTwoLists(l1, l2);
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }

    }
}
