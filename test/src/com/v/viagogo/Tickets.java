package com.v.viagogo;

import java.util.*;

/**
 * @author ：Tianyi Tang
 * @date ：Created in 2019-10-16 15:43
 */

public class Tickets {

    static class Event {
        String eventId;
        int x;
        int y;
        PriorityQueue<Integer> price;

        public Event (String eventId, int x, int y) {
            this.eventId = eventId;
            this.x = x;
            this.y = y;
            price = new PriorityQueue<>();
        }
    }

    public static void main(String args[] ) throws Exception {
        HashMap<String, Event> events = new HashMap<>();
        Scanner scan = new Scanner(System.in);
        int sizeOfWorld = Integer.parseInt(scan.nextLine());
        int numberOfEvents = Integer.parseInt(scan.nextLine());
        while(numberOfEvents-- > 0){
            String eventLine = scan.nextLine();
            String[] split = eventLine.split(" ");
            if (split.length < 4) {
                continue;
            }
            if (Integer.valueOf(split[1]) < 0 || Integer.valueOf(split[1]) >= sizeOfWorld || Integer.valueOf(split[2]) < 0 || Integer.valueOf(split[2]) >= sizeOfWorld) {
                continue;
            }
            String eventId = split[0];
            if (events.containsKey(eventId)) {
                for (int j = 3; j < split.length; j++) {
                    events.get(eventId).price.add(Integer.valueOf(split[j]));
                }
            } else {
                Event event = new Event(eventId, Integer.valueOf(split[1]), Integer.valueOf(split[2]));
                for (int j = 3; j < split.length; j++) {
                    event.price.add(Integer.valueOf(split[j]));
                }
                if (event.price.size() == 0) {
                    continue;
                }
                events.put(eventId, event);
            }
        }

        int numberOfBuyers = Integer.parseInt(scan.nextLine());
        while(numberOfBuyers-- > 0){
            String buyerLine = scan.nextLine();
            List<String> eventId = new ArrayList<>(events.keySet());
            if (eventId.size() == 0) {
                System.out.println("-1 0");
                continue;
            }
            String[] split = buyerLine.split(" ");
            int tempX = Integer.valueOf(split[0]);
            int tempY = Integer.valueOf(split[1]);
            if (tempX < 0 || tempX >= sizeOfWorld || tempY < 0 || tempY >= sizeOfWorld) {
                System.out.println("-1 0");
            }
            eventId.sort((o1, o2) -> {
                Event event1 = events.get(o1);
                Event event2 = events.get(o2);
                int dis1 = calculateManhattanDistance(event1.x, event1.y, tempX, tempY);
                int dis2 = calculateManhattanDistance(event2.x, event2.y, tempX, tempY);
                if (dis1 == dis2) {
                    return Integer.compare(Integer.valueOf(event1.eventId), Integer.valueOf(event2.eventId));
                }
                return Integer.compare(dis1, dis2);
            });
            Event toBuy = events.get(eventId.get(0));
            int price = toBuy.price.poll();
            if (toBuy.price.size() == 0) {
                events.remove(toBuy.eventId);
            }
            System.out.println(toBuy.eventId + " " + price);
        }
    }

    public static int calculateManhattanDistance(int x1, int y1, int x2, int y2)    {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}

