//Solution leednote----83. Remove Duplicates from Sorted List
public class TestListNode {
    public static void main(String[] args) throws Exception {
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(1);
        head.next = n2;//建立起關聯:head=>n2
        ListNode n4 = new ListNode();//空的
        n4.val = 3;
        ListNode n3 = new ListNode(2, n4);//n3.next = n4(建立起關聯:n3=>n4)
        n2.next = n3;//建立起關聯:n2=>n3
        //head=>n2=>n3=>n4
        //--------------------------------

        // 建立鏈表 [1,1,2,3,3]
        ListNode test = new ListNode(1);
        test.next = new ListNode(1);
        test.next.next = new ListNode(2);
        test.next.next.next = new ListNode(3);
        test.next.next.next.next = new ListNode(3);

        // 刪除重複元素
        test = ListNode.deleteDuplicates(head);

        // 打印結果
        //printList(test);
        ListNode current = test;
        while (current != null) {
            System.out.println(String.valueOf(current.val));
            current = current.next;
        }
        System.out.println();
    }
    // 打印鏈表的方法
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}
/* 
public class ListNode_ {
    int val;
    ListNode next;
    ListNode() {
        
    }
    ListNode(int val) { 
        this.val = val; 
    }
    ListNode(int val, ListNode next) { 
        this.val = val; this.next = next; 
    } 
}
*/