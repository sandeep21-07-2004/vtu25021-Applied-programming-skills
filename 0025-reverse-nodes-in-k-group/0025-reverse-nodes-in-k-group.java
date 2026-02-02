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
    private ListNode getKthNode(ListNode temp, int k) {
        k = k - 1;
        while(temp != null && k > 0) {
            temp = temp.next;
            k--;
        }
        return temp;
    }

    private void reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prevLast = null;

        while(temp != null) {
            //get kth node
            ListNode kthNode = getKthNode(temp, k);

            //if less than k node left
            if(kthNode == null) {
                if(prevLast != null) {
                    prevLast.next = temp;
                }
                break;
            }

            ListNode nextNode = kthNode.next;
            kthNode.next = null;
            reverse(temp);

            //if first group
            if(temp == head) {
                head = kthNode;
            }
            else {
                prevLast.next = kthNode;
            }

            prevLast = temp;
            temp = nextNode;
        }

        return head;
    }
}