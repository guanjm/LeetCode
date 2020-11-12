package indi.gjm.no_2;

/**
 * 两数相加
 * @Author : ex_guanjm
 * @Date: 2020/11/12 17:06
 *
 */
public class AddTwoNumbers {

    private static ListNode getResult(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
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
            if (val3 > 9) {
                add = 1;
                val3 = val3 - 9;
            } else {
                add = 0;
            }
            ListNode nextNode;
            if (lastNode == null) {
                nextNode = result;
            } else {
                nextNode = new ListNode();
                lastNode.setNext(nextNode);
            }
            nextNode.setVal(val3);
            lastNode = nextNode;
        }
        return result;
    }

    public static void main(String[] args) {
        //4 -> 3 -> 2 -> 1 (1234)
        ListNode l14 = new ListNode(4);
        ListNode l13 = new ListNode(3, l14);
        ListNode l12 = new ListNode(2, l13);
        ListNode l11 = new ListNode(1, l12);
        //8 -> 7 -> 6 -> 5 (5678)
        ListNode l24 = new ListNode(8);
        ListNode l23 = new ListNode(7, l24);
        ListNode l22 = new ListNode(6, l23);
        ListNode l21 = new ListNode(5, l22);

        ListNode result = getResult(l11, l21);
        while (result != null) {
            System.out.println(result.getVal());
            result = result.getNext();
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