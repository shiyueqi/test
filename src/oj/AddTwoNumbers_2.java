package oj;

/**
 * date: 2017/01/18 12:30.
 * author: Yueqi Shi
 */

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * �������㣬342��ʾ��2->4->3.   342 + 465 = 807
 * ��λ����
 */
public class AddTwoNumbers_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode node = null;
        ListNode resultNode = null;
        ListNode nextNode = null;

        boolean isPlusOne = Boolean.FALSE;

        while (l1 != null && l2 != null) {
            int result = l1.val + l2.val;
            if (isPlusOne) {
                result += 1;
            }

            if (result >= 10) {
                isPlusOne = true;
                result -= 10;
            } else {
                isPlusOne = false;
            }
            nextNode = new ListNode(result);

            if (resultNode == null) {
                resultNode = node = nextNode;
            } else {
                node.next = nextNode;
                node = nextNode;
            }

            l1 = l1.next;
            l2 = l2.next;
        }

        if (isPlusOne) {
            if (l1 == null && l2 == null) {
                node.next = new ListNode(1);
            } else if (l1 != null) {
                node.next = addTwoNumbers(l1, new ListNode(1));
            } else {
                node.next = addTwoNumbers(new ListNode(1), l2);
            }
        } else {
            if (l1 == null && l2 == null) {
                node.next = null;
            } else if (l1 != null) {
                node.next = addTwoNumbers(l1, null);
            } else {
                node.next = addTwoNumbers(null ,l2);
            }
        }

        return resultNode;
    }

    public static void main(String[] args) {
        AddTwoNumbers_2 addTwoNumbers_2 = new AddTwoNumbers_2();
        ListNode l1 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(3);
        l1.next = l12;
        l12.next = l13;

        ListNode l2 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        ListNode l23 = new ListNode(4);
        ListNode l24 = new ListNode(2);
        l2.next = l22;
        l22.next = l23;
        l23.next = l24;

        ListNode result = addTwoNumbers_2.addTwoNumbers(l1, l2);
        int index = 0;
        while (result != null) {
            if  (index++ > 0) {
                System.out.print("->");
            }
            System.out.print(result.val);
            result = result.next;
        }
    }
}
