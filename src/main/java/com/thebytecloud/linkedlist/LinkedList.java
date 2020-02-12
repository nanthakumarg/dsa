package com.thebytecloud.linkedlist;

public class LinkedList<E extends Comparable<E>> implements Cloneable {

    private Node<E> head = null;

    public LinkedList() {

    }

    public boolean addNode(E data) {

        Node<E> node = new Node<E>(data);

        if(head == null) {
            head = node;
            return true;
        }

        Node currentNode = head;
        while (currentNode.getNext() != null)
            currentNode = currentNode.getNext();
        currentNode.setNext(node);

        return true;
    }

    public void printNodes() {

        if(head == null) {
            System.out.println("No nodes in the Linked List");
            return;
        }

        Node currentNode = head;
        int i = 1;
        while(currentNode != null) {
            System.out.println("Node "+i+" = "+currentNode);
            currentNode = currentNode.getNext();
            i++;
        }

    }

    public int countNodes() {

        if(head == null) {
            System.out.println("No nodes in the Linked List");
            return 0;
        }

        Node currentNode = head;
        int count = 1;
        while(currentNode != null) {
            currentNode = currentNode.getNext();
            count++;
        }

        return count;
    }

    public E popElement() {
        if(head == null)
            return null;

        E topElement = head.getData();
        head = head.getNext();
        return topElement;
    }

    public void deleteLinkedList() {
        head = null;
    }

    public void insertNth(int i, E data) {

        if(i > countNodes())
            return;

        Node newNode = new Node(data);

        if( i == 0 ){
            newNode.setNext(head.getNext());
            head.setNext(newNode);
            return;
        }

        Node currentNode = head;
        int position = 0;
        while ( position < i - 1 ){
            currentNode = currentNode.getNext();
            position++;
        }

        newNode.setNext(currentNode.getNext());
        currentNode.setNext(newNode);

    }

}
