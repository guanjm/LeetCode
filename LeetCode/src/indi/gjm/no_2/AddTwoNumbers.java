package indi.gjm.no_2;

import indi.gjm.po.ListNode;

/**
 * 两数相加
 * @Author : guanjm
 * @Date: 2020/11/12 17:06
 *
 */
public class AddTwoNumbers {

    private static ListNode getResult(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode tmp = null;
        int sum = 0;
        while (l1 != null || l2 != null || sum != 0) {
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            if (tmp == null) {
                tmp = result;
                result.val = sum % 10;
            } else {
                ListNode currentNode = new ListNode(sum % 10);
                tmp.next = currentNode;
                tmp = currentNode;
            }
            sum = sum / 10;
        }
        return result;
    }

    public static void main(String[] args) {
        //4 -> 3 -> 2 -> 1 (1234)
        ListNode l11 = ListNode.generateReverseListNode1("1234");
        System.out.println(ListNode.getReverseString(l11));
        //8 -> 7 -> 6 -> 5 (5678)
        ListNode l21 = ListNode.generateReverseListNode2("5678");
        System.out.println(ListNode.getReverseString(l21));
        //2 -> 1 -> 9 -> 6 (6912)
        ListNode result = getResult(l11, l21);
        System.out.println(ListNode.getReverseString(result));
    }

}