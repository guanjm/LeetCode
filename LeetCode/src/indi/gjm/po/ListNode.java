package indi.gjm.po;

public class ListNode {

    private int val;

    private ListNode next;

    public ListNode() {
    }

    public ListNode(int x) { val = x; }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    /**
     * 生成链表（循环）倒序
     * @author : guanjm
     * @date: 2020/11/27
     * input: 1234
     * output: 4 -> 3 -> 2 -> 1
     *
     */
    public static ListNode generateReverseListNode1(String str) {
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

    /**
     * 生成链表（递归）倒序
     * @author : guanjm
     * @date: 2020/11/27
     * input: 1234
     * output: 4 -> 3 -> 2 -> 1
     *
     */
    public static ListNode generateReverseListNode2(String str) {
        if (str == null || str.length() < 1) {
            return null;
        } else {
            ListNode listNode = new ListNode();
            listNode.setVal(str.charAt(str.length() - 1) - '0');
            listNode.setNext(generateReverseListNode2(str.substring(0, str.length() - 1)));
            return listNode;
        }
    }

    /**
     * 生成链表
     * @author : guanjm
     * @date: 2020/11/27
     * input: 1234
     * output: 1 -> 2 -> 3 -> 4
     *
     */
    public static ListNode generateListNode(int[] array) {
        if (array == null || array.length < 1) {
            return null;
        } else {
            ListNode result = null;
            ListNode lastNode = null;
            for (int num : array) {
                ListNode listNode = new ListNode();
                listNode.setVal(num);
                if (lastNode != null) {
                    lastNode.setNext(listNode);
                } else {
                    result = listNode;
                }
                lastNode = listNode;
            }
            return result;
        }
    }

    /**
     * 链表转换字符串（倒序）
     * @author : guanjm
     * @date: 2020/11/27
     * input：4 -> 3 -> 2 -> 1
     * output：1234
     *
     */
    public static String getReverseString(ListNode listNode) {
        if (listNode != null) {
            return getReverseString(listNode.getNext()) + listNode.getVal();
        } else {
            return "";
        }
    }

    /**
     * 链表转字符串成
     * @author : guanjm
     * @date: 2020/11/27
     * input：1 -> 2 -> 3 -> 4
     * output: 1234
     */
    public static String getString(ListNode listNode) {
        if (listNode != null) {
            return listNode.getVal() + getString(listNode.getNext());
        } else {
            return "";
        }
    }

}
