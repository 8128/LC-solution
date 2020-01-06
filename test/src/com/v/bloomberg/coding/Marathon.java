package com.v.bloomberg.coding;

import java.util.*;
/**
 * @author :   Tianyi Tang
 * @date :   Created in 2020-01-06 15:13
 * @leetcode :
 * @timeComplexity :
 * @spaceComplexity :
 */
public class Marathon {

    Athlete[] athletes = new Athlete[10000];
    CheckPoint[] checkPoints = new CheckPoint[100];

    class Athlete {
        String name;
        int id;
        int curCp;

        Athlete(String name, int id) {
            this.name = name;
            this.id = id;
            this.curCp = -1;
        }

        @Override
        public boolean equals(Object object) {
            if (object == this) {
                return true;
            }
            if (object == null || object.getClass() != this.getClass()) {
                return false;
            }
            Athlete guest = (Athlete) object;
            return id == guest.id;
        }
    }

    class CheckPoint {
        int cpId;
        int distance;
        LinkedList<Athlete> passed;

        CheckPoint(int cpId, int distance) {
            this.cpId = cpId;
            this.distance = distance;
            passed = new LinkedList<>();
        }
    }

    public Marathon () {
        for (int i = 0; i < athletes.length; i++) {
            athletes[i] = new Athlete("a", i);
        }
        for (int i = 0; i < checkPoints.length; i++) {
            checkPoints[i] = new CheckPoint(i, new Random().nextInt());
        }
    }

    public void athletePass (int id, int cpId) {
        checkPoints[cpId].passed.addLast(athletes[id]);
    }

    public List<Athlete> topK (int k) {
        LinkedList<Athlete> ans = new LinkedList<>();
        HashSet<Athlete> seen = new HashSet<>();
        for (CheckPoint checkPoint : checkPoints) {
            for (Athlete athlete : checkPoint.passed) {
                if (seen.contains(athlete)) continue;
                ans.addLast(athlete);
                seen.add(athlete);
                if (ans.size() == k) {
                    break;
                }
            }
            if (ans.size() == k) {
                break;
            }
        }
        return ans;
    }
}
