package indi.gjm.no_147;

import indi.gjm.po.ListNode;

/**
 * 对链表进行插入排序
 * @Author : ex_guanjm
 * @Date: 2020/11/20 14:15
 *
 */
public class InsertionSortList {

    public static ListNode getResult1(ListNode head) {
        if (head == null) return null;
        ListNode start = head;
        ListNode cursor = head.next;
        start.next = null;
        while (cursor != null) {
            ListNode last = null;
            ListNode current = start;
            while (current != null) {
                if (cursor.val < current.val) {
                    ListNode tmp = cursor.next;
                    cursor.next = current;
                    if (last == null) {
                        start = cursor;
                    } else {
                        last.next = cursor;
                    }
                    cursor = tmp;
                    break;
                }
                if (current.next == null) {
                    ListNode tmp = cursor.next;
                    current.next = cursor;
                    cursor.next = null;
                    cursor = tmp;
                    break;
                }
                last = current;
                current = current.next;
            }
        }
        return start;
    }

    public static ListNode getResult2(ListNode head) {
        if (head == null) return null;
        ListNode start = head;
        ListNode cursor = head.next;
        ListNode last;
        while (cursor != null) {
            last = cursor.next;
            ListNode current = start;
            if (cursor.val < current.val) {
                start = cursor;
                cursor.next = current;
            } else {
                while (current.next.val < cursor.val) {
                    current = current.next;
                }
                cursor.next = current.next;
                current.next = cursor;
            }
            cursor = last;
        }
        return start;
    }

    public static void main(String[] args) {
        //4 -> 2 -> 1 -> 3
//        ListNode listNode1 = ListNode.generateListNode(new int[]{4, 2, 1, 3});
//        System.out.println(ListNode.getString(listNode1));
//        ListNode result1 = getResult2(listNode1);
//        System.out.println(ListNode.getString(result1));

        //-1 -> 5 -> 3 -> 4 -> 0
//        ListNode listNode2 = ListNode.generateListNode(new int[]{-1, 5, 3, 4, 0});
//        System.out.println(ListNode.getString(listNode2));
//        ListNode result2 = getResult2(listNode2);
//        System.out.println(ListNode.getString(result2));

        //-1 -> 5 -> 3 -> 4 -> 0
        ListNode listNode3 = ListNode.generateListNode(new int[]{1, 1});
        System.out.println(ListNode.getString(listNode3));
        ListNode result3 = getResult2(listNode3);
        System.out.println(ListNode.getString(result3));
    }

}
