package com.zia.linkedlist;

public class MyLinkedList {

    private Node head;

    public static void main(String[] args) {
        MyLinkedList obj = new MyLinkedList();
        Node head = new Node("Head");
        obj.addToList(head);
        obj.addToList(new Node("First"));
        obj.addToList(new Node("Second"));
        obj.addToList(new Node("Third"));
        obj.addToList(new Node("Fourth"));
        obj.addToList(new Node("Fifth"));

        obj.print(head);

        System.out.println("\n<<<< REVERSED >>>>>");
        final Node reverseLinkedList = reverseLinkedListRecursion(head);

        obj.print(reverseLinkedList);
    }

    public static Node reverseLinkedListRecursion(Node currentNode) {
        MyLinkedList obj = new MyLinkedList();
        obj.print(currentNode);
        System.out.println();
        if (currentNode == null || currentNode.next == null) {
            return currentNode;
        }
        Node remaining = reverseLinkedListRecursion(currentNode.next);
        currentNode.next.next = currentNode;
        currentNode.next = null;
        return remaining;
    }

    private static Node reverseLinkedListIteration(Node currentNode) {
        Node previousNode = null;
        Node nextNode;
        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        return previousNode;
    }

    /**
     * 1) Use two pointers fast and slow
     * 2) Move fast two nodes and slow one node in each iteration
     * 3) If fast and slow meet then linked list contains cycle
     * 4) if fast points to null or fast.next points to null then linked list is not cyclic
     */
    public boolean isCyclic() {
        Node slow = head;
        Node fast = head;

        while (slow != null && fast != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(fast == slow ){
                return true;
            }
        }

        return false;
    }

    private void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "=>");
            temp = temp.next;
        }
    }

    private void addToList(Node node) {
        if(head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }

    }

    static class Node {
        private String data;
        private Node next;

        Node(String data) {
            this.data = data;
        }
    }
}
