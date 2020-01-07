package com.v.bloomberg.coding.ood;

import java.util.*;
/**
 * @author :   Tianyi Tang
 * @date :   Created in 2020-01-06 17:02
 * @leetcode :
 * @timeComplexity :
 * @spaceComplexity :
 */
public class PhoneBook {

    TrieNode firstNode;

    class TrieNode {
        char c;
        List<String> phoneList;
        TrieNode[] trieNodes;

        public TrieNode (char c) {
            this.c = c;
            this.trieNodes = new TrieNode[26];
            this.phoneList = new LinkedList<>();
        }

        @Override
        public String toString() {
            return "TrieNode{" +
                    "c=" + c +
                    ", phoneList=" + phoneList +
                    '}';
        }
    }

    public PhoneBook () {
        this.firstNode = new TrieNode(' ');
    }

    public void addPerson (String name, String number) {
        char[] cs = name.toCharArray();
        TrieNode cur = firstNode;
        for (char c : cs) {
            if (cur.trieNodes[c - 'a'] == null) {
                cur.trieNodes[c - 'a'] = new TrieNode(c);
                cur = cur.trieNodes[c - 'a'];
            } else {
                cur = cur.trieNodes[c - 'a'];
            }
        }
        cur.phoneList.add(number);
    }

    public List<String> findNumber (String name) {
        TrieNode cur = firstNode;
        char[] cs = name.toCharArray();
        for (char c : cs) {
            if (cur.trieNodes[c - 'a'] == null) {
                return new ArrayList<>();
            }
            cur = cur.trieNodes[c - 'a'];
        }
        return cur.phoneList;
    }

    public List<String> findNeighbor (String name, int k) {
        List<String> res = new LinkedList<>();
        TrieNode cur = firstNode;
        char[] cs = name.toCharArray();
        for (char c : cs) {
            if (cur.trieNodes[c - 'a'] == null) {
                return new ArrayList<>();
            }
            cur = cur.trieNodes[c - 'a'];
        }
        return recursiveFindNeighbor(cur, new LinkedList<>(), k, new StringBuilder(name.substring(0, name.length() - 1)));
    }

    public List<String> recursiveFindNeighbor (TrieNode node, List<String> res, int k, StringBuilder sb) {
        StringBuilder tmp = new StringBuilder(sb);
        tmp.append(node.c);
        if (node.phoneList.size() != 0) {
            res.add(tmp.toString());
        }
        if (res.size() > k) {
            return res.subList(0, k);
        }
        if (res.size() == k) {
            return res;
        }
        for (TrieNode trieNode : node.trieNodes) {
            if (trieNode != null) {
                res = recursiveFindNeighbor(trieNode, res, k, tmp);
                if (res.size() == k) break;
            }
        }
        return res;
    }

    public void printTrie (TrieNode node) {
        Queue<TrieNode> q = new LinkedList<>();
        q.offer(node);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TrieNode tmp = q.poll();
                System.out.println(tmp);
                for (TrieNode trieNode :tmp.trieNodes) {
                    if (trieNode != null) {
                        q.offer(trieNode);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addPerson("to","12312321");
        phoneBook.addPerson("tom","18231083");
        phoneBook.addPerson("tom", "8021689321");
        phoneBook.addPerson("tommy", "798271937219");
        phoneBook.addPerson("tom", "120820312");
        phoneBook.addPerson("tomme", "21387293721");
        phoneBook.printTrie(phoneBook.firstNode);
        System.out.println(phoneBook.findNumber("tom"));
        System.out.println(phoneBook.findNeighbor("tom", 4));
        System.out.println(phoneBook.findNeighbor("to", 4));
    }
}
