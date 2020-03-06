//done

/*
 * 
 * Design your implementation of the linked list. You can choose to use the singly linked list or the doubly linked list. A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next is a pointer/reference to the next node. If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.

Implement these functions in your linked list class:

get(index) : Get the value of the index-th node in the linked list. If the index is invalid, return -1.
addAtHead(val) : Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
addAtTail(val) : Append a node of value val to the last element of the linked list.
addAtIndex(index, val) : Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
deleteAtIndex(index) : Delete the index-th node in the linked list, if the index is valid.
 

Example:

Input: 
["MyLinkedList","addAtHead","addAtTail","addAtIndex","get","deleteAtIndex","get"]
[[],[1],[3],[1,2],[1],[1],[1]]
Output:  
[null,null,null,null,2,null,3]

Explanation:
MyLinkedList linkedList = new MyLinkedList(); // Initialize empty LinkedList
linkedList.addAtHead(1);
linkedList.addAtTail(3);
linkedList.addAtIndex(1, 2);  // linked list becomes 1->2->3
linkedList.get(1);            // returns 2
linkedList.deleteAtIndex(1);  // now the linked list is 1->3
linkedList.get(1);            // returns 3
 

Constraints:

0 <= index,val <= 1000
Please do not use the built-in LinkedList library.
At most 2000 calls will be made to get, addAtHead, addAtTail,  addAtIndex and deleteAtIndex.
 * 
 * 
 */
package leetcode;

public class Design_Linked_List {
	
	class Node {
        Node prev, next;
        int val;
        Node(int val) { this.val = val; }
    }

    int size;
    Node head, tail;
    // Initialize your data structure here.
    public Design_Linked_List() { }

    // Get the value of the index-th node in the linked list. If the index is invalid, return -1.
    public int get(int index) {
        if(index < 0 || index >= size) return -1;
        Node x = head;
        int i = 0;
        while(i < index && x != null) {
            x = x.next;
            i++;
        }
        return (i < index || x == null) ? -1 : x.val;
    }

    // Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
    public void addAtHead(int val) {
        if(isEmpty()) {
            initHead(val);
            return;
        }
        Node node = new Node(val);
        link(node, head);
        head = node;
        size++;
    }

    // Append a node of value val to the last element of the linked list.
    public void addAtTail(int val) {
        if(isEmpty()) {
            initHead(val);
            return;
        }
        Node node = new Node(val);
        link(tail, node);
        tail = node;
        size++;
    }

    // Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
    public void addAtIndex(int index, int val) {
        if(index > size) return;
        if(index == size) {
            addAtTail(val);
            return;
        }
        //if negative add at head??
        if(index <= 0) {
            addAtHead(val);
            return;
        }

        Node cur = search(index);
        Node node = new Node(val);
        link(cur.prev, node, cur);
        size++;
    }

    // Delete the index-th node in the linked list, if the index is valid.
    public void deleteAtIndex(int index) {
        if(index >= size || index < 0) return;
        if(index == 0) {
            head = head.next;
            size--;
            return;
        }

        if(index == size - 1) {
            tail = tail.prev;
            tail.next = null;
            size--;
            return;
        }

        Node cur = search(index);
        link(cur.prev, cur.next);
        size--;

    }

    private boolean isEmpty() {
        return size == 0;
    }

    private void initHead(int val) {
        head = new Node(val);
        tail = head;
        size++;
    }

    private void link(Node a, Node b) {
        a.next = b;
        b.prev = a;
    }

    private void link(Node a, Node b, Node c) {
        a.next = b;
        b.prev = a;
        b.next = c;
        c.prev = b;
    }

    //add search from head and tail
    private Node search(int index) {
        Node cur = null;
        if(index < size / 2) {
            cur = head;
            int i = 0;
            while(i < index) {
                cur = cur.next;
                i++;
            }
        } else {
            cur = tail;
            int i = size - 1;
            while(i > index) {
                cur = cur.prev;
                i--;
            }
        }
        return cur;
    }
	

}
