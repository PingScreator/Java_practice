//20240704_實際應用一個類(Class)內有三個涵式的範例
//Solution leednote----83. Remove Duplicates from Sorted List
/*
 * 有三個構造函數：一個無參構造函數，一個只接受值的構造函數，和一個接受值和下一個節點的構造函數。
 * TestListNode執行
 * 該節點類 可以指向自己和他下一個點
 */
public class ListNode {
    int val;
    ListNode next;
    //以下為建構式
    ListNode() {
    }
    ListNode(int val) { 
        this.val = val; 
    }//ListNode(class)的值 = 當前的值
    ListNode(int val, ListNode next) { 
        this.val = val; this.next = next; 
    }
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;//起始

        if(head == null){
            return head;//防呆:head為結尾或head==null
        }
        while(current != null && current.next != null){
            //如果沒有下一個點:結束 current.next == null break;
            //如果下一個點數字不同:目前的點往下一個            
            //如果下一個點數字相同:current.next == (current.next).next
            if(current.val == current.next.val){
                current.next = (current.next).next;//表示下一個點(目前的點中的下一個點)會被下下個點(下一個點的下一個點取代)
                // 跳過下一個節點
            } else{
                current = current.next;
            }
        }
        return head;//整理好的head回傳
    }
}
