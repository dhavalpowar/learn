/**
 * Definition for singly-linked list.
 */
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }

public class SumLinkedList {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = null;
		ListNode curr = null;
		int carry = 0, i = 0;

		//If there is another digit
		while(l1 != null || l2 != null) {
			//Assign num1 and point to next node on l1
			if(l1 != null) {
				carry += l1.val;
				l1 = l1.next;
			}

			//Assign num2 and point to next node on l2
			if(l2 != null) {
				carry += l2.val;
				l2 = l2.next;
			}

			if(result == null) {
				curr = new ListNode(carry % 10);
				result = curr;
			} else {
				curr.next = new ListNode(carry % 10);
				curr = curr.next;
			}

			carry = carry / 10;

		}

		//If carry exists on last sum
		if(carry > 0) {
			curr.next = new ListNode(carry);
		}

		return result;
	}

	public static void main(String [] args) {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);

		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);

		SumLinkedList sll = new SumLinkedList();
		ListNode l3 = sll.addTwoNumbers(l1, l2);

		while(l3 != null) {
			System.out.println(l3.val);
			l3 = l3.next;
		}
	}
}
