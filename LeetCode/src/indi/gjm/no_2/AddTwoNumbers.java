package indi.gjm.no_2;

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