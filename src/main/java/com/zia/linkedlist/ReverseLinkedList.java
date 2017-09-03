package com.zia.linkedlist;

public class ReverseLinkedList {

    private Node head;

    public static void main(String[] args) {
        ReverseLinkedList obj = new ReverseLinkedList();
        Node head = new Node("Head");
        obj.addToList(head);
        obj.addToList(new Node("First"));
        obj.addToList(new Node("Second"));
        obj.addToList(new Node("Third"));
        obj.addToList(new Node("Fourth"));
        obj.addToList(new Node("Fifth"));

        obj.print(head);

        System.out.println("<<<< REVERSED >>>>>");

        final Node reverseLinkedList = reverseLinkedList(head);

        obj.print(reverseLinkedList);
    }

    public static Node reverseLinkedList(Node currentNode) {
        if (currentNode == null || currentNode.next == null) {
            return currentNode;
        }
        Node remaining = reverseLinkedList(currentNode.next);
        currentNode.next.next = currentNode;
        currentNode.next = null;
        return remaining;
    }


    private void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
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
