package com.v.bloomberg.coding.ood;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author :   Tianyi Tang
 * @date :   Created in 2020-01-06 22:36
 * @leetcode :
 * @timeComplexity :
 * @spaceComplexity :
 */
public class NewYorkSubway {

    class Person {
        int cardId;
        int stationId;
        Date in;
        Date out;
    }

    public NewYorkSubway () {
        Scanner scanner = new Scanner(System.in);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] strs = line.split(" ");
            if (strs.length < 4) continue;
            Person person = new Person();
            person.cardId = Integer.valueOf(strs[0]);
            person.stationId = Integer.valueOf(strs[1]);
            try {
                person.in = df.parse(strs[2]);
                person.out = df.parse(strs[3]);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
}
