package com.v.bloomberg.coding.ood;

import java.util.*;

/**
 * @author :   Tianyi Tang
 * @date :   Created in 2020-01-06 17:03
 * @leetcode :
 * @timeComplexity :
 * @spaceComplexity :
 */
public class PhoneBookTreeMap {

    TreeMap<String, LinkedList<PersonInfo>> treeMap;

    class NameNotFoundException extends Exception {
        NameNotFoundException (String string){
            super(string);
        }
    }

    class PersonInfo {
        String name;
        String phoneNumber;

        public PersonInfo (String name, String phoneNumber) {
            this.name = name;
            this.phoneNumber = phoneNumber;
        }

        @Override
        public String toString() {
            return "PersonInfo{" +
                    "name='" + name + '\'' +
                    ", phoneNumber='" + phoneNumber + '\'' +
                    '}';
        }
    }

    public PhoneBookTreeMap () {
        treeMap = new TreeMap<>();
    }

    public void addPerson (String name, String number) {
        PersonInfo personInfo = new PersonInfo(name, number);
        treeMap.putIfAbsent(name, new LinkedList());
        LinkedList ll = treeMap.get(name);
        ll.addLast(personInfo);
    }

    public List<PersonInfo> getNumber (String name) throws Exception {
        List<PersonInfo> res = treeMap.get(name);
        if (res == null) {
            throw new NameNotFoundException("Name Not Found");
        }
        return res;
    }

    public List<PersonInfo> getNeighbors (String name, int k) {
        List<PersonInfo> res = treeMap.getOrDefault(name, new LinkedList<>());
        while (res.size() < k) {
            Map.Entry<String, LinkedList<PersonInfo>> newKey = treeMap.higherEntry(name);
            String nextKey = newKey.getKey();
            for (int i = 0; i < Math.min(nextKey.length(), name.length()); i++) {
                if (nextKey.charAt(i) != name.charAt(i)) {
                    return res;
                }
            }
            res.addAll(newKey.getValue());
            name = nextKey;
        }
        if (res.size() > k) return res.subList(0, k);
        else return res;
    }



    public static void main(String[] args) throws Exception {
        PhoneBookTreeMap phoneBookTreeMap = new PhoneBookTreeMap();
        phoneBookTreeMap.addPerson("to","12312321");
        phoneBookTreeMap.addPerson("tom","18231083");
        phoneBookTreeMap.addPerson("tom", "8021689321");
        phoneBookTreeMap.addPerson("tommy", "798271937219");
        phoneBookTreeMap.addPerson("tom", "120820312");
        phoneBookTreeMap.addPerson("tomme", "21387293721");
        System.out.println(phoneBookTreeMap.getNumber("tom"));
        System.out.println(phoneBookTreeMap.getNeighbors("tom", 4));
        System.out.println(phoneBookTreeMap.getNeighbors("to", 4));
    }
}
