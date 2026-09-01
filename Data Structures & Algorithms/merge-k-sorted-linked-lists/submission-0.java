/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> list=new ArrayList<>();
        for(ListNode node:lists){
            while(node!=null){
                list.add(node.val);
                node=node.next;
            }
        }
        Collections.sort(list);
        ListNode res=new ListNode(0);
        ListNode curr=res;
        for(int node:list){
            curr.next=new ListNode(node);
            curr=curr.next;
        }
        return res.next;
    }
}
