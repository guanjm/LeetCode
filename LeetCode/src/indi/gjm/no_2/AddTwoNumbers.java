package indi.gjm.no_2;

/**
 * 两数相加
 * @Author : ex_guanjm
 * @Date: 2020/11/12 17:06
 *
 */
public class AddTwoNumbers {

    private static ListNode getResult(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode lastNode = null;
        int add = 0;
        while (l1 != null || l2 != null || add > 0) {
            int val1 = 0;
            int val2 = 0;
            if (l1 != null) {
                val1 = l1.getVal();
                l1 = l1.getNext();
            }
            if (l2 != null) {
                val2 = l2.getVal();
                l2 = l2.getNext();
            }
            int val3 = val1 + val2 + add;
            if (val3 > 10) {
                add = 1;
                val3 = val3 - 10;
            } else {
                add = 0;
            }
            ListNode currentNode;
            if (lastNode == null) {
                result = lastNode = new ListNode();
                lastNode.setVal(val3);
            } else {
                currentNode = new ListNode();
                lastNode.setNext(currentNode);
                currentNode.setVal(val3);
                lastNode = currentNode;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        //4 -> 3 -> 2 -> 1 (1234)
        ListNode l11 = generateListNode1("1234");
        System.out.println(getString(l11));
        //8 -> 7 -> 6 -> 5 (5678)
        ListNode l21 = generateListNode1("5678");
        System.out.println(getString(l21));
        //2 -> 1 -> 9 -> 6 (6912)
        ListNode result = getResult(l11, l21);
        System.out.println(getString(result));
    }

    //生成链表（循环）
    private static ListNode generateListNode1(String str) {
        ListNode result = null;
        ListNode last = null;
        for (int i = str.length()-1; i >= 0; i--) {
            if (last == null) {
                result = last = new ListNode();
                last.setVal(str.charAt(i) - '0');
            } else {
                ListNode currentNode = new ListNode();
                last.setNext(currentNode);
                currentNode.setVal(str.charAt(i) - '0');
                last = currentNode;
            }
        }
        return result;
    }

    //生成链表（递归）
    private static ListNode generateListNode2(String str) {
        if (str == null || str.length() < 1) {
            return null;
        } else {
            ListNode listNode = new ListNode();
            listNode.setVal(str.charAt(str.length() - 1) - '0');
            listNode.setNext(generateListNode2(str.substring(0, str.length() - 1)));
            return listNode;
        }
    }

    private static String getString(ListNode listNode) {
        if (listNode != null) {
            return getString(listNode.getNext()) + listNode.getVal();
        } else {
            return "";
        }
    }

}

class ListNode {

    int val;

    ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}