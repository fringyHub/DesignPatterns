package com.company;

class ListNode {
    int data;
    ListNode next;

    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Linked {
    private ListNode head;
    public Linked() { head = null; }

    void insertBack(int data) {
        if(head == null) {
            head = new ListNode(data);
        } else {
            ListNode temp = head;
            while(temp.next != null)
                temp = temp.next;
            temp.next = new ListNode(data);
        }
    }

    void print() {
        ListNode temp = head;
        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    void reverse() {
        ListNode current = head, prev = null, next = null;
        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }


    void reverseAfterN(int n) {
        ListNode current = head, prev = null, next = null;
        int counter = 0;

        while(true) {
            ListNode nextStarting, currentEnding = null;
            while (current != null && counter != n) {
                if(counter == 0) currentEnding = current;
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
                counter++;
            }
            currentEnding.next = prev;
            counter =0;
        }
    }
    public static void main(String args[]) {
        Linked list = new Linked();

        for(int i = 0; i < 6; i++)
            list.insertBack(i);
        list.print();
        list.reverseAfterN(3);
        list.print();
    }


}
