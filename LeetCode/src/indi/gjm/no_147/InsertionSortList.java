package indi.gjm.no_147;

import indi.gjm.po.ListNode;

/**
 * 对链表进行插入排序
 * @Author : ex_guanjm
 * @Date: 2020/11/20 14:15
 *
 */
public class InsertionSortList {

    public static ListNode getResult(ListNode head) {
        ListNode result = null;
        ListNode currentNode = head;
        //逐一轮询输入链表
        while (currentNode != null) {
            //当为输出链表第一个节点时直接新建
            if (result == null) {
                result = new ListNode();
                result.setVal(currentNode.getVal());
            //否则，轮询输出链表
            } else {
                ListNode last = null;
                ListNode current = result;
                while (current != null) {
                    //判断是否能在此节点前插入
                    if (currentNode.getVal() < current.getVal()) {
                        ListNode listNode = new ListNode();
                        listNode.setVal(currentNode.getVal());
                        listNode.setNext(current);
                        if (last == null) {
                            result = listNode;
                        } else {
                            last.setNext(listNode);
                        }
                        break;
                    }
                    //判断是否
                    if (current.getNext() == null) {
                        ListNode listNode = new ListNode();
                        listNode.setVal(currentNode.getVal());
                        current.setNext(listNode);
                        break;
                    }
                    last = current;
                    current = current.getNext();
                }
            }
            currentNode = currentNode.getNext();
        }
        return result;
    }

    public static void main(String[] args) {
        //4 -> 2 -> 1 -> 3
        ListNode listNode1 = ListNode.generateListNode(new int[]{4, 2, 1, 3});
        System.out.println(ListNode.getString(listNode1));
        ListNode result1 = getResult(listNode1);
        System.out.println(ListNode.getString(result1));

        //-1 -> 5 -> 3 -> 4 -> 0
        ListNode listNode2 = ListNode.generateListNode(new int[]{-1, 5, 3, 4, 0});
        System.out.println(ListNode.getString(listNode2));
        ListNode result2 = getResult(listNode2);
        System.out.println(ListNode.getString(result2));
    }

}
