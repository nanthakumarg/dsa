package com.thebytecloud.linkedlist;

import java.util.List;

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
        int count = 0;
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

    public void insertSorted(E data) {

        Node<E> newNode = new Node<E>(data);

        if(countNodes() ==0 && head.getData().compareTo(data) > 0){
            newNode.setNext(head);
            head = newNode;
            return;
        }

        Node<E> currentNode = head;

        while(currentNode.getNext() != null && currentNode.getNext().getData().compareTo(data) < 0) {
            currentNode = currentNode.getNext();
        }

        newNode.setNext(currentNode.getNext());
        currentNode.setNext(newNode);


    }

    public void appendList(LinkedList<E> ll){

        if(ll.head == null)
            return;

        Node<E> currentNode = ll.head;
        while(currentNode != null) {
            addNode( (E) currentNode.getData());
            currentNode = currentNode.getNext();
        }

    }


    /*
    Brute Force Solution

    public List<LinkedList<E>> frontBackSplit() {
        int count = countNodes();
        int mid = count / 2 + count % 2;

        LinkedList<E> front = new LinkedList<E>();
        LinkedList<E> back = new LinkedList<E>();

        Node<E> currentNode = head;
        int i = 0;
        while(currentNode != null && i < mid) {
            front.addNode((E) currentNode.getData());
            currentNode = currentNode.getNext();
            i++;
        }

        while(currentNode != null && i < count ) {
            back.addNode((E)currentNode.getData());
            currentNode = currentNode.getNext();
            i++;
        }

        return List.of(front, back);

    }*/

    public List<Node<E>> frontBackSplit() {

        Node<E> front = null;
        Node<E> back = null;

        if(head == null) {
            front = null;
            back = null;
        } else if(head.getNext() == null) {
            front = head;
            back = null;
        } else {

            Node<E> fast = head;
            Node<E> slow = head;
            while(fast != null) {
                fast = fast.getNext();

                if(fast == null)
                    break;

                fast = fast.getNext();
                if(fast != null) {
                    slow = slow.getNext();
                }
            }

            front = head;
            back = slow.getNext();
            slow.setNext(null);
        }

        return List.of(front, back);
    }

    //Remove duplicate in the sorted List
    public void removeDuplicates() {

        int count = countNodes();

        if(count == 0 || count == 1) {
            return;
        }

        Node<E> currentNode = head;

        do {

            if(currentNode.getData().compareTo(currentNode.getNext().getData()) == 0 ) {

                currentNode.setNext(currentNode.getNext().getNext());
            } else {
                currentNode = currentNode.getNext();
            }

        }while ( currentNode != null );
    }


}
