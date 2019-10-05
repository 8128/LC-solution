package com.company.broadway;

import java.util.*;

/**
 * @author ：Tianyi Tang
 * @date ：Created in 2019-10-03 13:39
 * @modified By：
 *
 *  WARNING !!!!!!
 *
 *  这个代码并没有写完，懒得写了，思路基本写完了，就是利用一个freq map，一个node 地址map， 然后在添加完新的物品交易之后更新
 *  freq map，并用freq和listnode末端的val比对，若其超越了listnode末端，则删除末端nodemap中地址，并将新node加入，随后更新node 地址map
 *  当同一freq的node过多并且在list末端时，插入时间会超过O1，此时需要进行一个bubble sort
 *  举例， list node 的top 5 是 1 1 1 2 2
 *  此时有 a商品本就有1 的freq，但因为先后顺序并不在列表中
 *  此时freq++后 freq为2， 则需bubble sort 到第三位
 *  此时复杂度为O(m) m为node重复数
 *  正常情况下只是listnode末端的操作，因此一般情况下复杂度为O1
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

    public List<String> topK() {
        Node cur = nodeList.firstNode;
        List<String> ans = new ArrayList<>();
        while (cur != null) {
            ans.add(cur.merchandise);
            cur = cur.next;
        }
        return ans;
    }

}
