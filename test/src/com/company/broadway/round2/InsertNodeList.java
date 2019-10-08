package com.company.broadway.round2;

import java.util.Arrays;
import java.util.Random;

/**
 * @author ：Tianyi Tang
 * @date ：Created in 2019-10-08 12:05
 * @modified By：
 */
public class InsertNodeList {

    class Node {

        int val;
        Node next;
        Node prev;

        public Node (int val) {
            this.val = val;
        }
    }

    public Node nodeListGenerator (int num) {
        if (num == 0) {
            return null;
        }
        int[] array = new int[num];
        Random random = new Random();
        for (int i = 0; i < num; i++) {
            array[i] = random.nextInt();
        }
        Arrays.sort(array);
        Node start = null;
        Node end = null;
        Node cur = null;
        for (int i = 0; i < num; i++) {
            if (i == 0) {
                start = new Node(array[i]);
                end = start;
                cur = start;
                continue;
            }
            Node temp = new Node(array[i]);
            cur.next = temp;
            temp.prev = cur;
            cur = cur.next;
            end = cur;
        }
        start.prev = end;
        end.next = start;
        return start;
    }

    public void insertNode (int val, Node randomNode) {
        Node insert = new Node(val);
        if (val > randomNode.val) {
            while (val > randomNode.val && randomNode.next.val > randomNode.val) {
                randomNode = randomNode.next;
            }
            helper(val, randomNode, insert);
        } else {
            while (val < randomNode.val && randomNode.prev.val < randomNode.val) {
                randomNode = randomNode.prev;
            }
            helper(val, randomNode, insert);
        }


    }

    public void helper(int val, Node randomNode, Node insert) {
        Node first = randomNode.val > val ? randomNode.prev : randomNode;
        Node last = randomNode.val > val ? randomNode : randomNode.next;
        first.next = insert;
        insert.next = last;
        insert.prev = first;
        last.prev = insert;
    }

    public static void main(String[] args) {

        // test listnode generator
        InsertNodeList insertNodeList = new InsertNodeList();
        Node cur = insertNodeList.nodeListGenerator(10);
        for (int i =0; i < 10; i++) {
            System.out.println("prev " + cur.prev.val + " cur[" + i + "] " + cur.val + " next " +cur.next.val);
            cur = cur.next;
        }

        int nodeNum = (int)(Math.random() * 10);
        while (nodeNum != 0) {
            cur = cur.next;
            nodeNum--;
        }

        int insertNum = new Random().nextInt();
        insertNodeList.insertNode(insertNum, cur);
        System.out.println("Inserted Number : " + insertNum);

        for (int i =0; i < 11; i++) {
            System.out.println("prev " + cur.prev.val + " cur[" + i + "] " + cur.val + " next " +cur.next.val);
            cur = cur.next;
        }
    }
}
