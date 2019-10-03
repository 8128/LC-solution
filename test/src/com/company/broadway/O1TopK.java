package com.company.broadway;

import java.util.*;

/**
 * @author ：Tianyi Tang
 * @date ：Created in 2019-10-03 13:39
 * @modified By：
 */
public class O1TopK {

    HashMap<String, Integer> freqHM;
    HashMap<String, Node> nodeHM;
    NodeList nodeList;
    int k;

    class Node {

        int val;
        String merchandise;
        Node next = null;
        Node prev = null;

        Node (String merchandise, int val) {
            this.merchandise = merchandise;
            this.val = val;
        }

        Node (int val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }

    }

    class NodeList {

        Node firstNode;
        Node lastNode;
        int size;

        NodeList (Node firstNode) {
            this.firstNode = firstNode;
        }

    }

    public O1TopK (int k) {
        this.k = k;
        freqHM = new HashMap<>();
        nodeHM = new HashMap<>();
        nodeList = null;
    }

    public void add (String oneTrade) {
        String[] strings = oneTrade.split(" ");
        String merchandise = strings[0];
        String value = strings[1];
        freqHM.put(merchandise, freqHM.getOrDefault(merchandise, 0) + 1);
        if (!nodeHM.containsKey(merchandise)) {
            if (nodeList.size < k) {
                Node tempNode = nodeHM.getOrDefault(merchandise, new Node(merchandise, 0));
                tempNode.val++;
                tempNode.next = nodeList.firstNode;
                nodeList.firstNode.prev = tempNode;
                nodeList.firstNode = tempNode;
                nodeList.size ++;
            }else if (freqHM.get(merchandise) > nodeList.firstNode.val) {

            }
        }
    }

    public void addList (Node newNode) {
        Node next = nodeList.firstNode;
        nodeHM.remove(nodeList.firstNode.merchandise);
        nodeList.firstNode = newNode;
        newNode.next = next;
        while (newNode.next != null && newNode.val > newNode.next.val) {
            Node first = newNode.prev;
            Node third = newNode.next;
            Node forth = newNode.next.next;
            first.next = third;
            third.next = newNode;
            newNode.next = forth;
            third.prev = first;
            newNode.prev = third;
            forth.prev = newNode;
        }
    }

}
